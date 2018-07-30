package org.slizaa.hierarchicalgraph.core.ui.xref.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ToolItem;
import org.slizaa.hierarchicalgraph.core.model.HGCoreDependency;
import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.hierarchicalgraph.core.model.HGRootNode;
import org.slizaa.hierarchicalgraph.core.model.spi.INodeComparator;
import org.slizaa.hierarchicalgraph.core.selections.DependencySelection;
import org.slizaa.hierarchicalgraph.core.selections.NodeSelections;
import org.slizaa.hierarchicalgraph.core.selections.SelectionsFactory;
import org.slizaa.hierarchicalgraph.core.selections.xref.IXRefListener;
import org.slizaa.hierarchicalgraph.core.selections.xref.XRefStack;
import org.slizaa.ui.shared.NodeComparator2ViewerComparatorAdapter;
import org.slizaa.ui.shared.SlizaaCommonColors;
import org.slizaa.ui.shared.context.BusyCursor;
import org.slizaa.ui.shared.context.RootObject;
import org.slizaa.ui.tree.VisibleNodesFilter;
import org.slizaa.ui.tree.expand.NullExpandStrategy;
import org.slizaa.ui.tree.interceptors.DependencyResolvingTreeEventInterceptor;
import org.slizaa.ui.tree.interceptors.SelectedNodesLabelProviderInterceptor;
import org.slizaa.ui.tree.internal.IInterceptableLabelProvider;

public class XRefComposite extends Composite {

  public static enum ToolbarItems {
    EXPAND_ALL, COLLAPSE_ALL, CROP, UNCROP, BACK, FORWARD
  }

  /** - */
  private Consumer<DependencySelection> _dependencySelectionConsumer;

  /** - */
  private XRefStack                     _xRefStack;

  /** - */
  private TreeViewComposite             _leftsidedTreeViewComposite;

  /** - */
  private TreeViewComposite             _centeredTreeViewComposite;

  /** - */
  private TreeViewComposite             _rightsidedTreeViewComposite;

  /** - */
  private HGRootNode                    _rootNode;

  /**
   * <p>
   * Creates a new instance of type {@link XRefComposite}.
   * </p>
   *
   * @param parent
   * @param eclipseContextSupplier
   */
  public XRefComposite(Composite parent, Consumer<DependencySelection> dependencySelectionConsumer) {
    super(parent, SWT.NONE);

    //
    this._dependencySelectionConsumer = checkNotNull(dependencySelectionConsumer);

    //
    GridLayoutFactory.fillDefaults().applyTo(this);

    //
    SashForm sashForm = new SashForm(this, SWT.HORIZONTAL);
    sashForm.setBackground(SlizaaCommonColors.getSashBackgroundColor());
    GridDataFactory.fillDefaults().grab(true, true).applyTo(sashForm);

    //
    this._leftsidedTreeViewComposite = createLeftTree(sashForm);
    this._centeredTreeViewComposite = createCenterTree(sashForm);
    this._rightsidedTreeViewComposite = createRightTree(sashForm);

    //
    this._xRefStack = new XRefStack();
    this._xRefStack.addXRefListener(new IXRefListenerImplementation());
  }

  public void refresh() {
    // TODO
    this._leftsidedTreeViewComposite.getTreeViewer().refresh();
    this._centeredTreeViewComposite.getTreeViewer().refresh();
    this._rightsidedTreeViewComposite.getTreeViewer().refresh();
  }

  /**
   * <p>
   * </p>
   *
   * @param filteredNodes
   */
  public void setFilteredNodes(List<HGNode> filteredNodes, boolean includeChildren) {

    //
    if (filteredNodes != null && !filteredNodes.isEmpty()) {

      //
      this._xRefStack.pruneDependenciesForUncroppedCenterNodes(filteredNodes,
          getSelectedIncomingCoreDependenciesIfNotRoot(filteredNodes),
          getSelectedOutgoingCoreDependenciesIfNotRoot(filteredNodes));

      this._xRefStack.cropSelection();
    }
    //
    else {
      //
      this._xRefStack.uncropAll();
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param rootNode
   */
  public void setRootNode(HGRootNode rootNode) {

    //
    if (rootNode != null && rootNode.equals(this._rootNode)) {
      return;
    }

    //
    this._rootNode = rootNode;

    //
    if (this._rootNode == null) {
      forEachTreeViewerComposite(t -> t.getTreeViewer().setInput(null));
      this._xRefStack.pruneDependenciesForUncroppedCenterNodes(Collections.emptySet(), Collections.emptySet(),
          Collections.emptySet());
    }
    //
    else {

      // set the input
      forEachTreeViewerComposite(t -> t.getTreeViewer().setInput(new RootObject(rootNode)));

      //
      this._leftsidedTreeViewComposite.getTreeViewer()
          .setFilters(new VisibleNodesFilter(() -> Collections.emptySet(), false));
      this._rightsidedTreeViewComposite.getTreeViewer()
          .setFilters(new VisibleNodesFilter(() -> Collections.emptySet(), false));

      // set the viewer comparator
      if (rootNode.hasExtension(INodeComparator.class)) {
        forEachTreeViewerComposite(t -> t.getTreeViewer()
            .setComparator(new NodeComparator2ViewerComparatorAdapter(rootNode.getExtension(INodeComparator.class))));
      }
    }

    // deselect all
    forEachTreeViewerComposite(t -> t.getTreeViewer().setSelection(new StructuredSelection()));

    // set focus to center tree viewer
    this._centeredTreeViewComposite.getTreeViewer().getTree().setFocus();
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  XRefStack xRefStack() {
    return this._xRefStack;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  TreeViewComposite centeredTreeViewComposite() {
    return this._centeredTreeViewComposite;
  }

  /**
   * <p>
   * </p>
   *
   * @param consumer
   */
  private void forEachTreeViewerComposite(Consumer<TreeViewComposite> consumer) {
    consumer.accept(this._leftsidedTreeViewComposite);
    consumer.accept(this._centeredTreeViewComposite);
    consumer.accept(this._rightsidedTreeViewComposite);
  }

  /**
   * <p>
   * </p>
   *
   * @param sashForm
   * @return
   */
  private TreeViewComposite createRightTree(SashForm sashForm) {

    //
    TreeViewComposite treeViewComposite = new TreeViewComposite(sashForm,
        new DependencyResolvingTreeEventInterceptor(
            (node) -> this._xRefStack.outgoingDependencySelector().getDependenciesForTargetNode(node)),
        new NullExpandStrategy(), SWT.RIGHT);

    //
    treeViewComposite.getTreeViewer().getTree().setData("slizaa-id", "xref-to-treeviewer");

    // collapse all
    treeViewComposite.createToolItem(ToolbarItems.COLLAPSE_ALL, XRefImages.COLLAPSE_ALL.getImage(),
        XRefImages.DISABLED_COLLAPSE_ALL.getImage(), e -> {
          collapseAll(treeViewComposite.getTreeViewer());
        });

    //
    treeViewComposite.getTreeViewer().addSelectionChangedListener(event -> {
      IStructuredSelection structuredSelection = (IStructuredSelection) event.getSelection();
      this._xRefStack.setSelectedRightsidedNodes(structuredSelection.toList());
    });

    //
    return treeViewComposite;
  }

  /**
   * <p>
   * </p>
   *
   * @param sashForm
   * @return
   */
  private TreeViewComposite createCenterTree(SashForm sashForm) {

    //
    TreeViewComposite treeViewComposite = new TreeViewComposite(sashForm,
        new DependencyResolvingTreeEventInterceptor((node) -> {
          Set<HGCoreDependency> result = new HashSet<>();

          if (this._xRefStack.hasCroppedSelections()) {
            result.addAll(this._xRefStack.incomingDependencySelector().getDependenciesForTargetNode(node));
            result.addAll(this._xRefStack.outgoingDependencySelector().getDependenciesForSourceNode(node));
          } else {
            result.addAll(node.getIncomingCoreDependencies());
            result.addAll(node.getOutgoingCoreDependencies());
          }

          return result;
        }), new NullExpandStrategy(), SWT.RIGHT);

    //
    treeViewComposite.getTreeViewer().getTree().setData("slizaa-id", "xref-center-treeviewer");

    // set label provider
    ((IInterceptableLabelProvider) treeViewComposite.getTreeViewer().getLabelProvider()).setLabelProviderInterceptor(
        new SelectedNodesLabelProviderInterceptor(() -> this._xRefStack.getBackreferencedCenterNodes()));

    //
    treeViewComposite.getTreeViewer().addSelectionChangedListener(event -> {

      // return if noting is selected
      IStructuredSelection structuredSelection = (IStructuredSelection) event.getSelection();

      if (!structuredSelection.isEmpty()) {

        BusyCursor.execute(this, () -> {

          // This is a performance optimization: if nothing has been 'cropped' yet, we set
          // the initial dependencies whenever the selection changes.
          if (this._xRefStack.isCurrentSelectionCropped()) {
            this._xRefStack.setSelectedCenterNodes(structuredSelection.toList());
          } else {
            this._xRefStack.pruneDependenciesForUncroppedCenterNodes(structuredSelection.toList(),
                getSelectedIncomingCoreDependenciesIfNotRoot(structuredSelection.toList()),
                getSelectedOutgoingCoreDependenciesIfNotRoot(structuredSelection.toList()));
          }
        });

      }
    });

    // create the crop selection button
    treeViewComposite.createToolItem(ToolbarItems.CROP, XRefImages.CROP_SELECTION.getImage(),
        XRefImages.DISABLED_CROP_SELECTION.getImage(), (e) -> {
          this._xRefStack.cropSelection();
        });

    // create the uncrop selection button
    treeViewComposite.createToolItem(ToolbarItems.UNCROP, XRefImages.UNCROP.getImage(),
        XRefImages.DISABLED_UNCROP.getImage(), (e) -> {
          this._xRefStack.uncropAll();
        });

    // create the go back button
    treeViewComposite.createToolItem(ToolbarItems.BACK, XRefImages.CROP_SELECTION_BACK.getImage(),
        XRefImages.DISABLED_CROP_SELECTION_BACK.getImage(), (e) -> {
          this._xRefStack.goBack();
        });

    // create the go forward button
    treeViewComposite.createToolItem(ToolbarItems.FORWARD, XRefImages.CROP_SELECTION_FORWARD.getImage(),
        XRefImages.DISABLED_CROP_SELECTION_FORWARD.getImage(), (e) -> {
          this._xRefStack.goForward();
        });

    // separator
    new ToolItem(treeViewComposite.getToolBar(), SWT.SEPARATOR);

    // collapse all
    treeViewComposite.createToolItem(ToolbarItems.COLLAPSE_ALL, XRefImages.COLLAPSE_ALL.getImage(),
        XRefImages.DISABLED_COLLAPSE_ALL.getImage(), e -> {
          collapseAll(treeViewComposite.getTreeViewer());
        });

    //
    treeViewComposite.getToolItem(ToolbarItems.CROP).setEnabled(false);
    treeViewComposite.getToolItem(ToolbarItems.UNCROP).setEnabled(false);
    treeViewComposite.getToolItem(ToolbarItems.BACK).setEnabled(false);
    treeViewComposite.getToolItem(ToolbarItems.FORWARD).setEnabled(false);

    //
    return treeViewComposite;
  }

  /**
   * <p>
   * </p>
   *
   * @param sashForm
   * @return
   */
  private TreeViewComposite createLeftTree(SashForm sashForm) {

    //
    TreeViewComposite treeViewComposite = new TreeViewComposite(sashForm,
        new DependencyResolvingTreeEventInterceptor(
            (node) -> this._xRefStack.incomingDependencySelector().getDependenciesForSourceNode(node)),
        new NullExpandStrategy(), SWT.RIGHT);

    //
    treeViewComposite.getTreeViewer().getTree().setData("slizaa-id", "xref-from-treeviewer");

    //
    treeViewComposite.getTreeViewer().addSelectionChangedListener(event -> {
      IStructuredSelection structuredSelection = (IStructuredSelection) event.getSelection();
      this._xRefStack.setSelectedLeftsidedNodes(structuredSelection.toList());
    });

    // collapse all
    treeViewComposite.createToolItem(ToolbarItems.COLLAPSE_ALL, XRefImages.COLLAPSE_ALL.getImage(),
        XRefImages.DISABLED_COLLAPSE_ALL.getImage(), e -> {
          collapseAll(treeViewComposite.getTreeViewer());
        });

    //
    return treeViewComposite;
  }

  private void collapseAll(TreeViewer treeViewer) {
    for (TreePath treePath : checkNotNull(treeViewer).getExpandedTreePaths()) {
      if (treePath.getSegmentCount() > 1) {
        treeViewer.setExpandedState(treePath, false);
      }
    }
  }

  /**
   * <p>
   * </p>
   */
  private void updateDetailsSelection() {

    Display.getDefault().syncExec(() -> {
      try {

        //
        Cursor cursor = Display.getDefault().getSystemCursor(SWT.CURSOR_WAIT);
        XRefComposite.this.setCursor(cursor);

        //
        DependencySelection dependencySelection = SelectionsFactory.eINSTANCE.createDependencySelection();
        dependencySelection.getDependencies().addAll(this._xRefStack.getSelectedDependencies());

        this._dependencySelectionConsumer.accept(dependencySelection);

      } finally {
        XRefComposite.this.setCursor(null);
      }
    });
  }

  /**
   * <p>
   * </p>
   *
   * @param structuredSelection
   * @return
   */
  private static List<HGCoreDependency> getSelectedIncomingCoreDependenciesIfNotRoot(List<HGNode> elements) {

    //
    if (elements.size() == 1 && elements.get(0) instanceof HGRootNode) {
      return Collections.emptyList();
    }

    //
    return checkNotNull(elements).stream().filter((e) -> e instanceof HGNode)
        .flatMap((node) -> node.getAccumulatedIncomingCoreDependencies().stream()).collect(Collectors.toList());
  }

  /**
   * <p>
   * </p>
   *
   * @param structuredSelection
   * @return
   */
  private static List<HGCoreDependency> getSelectedOutgoingCoreDependenciesIfNotRoot(List<HGNode> elements) {

    //
    if (elements.size() == 1 && elements.get(0) instanceof HGRootNode) {
      return Collections.emptyList();
    }

    //
    return checkNotNull(elements).stream().filter((e) -> e instanceof HGNode)
        .flatMap((node) -> node.getAccumulatedOutgoingCoreDependencies().stream()).collect(Collectors.toList());

  }

  /**
   * <p>
   * </p>
   *
   * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
   */
  private final class IXRefListenerImplementation implements IXRefListener {

    /**
     * {@inheritDoc}
     */
    @Override
    public void croppedSelectionChanged() {

      //
      XRefComposite.this._leftsidedTreeViewComposite.getTreeViewer()
          .setFilters(new VisibleNodesFilter(() -> XRefComposite.this._xRefStack.getLeftsidedNodes(), false));
      XRefComposite.this._leftsidedTreeViewComposite.getTreeViewer().getTree().deselectAll();

      //
      if (XRefComposite.this._xRefStack.isCurrentSelectionCropped()) {
        XRefComposite.this._centeredTreeViewComposite.getTreeViewer()
            .setFilters(new VisibleNodesFilter(() -> XRefComposite.this._xRefStack.getCenterNodes(), true));
      }
      //
      else {
        //
        IStructuredSelection selection = XRefComposite.this._centeredTreeViewComposite.getTreeViewer()
            .getStructuredSelection();
        XRefComposite.this._centeredTreeViewComposite.getTreeViewer().resetFilters();
        XRefComposite.this._centeredTreeViewComposite.getTreeViewer().setSelection(selection);
      }
      XRefComposite.this._centeredTreeViewComposite.getTreeViewer().refresh();

      //
      XRefComposite.this._rightsidedTreeViewComposite.getTreeViewer()
          .setFilters(new VisibleNodesFilter(() -> XRefComposite.this._xRefStack.getRightsidedNodes(), false));
      XRefComposite.this._rightsidedTreeViewComposite.getTreeViewer().getTree().deselectAll();

      // update the toolbar
      updateToolbar();

      // set the selected detail dependencies in the context
      updateDetailsSelection();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void coreDependenciesChanged() {

      //
      XRefComposite.this._leftsidedTreeViewComposite.getTreeViewer()
          .setFilters(new VisibleNodesFilter(() -> XRefComposite.this._xRefStack.getLeftsidedNodes(), false));
      XRefComposite.this._leftsidedTreeViewComposite.getTreeViewer().getTree().deselectAll();

      //
      if (XRefComposite.this._xRefStack.isCurrentSelectionCropped()) {
        XRefComposite.this._centeredTreeViewComposite.getTreeViewer()
            .setFilters(new VisibleNodesFilter(() -> XRefComposite.this._xRefStack.getCenterNodes(), true));
      }
      //
      else {
        XRefComposite.this._centeredTreeViewComposite.getTreeViewer().refresh();
      }

      //
      XRefComposite.this._rightsidedTreeViewComposite.getTreeViewer()
          .setFilters(new VisibleNodesFilter(() -> XRefComposite.this._xRefStack.getRightsidedNodes(), false));
      XRefComposite.this._rightsidedTreeViewComposite.getTreeViewer().getTree().deselectAll();

      // update the toolbar
      updateToolbar();

      // set the selected detail dependencies in the context
      updateDetailsSelection();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void centerNodeSelectionChanged() {

      // prepare left tree viewer
      XRefComposite.this._leftsidedTreeViewComposite.getTreeViewer()
          .setFilters(new VisibleNodesFilter(() -> XRefComposite.this._xRefStack.getLeftsidedNodes(), false));
      XRefComposite.this._leftsidedTreeViewComposite.getTreeViewer().getTree().deselectAll();

      //
      XRefComposite.this._centeredTreeViewComposite.getTreeViewer().update(
          NodeSelections.computeNodesWithParents(XRefComposite.this._xRefStack.getCenterNodes(), true).toArray(), null);

      // prepare right tree viewer
      XRefComposite.this._rightsidedTreeViewComposite.getTreeViewer()
          .setFilters(new VisibleNodesFilter(() -> XRefComposite.this._xRefStack.getRightsidedNodes(), false));
      XRefComposite.this._rightsidedTreeViewComposite.getTreeViewer().getTree().deselectAll();

      // update the toolbar
      updateToolbar();

      // set the selected detail dependencies in the context
      updateDetailsSelection();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void leftsidedNodeSelectionChanged() {

      // update center...
      XRefComposite.this._centeredTreeViewComposite.getTreeViewer().update(
          NodeSelections.computeNodesWithParents(XRefComposite.this._xRefStack.getCenterNodes(), true).toArray(), null);

      // ...and deselect rightsided tree
      XRefComposite.this._rightsidedTreeViewComposite.getTreeViewer().getTree().deselectAll();

      // update the toolbar
      updateToolbar();

      // set the selected detail dependencies in the context
      updateDetailsSelection();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void rightsidedNodeSelectionChanged() {

      // update center...
      XRefComposite.this._centeredTreeViewComposite.getTreeViewer().update(
          NodeSelections.computeNodesWithParents(XRefComposite.this._xRefStack.getCenterNodes(), true).toArray(), null);

      // ...and deselect leftsided tree
      XRefComposite.this._leftsidedTreeViewComposite.getTreeViewer().getTree().deselectAll();

      // update the toolbar
      updateToolbar();

      // set the selected detail dependencies in the context
      updateDetailsSelection();
    }

    /**
     * <p>
     * </p>
     */
    private void updateToolbar() {
      XRefComposite.this._centeredTreeViewComposite.getToolItem(ToolbarItems.CROP)
          .setEnabled(XRefComposite.this._xRefStack.isCurrentSelectionCropped()
              || !XRefComposite.this._xRefStack.incomingDependencySelector().getUnfilteredCoreDependencies().isEmpty()
              || !XRefComposite.this._xRefStack.outgoingDependencySelector().getUnfilteredCoreDependencies().isEmpty());
      XRefComposite.this._centeredTreeViewComposite.getToolItem(ToolbarItems.UNCROP)
          .setEnabled(XRefComposite.this._xRefStack.hasCroppedSelections());
      XRefComposite.this._centeredTreeViewComposite.getToolItem(ToolbarItems.BACK)
          .setEnabled(XRefComposite.this._xRefStack.canGoBack());
      XRefComposite.this._centeredTreeViewComposite.getToolItem(ToolbarItems.FORWARD)
          .setEnabled(XRefComposite.this._xRefStack.canGoForward());
    }
  }
}
