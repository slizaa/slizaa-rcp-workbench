package org.slizaa.rcp.workbench.ui.internal.handler;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.ui.PlatformUI;

public final class EclipseContextHelper {

  public static IEclipseContext getActiveContext() {
    IEclipseContext context = getWorkbenchContext();
    return context == null ? null : context.getActiveLeaf();
  }

  public static IEclipseContext getWorkbenchContext() {
    return PlatformUI.getWorkbench().getService(IEclipseContext.class);
  }
}