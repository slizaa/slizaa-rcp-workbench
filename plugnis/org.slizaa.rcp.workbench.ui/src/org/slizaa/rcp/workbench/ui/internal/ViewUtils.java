/**
 *
 */
package org.slizaa.rcp.workbench.ui.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.ui.PlatformUI;
import org.slizaa.hierarchicalgraph.graphdb.ui.hierarchicalgraphview.HierarchicalGraphViewPart;

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
  public static void bringViewToTop(String partId) {

    //
    checkNotNull(partId);

    // get the part service
    EPartService partService = getPartService();

    //
    for (MPart part : partService.getParts()) {
      System.out.println(part.getElementId());
    }

    //
    MPart part = partService.findPart(HierarchicalGraphViewPart.PART_ID);
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
