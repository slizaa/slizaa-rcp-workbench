package org.slizaa.rcp.workbench.core.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;

public class BuildHelper {

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
