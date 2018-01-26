/**
 *
 */
package org.slizaa.rcp.workbench.core.internal;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.wiring.BundleWiring;
import org.osgi.util.tracker.ServiceTracker;
import org.slizaa.neo4j.hierarchicalgraph.mapping.service.IMappingService;
import org.slizaa.rcp.workbench.core.internal.classpathcontainer.SlizaaSpiApiBundleTracker;
import org.slizaa.rcp.workbench.core.internal.extensions.SlizaaExtensionsBundleTracker;
import org.slizaa.rcp.workbench.core.model.SlizaaExtensionBundle;
import org.slizaa.scanner.core.api.cypherregistry.ICypherStatementRegistry;
import org.slizaa.scanner.core.api.graphdb.IGraphDbFactory;
import org.slizaa.scanner.core.api.importer.IModelImporterFactory;
import org.slizaa.scanner.core.classpathscanner.ClasspathScannerFactoryBuilder;
import org.slizaa.scanner.core.classpathscanner.IClasspathScannerFactory;
import org.slizaa.scanner.core.cypherregistry.CypherStatementRegistry;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class Activator implements BundleActivator {

  /** - */
  private static Activator                                             _instance;

  /** - */
  private SlizaaExtensionsBundleTracker                                _slizaaExtensionsTracker;

  /** - */
  private SlizaaSpiApiBundleTracker                                    _slizaaSpiApiBundleTracker;

  /** - */
  private ServiceTracker<IGraphDbFactory, IGraphDbFactory>             _graphDbFactoryTracker;

  /** - */
  private ServiceTracker<IModelImporterFactory, IModelImporterFactory> _modelImporterFactoryTracker;

  /** - */
  private ServiceTracker<IMappingService, IMappingService>             _mappingServiceTracker;

  /** - */
  private IClasspathScannerFactory                                     _classpathScannerFactory;

  /** - */
  private CypherStatementRegistry                                      _cypherStatementRegistry;

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public Map<Bundle, Set<Bundle>> getTrackedSpiApiBundles() {
    return this._slizaaSpiApiBundleTracker.getTracked();
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public Map<Bundle, SlizaaExtensionBundle> getTrackedExtensionBundles() {
    return this._slizaaExtensionsTracker.getTracked();
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public static Activator instance() {
    return _instance;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void start(BundleContext context) throws Exception {

    //
    _instance = this;

    //
    this._mappingServiceTracker = new ServiceTracker<>(context, IMappingService.class, null);
    this._mappingServiceTracker.open();

    //
    this._slizaaExtensionsTracker = new SlizaaExtensionsBundleTracker(context);
    this._slizaaExtensionsTracker.open();

    //
    this._slizaaSpiApiBundleTracker = new SlizaaSpiApiBundleTracker(context);
    this._slizaaSpiApiBundleTracker.open();

    // create and open the service tracker
    this._modelImporterFactoryTracker = new ServiceTracker<>(context, IModelImporterFactory.class, null);
    this._graphDbFactoryTracker = new ServiceTracker<>(context, IGraphDbFactory.class, null);

    this._modelImporterFactoryTracker.open();
    this._graphDbFactoryTracker.open();

    //
    this._classpathScannerFactory = ClasspathScannerFactoryBuilder.newClasspathScannerFactory()
        .registerCodeSourceClassLoaderProvider(ClassLoader.class, c -> c)
        .registerCodeSourceClassLoaderProvider(Bundle.class, b -> b.adapt(BundleWiring.class).getClassLoader())
        .create();

    this._cypherStatementRegistry = new CypherStatementRegistry(() -> {
      return this._slizaaExtensionsTracker.getTracked().values().stream()
          .flatMap(extensionBundle -> extensionBundle.getDefinedCypherStatements().stream())
          .collect(Collectors.toList());
    });
    context.registerService(ICypherStatementRegistry.class, this._cypherStatementRegistry, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void stop(BundleContext context) throws Exception {

    //
    this._mappingServiceTracker.close();

    //
    this._slizaaExtensionsTracker.close();

    //
    this._slizaaSpiApiBundleTracker.close();

    // close the service tracker
    this._modelImporterFactoryTracker.close();
    this._graphDbFactoryTracker.close();

    this._modelImporterFactoryTracker = null;
    this._graphDbFactoryTracker = null;

    //
    _instance = null;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public IMappingService getMappingService() {
    return this._mappingServiceTracker.getService();
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public IClasspathScannerFactory getClasspathScannerFactory() {
    return this._classpathScannerFactory;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public CypherStatementRegistry getCypherStatementRegistry() {
    return this._cypherStatementRegistry;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public IModelImporterFactory getModelImporterFactory() {

    IModelImporterFactory result = this._modelImporterFactoryTracker.getService();

    if (result == null) {
      // startRequiredBundles();
      // if (result == null) {
      throw new RuntimeException("Service IModelImporterFactory not found.");
      // }
    }

    return result;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public IGraphDbFactory getGraphDbFactory() {

    IGraphDbFactory result = this._graphDbFactoryTracker.getService();

    if (result == null) {
      // startRequiredBundles();
      // if (result == null) {
      throw new RuntimeException("Service IGraphDbFactory not found.");
      // }
    }

    return result;
  }
}
