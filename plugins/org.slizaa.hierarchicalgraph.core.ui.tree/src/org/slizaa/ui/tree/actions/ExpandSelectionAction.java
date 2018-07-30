package org.slizaa.ui.tree.actions;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.osgi.service.component.annotations.Component;
import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.hierarchicalgraph.core.model.ProxyDependencyFunctions;
import org.slizaa.ui.tree.ISlizaaActionContribution;

@Component(service = ISlizaaActionContribution.class)
public class ExpandSelectionAction implements ISlizaaActionContribution {

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
    return "Expand";
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

      //
      List<Object> expandedElements = new LinkedList<>();
      expandedElements.addAll(Arrays.asList(((TreeViewer) viewer).getExpandedElements()));

      //
      expandedElements((List<HGNode>) selection, expandedElements);

      //
      ((TreeViewer) viewer).setExpandedElements(expandedElements.toArray());
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param selection
   * @return
   */
  private Object[] expandedElements(List<HGNode> selection, List<Object> expandedElements) {

    //
    for (HGNode hgNode : selection) {

      if (!ProxyDependencyFunctions.containsUnresolvedProxyDependencies(hgNode.getIncomingCoreDependencies())
          && !ProxyDependencyFunctions.containsUnresolvedProxyDependencies(hgNode.getOutgoingCoreDependencies())) {

        expandedElements.add(hgNode);
        expandedElements(hgNode.getChildren(), expandedElements);
      }
    }

    //
    return expandedElements.toArray();
  }
}