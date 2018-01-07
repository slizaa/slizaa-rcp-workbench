package org.slizaa.rcp.workbench.core.internal.projectconfig;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.slizaa.rcp.workbench.core.SlizaaWorkbenchCore;

public class SlizaaProjectConfigurationBuilder extends IncrementalProjectBuilder {

  @Override
  protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {

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

  private void fullBuild(IProgressMonitor monitor) {
    try {
      getProject().accept(new SlizaaProjectConfigurationBuildVisitor());
    } catch (CoreException e) {
    }
  }

  protected void incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
    delta.accept(new SlizaaProjectConfigurationBuildVisitor());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void clean(IProgressMonitor monitor) throws CoreException {

    // delete all the markers
    getProject().deleteMarkers(SlizaaWorkbenchCore.SLIZAA_CONFIGURATION_PROBLEM_MARKER, true, IResource.DEPTH_ZERO);

    // //
    // ComponentDescriptionFactory.getComponentDescriptionWriter().removeDanglingComponentDescriptions(getProject());

    //
    super.clean(monitor);
  }
}