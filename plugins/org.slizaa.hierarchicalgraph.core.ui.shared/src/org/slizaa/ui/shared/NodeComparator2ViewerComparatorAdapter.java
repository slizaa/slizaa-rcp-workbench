package org.slizaa.ui.shared;

import static com.google.common.base.Preconditions.checkNotNull;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.slizaa.hierarchicalgraph.core.model.spi.INodeComparator;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class NodeComparator2ViewerComparatorAdapter extends ViewerComparator {

  /** - */
  private INodeComparator _nodeComparator;

  /**
   * <p>
   * Creates a new instance of type {@link NodeComparator2ViewerComparatorAdapter}.
   * </p>
   *
   * @param nodeComparator
   */
  public NodeComparator2ViewerComparatorAdapter(INodeComparator nodeComparator) {
    _nodeComparator = checkNotNull(nodeComparator);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int category(Object element) {
    return _nodeComparator.category(element);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int compare(Viewer viewer, Object e1, Object e2) {
    return _nodeComparator.compare(e1, e2);
  }
}
