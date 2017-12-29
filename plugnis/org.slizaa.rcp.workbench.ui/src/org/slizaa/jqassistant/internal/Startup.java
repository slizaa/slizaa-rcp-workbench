package org.slizaa.jqassistant.internal;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.WorkbenchWindow;

public class Startup implements IStartup {

  @Override
  public void earlyStartup() {

    final IWorkbench workbench = PlatformUI.getWorkbench();

    workbench.getDisplay().asyncExec(() -> {

      //
      WorkbenchWindow workbenchWindow = (WorkbenchWindow) workbench.getActiveWorkbenchWindow();
      EModelService modelService = workbenchWindow.getService(EModelService.class);
      MApplication application = workbenchWindow.getService(MApplication.class);
      EPartService partService = workbenchWindow.getService(EPartService.class);

      workbenchWindow.addPerspectiveListener(new SlizaaPerspectiveAdapter(modelService, application, partService));
    });
  }
}
