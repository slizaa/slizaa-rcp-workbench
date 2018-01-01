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

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.ui.PlatformUI;

public class ErrorDialogUtil {

  /**
   * Shows JFace ErrorDialog but improved by constructing full stack trace in detail area.
   */
  public static void errorDialogWithStackTrace(String title, String msg, String pluginId, Throwable t) {

    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    t.printStackTrace(pw);

    final String trace = sw.toString(); // stack trace as a string

    // Temp holder of child statuses
    List<Status> childStatuses = new ArrayList<Status>();

    // Split output by OS-independend new-line
    for (String line : trace.split(System.getProperty("line.separator"))) {
      // build & add status
      childStatuses.add(new Status(IStatus.ERROR, pluginId, line));
    }

    MultiStatus ms = new MultiStatus(pluginId, IStatus.ERROR,
        childStatuses.toArray(new Status[] {}), // convert to array of statuses
        t.getLocalizedMessage(), t);

    ErrorDialog.openError(PlatformUI.getWorkbench().
        getActiveWorkbenchWindow().getShell(), title, msg, ms);
  }

  /**
   * <p>
   * </p>
   * 
   * @param exception
   * @return
   */
  public static Throwable getNestedNonCoreThrowable(Throwable exception) {

    //
    Throwable result = exception;
    List<Throwable> throwables = new LinkedList<Throwable>();

    //
    while (!throwables.contains(result) && result instanceof CoreException && result.getCause() != null) {
      throwables.add(result);
      result = result.getCause();
    }

    //
    return result;
  }
}
