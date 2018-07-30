/**
 *
 */
package org.slizaa.rcp.workbench.ui.internal.decorators;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.notify.Notifier;
import org.slizaa.rcp.workbench.core.SlizaaWorkbenchCore;
import org.slizaa.rcp.workbench.core.model.SlizaaProject;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class SlizaaProjectListener implements IResourceChangeListener {

  /** - */
  private SlizaaProjectAdapter _slizaaProjectAdapter;

  /**
   * <p>
   * </p>
   */
  public void initialize() {

    //
    this._slizaaProjectAdapter = new SlizaaProjectAdapter();

    //
    ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
    for (SlizaaProject slizaaProject : SlizaaWorkbenchCore.getSlizaaProjects()) {
      addSlizaaProjectListener(slizaaProject);
    }
  }

  /**
   * <p>
   * </p>
   */
  public void dispose() {

    //
    ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
    for (SlizaaProject slizaaProject : SlizaaWorkbenchCore.getSlizaaProjects()) {
      removeSlizaaProjectListener(slizaaProject);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void resourceChanged(IResourceChangeEvent event) {

    //
    if (event.getType() == IResourceChangeEvent.POST_CHANGE) {
      List<IProject> projects = getProjects(event.getDelta());
      for (IProject project : projects) {
        addSlizaaProjectListener(project);
      }
    }

    //
    else if (event.getType() == IResourceChangeEvent.PRE_DELETE && event.getResource() instanceof IProject) {
      removeSlizaaProjectListener((IProject) event.getResource());
    }

  }

  /**
   * <p>
   * </p>
   *
   * @param project
   */
  private void addSlizaaProjectListener(SlizaaProject project) {

    //
    if (project instanceof Notifier) {
      Notifier notifier = (Notifier) project;
      if (!notifier.eAdapters().contains(this._slizaaProjectAdapter)) {
        notifier.eAdapters().add(this._slizaaProjectAdapter);
      }
    }
  }

  private void removeSlizaaProjectListener(SlizaaProject project) {

    //
    if (project instanceof Notifier) {
      Notifier notifier = (Notifier) project;
      notifier.eAdapters().remove(this._slizaaProjectAdapter);
    }
  }

  /**
   * <p>
   * </p>
   */
  private void addSlizaaProjectListener(IProject project) {

    try {
      addSlizaaProjectListener(SlizaaWorkbenchCore.getSlizaaProject(project));
    } catch (CoreException e) {
      // ignore
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param project
   */
  private void removeSlizaaProjectListener(IProject project) {

    try {
      removeSlizaaProjectListener(SlizaaWorkbenchCore.getSlizaaProject(project));
    } catch (CoreException e) {
      //
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param delta
   * @return
   */
  private List<IProject> getProjects(IResourceDelta delta) {

    // create the result list
    final List<IProject> result = new ArrayList<IProject>();

    // fetch deltas
    try {

      delta.accept(d -> {

        // add newly created projects
        if (d.getKind() == IResourceDelta.ADDED && d.getResource().getType() == IResource.PROJECT) {
          IProject project = (IProject) d.getResource();
          if (project.isAccessible()) {
            result.add(project);
          }
        }

        // only continue for the workspace root
        return d.getResource().getType() == IResource.ROOT;
      });
    } catch (CoreException e) {
      // handle error
    }

    // return the result
    return result;
  }
}