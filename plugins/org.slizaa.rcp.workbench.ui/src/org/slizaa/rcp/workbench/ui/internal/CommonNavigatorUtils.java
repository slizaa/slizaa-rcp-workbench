/*******************************************************************************
 * Copyright (c) 2011-2015 slizaa project team.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    slizaa project team - initial API and implementation
 ******************************************************************************/
package org.slizaa.rcp.workbench.ui.internal;

import org.eclipse.core.runtime.Status;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonNavigator;

/**
 * <p>
 * </p>
 * 
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class CommonNavigatorUtils {

  /** the id of the Eclipse project explorer */
  public static final String PROJECT_EXPLORER_VIEW_ID = IPageLayout.ID_PROJECT_EXPLORER;

  // /**
  // * <p>
  // * </p>
  // *
  // * @param identifier
  // */
  // public static void update(String identifier) {
  // CommonNavigator commonNavigator = findCommonNavigator(identifier);
  // if (commonNavigator != null) {
  // commonNavigator.getNavigatorContentService().update();
  // }
  // }

//  /**
//   * <p>
//   * </p>
//   */
//  public static void refresh(String identifier, IAnalysisModelElement... artifacts) {
//
//    //
//    CommonNavigator commonNavigator = findCommonNavigator(identifier);
//
//    if (commonNavigator == null) {
//      return;
//    }
//
//    if (artifacts == null || artifacts.length < 1) {
//      // No artifact given => refresh all
//      commonNavigator.getCommonViewer().refresh();
//    } else {
//      // refresh individual artifacts
//      for (IAnalysisModelElement iArtifact : artifacts) {
//        commonNavigator.getCommonViewer().refresh(iArtifact);
//      }
//    }
//
//  }

  // public static void refreshProject(String identifier, ISlizaaProject bundleMakerProject) {
  // if (bundleMakerProject == null) {
  // return;
  // }
  //
  // CommonNavigator commonNavigator = findCommonNavigator(identifier);
  //
  // if (commonNavigator == null) {
  // return;
  // }
  //
  // IProject project = bundleMakerProject.getProject();
  //
  // commonNavigator.getCommonViewer().refresh(project);
  //
  // }

  /**
   * <p>
   * </p>
   * 
   * @param navigatorViewId
   * @return
   */
  public static CommonNavigator findCommonNavigator(String navigatorViewId) {
    try {
      IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
      if (page != null) {
        IViewPart view = page.findView(navigatorViewId);
        if (view != null && view instanceof CommonNavigator)
          return ((CommonNavigator) view);
      }
    } catch (Exception e) {
      return null;
    }
    return null;
  }

  public static void activateCommonNavigator(String navigatorViewId) {
    CommonNavigator navigator = findCommonNavigator(navigatorViewId);
    IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    if (navigator == null) {
      try {
        page.showView(navigatorViewId);
      } catch (PartInitException ex) {
        Activator
            .getDefault()
            .getLog()
            .log(
                new Status(Status.ERROR, Activator.PLUGIN_ID, "Could not open view '" + navigatorViewId + "': " + ex,
                    ex));
      }
    }
    page.activate(navigator);
  }
}
