/**
 *
 */
package org.slizaa.rcp.workbench.core.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.osgi.framework.FrameworkUtil;
import org.slizaa.rcp.workbench.core.internal.extensions.SlizaaExtensionsBundleTracker;
import org.slizaa.rcp.workbench.core.model.SlizaaExtensionBundle;
import org.slizaa.scanner.core.spi.annotations.ParserFactory;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 */
public class SlizaaExtensionBundleTrackerTest {

  @Test
  public void test() throws Exception {

    //
    SlizaaExtensionsBundleTracker bundleTracker = new SlizaaExtensionsBundleTracker(
        FrameworkUtil.getBundle(SlizaaExtensionsBundleTracker.class).getBundleContext());

    //
    bundleTracker.open();

    //
    assertThat(bundleTracker.getTracked().values()).hasSize(2);
    for (SlizaaExtensionBundle slizaaExtensionBundle : bundleTracker.getTracked().values()) {

      System.out.println(slizaaExtensionBundle.getDefinedExtensions().get(ParserFactory.class));

    }

    //
    bundleTracker.close();
  }
}
