package org.slizaa.ui.tree.actions;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.ui.tree.ISlizaaActionContribution;

@Component(service = ISlizaaActionContribution.class)
public class CopyIdAction extends AbstractCopyAction implements ISlizaaActionContribution {

  @Override
  public int getRanking() {
    return 10;
  }
  
  @Override
  protected String mapNode(HGNode node) {
    return node.getIdentifier().toString();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getLabel(List<?> selection) {
    return selection.size() > 1 ? "Copy IDs" : "Copy ID";
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getImagePath(List<?> selection) {
    return null;
  }
}
