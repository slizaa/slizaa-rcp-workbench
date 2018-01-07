/**
 *
 */
package org.slizaa.rcp.workbench.core.internal;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.wiring.BundleWiring;
import org.osgi.util.tracker.ServiceTracker;
import org.slizaa.rcp.workbench.core.internal.classpathcontainer.SlizaaSpiApiBundleTracker;
import org.slizaa.scanner.core.api.graphdb.IGraphDbFactory;
import org.slizaa.scanner.core.api.importer.IModelImporterFactory;
import org.slizaa.scanner.core.classpathscanner.ClasspathScannerFactoryBuilder;
import org.slizaa.scanner.core.classpathscanner.IClasspathScannerFactory;

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
  private IClasspathScannerFactory                                     _classpathScannerFactory;

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
  public Map<Bundle, Map<Class<?>, List<Class<?>>>> getTrackedExtensionBundles() {
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
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void stop(BundleContext context) throws Exception {

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
  public IClasspathScannerFactory getClasspathScannerFactory() {
    return this._classpathScannerFactory;
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
