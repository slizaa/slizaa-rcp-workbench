/*******************************************************************************
 * Copyright (c) 2011-2015 slizaa project team. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: slizaa project team - initial API and implementation
 ******************************************************************************/
package org.slizaa.rcp.workbench.ui.internal.handler;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.slizaa.rcp.workbench.ui.internal.Activator;

/**
 * Abstract base class for BundleMaker-based command handlers.
 * <p>
 * This class provides some convenience methods for own handler implementations
 * </p>
 *
 * @author Nils Hartmann (nils@nilshartmann.net)
 *
 */
public abstract class AbstractSlizaaHandler extends AbstractHandler implements IHandler {
  /*
   * (non-Javadoc)
   *
   * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
   */
  @Override
  public final Object execute(ExecutionEvent event) throws ExecutionException {

    ISelection selection = HandlerUtil.getCurrentSelection(event);
    if (selection != null) {
      // Invoke execution method
      try {

        // store the active part
        IWorkbenchPart part = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage()
            .getActivePart();

        execute(event, selection);

        // reset the active part
        Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(part);

      } catch (Exception ex) {
        reportError(Activator.PLUGIN_ID, "Error while executing command: " + ex, ex);
        throw new ExecutionException("Error while executing command: " + ex, ex);
      }
    }

    // execute() methods always must return null
    return null;
  }

  /**
   * Is called when the handler is executed
   *
   * @param event
   *          the ExecutionEvent. Never null
   * @param selection
   *          the selection. Never null
   * @throws Exception
   */
  protected abstract void execute(ExecutionEvent event, ISelection selection) throws Exception;

  /**
   * Report an error via Eclipse Log service
   *
   * @param pluginId
   * @param message
   * @param ex
   */
  protected void reportError(String pluginId, String message, Throwable ex) {
    Status errorStatus = new Status(IStatus.ERROR, pluginId, message, ex);
    Activator.getDefault().getLog().log(errorStatus);
  }

  /**
   * <p>
   * Returns all elements in the given {@link ISelection} that are of the specified type
   * </p>
   * <p>
   * Selected objects in the specified selection that are <em>not</em> instances of the specified type are ignored.
   * </p>
   *
   * @param <T>
   *          thew requested type
   * @param selection
   *          The object containing selected objects
   * @param type
   *          the expected type of the result objects
   * @return
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static <T> List<T> getSelectedObjects(ISelection selection, Class<T> type) {

    // create the result list
    final List<T> result = new LinkedList<T>();

    // copy the selection into a list
    if (selection instanceof IStructuredSelection) {
      IStructuredSelection structuredSelection = (IStructuredSelection) selection;
      Iterator iterator = structuredSelection.iterator();
      while (iterator.hasNext()) {
        Object element = iterator.next();
        if (type.isInstance(element)) {
          result.add((T) element);
        }
      }
    }

    // return the result
    return result;
  }

  @SuppressWarnings({ "unchecked" })
  public static <T> T getSelectedObject(ISelection selection, Class<T> type) {

    // copy the selection into a list
    if (selection instanceof IStructuredSelection) {
      IStructuredSelection structuredSelection = (IStructuredSelection) selection;
      Iterator<?> iterator = structuredSelection.iterator();
      while (iterator.hasNext()) {
        Object element = iterator.next();
        if (type.isInstance(element)) {
          // return the result
          return (T) element;
        }
      }
    }

    // return null
    return null;
  }
}
