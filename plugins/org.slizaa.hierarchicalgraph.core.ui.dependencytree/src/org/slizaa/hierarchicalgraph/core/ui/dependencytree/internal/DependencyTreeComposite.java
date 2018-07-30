/*******************************************************************************
 * Copyright (c) Gerd W�therich 2012-2016. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors: Gerd W�therich (gerd@gerd-wuetherich.de) - initial API and implementation
 ******************************************************************************/
package org.slizaa.hierarchicalgraph.core.ui.dependencytree.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.function.Consumer;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.slizaa.hierarchicalgraph.core.model.AbstractHGDependency;
import org.slizaa.hierarchicalgraph.core.model.HGCoreDependency;
import org.slizaa.hierarchicalgraph.core.model.HGRootNode;
import org.slizaa.hierarchicalgraph.core.model.spi.IAutoExpandInterceptor;
import org.slizaa.hierarchicalgraph.core.selections.DependencySelection;
import org.slizaa.hierarchicalgraph.core.selections.SelectionsFactory;
import org.slizaa.hierarchicalgraph.core.selections.selector.DefaultDependencySelector;
import org.slizaa.hierarchicalgraph.core.selections.selector.IDependencySelector;
import org.slizaa.hierarchicalgraph.core.selections.selector.IDependencySelectorListener;
import org.slizaa.hierarchicalgraph.core.selections.selector.SelectedNodesChangedEvent;
import org.slizaa.hierarchicalgraph.core.selections.selector.UnfilteredDependenciesChangedEvent;
import org.slizaa.ui.shared.SlizaaCommonColors;
import org.slizaa.ui.shared.context.RootObject;
import org.slizaa.ui.tree.SlizaaTreeViewerFactory;
import org.slizaa.ui.tree.VisibleNodesFilter;
import org.slizaa.ui.tree.expand.DefaultExpandStrategy;
import org.slizaa.ui.tree.expand.IExpandStrategy;
import org.slizaa.ui.tree.interceptors.DependencyResolvingTreeEventInterceptor;
import org.slizaa.ui.tree.interceptors.SelectedNodesLabelProviderInterceptor;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class DependencyTreeComposite extends Composite {

  /** - */
  public static final String                 SLIZAA_ID_DEPENDENCY_TREE_TO_TREE   = "dependency-tree-to-tree";

  /** - */
  public static final String                 SLIZAA_ID_DEPENDENCY_TREE_FROM_TREE = "dependency-tree-from-tree";

  /** - */
  private static final Set<HGCoreDependency> EMPTY_DEPENDENCY_SET                = Collections.emptySet();

  /** the from tree viewer */
  private TreeViewer                         _fromTreeViewer;

  /** the to tree viewer */
  private TreeViewer                         _toTreeViewer;

  /** - */
  private IDependencySelector                _selector;

  /** - */
  private IExpandStrategy                    _fromExpandStrategy;

  /** - */
  private IExpandStrategy                    _toExpandStrategy;

  /** - */
  @Inject
  @Named("dependencySelectionCallback")
  private Consumer<DependencySelection>      _dependencyConsumer;

  /**
   * <p>
   * Creates a new instance of type {@link DependencyTreeComposite}.
   * </p>
   *
   * @param parent
   */
  public DependencyTreeComposite(Composite parent) {
    super(parent, SWT.NONE);
  }

  /**
   * <p>
   * </p>
   *
   * @param dependencies
   */
  public void setDependencies(Collection<HGCoreDependency> dependencies) {

    //
    this._selector.setUnfilteredCoreDependencies(dependencies);

    // set input to null if no dependencies are defined...
    if (dependencies.size() == 0) {

      //
      this._fromTreeViewer.setInput(null);
      this._toTreeViewer.setInput(null);
    }

    // ... else set the root node
    else {

      // get the root node
      HGRootNode rootNode = dependencies.toArray(new AbstractHGDependency[0])[0].getFrom().getRootNode();

      //
      if (!rootNode.equals(this._fromTreeViewer.getInput()) && !rootNode.equals(this._toTreeViewer.getInput())) {
        this._fromTreeViewer.setInput(new RootObject(rootNode));
        this._toTreeViewer.setInput(new RootObject(rootNode));
      }
    }

    this._fromExpandStrategy.expand(this._selector.getUnfilteredSourceNodes());
    this._toExpandStrategy.expand(this._selector.getUnfilteredTargetNodes());
  }

  /**
   * <p>
   * </p>
   */
  public void init() {

    //
    this._fromExpandStrategy = new DefaultExpandStrategy((node) -> {

      //
      boolean preventAutoExpand = false;
      if (node.getRootNode().hasExtension(IAutoExpandInterceptor.class)) {
        preventAutoExpand = node.getRootNode().getExtension(IAutoExpandInterceptor.class).preventAutoExpansion(node);
      }

      //
      return preventAutoExpand
          || DefaultExpandStrategy.hasUnresolvedProxyDependencies(node.getOutgoingCoreDependencies());
    });

    //
    this._toExpandStrategy = new DefaultExpandStrategy((node) -> {

      //
      boolean preventAutoExpand = false;
      if (node.getRootNode().hasExtension(IAutoExpandInterceptor.class)) {
        preventAutoExpand = node.getRootNode().getExtension(IAutoExpandInterceptor.class).preventAutoExpansion(node);
      }

      //
      return preventAutoExpand
          || DefaultExpandStrategy.hasUnresolvedProxyDependencies(node.getIncomingCoreDependencies());
    });

    //
    this._selector = new DefaultDependencySelector();

    //
    this._selector.addDependencySelectorListener(new IDependencySelectorListener.Adapter() {

      @Override
      public void unfilteredDependenciesChanged(UnfilteredDependenciesChangedEvent event) {

        //
        DependencyTreeComposite.this._fromTreeViewer.refresh();
        DependencyTreeComposite.this._toTreeViewer.refresh();

        //
        broadcastDetailDependencies(DependencyTreeComposite.this._selector.getFilteredCoreDependencies());
      }

      @Override
      public void selectedNodesChanged(SelectedNodesChangedEvent event) {

        //
        DependencyTreeComposite.this._fromTreeViewer.refresh();
        DependencyTreeComposite.this._toTreeViewer.refresh();

        //
        broadcastDetailDependencies(DependencyTreeComposite.this._selector.getFilteredCoreDependencies());
      }
      //
      // @Override
      // public void proxyDependencyChanged(ProxyDependencyChangedEvent event) {
      // _fromTreeViewer.refresh();
      // _toTreeViewer.refresh();
      // }
    });

    //
    GridLayout layout = new GridLayout(1, false);
    layout.marginWidth = 0;
    layout.marginHeight = 0;
    this.setLayout(layout);

    //
    SashForm sashForm = new SashForm(this, SWT.HORIZONTAL | SWT.SMOOTH);
    sashForm.setBackground(SlizaaCommonColors.getSashBackgroundColor());
    GridData data = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
    sashForm.setLayoutData(data);

    //
    this._fromTreeViewer = SlizaaTreeViewerFactory.newSlizaaTreeViewer(sashForm)
        .withStyle(SWT.NO_BACKGROUND | SWT.MULTI).withAutoExpandLevel(3)
        .withLabelProviderInterceptor(new SelectedNodesLabelProviderInterceptor(
            () -> this._selector.getSelectedTargetNodes().isEmpty() ? Collections.emptyList()
                : this._selector.getFilteredSourceNodes()))
        .withTreeEventInterceptor(
            new DependencyResolvingTreeEventInterceptor((node) -> this._selector.getDependenciesForSourceNode(node)))
        .create();

    this._fromTreeViewer.getTree().setData("slizaa-id", SLIZAA_ID_DEPENDENCY_TREE_FROM_TREE);

    //
    this._toTreeViewer = SlizaaTreeViewerFactory.newSlizaaTreeViewer(sashForm).withStyle(SWT.NO_BACKGROUND | SWT.MULTI)
        .withAutoExpandLevel(3)
        .withLabelProviderInterceptor(new SelectedNodesLabelProviderInterceptor(
            () -> this._selector.getSelectedSourceNodes().isEmpty() ? Collections.emptyList()
                : this._selector.getFilteredTargetNodes()))
        .withTreeEventInterceptor(
            new DependencyResolvingTreeEventInterceptor((node) -> this._selector.getDependenciesForTargetNode(node)))
        .create();

    this._toTreeViewer.getTree().setData("slizaa-id", SLIZAA_ID_DEPENDENCY_TREE_TO_TREE);

    //
    this._fromTreeViewer.setFilters(new VisibleNodesFilter(() -> this._selector.getUnfilteredSourceNodes(), false));
    this._toTreeViewer.setFilters(new VisibleNodesFilter(() -> this._selector.getUnfilteredTargetNodes(), false));

    // add SelectionListeners
    this._fromTreeViewer.addSelectionChangedListener(new FromArtifactsSelectionChangedListener());
    this._toTreeViewer.addSelectionChangedListener(new ToArtifactSelectionChangedListener());

    //
    this._fromExpandStrategy.init(this._fromTreeViewer);
    this._toExpandStrategy.init(this._toTreeViewer);
  }

  /**
   * <p>
   * </p>
   *
   * @param selectedDetailDependencies
   */
  private void broadcastDetailDependencies(Set<HGCoreDependency> dependencies) {

    // create dependency selection
    DependencySelection dependencySelection = SelectionsFactory.eINSTANCE.createDependencySelection();
    dependencySelection.getDependencies().addAll(dependencies);

    // and broadcast it
    this._dependencyConsumer.accept(dependencySelection);
  }

  /**
   * <p>
   * </p>
   *
   * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
   */
  private final class FromArtifactsSelectionChangedListener implements ISelectionChangedListener {

    @Override
    public void selectionChanged(SelectionChangedEvent event) {

      //
      IStructuredSelection structuredSelection = (IStructuredSelection) event.getSelection();
      if (structuredSelection.isEmpty()) {
        return;
      }

      DependencyTreeComposite.this._selector.setSelectedSourceNodes(SelectionUtil.toArtifactList(structuredSelection));

      if (DependencyTreeComposite.this._selector.getFilteredSourceNodes().isEmpty()
          || DependencyTreeComposite.this._selector.getFilteredTargetNodes().isEmpty()) {

        // TODO: How should we handle this?
      }
    }
  }

  /**
   * <p>
   * </p>
   *
   * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
   */
  private final class ToArtifactSelectionChangedListener implements ISelectionChangedListener {

    /**
     * {@inheritDoc}
     */
    @Override
    public void selectionChanged(SelectionChangedEvent event) {

      //
      IStructuredSelection structuredSelection = (IStructuredSelection) event.getSelection();
      if (structuredSelection.isEmpty()) {
        return;
      }

      DependencyTreeComposite.this._selector.setSelectedTargetNodes(SelectionUtil.toArtifactList(structuredSelection));

      if (DependencyTreeComposite.this._selector.getFilteredSourceNodes().isEmpty()
          || DependencyTreeComposite.this._selector.getFilteredTargetNodes().isEmpty()) {

        // TODO: How should we handle this?
      }
    }
  }
}
