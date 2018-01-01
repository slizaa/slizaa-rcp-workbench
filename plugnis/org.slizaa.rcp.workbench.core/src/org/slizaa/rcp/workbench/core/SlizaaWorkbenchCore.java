/*******************************************************************************
 * Copyright (c) 2011-2015 slizaa project team. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: slizaa project team - initial API and implementation
 ******************************************************************************/
package org.slizaa.rcp.workbench.core;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.File;
import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.slizaa.rcp.workbench.core.common.EclipseProjectUtils;
import org.slizaa.rcp.workbench.core.internal.SlizaaProject;
import org.slizaa.rcp.workbench.core.internal.SlizaaProjectCache;
import org.slizaa.rcp.workbench.core.internal.SlizaaProjectCreator;

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

  public static final String BUNDLE_ID_ORG_SLIZAA_RCP_WORKBENCH_CORE = "org.slizaa.rcp.workbench.core";

  /** the nature id */
  public static final String NATURE_ID                               = "org.slizaa.rcp.workbench.slizaanature";

  /** the bundle make directory name */
  public static final String SLIZAA_DATABASE_DIRECTORY_NAME          = ".slizaa";

  /** - */
  public static final String SLIZAA_CONTAINER_ID                     = "org.slizaa.rcp.workbench.core.SLIZAA_SPI_CONTAINER";

  /** - */
  public final static IPath  SLIZAA_CONTAINER_PATH                   = new Path(SLIZAA_CONTAINER_ID);

  /**
   * <p>
   * </p>
   *
   * @param project
   * @return
   * @throws CoreException
   */
  public static IProject configureSlizaaProject(IProject project) throws CoreException {
    return SlizaaProjectCreator.configureSlizaaProject(checkNotNull(project));
  }

  /**
   * <p>
   * </p>
   *
   * @param project
   * @return
   */
  public static File getDatabaseDirectory(IProject project) {
    return project.getFolder(SLIZAA_DATABASE_DIRECTORY_NAME).getRawLocation().toFile();
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
  public static ISlizaaProject getSlizaaProject(IProject project) throws CoreException {
    Assert.isNotNull(project);

    // check if nature exists
    if (!project.exists()) {
      throw new CoreException(new Status(IStatus.ERROR, BUNDLE_ID_ORG_SLIZAA_RCP_WORKBENCH_CORE,
          "Project '" + project.getName() + "' has to exist."));
    }

    // check if nature exists
    if (!project.hasNature(NATURE_ID)) {
      throw new CoreException(new Status(IStatus.ERROR, BUNDLE_ID_ORG_SLIZAA_RCP_WORKBENCH_CORE,
          "Project '" + project.getName() + "' must have nature '" + NATURE_ID + "'."));
    }

    // // try to get project from cache
    ISlizaaProject slizaaProject = SlizaaProjectCache.instance().getBundleMakerProject(project);

    // create project if necessary
    if (slizaaProject == null) {

      // step 1: create the project
      slizaaProject = new SlizaaProject(project);

      // step 2: cache the bundle maker project
      SlizaaProjectCache.instance().cacheBundleMakerProject(project, slizaaProject);
    }

    // return result
    return slizaaProject;
  }

  /**
   * <p>
   * Create a simple project with the bundle maker nature.
   * </p>
   *
   * @param projectName
   * @return
   * @throws CoreException
   */
  public static IProject getOrCreateSimpleProjectWithSlizaaNature(String projectName) throws CoreException {

    // create the bundle maker project
    IProject project = EclipseProjectUtils.getOrCreateSimpleProject(projectName);

    // add the bundle maker nature
    SlizaaWorkbenchCore.addSlizaaNature(project);

    // return the newly created project
    return project;
  }

  /**
   * <p>
   * Adds the bundle maker nature to the given project.
   * </p>
   *
   * @param project
   *          the project
   * @throws CoreException
   */
  public static void addSlizaaNature(IProject project) throws CoreException {
    addNature(project, NATURE_ID);
  }

  // public static void addJavaNature(IProject project) throws CoreException {
  // addNature(project, JavaCore.NATURE_ID);
  // }
  //
  // public static boolean isJavaProject(IProject project) throws CoreException {
  // return project.hasNature(JavaCore.NATURE_ID);
  // }

  public static void addNature(IProject project, String nature) throws CoreException {
    if (!project.hasNature(nature)) {

      // get the project description
      IProjectDescription description = project.getDescription();

      // set the new nature
      String[] prevNatures = description.getNatureIds();
      String[] newNatures = new String[prevNatures.length + 1];
      System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
      newNatures[prevNatures.length] = nature;
      description.setNatureIds(newNatures);

      // set the new description
      project.setDescription(description, null);
    }

  }

  /**
   * <p>
   * </p>
   *
   * @return
   * @throws CoreException
   */
  @SuppressWarnings("unchecked")
  public static Collection<ISlizaaProject> getSlizaaProjects() {
    //
    IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
    for (IProject iProject : projects) {
      try {
        if (iProject.exists() && iProject.hasNature(NATURE_ID)) {
          getSlizaaProject(iProject);
        }
      } catch (CoreException e) {
        //
      }
    }

    //
    return (Collection<ISlizaaProject>) SlizaaProjectCache.instance().getBundleMakerProjects();
  }

  /**
   * <p>
   * </p>
   *
   * @param simpleProjectName
   * @return
   * @throws CoreException
   */
  public static ISlizaaProject getSlizaaProject(String simpleProjectName) throws CoreException {

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
      if (!project.hasNature(NATURE_ID)) {
        return false;
      }
    } catch (CoreException e) {
      return false;
    }

    // returns true
    return true;
  }
}
