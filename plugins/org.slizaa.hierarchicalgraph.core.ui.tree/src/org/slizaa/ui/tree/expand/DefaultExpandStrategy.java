/*******************************************************************************
 * Copyright (c) Gerd W�therich 2012-2016. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors: Gerd W�therich (gerd@gerd-wuetherich.de) - initial API and implementation
 ******************************************************************************/
package org.slizaa.ui.tree.expand;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import org.slizaa.hierarchicalgraph.core.model.HGCoreDependency;
import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.hierarchicalgraph.core.model.HGProxyDependency;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class DefaultExpandStrategy extends AbstractExpandStrategy implements IExpandStrategy {

  /** - */
  private int                       _maxExpanded       = 100;

  /** - */
  private int                       _currentlyExpanded = 0;

  /** - */
  private Function<HGNode, Boolean> _preventAutoExpansion;

  /**
   * <p>
   * Creates a new instance of type {@link DefaultExpandStrategy}.
   * </p>
   *
   * @param preventAutoExpansion
   *          may be null
   */
  public DefaultExpandStrategy(Function<HGNode, Boolean> preventAutoExpansion) {
    this._preventAutoExpansion = preventAutoExpansion;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected List<Object> computeExpandedArtifacts(HGNode rootElement) {
    checkNotNull(rootElement);

    this._currentlyExpanded = 0;

    //
    List<Object> result = new LinkedList<>();

    //
    List<HGNode> visibleChildren = computeVisibleChildren(rootElement);
    this._currentlyExpanded = visibleChildren.size();
    result.add(rootElement);

    //
    _computeExpandedElements(visibleChildren, result);

    //
    return result;
  }

  /**
   * <p>
   * </p>
   *
   * @param result
   * @param element
   * @param visibleElements
   * @param maxExpanded
   */
  private void _computeExpandedElements(List<HGNode> elementsToExpand, List<Object> result) {

    //
    checkNotNull(elementsToExpand);
    checkNotNull(result);

    //
    if (elementsToExpand.size() == 0) {
      return;
    }

    //
    List<HGNode> newChildren = new LinkedList<>();

    //
    for (HGNode child : elementsToExpand) {

      // only expand nodes with 'autoExpand' == true
      if (!child.getNodeSource().isAutoExpand()) {
        continue;
      }

      // don't expand a node when the 'preventAutoExpansion' function returns 'true' (mainly used for proxy
      // dependencies)
      if (this._preventAutoExpansion != null && this._preventAutoExpansion.apply(child)) {
        continue;
      }

      //
      List<HGNode> visibleChildren = computeVisibleChildren(child);

      //
      if (this._currentlyExpanded + visibleChildren.size() < this._maxExpanded) {
        result.add(child);
        newChildren.addAll(visibleChildren);
        this._currentlyExpanded = this._currentlyExpanded + visibleChildren.size();
      }
      //
      else {
        return;
      }
    }

    _computeExpandedElements(newChildren, result);
  }

  /**
   * <p>
   * </p>
   *
   * @param elementToExpand
   * @return
   */
  private List<HGNode> computeVisibleChildren(HGNode elementToExpand) {

    //
    List<HGNode> result = new LinkedList<>();

    //
    for (HGNode element : elementToExpand.getChildren()) {
      if (getVisibleElements().contains(element)) {
        result.add(element);
      }
    }

    //
    return result;
  }

  /**
   * <p>
   * </p>
   *
   * @param coreDependencies
   * @return
   */
  public static boolean hasUnresolvedProxyDependencies(Iterable<HGCoreDependency> coreDependencies) {

    //
    for (HGCoreDependency coreDependency : coreDependencies) {
      if (coreDependency instanceof HGProxyDependency && !((HGProxyDependency) coreDependency).isResolved()) {
        return true;
      }
    }
    return false;
  }
}
