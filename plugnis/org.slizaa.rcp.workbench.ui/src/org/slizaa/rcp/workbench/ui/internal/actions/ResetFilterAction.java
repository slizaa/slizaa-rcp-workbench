package org.slizaa.rcp.workbench.ui.internal.actions;

import java.util.List;

import org.eclipse.jface.viewers.Viewer;
import org.osgi.service.component.annotations.Component;
import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.hierarchicalgraph.selection.FilterSelections;
import org.slizaa.ui.tree.ISlizaaActionContribution;

@Component(service = ISlizaaActionContribution.class)
public class ResetFilterAction extends AbstractFilterAction {

  @Override
  public void execute(List<?> selection, Viewer viewer) {
    HGNode node = (HGNode) selection.get(0);
    FilterSelections.resteFilter(node.getRootNode());
  }

  @Override
  public String getLabel(List<?> selection) {
    return "Reset Filter";
  }
}
