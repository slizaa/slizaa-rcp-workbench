/**
 *
 */
package org.slizaa.rcp.workbench.ui.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.ui.PlatformUI;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class ViewUtils {

  /**
   * <p>
   * </p>
   *
   * @param partId
   */
  public static void activate(String partId, boolean requireFocus) {

    //
    checkNotNull(partId);

    // get the part service
    EPartService partService = getPartService();

    //
    try {
      MPart part = partService.findPart(partId);
      if (part != null) {
        partService.activate(part, requireFocus);
      }
    } catch (Exception e) {
      // ignore
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param partId
   */
  public static void bringViewToTop(String partId) {

    //
    checkNotNull(partId);

    // get the part service
    EPartService partService = getPartService();

    //
    MPart part = partService.findPart(partId);
    if (part != null) {
      partService.bringToTop(part);
    }
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public static EPartService getPartService() {
    return getEclipseContext().get(EPartService.class);
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public static IEclipseContext getEclipseContext() {

    return PlatformUI.getWorkbench().getService(IEclipseContext.class);
    // BundleContext bundleContext = FrameworkUtil.getBundle(ViewUtils.class).getBundleContext();
    //
    // return EclipseContextFactory.getServiceContext(FrameworkUtil.getBundle(ViewUtils.class).getBundleContext());
  }

}
