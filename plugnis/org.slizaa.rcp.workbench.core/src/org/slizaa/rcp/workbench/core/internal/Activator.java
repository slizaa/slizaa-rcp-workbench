/**
 *
 */
package org.slizaa.rcp.workbench.core.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.slizaa.neo4j.hierarchicalgraph.mapping.service.IMappingService;
import org.slizaa.rcp.workbench.core.internal.classpathcontainer.SlizaaSpiApiBundleTracker;
import org.slizaa.scanner.core.api.cypherregistry.ICypherStatement;
import org.slizaa.scanner.core.api.cypherregistry.ICypherStatementRegistry;
import org.slizaa.scanner.core.api.graphdb.IGraphDbFactory;
import org.slizaa.scanner.core.api.importer.IModelImporterFactory;
import org.slizaa.scanner.core.classpathscanner.IClasspathScannerService;
import org.slizaa.scanner.core.cypherregistry.CypherStatementRegistry;
import org.slizaa.scanner.core.cypherregistry.SlizaaCypherFileParser;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class Activator implements BundleActivator {

  /** - */
  private static Activator                                                   _instance;

  /** - */
  private SlizaaSpiApiBundleTracker                                          _slizaaSpiApiBundleTracker;

  /** - */
  private ServiceTracker<IGraphDbFactory, IGraphDbFactory>                   _graphDbFactoryTracker;

  /** - */
  private ServiceTracker<IModelImporterFactory, IModelImporterFactory>       _modelImporterFactoryTracker;

  /** - */
  private ServiceTracker<IMappingService, IMappingService>                   _mappingServiceTracker;

  /** - */
  private ServiceTracker<IClasspathScannerService, IClasspathScannerService> _classpathScannerService;

  /** - */
  private CypherStatementRegistry                                            _cypherStatementRegistry;

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
    this._slizaaSpiApiBundleTracker = new SlizaaSpiApiBundleTracker(context);
    this._slizaaSpiApiBundleTracker.open();

    // create and open the service tracker
    this._modelImporterFactoryTracker = new ServiceTracker<>(context, IModelImporterFactory.class, null);
    this._graphDbFactoryTracker = new ServiceTracker<>(context, IGraphDbFactory.class, null);
    this._classpathScannerService = new ServiceTracker<>(context, IClasspathScannerService.class, null);

    this._modelImporterFactoryTracker.open();
    this._graphDbFactoryTracker.open();
    this._classpathScannerService.open();

    // TODO: OSGi Service!
    this._cypherStatementRegistry = new CypherStatementRegistry(() -> {

      // get the classpath scanner service...
      IClasspathScannerService classpathScannerService = this._classpathScannerService.getService();

      //
      List<ICypherStatement> result = classpathScannerService != null
          ? classpathScannerService.getFiles("cypher", ICypherStatement.class,
              (name, stream) -> SlizaaCypherFileParser.parse(name, stream))
          : Collections.emptyList();

      return result;
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
    this._slizaaSpiApiBundleTracker.close();

    // close the service tracker
    this._modelImporterFactoryTracker.close();
    this._graphDbFactoryTracker.close();
    this._classpathScannerService.close();

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
  public IClasspathScannerService getClasspathScannerService() {
    return service(this._classpathScannerService, IClasspathScannerService.class);
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public IMappingService getMappingService() {
    return service(this._mappingServiceTracker, IMappingService.class);
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public CypherStatementRegistry getCypherStatementRegistry() {
    this._cypherStatementRegistry.rescan();
    return this._cypherStatementRegistry;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public IModelImporterFactory getModelImporterFactory() {
    return service(this._modelImporterFactoryTracker, IModelImporterFactory.class);
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public IGraphDbFactory getGraphDbFactory() {
    return service(this._graphDbFactoryTracker, IGraphDbFactory.class);
  }
  
  /**
   * <p>
   * </p>
   *
   * @param serviceType
   * @return
   */
  private static <T> T service(ServiceTracker<T, T> serviceTracker, Class<T> serviceType) {

    //
    T result = checkNotNull(serviceTracker).getService();

    //
    if (result == null) {
      throw new RuntimeException(String.format("Service of type '%s' not found.", serviceType.getName()));
    }

    //
    return result;
  }
}
