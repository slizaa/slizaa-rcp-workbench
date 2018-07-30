package org.slizaa.hierarchicalgraph.core.ui.xref.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.hierarchicalgraph.core.model.HGRootNode;
import org.slizaa.hierarchicalgraph.core.selections.NodeSelection;
import org.slizaa.hierarchicalgraph.core.selections.NodeSelections;
import org.slizaa.ui.shared.AbstractSlizaaWorkbenchModelComponent;
import org.slizaa.ui.shared.context.RootObject;
import org.slizaa.ui.tree.SlizaaTreeViewerFactory;
import org.slizaa.ui.tree.VisibleNodesFilter;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public abstract class AbstractRefNodesPart extends AbstractSlizaaWorkbenchModelComponent {

  /** - */
  private TreeViewer _treeViewer;

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

    // create the tree viewer
    this._treeViewer = SlizaaTreeViewerFactory.newSlizaaTreeViewer(parent)
        .withStyle(SWT.NO_BACKGROUND | SWT.NONE | SWT.MULTI).withAutoExpandLevel(2).create();

    //
    setSelection();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void handleRootNodeChanged(HGRootNode oldValue, HGRootNode newValue) {
    setSelection();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void handleNodeSelectionChanged(NodeSelection oldValue, NodeSelection newValue) {
    setSelection();
  }

  private void setSelection() {

    if (this._treeViewer == null || this._treeViewer.getTree().isDisposed()) {
      return;
    }

    //
    if (getWorkbenchModel().getNodeSelection() == null || getWorkbenchModel().getNodeSelection().getNodes().isEmpty()) {
      this._treeViewer.setInput(null);
      return;
    }

    RootObject oldRoot = (RootObject) this._treeViewer.getInput();
    if (oldRoot == null || oldRoot.getRoot() != getWorkbenchModel().getRootNode()) {
      this._treeViewer.setInput(new RootObject(getWorkbenchModel().getRootNode()));
    }

    // compute referenced/referencing nodes
    Set<HGNode> referencedNodes = getNodesToShow(
        getWorkbenchModel().getNodeSelection() == null ? Collections.emptyList()
            : getWorkbenchModel().getNodeSelection().getNodes());

    //
    Set<HGNode> visible = NodeSelections.computeNodesWithParents(referencedNodes, false);

    //
    this._treeViewer.setFilters(new VisibleNodesFilter(() -> {
      return visible;
    }, false));
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  protected abstract Set<HGNode> getNodesToShow(Collection<HGNode> selectedNodes);
}
