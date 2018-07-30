/*******************************************************************************
 * Copyright (c) Gerd W�therich 2012-2016.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *    Gerd W�therich (gerd@gerd-wuetherich.de) - initial API and implementation
 ******************************************************************************/
package org.slizaa.ui.tree;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.function.Supplier;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.hierarchicalgraph.core.model.HGRootNode;

/**
 * <p>
 * </p>
 * 
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class VisibleNodesFilter extends ViewerFilter {

  /** - */
  private Supplier<Collection<HGNode>> _visibleNodesSupplier;

  /** - */
  private boolean                      _showChildren;

  /**
   * <p>
   * Creates a new instance of type {@link VisibleNodesFilter} .
   * </p>
   * 
   * @param visibleNodesSupplier
   */
  public VisibleNodesFilter(Supplier<Collection<HGNode>> visibleNodesSupplier, boolean showChildren) {
    _visibleNodesSupplier = checkNotNull(visibleNodesSupplier);
    _showChildren = showChildren;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean select(Viewer viewer, Object parentElement, Object element) {

    //
    if (element instanceof HGRootNode) {
      return true;
    }

    // only Filter HGNodes
    if (!(element instanceof HGNode)) {
      return true;
    }

    //
    HGNode elementNode = ((HGNode) element);

    //
    Collection<HGNode> visibleElements = _visibleNodesSupplier.get();

    //
    if (visibleElements == null || visibleElements.isEmpty()) {
      return false;
    }
    // selected element?
    else if (visibleElements.contains(elementNode)) {
      return true;
    }
    // child element?
    else if (_showChildren && elementNode.getPredecessors().stream().anyMatch(visibleElements::contains)) {
      return true;
    }
    // parent element?
    else if (visibleElements.parallelStream().anyMatch(node -> node.getPredecessors().contains(elementNode))) {
      return true;
    }

    //
    return false;
  }
}
