package org.slizaa.rcp.workbench.core.internal.builder;

import java.util.Arrays;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.slizaa.rcp.workbench.core.SlizaaWorkbenchCore;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class MarkerUtils {

  /** - */
  private final static String[] MARKERTYPES_TO_DELETE_ON_CLEAN = {
      SlizaaWorkbenchCore.SLIZAA_CONFIGURATION_PROBLEM_MARKER };

  /**
   * <p>
   * </p>
   *
   * @param resource
   */
  public static void deleteMarker(IResource resource) {

    //
    Arrays.asList(MARKERTYPES_TO_DELETE_ON_CLEAN).forEach(m -> {
      try {
        resource.deleteMarkers(m, true, IResource.DEPTH_INFINITE);
      } catch (CoreException e) {
        // ignore
      }
    });
  }

}
