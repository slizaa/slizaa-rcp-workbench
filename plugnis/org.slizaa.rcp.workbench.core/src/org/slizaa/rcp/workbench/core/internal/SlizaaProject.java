/*******************************************************************************
 * Copyright (c) 2011-2015 slizaa project team. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: slizaa project team - initial API and implementation
 ******************************************************************************/
package org.slizaa.rcp.workbench.core.internal;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.osgi.framework.Bundle;
import org.slizaa.hierarchicalgraph.HGRootNode;
import org.slizaa.neo4j.dbadapter.DbAdapterFactory;
import org.slizaa.neo4j.dbadapter.Neo4jClient;
import org.slizaa.rcp.workbench.core.ISlizaaProject;
import org.slizaa.rcp.workbench.core.SlizaaWorkbenchCore;
import org.slizaa.rcp.workbench.core.internal.projectconfig.SlizaaProjectConfigurationModel;
import org.slizaa.scanner.core.api.cypherregistry.ICypherStatement;
import org.slizaa.scanner.core.api.graphdb.IGraphDb;
import org.slizaa.scanner.core.api.importer.IModelImporter;
import org.slizaa.scanner.core.api.importer.IModelImporterFactory;
import org.slizaa.scanner.core.spi.annotations.ParserFactory;
import org.slizaa.scanner.core.spi.contentdefinition.IContentDefinitionProvider;
import org.slizaa.scanner.core.spi.parser.IParserFactory;

/**
 * <p>
 * Implementation of the interface {@link ISlizaaProject}.
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class SlizaaProject implements ISlizaaProject {

  @FunctionalInterface
  public interface SlizaaProjectDynamicAction {

    void execute() throws CoreException;
  }

  /** the associated eclipse project */
  private IProject                                              _project;

  /** - */
  private Map<IResource, List<SlizaaProjectConfigurationModel>> _projectConfigurationModels;

  /** - */
  private SlizaaProjectConfigurationModel                       _currentConfigurationModel;

  /** - */
  private HGRootNode                                            _hierarchicalGraph;

  /** - */
  private Neo4jClient                                           _boltClient;

  /** - */
  private IGraphDb                                              _graphDb;

  /**
   * <p>
   * Creates a new instance of type {@link SlizaaProject}.
   * </p>
   *
   * @param project
   * @throws Exception
   */
  public SlizaaProject(IProject project) throws CoreException {

    // TODO: CoreException
    Assert.isTrue(project.hasNature(SlizaaWorkbenchCore.SLIZAA_NATURE_ID));

    // set the project
    this._project = project;

    //
    this._projectConfigurationModels = new HashMap<>();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public IProject getProject() {
    return this._project.getProject();
  }

  @Override
  public IContentDefinitionProvider getContentDefinitionProvider() {

    // TODO
    if (this._currentConfigurationModel == null) {

      this._currentConfigurationModel = (SlizaaProjectConfigurationModel) this._projectConfigurationModels.values()
          .toArray(new List[0])[0].get(0);
    }

    return this._currentConfigurationModel.getContentDefinitionProvider();
  }

  @Override
  public void createHierarchicalGraph() throws CoreException {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean isConnected() {
    // TODO Auto-generated method stub
    return false;
  }

  /**
   *
   * /** {@inheritDoc}
   */
  @Override
  public boolean hasDatabase() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public HGRootNode getHierachicalGraph() {
    return this._hierarchicalGraph;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Neo4jClient getBoltClient() {
    return this._boltClient;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void initialize(IProgressMonitor progressMonitor) throws CoreException {

    // // reload the project description
    // reloadSystemDefinition();

    // initialize
    // this._contentDefinitionProvider.getContentDefinitions();
  }

  @Override
  public void parse(IProgressMonitor progressMonitor) throws CoreException {

    // create new null monitor if necessary
    if (progressMonitor == null) {
      progressMonitor = new NullProgressMonitor();
    }

    // create the sub-monitor
    final SubMonitor subMonitor = SubMonitor.convert(progressMonitor, 100);

    //
    shutdownDatabase();

    //
    progressMonitor.subTask("Parsing...");
    internalParse(subMonitor.newChild(90));

    //
    progressMonitor.subTask("Launching graph database...");
    startAndConnectGraphDatabase(subMonitor.newChild(10));
  }

  /**
   * <p>
   * </p>
   *
   * @param progressMonitor
   * @throws CoreException
   */
  @Override
  public void startAndConnectGraphDatabase(IProgressMonitor progressMonitor) throws CoreException {

    //
    if (this._graphDb == null) {

      this._graphDb = Activator.instance().getGraphDbFactory()
          .newGraphDb(5001, SlizaaWorkbenchCore.getDatabaseDirectory(getProject())).withUserObject(this).create();
    }

    //
    if (this._boltClient == null) {

      //
      Neo4jClient neo4jClient = DbAdapterFactory.eINSTANCE.createNeo4jClient();
      neo4jClient.setUri("bolt://localhost:" + this._graphDb.getPort());
      neo4jClient.setName(this.getProject().getName());
      neo4jClient.setDescription(this.getProject().getName());
      neo4jClient.connect();

      //
      this._boltClient = neo4jClient;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void dispose() {

    shutdownDatabase();

    // // set the project state
    // _projectState = SlizaaProjectState.DISPOSED;

    // notify listeners
    // fireProjectStateChangedEvent(new
    // BundleMakerProjectStateChangedEvent(this, _projectState));

    //
    SlizaaProjectCache.instance().removeCachedBundleMakerProject(this._project);
  }

  public Map<IResource, List<SlizaaProjectConfigurationModel>> getProjectConfigurationModels() {
    return this._projectConfigurationModels;
  }

  /**
   * <p>
   * </p>
   *
   */
  private void shutdownDatabase() {

    //
    if (this._boltClient != null) {
      this._boltClient.disconnect();
      this._boltClient = null;
    }

    //
    if (this._graphDb != null) {
      this._graphDb.shutdown();
      this._graphDb = null;
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param progressMonitor
   */
  private void internalParse(IProgressMonitor progressMonitor) {

    //
    try {
      BuildHelper.cleanBuildProject(this._project);
      BuildHelper.failOnErrors(this._project);
    }
    //
    catch (CoreException exception) {
      //
    }

    // delete the old database directory...
    try {

      // get the root path
      Path rootPath = Paths.get(SlizaaWorkbenchCore.getDatabaseDirectory(getProject()).getAbsolutePath());

      // delete all contained files
      Files.walk(rootPath, FileVisitOption.FOLLOW_LINKS).sorted(Comparator.reverseOrder()).map(Path::toFile)
          .forEach(File::delete);

    } catch (IOException e) {
      // simply ignore
    }

    try {
      executeWithProperties(() -> {

        //
        List<IParserFactory> parserFactories = new ArrayList<>();
        Map<Bundle, Map<Class<?>, List<Class<?>>>> extensions = Activator.instance().getTrackedExtensionBundles();
        for (Map<Class<?>, List<Class<?>>> entry : extensions.values()) {

          List<Class<?>> parserFactoriesClasses = entry.get(ParserFactory.class);

          for (Class<?> clazz : parserFactoriesClasses) {
            try {
              System.out.println("FOUND: " + clazz);
              parserFactories.add((IParserFactory) clazz.newInstance());
            } catch (InstantiationException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            } catch (IllegalAccessException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
          }
        }

        List<ICypherStatement> cypherStatements = Collections.emptyList();

        //
        IModelImporterFactory modelImporterFactory = Activator.instance().getModelImporterFactory();

        this._currentConfigurationModel = selectConfigurationModel();

        // create a new model importer...
        IModelImporter modelImporter = modelImporterFactory.createModelImporter(
            this._currentConfigurationModel.getContentDefinitionProvider(),
            SlizaaWorkbenchCore.getDatabaseDirectory(getProject()), parserFactories, cypherStatements);

        // ... and parse the content
        modelImporter.parse(progressMonitor);

      });
    } catch (CoreException coreException) {
      coreException.printStackTrace();
    }

  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  private SlizaaProjectConfigurationModel selectConfigurationModel() {

    // TODO
    for (List<SlizaaProjectConfigurationModel> configurationModels : this._projectConfigurationModels.values()) {
      for (SlizaaProjectConfigurationModel slizaaProjectConfigurationModel : configurationModels) {
        return slizaaProjectConfigurationModel;
      }
    }

    //
    return null;
  }

  /**
   * <p>
   * </p>
   *
   * @param dynamicAction
   * @throws CoreException
   */
  private void executeWithProperties(SlizaaProjectDynamicAction dynamicAction) throws CoreException {

    //
    Map<String, String> properties = new HashMap<>();
    properties.put("slizaa.project.directory", this._project.getLocation().toOSString());

    try {

      //
      properties.forEach((k, v) -> System.setProperty(k, v));

      //
      dynamicAction.execute();

    } finally {
      properties.forEach((k, v) -> System.clearProperty(k));
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this._project == null) ? 0 : this._project.hashCode());
    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    SlizaaProject other = (SlizaaProject) obj;
    if (this._project == null) {
      if (other._project != null) {
        return false;
      }
    } else if (!this._project.equals(other._project)) {
      return false;
    }
    return true;
  }
}
