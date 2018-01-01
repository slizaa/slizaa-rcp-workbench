/*******************************************************************************
 * Copyright (c) 2011-2015 slizaa project team. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: slizaa project team - initial API and implementation
 ******************************************************************************/
package org.slizaa.rcp.workbench.ui.internal.handler;

import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ISelection;
import org.slizaa.neo4j.hierarchicalgraph.mapping.spi.IMappingProvider;
import org.slizaa.rcp.workbench.core.ISlizaaProject;
import org.slizaa.rcp.workbench.core.SlizaaWorkbenchCore;

public class CreateHierarchicalGraphHandler extends AbstractSlizaaHandler implements IHandler {

  @Override
  protected void execute(ExecutionEvent event, ISelection selection) throws Exception {

    // get the selected resource
    List<IResource> selectedObjects = getSelectedObject(selection, IResource.class);

    // check if there's at least one resource
    if (selectedObjects.isEmpty()) {
      return;
    }

    // grab resource and get the project
    IResource selectedResource = selectedObjects.get(0);
    IProject project = selectedResource.getProject();
    ISlizaaProject slizaaProject = SlizaaWorkbenchCore.getSlizaaProject(project);

    // TODO
    IMappingProvider mappingProvider = null;

    // user pressed cancel
    if (mappingProvider == null) {
      return;
    }

    //
    // LoadModelFromGraphDatabaseJob myJob = new
    // LoadModelFromGraphDatabaseJob(Activator.getDefault().getWorkbenchModel(),
    // Activator.getDefault().getHierarchicalGraphMappingServiceTracker(), slizaaProject.getNeo4jClient(),
    // mappingDescriptor);
    //
    // myJob.schedule();

    // //
    // Display.getDefault().asyncExec(new Runnable() {
    // public void run() {
    // MPart part = _partService.findPart(HierarchicalGraphViewPart.PART_ID);
    // _partService.bringToTop(part);
    // }
    // });
  }
}
