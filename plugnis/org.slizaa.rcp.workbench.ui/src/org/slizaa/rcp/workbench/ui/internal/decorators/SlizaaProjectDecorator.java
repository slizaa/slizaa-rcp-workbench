package org.slizaa.rcp.workbench.ui.internal.decorators;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;
import org.slizaa.rcp.workbench.core.SlizaaWorkbenchCore;
import org.slizaa.rcp.workbench.core.model.SlizaaProject;

public class SlizaaProjectDecorator implements ILightweightLabelDecorator {

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
        decoration.addSuffix(" [" + slizaaProject.getBoltClient() + "]");
      } catch (CoreException e) {
        // simply ignore
      }
    }
  }

  public static void update() {
    IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
    decoratorManager.update("org.slizaa.rcp.workbench.ui.SlizaaProjectDecorator");
  }
}