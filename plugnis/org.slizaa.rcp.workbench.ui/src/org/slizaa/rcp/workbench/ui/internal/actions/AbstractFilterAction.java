package org.slizaa.rcp.workbench.ui.internal.actions;

import java.util.List;

import org.eclipse.jface.viewers.Viewer;
import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.rcp.workbench.ui.internal.Activator;
import org.slizaa.ui.shared.UiUtils;
import org.slizaa.ui.tree.ISlizaaActionContribution;

public abstract class AbstractFilterAction implements ISlizaaActionContribution {

  @Override
  public String getParentGroupId() {
    return null;
  }

  @Override
  public String getImagePath(List<?> selection) {
    return null;
  }

  @Override
  public int getRanking() {
    return 100;
  }

  @Override
  public boolean shouldShow(List<?> selection, Viewer viewer) {
    return Activator.CROSS_REFERENCER_PERSPECTIVE.equals(UiUtils.getCurrentPerspectiveId())
        && "org.slizaa.ui.xref.XRefPart".equals(UiUtils.getCurrentPartId());
  }

  @Override
  public boolean isEnabled(List<?> selection, Viewer viewer) {
    return selection.stream().allMatch(n -> n instanceof HGNode);
  }
}
