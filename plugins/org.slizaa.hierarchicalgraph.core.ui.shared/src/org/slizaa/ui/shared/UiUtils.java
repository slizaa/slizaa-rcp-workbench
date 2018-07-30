package org.slizaa.ui.shared;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

public class UiUtils {

  public static String getCurrentPartId() {
    //
    String partId = null;
    try {
      IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
      partId = page.getActivePart().getSite().getId();
    } catch (Exception e) {
      // ignore
    }
    return partId;
  }

  public static String getCurrentPerspectiveId() {
    //
    String result = null;
    try {
      result = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getPerspective().getId();
    } catch (Exception e) {
      // ignore
    }
    return result;
  }
}
