/*******************************************************************************
 * Copyright (c) 2011-2015 slizaa project team. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: slizaa project team - initial API and implementation
 ******************************************************************************/
package org.slizaa.rcp.workbench.core.internal;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
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
    createFolder(this._project.getFolder(SlizaaWorkbenchCore.SLIZAA_DATABASE_DIRECTORY_NAME));
    createFolder(this._project.getFolder("_content"));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void deconfigure() throws CoreException {
    this._project.getFolder(SlizaaWorkbenchCore.SLIZAA_DATABASE_DIRECTORY_NAME).delete(true, null);
    this._project.getFolder("_content").delete(true, null);
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
