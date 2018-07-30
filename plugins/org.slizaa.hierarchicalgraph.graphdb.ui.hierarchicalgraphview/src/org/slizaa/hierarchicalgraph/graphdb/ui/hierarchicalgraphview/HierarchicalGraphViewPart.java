/*******************************************************************************
 * Copyright (c) Gerd W�therich 2012-2016. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors: Gerd W�therich (gerd@gerd-wuetherich.de) - initial API and implementation
 ******************************************************************************/
package org.slizaa.hierarchicalgraph.graphdb.ui.hierarchicalgraphview;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.hierarchicalgraph.core.model.HGRootNode;
import org.slizaa.hierarchicalgraph.core.selections.NodeSelection;
import org.slizaa.hierarchicalgraph.core.selections.SelectionsFactory;
import org.slizaa.ui.shared.AbstractSlizaaWorkbenchModelComponent;
import org.slizaa.ui.shared.context.RootObject;
import org.slizaa.ui.tree.SlizaaTreeViewerFactory;

public class HierarchicalGraphViewPart extends AbstractSlizaaWorkbenchModelComponent {

  /** - */
  public static final String PART_ID = HierarchicalGraphViewPart.class.getName();

  @Inject
  private ESelectionService  _selectionService;

  /** - */
  private TreeViewer         _treeViewer;

  /**
   * <p>
   * </p>
   *
   * @param parent
   */
  @Override
  @PostConstruct
  public void createComposite(Composite parent) {

    //
    GridLayoutFactory.fillDefaults().applyTo(parent);

    //
    createTreeViewer(parent);
    if (getWorkbenchModel().getRootNode() != null) {
      setRootNodeInViewer(getWorkbenchModel().getRootNode());
    }
  }

  @Override
  protected void handleRootNodeChanged(HGRootNode oldValue, HGRootNode newValue) {

    //
    if (oldValue == newValue) {
      return;
    }

    setRootNodeInViewer(newValue);
  }

  private void setRootNodeInViewer(final HGRootNode newValue) {
    if (this._treeViewer != null && !this._treeViewer.getTree().isDisposed()) {
      if (newValue == null) {
        this._treeViewer.setInput(null);
      } else {
        this._treeViewer.setInput(new RootObject(newValue));
      }
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param parent
   * @param project
   * @return
   */
  private TreeViewer createTreeViewer(Composite parent) {

    //
    this._treeViewer = SlizaaTreeViewerFactory.newSlizaaTreeViewer(parent).withAutoExpandLevel(2)
        .withStyle(SWT.NO_BACKGROUND | SWT.NONE | SWT.MULTI).create();

    //
    this._treeViewer.addSelectionChangedListener(event -> {

      //
      IStructuredSelection selection = (IStructuredSelection) event.getSelection();

      if (HierarchicalGraphViewPart.this._selectionService != null) {
        HierarchicalGraphViewPart.this._selectionService
            .setSelection(selection.size() == 1 ? selection.getFirstElement() : selection.toArray());
      }

      //
      List<HGNode> rep = new ArrayList<>();
      for (Object s : selection.toList()) {
        if (!(s instanceof HGNode) || s instanceof HGRootNode) {
          rep.clear();
          break;
        } else {
          rep.add((HGNode) s);
        }
      }

      //
      NodeSelection nodeSelection = SelectionsFactory.eINSTANCE.createNodeSelection();
      nodeSelection.getNodes().addAll(rep);
      getWorkbenchModel().setNodeSelection(nodeSelection);
    });

    this._treeViewer.addPostSelectionChangedListener(event -> {

      //
      IStructuredSelection selection = (IStructuredSelection) event.getSelection();

      if (HierarchicalGraphViewPart.this._selectionService != null) {
        HierarchicalGraphViewPart.this._selectionService
            .setPostSelection(selection.size() == 1 ? selection.getFirstElement() : selection.toArray());
      }
    });

    //
    return this._treeViewer;
  }
}
