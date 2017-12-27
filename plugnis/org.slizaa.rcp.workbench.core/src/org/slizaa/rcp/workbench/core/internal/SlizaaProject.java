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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.slizaa.hierarchicalgraph.HGRootNode;
import org.slizaa.neo4j.dbadapter.DbAdapterFactory;
import org.slizaa.neo4j.dbadapter.Neo4jClient;
import org.slizaa.rcp.workbench.core.ISlizaaProject;
import org.slizaa.rcp.workbench.core.SlizaaWorkbenchCore;
import org.slizaa.scanner.core.api.cypherregistry.ICypherStatement;
import org.slizaa.scanner.core.api.graphdb.IGraphDb;
import org.slizaa.scanner.core.api.importer.IModelImporter;
import org.slizaa.scanner.core.contentdefinition.DirectoryBasedContentDefinitionProvider;
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

  /** the associated eclipse project */
  private IProject                   _project;

  /** the system definition */
  private IContentDefinitionProvider _contentDefinitionProvider;

  /** - */
  private HGRootNode                 _hierarchicalGraph;

  /** - */
  private Neo4jClient                _boltClient;

  /** - */
  private IGraphDb                   _graphDb;

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
    Assert.isTrue(project.hasNature(SlizaaWorkbenchCore.NATURE_ID));

    // set the project
    this._project = project;

    //
    this._contentDefinitionProvider = new DirectoryBasedContentDefinitionProvider();
    ((DirectoryBasedContentDefinitionProvider) this._contentDefinitionProvider)
        .add(project.getFile("_content").getRawLocation().makeAbsolute().toFile());
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
  public HGRootNode getAnalysisModel() {
    return this._hierarchicalGraph;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Neo4jClient getNeo4jClient() {
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
    this._contentDefinitionProvider.getContentDefinitions();
  }

  @Override
  public void parseAndOpen(IProgressMonitor progressMonitor) throws CoreException {

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
      neo4jClient.setName(this.getName());
      neo4jClient.setDescription(this.getName());
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

    // delete
    try {
      Path rootPath = Paths.get(SlizaaWorkbenchCore.getDatabaseDirectory(getProject()).getAbsolutePath());
      Files.walk(rootPath, FileVisitOption.FOLLOW_LINKS).sorted(Comparator.reverseOrder()).map(Path::toFile)
          .forEach(File::delete);
    } catch (IOException e) {
      // simply ignore
    }

    // TODO
    List<IParserFactory> parserFactories = Collections.emptyList();
    List<ICypherStatement> cypherStatements = Collections.emptyList();

    //
    IModelImporter modelImporter = Activator.instance().getModelImporterFactory().createModelImporter(
        this._contentDefinitionProvider, SlizaaWorkbenchCore.getDatabaseDirectory(getProject()), parserFactories,
        cypherStatements);

    modelImporter.parse(progressMonitor);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public IProject getProject() {
    return this._project.getProject();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getName() {
    return getProject().getName();
  }

  @Override
  public IContentDefinitionProvider getContentDefinitionProvider() {
    return this._contentDefinitionProvider;
  }

  // /*
  // * (non-Javadoc)
  // *
  // * @see org.bundlemaker.core.IBundleMakerProject#reloadProjectDescription()
  // */
  // @Override
  // public void reloadSystemDefinition() throws CoreException {
  //
  // //
  // try {
  //
  // // get target file
  // File targetFile = Constants.getProjectDescriptionFile(getProject());
  //
  // // load system definition
  // try (FileReader fileReader = new FileReader(targetFile)) {
  //
  // // TODO: CLASSLOADER
  // // TODO: MAP
  //
  // // load system definition
  // if (_contentDefinitionProvider == null) {
  //
  // //
  // ISystemDefinition systemDefinition = Activator.getDefault().getSystemDefinitionFactory()
  // .loadSystemDefinition(fileReader, this.getClass().getClassLoader(), null);
  //
  // //
  // _contentDefinitionProvider = Activator.getDefault().getSystemDefinitionFactory()
  // .createSystemDefinitionWithWorkingCopy(systemDefinition);
  // }
  //
  // // re-load system definition
  // else {
  //
  // //
  // Activator.getDefault().getSystemDefinitionFactory().reloadSystemDefinition(_contentDefinitionProvider,
  // fileReader, this.getClass().getClassLoader(), null);
  // }
  // }
  // }
  //
  // // re-throw exception
  // catch (IOException e) {
  // throw new CoreException(new Status(IStatus.ERROR, Constants.BUNDLE_ID_ORG_SLIZAA, e.getMessage(), e));
  // }
  //
  // //
  // // fireDescriptionChangedEvent(new
  // // BundleMakerProjectDescriptionChangedEvent(this,
  // // BundleMakerProjectDescriptionChangedEvent.Type.PROJECT_DESCRIPTION_RELOADED));
  // }
  //
  // @Override
  // public void saveSystemDefinition() throws CoreException {
  //
  // //
  // try {
  //
  // File targetFile = Constants.getProjectDescriptionFile(getProject());
  //
  // try (FileWriter fileWriter = new FileWriter(targetFile)) {
  // Activator.getDefault().getSystemDefinitionFactory().save(_contentDefinitionProvider, fileWriter);
  // }
  //
  // } catch (IOException e) {
  //
  // // throw new exception
  // throw new CoreException(new Status(IStatus.ERROR, Constants.BUNDLE_ID_ORG_SLIZAA, e.getMessage(), e));
  // }
  //
  // // refresh
  // getProject().refreshLocal(IResource.DEPTH_ONE, null);
  // }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this._project == null) ? 0 : this._project.hashCode());
    return result;
  }

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
