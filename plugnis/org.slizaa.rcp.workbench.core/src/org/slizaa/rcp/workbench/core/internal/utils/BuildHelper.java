package org.slizaa.rcp.workbench.core.internal.utils;

import static com.google.common.base.Preconditions.checkNotNull;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.slizaa.rcp.workbench.core.internal.SlizaaProjectNature;

public class BuildHelper {

  /**
   * <p>
   * </p>
   *
   * @return
   * @throws Exception
   */
  public static URLClassLoader createClassLoader(IProject project) throws Exception {

    //
    IJavaProject javaProject = JavaCore.create(project);

    // TODO
    // https://sdqweb.ipd.kit.edu/wiki/JDT_Tutorial:_Class_Loading_in_a_running_plugin
    String[] classPathEntries = JavaRuntime.computeDefaultRuntimeClassPath(javaProject);

    List<URL> urlList = new ArrayList<URL>();
    for (int i = 0; i < classPathEntries.length; i++) {
      IPath path = new Path(classPathEntries[i]);
      urlList.add(path.toFile().toURI().toURL());
    }

    //
    ClassLoader parentClassLoader = SlizaaProjectNature.class.getClassLoader();
    URL[] urls = urlList.toArray(new URL[urlList.size()]);

    //
    return new URLClassLoader(urls, parentClassLoader);
  }

  /**
   * <p>
   * </p>
   *
   * @param project
   * @throws CoreException
   */
  public static void cleanBuildProject(IProject project) throws CoreException {

    //
    checkNotNull(project);

    // refresh and build
    project.refreshLocal(IResource.DEPTH_INFINITE, null);
    project.build(IncrementalProjectBuilder.CLEAN_BUILD, null);
    project.build(IncrementalProjectBuilder.FULL_BUILD, null);
  }

  /**
   * @param project
   * @throws CoreException
   */
  public static void failOnErrors(IProject project) throws CoreException {

    // check for errors
    List<IMarker> errors = new LinkedList<IMarker>();
    for (IMarker marker : project.findMarkers(null, true, IResource.DEPTH_INFINITE)) {
      if (marker.getAttribute(IMarker.SEVERITY).equals(IMarker.SEVERITY_ERROR)) {
        errors.add(marker);
      }
    }

    // fails if any errors
    if (!errors.isEmpty()) {

      //
      StringBuilder builder = new StringBuilder("The test project has compile errors:\n");

      //
      for (IMarker iMarker : errors) {
        builder.append(" - " + iMarker.getAttribute(IMarker.MESSAGE) + "(" + iMarker.getAttribute(IMarker.CHAR_START)
            + ", " + iMarker.getAttribute(IMarker.CHAR_START) + ")");
        builder.append("\n");
      }

      //
      throw new RuntimeException(builder.toString());
    }
  }
}
