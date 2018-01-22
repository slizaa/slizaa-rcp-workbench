package org.slizaa.rcp.workbench.core.internal;

import org.eclipse.core.expressions.PropertyTester;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class OSGiServicePropertyTester extends PropertyTester {

  /** - */
  private static final String PROPERTY_IS_SERVICE_REGISTERED = "isServiceRegistered"; // $NON-NLS-1

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

    //
    if (PROPERTY_IS_SERVICE_REGISTERED.equals(property) && expectedValue != null) {

      // bundle context
      BundleContext bundleContext = FrameworkUtil.getBundle(OSGiServicePropertyTester.class).getBundleContext();

      //
      ServiceReference<?> serviceReference = bundleContext.getServiceReference(expectedValue.toString());

      //
      return serviceReference != null;
    }

    // default: false
    return false;
  }
}