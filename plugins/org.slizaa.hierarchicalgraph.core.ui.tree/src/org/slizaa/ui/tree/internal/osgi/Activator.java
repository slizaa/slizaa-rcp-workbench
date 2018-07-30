package org.slizaa.ui.tree.internal.osgi;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.slizaa.ui.tree.ISlizaaActionContributionProvider;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

  // The plug-in ID
  public static final String                     PLUGIN_ID = "org.slizaa.ui.tree"; //$NON-NLS-1$

  // The shared instance
  private static Activator                       plugin;

  /** - */
  private ComposedAdapterFactory                 _adapterFactory;

  /** - */
  private ServiceTracker<IWorkbench, IWorkbench> _workBenchServiceTracker;

  /** - */
  private OSGiBasedActionContributionProvider    _contributionProvider;

  /**
   * Returns the shared instance
   *
   * @return the shared instance
   */
  public static Activator getDefault() {
    return plugin;
  }

  /**
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
   */
  public void start(BundleContext context) throws Exception {
    super.start(context);
    plugin = this;

    _contributionProvider = new OSGiBasedActionContributionProvider(context);
    _contributionProvider.init();

    //
    _workBenchServiceTracker = new ServiceTracker<>(context, IWorkbench.class, null);
    _workBenchServiceTracker.open();
  }

  /**
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
   */
  public void stop(BundleContext context) throws Exception {
    plugin = null;
    super.stop(context);

    _contributionProvider.dispose();
    _workBenchServiceTracker.close();
  }

  /**
   * Gives access to the composed adapter factory.
   *
   * @return the adapter factory
   */
  public ComposedAdapterFactory getComposedAdapterFactory() {
    if (_adapterFactory == null) {
      _adapterFactory = new ComposedAdapterFactory(new AdapterFactory[] { new ReflectiveItemProviderAdapterFactory(),
          new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE) });
    }
    return _adapterFactory;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public ISlizaaActionContributionProvider getSlizaaActionContributionProvider() {
    return _contributionProvider;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public IEclipseContext getEclipseContext() {
    return _workBenchServiceTracker.getService().getApplication().getContext();
  }
}
