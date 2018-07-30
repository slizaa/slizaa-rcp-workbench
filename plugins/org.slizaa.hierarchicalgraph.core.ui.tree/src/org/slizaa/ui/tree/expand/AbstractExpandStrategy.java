/*******************************************************************************
 * Copyright (c) Gerd W�therich 2012-2016. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors: Gerd W�therich (gerd@gerd-wuetherich.de) - initial API and implementation
 ******************************************************************************/
package org.slizaa.ui.tree.expand;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.ITreeViewerListener;
import org.eclipse.jface.viewers.TreeExpansionEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.ui.shared.context.RootObject;

public abstract class AbstractExpandStrategy implements IExpandStrategy {

  /** - */
  private final Set<Object>   _manuallyCollapsedElements = new HashSet<Object>();

  /** - */
  private final Set<Object>   _manuallyExpandedElements  = new HashSet<Object>();

  /** - */
  private TreeViewer          _treeViewer;

  /** - */
  private Collection<HGNode>  _visibleElements;

  /** - */
  private ITreeViewerListener _treeViewerListener;

  /**
   * {@inheritDoc}
   */
  @Override
  public void init(TreeViewer treeViewer) {

    //
    this._treeViewer = checkNotNull(treeViewer);

    //
    this._treeViewerListener = new ITreeViewerListener() {

      @Override
      public void treeExpanded(TreeExpansionEvent event) {
        AbstractExpandStrategy.this._manuallyExpandedElements.add(event.getElement());
        AbstractExpandStrategy.this._manuallyCollapsedElements.remove(event.getElement());
      }

      @Override
      public void treeCollapsed(TreeExpansionEvent event) {
        AbstractExpandStrategy.this._manuallyExpandedElements.remove(event.getElement());
        AbstractExpandStrategy.this._manuallyCollapsedElements.add(event.getElement());
      }
    };

    //
    treeViewer.addTreeListener(this._treeViewerListener);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void dispose() {

    //
    this._treeViewer.remove(this._treeViewerListener);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public TreeViewer getTreeViewer() {

    //
    return this._treeViewer;
  }

  @Override
  public final void expand(Collection<HGNode> visibleElements) {

    //
    this._visibleElements = new HashSet<HGNode>();
    for (HGNode hgNode : visibleElements) {
      this._visibleElements.add(hgNode);
      this._visibleElements.addAll(hgNode.getPredecessors());
    }

    // disable redraw (performance)
    this._treeViewer.getTree().setRedraw(false);

    //
    _expand(false);

    // enable redraw (performance)
    this._treeViewer.getTree().setRedraw(true);
  }

  public Collection<HGNode> getVisibleElements() {
    return this._visibleElements;
  }

  private void _expand(boolean deleteManuallyExpandedElements) {

    //
    if (deleteManuallyExpandedElements) {
      this._manuallyExpandedElements.clear();
      this._manuallyCollapsedElements.clear();
    }

    //
    Object input = this._treeViewer.getInput();
    if (input == null) {
      return;
    }

    HGNode rootElement = null;
    if (input instanceof RootObject) {
      rootElement = (HGNode) ((RootObject) input).getRoot();
    } else if (input instanceof HGNode) {
      rootElement = (HGNode) input;
    }

    //
    List<Object> expandedElements = computeExpandedArtifacts(rootElement);

    //
    expandedElements.addAll(this._manuallyExpandedElements);
    expandedElements.removeAll(this._manuallyCollapsedElements);

    //
    this._treeViewer.setExpandedElements(expandedElements.toArray());
  }

  /**
   * <p>
   * </p>
   *
   * @param rootElement
   * @param visibleArtifact
   * @return
   */
  protected abstract List<Object> computeExpandedArtifacts(HGNode rootElement);
}
