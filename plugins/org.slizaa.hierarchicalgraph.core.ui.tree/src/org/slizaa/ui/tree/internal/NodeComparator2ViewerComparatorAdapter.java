/**
 *
 */
package org.slizaa.ui.tree.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.function.Supplier;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.slizaa.hierarchicalgraph.core.model.spi.INodeComparator;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 */
public class NodeComparator2ViewerComparatorAdapter extends ViewerComparator {

  /** - */
  private Supplier<INodeComparator> _nodeComparatorSupplier;

  /**
   * <p>
   * Creates a new instance of type {@link NodeComparator2ViewerComparatorAdapter}.
   * </p>
   *
   * @param nodeComparatorSupplier
   */
  public NodeComparator2ViewerComparatorAdapter(Supplier<INodeComparator> nodeComparatorSupplier) {
    this._nodeComparatorSupplier = checkNotNull(nodeComparatorSupplier);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int category(Object element) {
    return this._nodeComparatorSupplier.get().category(element);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int compare(Viewer viewer, Object e1, Object e2) {

    //
    int cat1 = category(e1);
    int cat2 = category(e2);

    if (cat1 != cat2) {
      return cat1 - cat2;
    }

    return this._nodeComparatorSupplier.get().compare(e1, e2);
  }
}
