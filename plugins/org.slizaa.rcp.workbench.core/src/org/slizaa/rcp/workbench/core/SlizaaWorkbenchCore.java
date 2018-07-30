/*******************************************************************************
 * Copyright (c) 2011-2015 slizaa project team. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: slizaa project team - initial API and implementation
 ******************************************************************************/
package org.slizaa.rcp.workbench.core;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.slizaa.rcp.workbench.core.internal.SlizaaProjectCache;
import org.slizaa.rcp.workbench.core.internal.SlizaaProjectCreator;
import org.slizaa.rcp.workbench.core.model.ModelFactory;
import org.slizaa.rcp.workbench.core.model.SlizaaProject;
import org.slizaa.rcp.workbench.core.model.impl.ExtendedSlizaaProjectImpl;

/**
 * <p>
 * Core support for bundle maker projects.
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 * @noextend This class is not intended to be subclasses by clients.
 */
public final class SlizaaWorkbenchCore {

  /** - */
  public static final String BUNDLE_ID                           = SlizaaWorkbenchCore.class.getPackage().getName();

  /** the nature id */
  public static final String SLIZAA_NATURE_ID                    = BUNDLE_ID + ".slizaanature";

  /** - */
  public static final String SLIZAA_CONFIGURATION_PROBLEM_MARKER = BUNDLE_ID + ".slizaaConfigurationProblem";

  /** - */
  public static final String SLIZAA_BUILDER                      = BUNDLE_ID + ".slizaaProjectConfigurationBuilder";

  /** - */
  public static final String SLIZAA_CONTAINER_ID                 = BUNDLE_ID + ".SLIZAA_SPI_CONTAINER";

  /** - */
  public final static IPath  SLIZAA_CONTAINER_PATH               = new Path(SLIZAA_CONTAINER_ID);

  /**
   * <p>
   * </p>
   */
  public static final void cleanBuildAll() {

    //
    for (SlizaaProject slizaaProject : SlizaaWorkbenchCore.getSlizaaProjects()) {
      slizaaProject.cleanBuild();
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param project
   * @return
   * @throws CoreException
   */
  public static SlizaaProject configureSlizaaProject(IProject project) throws CoreException {
    return SlizaaProjectCreator.configureSlizaaProject(checkNotNull(project));
  }

  /**
   * <p>
   * Creates a bundle maker project for the given {@link IProject}. The specified project must have the bundle maker
   * nature.
   * </p>
   * <p>
   * You can use {@link #isSlizaaProject(IProject)} to check if the project is BundleMaker project
   *
   * @param project
   * @return
   * @throws CoreException
   */
  public static SlizaaProject getSlizaaProject(IProject project) throws CoreException {
    Assert.isNotNull(project);

    // check if nature exists
    if (!project.exists()) {
      throw new CoreException(
          new Status(IStatus.ERROR, BUNDLE_ID, "Project '" + project.getName() + "' has to exist."));
    }

    // check if nature exists
    if (!project.hasNature(SLIZAA_NATURE_ID)) {
      throw new CoreException(new Status(IStatus.ERROR, BUNDLE_ID,
          "Project '" + project.getName() + "' must have nature '" + SLIZAA_NATURE_ID + "'."));
    }

    // // try to get project from cache
    SlizaaProject slizaaProject = SlizaaProjectCache.instance().getSlizaaProject(project);

    // create project if necessary
    if (slizaaProject == null) {

      // step 1: create the project
      slizaaProject = ModelFactory.INSTANCE.createSlizaaProject();
      ((ExtendedSlizaaProjectImpl) slizaaProject).setProject(project);

      // step 2: cache the bundle maker project
      SlizaaProjectCache.instance().cacheBundleMakerProject(project, slizaaProject);
    }

    // return result
    return slizaaProject;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   * @throws CoreException
   */
  public static Collection<SlizaaProject> getSlizaaProjects() {
    //
    IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
    for (IProject iProject : projects) {
      try {
        if (iProject.exists() && iProject.hasNature(SLIZAA_NATURE_ID)) {
          getSlizaaProject(iProject);
        }
      } catch (CoreException e) {
        //
      }
    }

    //
    return SlizaaProjectCache.instance().getSlizaaProjects();
  }

  /**
   * <p>
   * </p>
   *
   * @param simpleProjectName
   * @return
   * @throws CoreException
   */
  public static SlizaaProject getSlizaaProject(String simpleProjectName) throws CoreException {

    // get the project
    IProject project = EclipseProjectUtils.getProject(simpleProjectName);

    // get the bundle maker project
    return getSlizaaProject(project);
  }

  /**
   * <p>
   * Returns <code>true</code> if the specified {@link IProject} is a BundleMaker project.
   * </p>
   *
   * @param project
   *          the project to test
   * @return
   * @throws CoreException
   */
  public static boolean isSlizaaProject(IProject project) {

    //
    if (project == null) {
      return false;
    }

    // check if project exists
    if (!project.exists()) {
      return false;
    }

    // check if nature exists
    try {
      if (!project.hasNature(SLIZAA_NATURE_ID)) {
        return false;
      }
    } catch (CoreException e) {
      return false;
    }

    // returns true
    return true;
  }
}
