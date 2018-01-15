package org.slizaa.rcp.workbench.core.internal.builder;

import java.util.Arrays;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.slizaa.rcp.workbench.core.SlizaaWorkbenchCore;

public class SlizaaIncrementalProjectBuilder extends IncrementalProjectBuilder {

  /** - */
  // TODO
  private final static String[] MARKERS_TO_DELETE_ON_CLEAN = {
      SlizaaWorkbenchCore.SLIZAA_CONFIGURATION_PROBLEM_MARKER };

  /**
   * {@inheritDoc}
   */
  @Override
  protected IProject[] build(int kind, Map<String, String> args, IProgressMonitor monitor) throws CoreException {

    if (kind == IncrementalProjectBuilder.FULL_BUILD) {
      fullBuild(monitor);
    } else {
      IResourceDelta delta = getDelta(getProject());
      if (delta == null) {
        fullBuild(monitor);
      } else {
        incrementalBuild(delta, monitor);
      }
    }
    return null;
  }

  /**
   * <p>
   * </p>
   *
   * @param monitor
   */
  private void fullBuild(IProgressMonitor monitor) {
    try {
      getProject().accept(new SlizaaProjectResourceVisitor());
    } catch (CoreException e) {
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param delta
   * @param monitor
   * @throws CoreException
   */
  protected void incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
    delta.accept(new SlizaaProjectResourceVisitor());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void clean(IProgressMonitor monitor) throws CoreException {

    //
    Arrays.asList(MARKERS_TO_DELETE_ON_CLEAN).forEach(m -> {
      try {
        getProject().deleteMarkers(m, true, IResource.DEPTH_INFINITE);
      } catch (CoreException e) {
        // ignore
      }
    });

    //
    super.clean(monitor);
  }
}