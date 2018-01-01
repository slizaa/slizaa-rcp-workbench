/*******************************************************************************
 * Copyright (c) 2011-2015 slizaa project team. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: slizaa project team - initial API and implementation
 ******************************************************************************/
package org.slizaa.rcp.workbench.ui.internal.wizards;

import static java.lang.String.format;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.ide.undo.CreateProjectOperation;
import org.eclipse.ui.ide.undo.WorkspaceUndoUtil;
import org.eclipse.ui.statushandlers.IStatusAdapterConstants;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.slizaa.rcp.workbench.core.SlizaaWorkbenchCore;
import org.slizaa.rcp.workbench.ui.internal.SlizaaImages;
import org.slizaa.rcp.workbench.ui.internal.SlizaaUiUtils;

/**
 * <p>
 * A project wizard that creates a new slizaa project
 * </p>
 *
 * @author Nils Hartmann (nils@nilshartmann.net)
 *
 */
public class NewSlizaaProjectWizard extends Wizard implements INewWizard, IExecutableExtension {

  /** - */
  private WizardNewProjectCreationPage _mainPage;

  /** - */
  private IConfigurationElement        _configurationElement;

  /** - */
  private IProject                     _newProject;

  /**
   * {@inheritDoc}
   */
  @Override
  public void init(IWorkbench workbench, IStructuredSelection selection) {
    setNeedsProgressMonitor(true);
    setWindowTitle("New slizaa Project");
    setDefaultPageImageDescriptor(SlizaaImages.SLIZAA_ICON.getImageDescriptor());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void addPages() {
    super.addPages();

    // add page
    this._mainPage = new NewSlizaaProjectWizardCreationPage();
    addPage(this._mainPage);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setInitializationData(IConfigurationElement cfig, String propertyName, Object data) {
    this._configurationElement = cfig;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean performFinish() {

    //
    createNewProject();

    if (this._newProject == null) {
      return false;
    }

    // open associated perspective
    BasicNewProjectResourceWizard.updatePerspective(this._configurationElement);

    //
    return true;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  private IProject createNewProject() {
    if (this._newProject != null) {
      return this._newProject;
    }

    // get a project handle
    final IProject newProjectHandle = this._mainPage.getProjectHandle();

    // get a project descriptor
    URI location = null;
    if (!this._mainPage.useDefaults()) {
      location = this._mainPage.getLocationURI();
    }

    IWorkspace workspace = ResourcesPlugin.getWorkspace();
    final IProjectDescription description = workspace.newProjectDescription(newProjectHandle.getName());
    description.setLocationURI(location);

    // create the new project operation
    IRunnableWithProgress op = monitor -> {
      CreateProjectOperation op1 = new CreateProjectOperation(description, "Create new slizaa project");
      try {
        // see bug
        // https://bugs.eclipse.org/bugs/show_bug.cgi?id=219901
        // directly execute the operation so that the undo state is
        // not preserved. Making this undoable resulted in too many
        // accidental file deletions.
        op1.execute(monitor, WorkspaceUndoUtil.getUIInfoAdapter(getShell()));
      } catch (ExecutionException e) {
        throw new InvocationTargetException(e);
      }
    };

    // run the new project creation operation
    try {
      getContainer().run(true, true, op);
    } catch (InterruptedException e) {
      return null;
    } catch (InvocationTargetException e) {
      Throwable t = e.getTargetException();
      if (t instanceof ExecutionException && t.getCause() instanceof CoreException) {
        CoreException cause = (CoreException) t.getCause();
        IStatus status;
        if (cause.getStatus().getCode() == IResourceStatus.CASE_VARIANT_EXISTS) {
          status = SlizaaUiUtils.newWarning(format(
              "The underlying file system is case insensitive. There is an existing project or directory that conflicts with '%s'",
              newProjectHandle.getName()), cause);
        } else {
          status = SlizaaUiUtils.newStatus(cause, "Problems while creating the project");
        }
        StatusAdapter statusAdapter = new StatusAdapter(status);
        statusAdapter.setProperty(IStatusAdapterConstants.TITLE_PROPERTY, "Project creation problems");
        StatusManager.getManager().handle(status, StatusManager.BLOCK);
      } else {
        StatusAdapter statusAdapter = new StatusAdapter(
            SlizaaUiUtils.newWarning(format("Internal error: %s", t.getMessage()), t));
        statusAdapter.setProperty(IStatusAdapterConstants.TITLE_PROPERTY, "Project creation problems");
        StatusManager.getManager().handle(statusAdapter, StatusManager.LOG | StatusManager.BLOCK);
      }
      return null;
    }

    try {

      SlizaaWorkbenchCore.configureSlizaaProject(newProjectHandle);
    }
    //
    catch (CoreException ex) {
      StatusAdapter statusAdapter = new StatusAdapter(
          SlizaaUiUtils.newStatus(ex, "Could not configure slizaa project."));
      statusAdapter.setProperty(IStatusAdapterConstants.TITLE_PROPERTY, "Project creation problems");
      StatusManager.getManager().handle(SlizaaUiUtils.newStatus(ex, "Could not configure slizaa project."),
          StatusManager.BLOCK);
      return null;

    }

    this._newProject = newProjectHandle;

    return this._newProject;
  }
}
