/**
 *
 */
package org.slizaa.hierarchicalgraph.core.ui.dependencytree.internal.osgi;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slizaa.hierarchicalgraph.core.ui.dependencytree.internal.DependencyTreePart;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 */
public class Activator implements BundleActivator {

  /**
   * {@inheritDoc}
   */
  @Override
  public void start(BundleContext bundleContext) throws Exception {

    //
    if (PlatformUI.isWorkbenchRunning()) {

      // get the eclipse context..
      IEclipseContext eclipseContext = PlatformUI.getWorkbench().getService(IEclipseContext.class);

      //
      Injector injector = Guice.createInjector(new DependencyTreeModule(eclipseContext));

      // ...and set the injector
      eclipseContext.set(DependencyTreePart.INJECTOR_KEY, injector);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void stop(BundleContext bundleContext) throws Exception {

    //
    if (PlatformUI.isWorkbenchRunning()) {

      // get the eclipse context..
      IEclipseContext eclipseContext = PlatformUI.getWorkbench().getService(IEclipseContext.class);

      // ...and remove the injector
      if (eclipseContext != null) {
        eclipseContext.remove(DependencyTreePart.INJECTOR_KEY);
      }
    }
  }
}
