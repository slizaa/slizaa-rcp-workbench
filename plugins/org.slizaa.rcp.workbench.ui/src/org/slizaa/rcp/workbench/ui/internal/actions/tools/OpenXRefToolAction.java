package org.slizaa.rcp.workbench.ui.internal.actions.tools;

import java.util.List;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.osgi.service.component.annotations.Component;
import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.rcp.workbench.ui.internal.Activator;
import org.slizaa.ui.tree.ISlizaaActionContribution;

@Component(service = ISlizaaActionContribution.class)
public class OpenXRefToolAction implements ISlizaaActionContribution {

  @Override
  public String getParentGroupId() {
    return SlizaaToolsActionGroup.ID;
  }

  @Override
  public int getRanking() {
    return 10;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean shouldShow(List<?> selection, Viewer viewer) {
    return selection.stream().allMatch(n -> n instanceof HGNode)
        && PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().isEditorAreaVisible();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isEnabled(List<?> selection, Viewer viewer) {
    return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(List<?> selection, Viewer viewer) {

    Display.getDefault().syncExec(() -> {
      try {

        // switch perspective
        PlatformUI.getWorkbench().showPerspective(Activator.CROSS_REFERENCER_PERSPECTIVE,
            PlatformUI.getWorkbench().getActiveWorkbenchWindow());

        // open view
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.slizaa.ui.xref.XRefPart");

      } catch (WorkbenchException e) {
        // do nothing
      }
    });
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getLabel(List<?> selection) {
    return "Open Xref";
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getImagePath(List<?> selection) {
    return "icons/actions/XRef.png";
  }
}
