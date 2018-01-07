/*******************************************************************************
 * Copyright (c) 2011-2015 slizaa project team. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: slizaa project team - initial API and implementation
 ******************************************************************************/
package org.slizaa.rcp.workbench.core.internal;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.slizaa.rcp.workbench.core.SlizaaWorkbenchCore;

/**
 * <p>
 * Implementation of the bundle maker project nature.
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class SlizaaProjectNature implements IProjectNature {

  /** the associated bundle maker project */
  private IProject _project;

  /**
   * {@inheritDoc}
   */
  @Override
  public IProject getProject() {
    return this._project;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setProject(IProject value) {
    this._project = value;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void configure() throws CoreException {

    // create the default slizaa directory
    createFolder(this._project.getFolder(SlizaaWorkbenchCore.SLIZAA_DEFAULT_DATABASE_DIRECTORY_NAME));

    //
    IProjectDescription desc = this._project.getDescription();

    // check if the ds annotation builder already is configured
    ICommand[] commands = desc.getBuildSpec();
    for (int i = 0; i < commands.length; ++i) {
      if (commands[i].getBuilderName().equals(SlizaaWorkbenchCore.SLIZAA_BUILDER)) {
        return;
      }
    }

    // add builder to project
    ICommand command = desc.newCommand();
    command.setBuilderName(SlizaaWorkbenchCore.SLIZAA_BUILDER);
    ICommand[] newCommands = new ICommand[commands.length + 1];

    // Add it before other builders.
    System.arraycopy(commands, 0, newCommands, 1, commands.length);
    newCommands[0] = command;
    desc.setBuildSpec(newCommands);
    this._project.setDescription(desc, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void deconfigure() throws CoreException {

    //
    this._project.getFolder(SlizaaWorkbenchCore.SLIZAA_DEFAULT_DATABASE_DIRECTORY_NAME).delete(true, null);

    // get the description
    IProjectDescription desc = this._project.getDescription();

    // remove the ds annotation builder command
    List<ICommand> iCommands = new LinkedList<ICommand>(Arrays.asList(desc.getBuildSpec()));
    for (Iterator<ICommand> iterator = iCommands.iterator(); iterator.hasNext();) {
      if (iterator.next().getBuilderName().equals(SlizaaWorkbenchCore.SLIZAA_BUILDER)) {
        iterator.remove();
        break;
      }
    }

    desc.setBuildSpec(iCommands.toArray(new ICommand[0]));
  }

  /**
   * <p>
   * </p>
   *
   * @param folder
   * @throws CoreException
   */
  private static void createFolder(IFolder folder) throws CoreException {

    IContainer parent = folder.getParent();

    if (parent instanceof IFolder) {
      createFolder((IFolder) parent);
    }

    if (!folder.exists()) {
      folder.create(false, true, null);
    }
  }
}
