/*******************************************************************************
 * Copyright (c) 2011-2015 slizaa project team. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: slizaa project team - initial API and implementation
 ******************************************************************************/
package org.slizaa.rcp.workbench.ui.internal.handler;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.slizaa.hierarchicalgraph.HGRootNode;
import org.slizaa.hierarchicalgraph.graphdb.ui.hierarchicalgraphview.HierarchicalGraphViewPart;
import org.slizaa.hierarchicalgraph.graphdb.ui.mappingsdialog.MappingsProviderDialog;
import org.slizaa.neo4j.hierarchicalgraph.mapping.spi.IMappingProvider;
import org.slizaa.rcp.workbench.core.ProjectExtensionsUtils;
import org.slizaa.rcp.workbench.core.SlizaaWorkbenchCore;
import org.slizaa.rcp.workbench.core.model.SlizaaProject;
import org.slizaa.rcp.workbench.ui.internal.Activator;
import org.slizaa.rcp.workbench.ui.internal.SlizaaUiUtils;
import org.slizaa.rcp.workbench.ui.internal.ViewUtils;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class CreateHierarchicalGraphHandler extends AbstractSlizaaHandler implements IHandler {

  @Override
  protected void execute(ExecutionEvent event, ISelection selection) throws Exception {

    // get the selected resource
    List<IResource> selectedObjects = getSelectedObjects(selection, IResource.class);

    // check if there's at least one resource
    if (selectedObjects.isEmpty()) {
      return;
    }

    // grab resource and get the project
    IResource selectedResource = selectedObjects.get(0);
    SlizaaProject slizaaProject = SlizaaWorkbenchCore.getSlizaaProject(selectedResource.getProject());

    //
    SlizaaWorkbenchCore.cleanBuildAll();

    //
    List<IMappingProvider> extensions = ProjectExtensionsUtils.getProjectExtensions_MappingProvider();

    //
    MappingsProviderDialog dialog = new MappingsProviderDialog(SlizaaUiUtils.getShell(), () -> extensions);
    dialog.open();

    //
    if (dialog.getReturnCode() == Window.OK) {

      //
      IMappingProvider mappingProvider = dialog.getSelectedMappingProvider();

      // Execute runnable via IProgressService
      try {

        //
        PlatformUI.getWorkbench().getProgressService().busyCursorWhile((monitor) -> {

          //
          try {

            // execute with console
            ConsoleHelper.executeWithConsole(() -> {

              // set hgRootNode
              HGRootNode hgRootNode = slizaaProject.mapToHierachicalGraph(mappingProvider, monitor);

              // set global
              Activator.getDefault().getWorkbenchModel().setRootNode(hgRootNode);
            });

          } catch (Exception e) {
            throw new RuntimeException(e);
          }
        });
      }

      //
      catch (InvocationTargetException ex) {

        // Report Error to error log
        Throwable cause = ex.getCause();
        cause.printStackTrace();

      } catch (InterruptedException ex) {
        // ignore. User has canceled the operation
      }

      //
      Display.getDefault().asyncExec(() -> {
        ViewUtils.bringViewToTop(HierarchicalGraphViewPart.PART_ID);
      });
    }
  }
}
