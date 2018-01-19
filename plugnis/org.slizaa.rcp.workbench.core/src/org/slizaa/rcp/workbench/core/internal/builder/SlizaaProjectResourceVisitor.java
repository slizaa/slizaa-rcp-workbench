package org.slizaa.rcp.workbench.core.internal.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class SlizaaProjectResourceVisitor implements IResourceVisitor, IResourceDeltaVisitor {

  /** - */
  private List<IResourceHandler> _resourceHandler;

  /**
   * <p>
   * Creates a new instance of type {@link SlizaaProjectResourceVisitor}.
   * </p>
   */
  public SlizaaProjectResourceVisitor(IResourceHandler... resourceHandlers) {

    //
    this._resourceHandler = Arrays.asList(checkNotNull(resourceHandlers));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean visit(IResourceDelta delta) throws CoreException {

    // removed
    if (delta.getKind() == IResourceDelta.REMOVED) {

      //
      if (delta.getResource().getType() != IResource.FILE) {
        return true;
      }

      //
      for (IResourceHandler resourceHandler : this._resourceHandler) {
        if (resourceHandler.canHandle(delta.getResource())) {
          resourceHandler.handleRemoved(delta.getResource());
        }
      }

      //
      return false;
    }

    // changed
    else if (delta.getKind() == IResourceDelta.CHANGED) {
      return visit(delta.getResource());
    }

    // added
    else if (delta.getKind() == IResourceDelta.ADDED) {
      return visit(delta.getResource());
    }

    //
    return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean visit(IResource resource) throws CoreException {

    //
    if (resource.getType() != IResource.FILE) {
      return true;
    }

    //
    for (IResourceHandler resourceHandler : this._resourceHandler) {
      if (resourceHandler.canHandle(resource)) {
        resourceHandler.handleAddedOrChanged(resource);
      }
    }

    //
    return false;
  }
}