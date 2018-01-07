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
package org.slizaa.rcp.workbench.ui.internal.handler;

import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ISelection;
import org.slizaa.hierarchicalgraph.HGRootNode;
import org.slizaa.rcp.workbench.ui.internal.Activator;

/**
 * Abstract base class for BundleMaker-based command handlers.
 * 
 * <p>
 * This class provides access to the IArtifact objects, that are selected in the navigator view
 * 
 * @author Nils Hartmann (nils@nilshartmann.net)
 * 
 */
public abstract class AbstractAnalysisModelElementBasedHandler extends AbstractSlizaaHandler {

  @Override
  protected void execute(ExecutionEvent event, ISelection structuredSelection) throws Exception {
    List<HGRootNode> selectedArtifacts = getSelectedObjects(structuredSelection, HGRootNode.class);

    // Invoke execution method
    execute(event, selectedArtifacts);
  }

  /**
   * Will be invoked when the command is executed. Subclasses must override this method to provide their execution logic
   * 
   * @param selectedArtifacts
   *          The {@link IArtifact} objects that are selected in the tree. Never null.
   */
  protected abstract void execute(ExecutionEvent event, List<HGRootNode> selectedArtifacts) throws Exception;

  @Override
  protected void reportError(String pluginId, String message, Throwable ex) {
    Status errorStatus = new Status(IStatus.ERROR, pluginId, message, ex);
    Activator.getDefault().getLog().log(errorStatus);
  }

}
