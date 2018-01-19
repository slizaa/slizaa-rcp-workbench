/*******************************************************************************
 * Copyright (c) 2011-2015 slizaa project team. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: slizaa project team - initial API and implementation
 ******************************************************************************/
package org.slizaa.rcp.workbench.ui.internal.handler;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.PlatformUI;
import org.slizaa.rcp.workbench.core.SlizaaWorkbenchCore;
import org.slizaa.rcp.workbench.core.model.SlizaaProject;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class ParseSlizaaProjectHandler extends AbstractSlizaaHandler implements IHandler {

  /**
   * {@inheritDoc}
   */
  @Override
  protected void execute(ExecutionEvent event, ISelection selection) throws Exception {

    // //
    // System.out.println(EclipseContextHelper.getWorkbenchContext());
    // System.out.println(EclipseContextHelper.getWorkbenchContext().get(EModelService.class));
    //
    // MApplication mapplication = EclipseContextHelper.getWorkbenchContext().get(MApplication.class);
    // MTrimmedWindow mWindow = (MTrimmedWindow) mapplication.getChildren().get(0);
    // System.out.println(mWindow);
    // mWindow.setLabel("BUMM");

    // get the selected resource
    IResource selectedObject = getSelectedObject(selection, IResource.class);

    // check if there's one resource
    if (selectedObject == null) {
      return;
    }

    // grab resource and get the project
    SlizaaProject slizaaProject = SlizaaWorkbenchCore.getSlizaaProject(selectedObject.getProject());
    slizaaProject.cleanBuild();

    // Execute runnable via IProgressService
    try {
      PlatformUI.getWorkbench().getProgressService().busyCursorWhile((monitor) -> {
        try {

          // execute with console
          ConsoleHelper.executeWithConsole(() -> slizaaProject.parse(monitor));

        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      });
    } catch (InvocationTargetException ex) {

      // Report Error to error log
      Throwable cause = ex.getCause();
      cause.printStackTrace();

    } catch (InterruptedException ex) {
      // ignore. User has canceled the operation
    }
  }
}
