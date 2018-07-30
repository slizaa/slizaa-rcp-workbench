package org.slizaa.ui.tree.interceptors;

import java.util.Collection;
import java.util.function.Supplier;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.graphics.Font;
import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.hierarchicalgraph.core.model.HGRootNode;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class SelectedNodesLabelProviderInterceptor extends ISlizaaLabelProviderInterceptor.Adapter
    implements ISlizaaLabelProviderInterceptor {

  /** - */
  private Supplier<Collection<HGNode>> _selectedNodesSupplier;

  /**
   * <p>
   * Creates a new instance of type {@link SelectedNodesLabelProviderInterceptor}.
   * </p>
   *
   * @param selectedNodesSupplier
   */
  public SelectedNodesLabelProviderInterceptor(Supplier<Collection<HGNode>> selectedNodesSupplier) {
    super();
    this._selectedNodesSupplier = selectedNodesSupplier;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Font alterFont(Object object) {

    //
    Collection<HGNode> selectedNodes = selectedNodes();

    //
    if (!(object instanceof HGRootNode) && selectedNodes != null && (selectedNodes.contains(object)
        || selectedNodes.parallelStream().anyMatch(selectedNode -> selectedNode.getPredecessors().contains(object)))) {

      //
      return JFaceResources.getFontRegistry().getBold(JFaceResources.DIALOG_FONT);
    }

    //
    return null;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public Collection<HGNode> selectedNodes() {
    return this._selectedNodesSupplier.get();
  }
}
