package org.slizaa.rcp.workbench.core.internal.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Arrays;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

public class SlizaaIncrementalProjectBuilder extends IncrementalProjectBuilder {

  /** - */
  private SlizaaProjectResourceVisitor _resourceVisitor;

  /**
   * <p>
   * Creates a new instance of type {@link SlizaaIncrementalProjectBuilder}.
   * </p>
   */
  public SlizaaIncrementalProjectBuilder(IResourceHandler... resourceHandlers) {
    this._resourceVisitor = new SlizaaProjectResourceVisitor(checkNotNull(resourceHandlers));
  }

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
      getProject().accept(this._resourceVisitor);
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
    delta.accept(this._resourceVisitor);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void clean(IProgressMonitor monitor) throws CoreException {

    // delete all markers
    MarkerUtils.deleteMarker(getProject());

    //
    super.clean(monitor);
  }
}