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
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;
import org.slizaa.rcp.workbench.core.ISlizaaProject;
import org.slizaa.rcp.workbench.core.SlizaaWorkbenchCore;
import org.slizaa.rcp.workbench.core.common.EclipseProjectUtils;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
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
  public static ISlizaaProject configureSlizaaProject(IProject project) throws CoreException {

    //
    checkNotNull(project);
    checkState(project.exists());

    // add the slizaa nature
    EclipseProjectUtils.addNature(project, SlizaaWorkbenchCore.SLIZAA_NATURE_ID);
    ISlizaaProject result = SlizaaWorkbenchCore.getSlizaaProject(project);

    // configure as JDT project
    configureJDT(project);

    // return the project
    return result;
  }

  /**
   * <p>
   * </p>
   *
   * @param project
   * @throws CoreException
   * @throws JavaModelException
   */
  private static void configureJDT(IProject project) throws CoreException, JavaModelException {

    // set the Java nature
    EclipseProjectUtils.addNature(project, JavaCore.NATURE_ID);

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
  }
}
