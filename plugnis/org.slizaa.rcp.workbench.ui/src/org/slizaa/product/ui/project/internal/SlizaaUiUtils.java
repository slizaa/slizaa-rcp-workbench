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
package org.slizaa.product.ui.project.internal;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.slizaa.product.ui.project.Activator;

/**
 * <p>
 * Common utils needed for UI parts of Bundlemaker
 * </p>
 * 
 * @author Nils Hartmann (nils@nilshartmann.net)
 */
public class SlizaaUiUtils {

  /**
   * Creates a new {@link IStatus} object reporting a Warning
   * <p>
   * </p>
   * 
   * @param message
   *          The error message
   * @param throwable
   *          The causing throwable if applicable, otherwise null
   * @return
   */
  public static IStatus newWarning(String message, Throwable throwable) {
    return new Status(IStatus.WARNING, Activator.PLUGIN_ID, message, throwable);
  }

  /**
   * Creates a new {@link IStatus} object reporting an Error
   * <p>
   * </p>
   * 
   * @param message
   *          The error message
   * @param throwable
   *          The causing throwable if applicable, otherwise null
   * @return
   */
  public static IStatus newError(String message, Throwable throwable) {
    int severity = Status.ERROR;
    if (throwable instanceof CoreException) {
      severity = ((CoreException) throwable).getStatus().getSeverity();
    }
    return new Status(severity, Activator.PLUGIN_ID, message, throwable);
  }

  /**
   * <p>
   * Constructs a new {@link IStatus} for the given {@link CoreException}.
   * </p>
   * 
   * @param coreException
   *          The coreException
   * @param message
   *          An optional message. If null the message from the coreException will be used
   * @return
   */
  public static IStatus newStatus(CoreException coreException, String message) {
    String actualMessage = (message == null ? coreException.getMessage() : message);
    return new Status(coreException.getStatus().getSeverity(), Activator.PLUGIN_ID, actualMessage, coreException);
  }

  /**
   * Logs the given error
   * <p>
   * </p>
   * 
   * @param message
   *          The message
   * @param throwable
   *          The causing throwable if applicable
   */
  public static void logError(String message, Throwable throwable) {
    IStatus error = newError(message, throwable);
    Activator.getDefault().getLog().log(error);
  }

  public static void logErrorMessage(String message, Object... args) {
    IStatus error = newError(String.format(message, args), null);
    Activator.getDefault().getLog().log(error);
  }

//  public static void refreshProjectExplorer(IProjectDescriptionAwareBundleMakerProject bundleMakerProject) {
//    // TODO: better way to refresh BundleMaker Navigator entries?
//    IViewPart projectExplorerView = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
//        .findView("org.eclipse.ui.navigator.ProjectExplorer");
//    if (projectExplorerView instanceof CommonNavigator) {
//      CommonNavigator navigator = (CommonNavigator) projectExplorerView;
//      navigator.getCommonViewer().refresh(bundleMakerProject.getProject());
//    }
//  }
//
//  public static void refreshProjectExplorer() {
//    IViewPart projectExplorerView = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
//        .findView("org.eclipse.ui.navigator.ProjectExplorer");
//    if (projectExplorerView instanceof CommonNavigator) {
//      CommonNavigator navigator = (CommonNavigator) projectExplorerView;
//      navigator.getCommonViewer().refresh();
//    }
//  }
}
