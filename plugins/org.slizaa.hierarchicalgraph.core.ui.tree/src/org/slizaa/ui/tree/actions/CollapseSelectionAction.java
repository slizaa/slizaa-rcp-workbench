package org.slizaa.ui.tree.actions;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.osgi.service.component.annotations.Component;
import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.ui.tree.ISlizaaActionContribution;

@Component(service = ISlizaaActionContribution.class)
public class CollapseSelectionAction implements ISlizaaActionContribution {

  @Override
  public String getParentGroupId() {
    return null;
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
    return viewer instanceof TreeViewer && checkNotNull(selection).stream().allMatch(o -> o instanceof HGNode);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isEnabled(List<?> selection, Viewer viewer) {
    return true;
  }

  @Override
  public String getLabel(List<?> selectedObjects) {
    return "Collapse";
  }

  @Override
  public String getImagePath(List<?> selectedObjects) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final void execute(List<?> selection, Viewer viewer) {
    if (viewer instanceof TreeViewer) {
      for (Object object : selection) {
        ((TreeViewer)viewer).collapseToLevel(object, TreeViewer.ALL_LEVELS);
      }
    }
  }
}