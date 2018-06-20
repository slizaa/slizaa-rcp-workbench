/**
 *
 */
package org.slizaa.rcp.workbench.core.model.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.slizaa.hierarchicalgraph.HGRootNode;
import org.slizaa.hierarchicalgraph.graphdb.mapping.spi.IMappingProvider;
import org.slizaa.neo4j.dbadapter.DbAdapterFactory;
import org.slizaa.neo4j.dbadapter.Neo4jClient;
import org.slizaa.neo4j.hierarchicalgraph.mapping.service.IMappingService;
import org.slizaa.rcp.workbench.core.BundleExtensionsUtils;
import org.slizaa.rcp.workbench.core.ProjectExtensionsUtils;
import org.slizaa.rcp.workbench.core.internal.Activator;
import org.slizaa.rcp.workbench.core.internal.utils.BuildHelper;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel;
import org.slizaa.scanner.core.api.cypherregistry.ICypherStatement;
import org.slizaa.scanner.core.api.graphdb.IGraphDb;
import org.slizaa.scanner.core.api.importer.IModelImporter;
import org.slizaa.scanner.core.api.importer.IModelImporterFactory;
import org.slizaa.scanner.core.spi.contentdefinition.IContentDefinitionProvider;
import org.slizaa.scanner.core.spi.parser.IParserFactory;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 */
public class ExtendedSlizaaProjectImpl extends SlizaaProjectImpl {

  /** the bundle make directory name */
  public static final String SLIZAA_DEFAULT_DATABASE_DIRECTORY_NAME = ".slizaa";

  /**
   * <p>
   * </p>
   *
   * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
   */
  @FunctionalInterface
  public interface SlizaaProjectDynamicAction {

    /**
     * <p>
     * </p>
     *
     * @throws CoreException
     */
    void execute() throws CoreException;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void dispose() {
    //
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void cleanBuild() {

    //
    try

    {
      BuildHelper.cleanBuildProject(this.getProject());
      BuildHelper.failOnErrors(this.getProject());
    }
    //
    catch (CoreException exception) {
      //
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void parse(IProgressMonitor monitor) {

    // create new null monitor if necessary
    if (monitor == null) {
      monitor = new NullProgressMonitor();
    }

    // create the sub-monitor
    final SubMonitor subMonitor = SubMonitor.convert(monitor, 100);

    //
    shutdownDatabase();

    //
    monitor.subTask("Parsing...");
    internalParse(subMonitor.newChild(90));

    //
    monitor.subTask("Launching graph database...");
    startAndConnectDatabase(subMonitor.newChild(10));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void startAndConnectDatabase(IProgressMonitor monitor) {

    //
    if (this.graphDatabaseInstance == null) {

      //
      IGraphDb graphDb = Activator.instance().getGraphDbFactory().newGraphDb(5001, getDatabaseDirectory(getProject()))
          .withUserObject(this).create();

      //
      setGraphDatabaseInstance(graphDb);
    }

    //
    if (this.boltClient == null) {

      //
      Neo4jClient boltClient = DbAdapterFactory.eINSTANCE.createNeo4jClient();
      boltClient.setUri("bolt://localhost:" + this.graphDatabaseInstance.getPort());
      boltClient.setName(this.getProject().getName());
      boltClient.setDescription(this.getProject().getName());
      boltClient.connect();

      //
      setBoltClient(boltClient);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public HGRootNode mapToHierachicalGraph(IMappingProvider mappingProvider, IProgressMonitor monitor) {

    // get the mapping service
    IMappingService mappingService = Activator.instance().getMappingService();

    // get the root node
    HGRootNode rootNode = mappingService.convert(mappingProvider, getBoltClient(), monitor);

    //
    setHierachicalGraph(rootNode);

    //
    return rootNode;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isDatabaseDirectoryPopulated() {

    //
    IFolder databaseDirectory = this.project.getFolder(SLIZAA_DEFAULT_DATABASE_DIRECTORY_NAME);

    //
    try {
      return databaseDirectory.exists() && databaseDirectory.members().length > 0;
    } catch (CoreException e) {
      return false;
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param newGraphDatabaseInstance
   */
  public void setGraphDatabaseInstance(IGraphDb newGraphDatabaseInstance) {

    //
    IGraphDb oldGraphDatabaseInstance = this.graphDatabaseInstance;

    //
    this.graphDatabaseInstance = newGraphDatabaseInstance;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.SLIZAA_PROJECT__GRAPH_DATABASE_INSTANCE,
          oldGraphDatabaseInstance, this.graphDatabaseInstance));
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param newBoltClient
   */
  public void setBoltClient(Neo4jClient newBoltClient) {

    Neo4jClient oldBoltClient = this.boltClient;

    this.boltClient = newBoltClient;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.SLIZAA_PROJECT__BOLT_CLIENT, oldBoltClient,
          this.boltClient));
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param newProject
   */
  public void setProject(IProject newProject) {
    IProject oldProject = this.project;
    this.project = newProject;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.SLIZAA_PROJECT__PROJECT, oldProject,
          this.boltClient));
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param newConfiguration
   */
  public void setConfiguration(SlizaaProjectConfigurationModel newConfiguration) {
    SlizaaProjectConfigurationModel oldConfiguration = this.configuration;
    this.configuration = newConfiguration;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.SLIZAA_PROJECT__CONFIGURATION,
          oldConfiguration, this.configuration));
    }
  }

  /**
   */
  public void setHierachicalGraph(HGRootNode newHierachicalGraph) {
    HGRootNode oldHierachicalGraph = this.hierachicalGraph;
    this.hierachicalGraph = newHierachicalGraph;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.SLIZAA_PROJECT__HIERACHICAL_GRAPH,
          oldHierachicalGraph, this.hierachicalGraph));
    }
  }

  /**
   * <p>
   * </p>
   */
  private void shutdownDatabase() {

    //
    if (this.getBoltClient() != null) {
      this.getBoltClient().disconnect();
      setBoltClient(null);
    }

    //
    if (this.getGraphDatabaseInstance() != null) {
      this.getGraphDatabaseInstance().shutdown();
      this.setGraphDatabaseInstance(null);
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param progressMonitor
   */
  private void internalParse(IProgressMonitor progressMonitor) {

    // delete the old database directory...
    try {

      // get the root path
      Path rootPath = Paths.get(getDatabaseDirectory(getProject()).getAbsolutePath());

      // delete all contained files
      Files.walk(rootPath, FileVisitOption.FOLLOW_LINKS).sorted(Comparator.reverseOrder()).map(Path::toFile)
          .forEach(File::delete);

    } catch (IOException e) {
      // simply ignore
    }

    try {
      executeWithProperties(() -> {

        // fetch all parser factories
        List<IParserFactory> parserFactories = new ArrayList<>();
        parserFactories.addAll(ProjectExtensionsUtils.getProjectExtensions_ParserFactory(this));
        parserFactories.addAll(BundleExtensionsUtils.getBundleExtensions_ParserFactory());

        // fetch all cypher statements
        List<ICypherStatement> cypherStatements = Activator.instance().getCypherStatementRegistry().getAllStatements();

        // TODO
        for (ICypherStatement cypherStatement : cypherStatements) {
          System.out.println("cypherStatement: " + cypherStatement);
        }

        // TODO
        IContentDefinitionProvider contentDefinitionProvider = getConfiguration().getInjector()
            .getInstance(IContentDefinitionProvider.class);

        // create a new model importer...
        IModelImporterFactory modelImporterFactory = Activator.instance().getModelImporterFactory();
        IModelImporter modelImporter = modelImporterFactory.createModelImporter(contentDefinitionProvider,
            getDatabaseDirectory(getProject()), parserFactories, cypherStatements);

        // ... and parse the content
        modelImporter.parse(progressMonitor, () -> Activator.instance().getGraphDbFactory()
            .newGraphDb(5001, getDatabaseDirectory(getProject())).withUserObject(this).create());

        //
        this.graphDatabaseInstance = modelImporter.getGraphDb();

        // refresh local
        getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
      });
    } catch (CoreException coreException) {
      coreException.printStackTrace();
    }

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
    properties.put("slizaa.project.directory", this.getProject().getLocation().toOSString());

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
   * <p>
   * </p>
   *
   * @param project
   * @return
   */
  private static File getDatabaseDirectory(IProject project) {
    return project.getFolder(SLIZAA_DEFAULT_DATABASE_DIRECTORY_NAME).getRawLocation().toFile();
  }
}
