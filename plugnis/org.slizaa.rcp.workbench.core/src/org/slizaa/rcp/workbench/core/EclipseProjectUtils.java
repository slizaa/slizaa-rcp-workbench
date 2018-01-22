/*******************************************************************************
 * Copyright (c) 2011-2015 slizaa project team. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: slizaa project team - initial API and implementation
 ******************************************************************************/
package org.slizaa.rcp.workbench.core;

import static com.google.common.base.Preconditions.checkNotNull;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;

/**
 * <p>
 * Helper class that provides several utility methods for creating, getting and deleting {@link IProject IProjects}.
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class EclipseProjectUtils {

  public static void addNature(IProject project, String nature) throws CoreException {
    checkNotNull(project);
    checkNotNull(nature);

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
   * Creates a new simple project with the specified project name.
   * </p>
   *
   * @param projectName
   *          the project name
   * @return the {@link IProject}
   * @throws CoreException
   *           if the project with the given name could not created
   */
  public static IProject getOrCreateSimpleProject(String projectName) throws CoreException {
    Assert.isNotNull(projectName);
    Assert.isTrue(projectName.trim().length() > 0);

    // get the project
    IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);

    // create the project if not exists
    if (!project.exists()) {

      IProjectDescription desc = project.getWorkspace().newProjectDescription(project.getName());

      project.create(desc, null);
      if (!project.isOpen()) {
        project.open(null);
      }
    }

    // return the new project
    return project;
  }

  /**
   * <p>
   * Returns the {@link IProject} with the given name.
   * </p>
   *
   * @param projectName
   *          the name of the project.
   * @return the {@link IProject} with the given name.
   * @throws CoreException
   */
  public static IProject getProject(String projectName) throws CoreException {
    Assert.isNotNull(projectName);
    Assert.isTrue(projectName.trim().length() > 0);

    // get the project
    return ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
  }

  /**
   * <p>
   * Deletes the project with the given name.
   * </p>
   *
   *
   * @param projectName
   *          the name of the project to delete
   * @throws CoreException
   */
  public static void deleteProjectIfExists(String projectName) throws CoreException {

    // get the project
    IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);

    // create the project if not exists
    if (project.exists()) {
      try {
        project.delete(true, true, null);
      } catch (Exception e) {
        // e.printStackTrace();
      }
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param projectName
   * @throws CoreException
   */
  public static boolean exists(String projectName) throws CoreException {

    // get the project
    return ResourcesPlugin.getWorkspace().getRoot().exists(new Path(projectName));
  }

  /**
   * <p>
   * Checks if a given path exists.
   * </p>
   *
   * @param path
   * @throws CoreException
   */
  public static boolean exists(Path path) throws CoreException {

    // get the project
    return ResourcesPlugin.getWorkspace().getRoot().exists(path);
  }
}
