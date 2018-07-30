package org.slizaa.ui.tree.actions;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.hierarchicalgraph.core.model.spi.INodeLabelProvider;
import org.slizaa.ui.tree.ISlizaaActionContribution;

@Component(service = ISlizaaActionContribution.class)
public class CopyNameAction extends AbstractCopyAction implements ISlizaaActionContribution {

  @Override
  public int getRanking() {
    return 11;
  }
  
  @Override
  protected String mapNode(HGNode node) {
    INodeLabelProvider nodeLabelProvider = node.getRootNode().getExtension(INodeLabelProvider.class);
    return nodeLabelProvider.getText(node);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getLabel(List<?> selection) {
    return selection.size() > 1 ? "Copy Names" : "Copy Name";
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getImagePath(List<?> selection) {
    return null;
  }
}
