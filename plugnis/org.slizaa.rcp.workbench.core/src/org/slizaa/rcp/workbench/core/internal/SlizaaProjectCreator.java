/**
 *
 */
package org.slizaa.rcp.workbench.core.internal;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;
import org.slizaa.rcp.workbench.core.SlizaaWorkbenchCore;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 */
public class SlizaaProjectCreator {

  /**
   * <p>
   * </p>
   *
   * @param project
   * @return
   * @throws CoreException
   */
  public static IProject configureSlizaaProject(IProject project) throws CoreException {

    //
    checkNotNull(project);
    checkState(project.exists());

    SlizaaWorkbenchCore.addSlizaaNature(project);
    SlizaaWorkbenchCore.getSlizaaProject(project);

    configureJDT_2(project);

    // return the project
    return project;
  }

  private static void configureJDT_2(IProject project) throws CoreException, JavaModelException {

    // set the Java nature
    SlizaaWorkbenchCore.addNature(project, JavaCore.NATURE_ID);

    // create the java project
    IJavaProject javaProject = JavaCore.create(project);

    // set the build path
    IClasspathEntry[] buildPath = { JavaRuntime.getDefaultJREContainerEntry(),
        JavaCore.newContainerEntry(SlizaaWorkbenchCore.SLIZAA_CONTAINER_PATH),
        JavaCore.newSourceEntry(project.getFullPath().append("src")) };

    javaProject.setRawClasspath(buildPath, project.getFullPath().append("bin"), null);

    // create folder by using resources package
    IFolder folder = project.getFolder("src");
    folder.create(true, true, null);

    // Add folder to Java element
    IPackageFragmentRoot srcFolder = javaProject.getPackageFragmentRoot(folder);

    // create package fragment
    IPackageFragment fragment = srcFolder.createPackageFragment("com.programcreek", true, null);

    // init code string and create compilation unit
    String str = "package com.programcreek;" + "\n" + "public class Test  {" + "\n" + " private String name;" + "\n"
        + "}";

    ICompilationUnit cu = fragment.createCompilationUnit("Test.java", str, false, null);

    // create a field
    IType type = cu.getType("Test");

    type.createField("private String age;", null, true, null);
  }
}
