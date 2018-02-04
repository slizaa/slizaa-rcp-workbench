package org.slizaa.rcp.workbench.ui.internal.decorators;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.slizaa.rcp.workbench.core.SlizaaWorkbenchCore;
import org.slizaa.rcp.workbench.core.model.SlizaaProject;

public class SlizaaProjectDecorator implements ILightweightLabelDecorator {

  /** - */
  public static final String DECORATOR_ID = "org.slizaa.rcp.workbench.ui.SlizaaProjectDecorator";

  @Override
  public void addListener(ILabelProviderListener listener) {
    //
  }

  @Override
  public void dispose() {
    //
  }

  @Override
  public boolean isLabelProperty(Object element, String property) {
    return false;
  }

  @Override
  public void removeListener(ILabelProviderListener listener) {
    //
  }

  @Override
  public void decorate(Object element, IDecoration decoration) {

    if (element instanceof IProject) {

      try {
        SlizaaProject slizaaProject = SlizaaWorkbenchCore.getSlizaaProject((IProject) element);
        decoration
            .addSuffix(" [" + boltClientState(slizaaProject) + "/" + graphDatabaseInstanceState(slizaaProject) + "]");
      } catch (CoreException e) {
        // simply ignore
      }
    }
  }

  private String boltClientState(SlizaaProject slizaaProject) {
    return slizaaProject.getBoltClient() != null ? "Connected" : "-";
  }

  private String graphDatabaseInstanceState(SlizaaProject slizaaProject) {
    return slizaaProject.getGraphDatabaseInstance() != null ? "Running" : "-";
  }
}