/**
 *
 */
package org.slizaa.rcp.workbench.core.internal.classpathcontainer;

import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTracker;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class SlizaaSpiApiBundleTracker extends BundleTracker<Set<Bundle>> {

  /**
   * <p>
   * Creates a new instance of type {@link SlizaaSpiApiBundleTracker}.
   * </p>
   *
   * @param context
   */
  public SlizaaSpiApiBundleTracker(BundleContext context) {
    super(context, Bundle.RESOLVED | Bundle.STARTING | Bundle.ACTIVE, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Set<Bundle> addingBundle(Bundle bundle, BundleEvent event) {

    //
    String slizaaSpiApi = bundle.getHeaders().get(SpiApiClasspathContainerConstants.SLIZAA_SPI_API_BUNDLE_HEADER);

    //
    if (slizaaSpiApi != null && !slizaaSpiApi.isEmpty()) {
      return new OSGiTransitiveClosureResolver(bundle).computeTransitiveClosure();
    }
    //
    else {
      return null;
    }
  }
}
