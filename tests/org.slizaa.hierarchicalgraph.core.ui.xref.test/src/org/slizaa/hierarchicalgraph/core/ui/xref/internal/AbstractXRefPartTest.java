package org.slizaa.hierarchicalgraph.core.ui.xref.internal;

import java.util.List;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotToolbarButton;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slizaa.hierarchicalgraph.core.model.DefaultNodeSource;
import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.hierarchicalgraph.core.testfwk.ui.AbstractXmiBasedTestGraphUiTest;
import org.slizaa.ui.tree.actions.CollapseSelectionAction;
import org.slizaa.ui.tree.actions.CopyActionGroup;
import org.slizaa.ui.tree.actions.CopyIdAction;
import org.slizaa.ui.tree.actions.CopyNameAction;
import org.slizaa.ui.tree.actions.ExpandSelectionAction;
import org.slizaa.ui.tree.interceptors.SelectedNodesLabelProviderInterceptor;
import org.slizaa.ui.tree.internal.IInterceptableLabelProvider;

public abstract class AbstractXRefPartTest extends AbstractXmiBasedTestGraphUiTest {

  /** - */
  private static XRefPart     _part;

  /** - */
  private SWTBotTree          _xrefFromTree;

  /** - */
  private SWTBotTree          _xrefCenterTree;

  /** - */
  private SWTBotTree          _xrefToTree;

  /** - */
  private SWTBotTreeItem      _fromRootItem;

  /** - */
  private SWTBotTreeItem      _centerRootItem;

  /** - */
  private SWTBotTreeItem      _toRootItem;

  /** - */
  private SWTBotToolbarButton _cropSelectionButton;

  /** - */
  private SWTBotToolbarButton _uncropButton;

  /** - */
  private List<HGNode>        _modules;

  /**
   * <p>
   * </p>
   */
  @BeforeClass
  public static void createPart() {

    //
    _part = openShell(new XRefPart());

    // add actions

    treeViewerFactoryRule.defaultActionContributionProvider().actionGroups().add(new CopyActionGroup());
    treeViewerFactoryRule.defaultActionContributionProvider().actions().add(new CopyNameAction());
    treeViewerFactoryRule.defaultActionContributionProvider().actions().add(new CopyIdAction());
    treeViewerFactoryRule.defaultActionContributionProvider().actions().add(new ExpandSelectionAction());
    treeViewerFactoryRule.defaultActionContributionProvider().actions().add(new CollapseSelectionAction());
  }

  /**
   * <p>
   * </p>
   *
   */
  @Before
  public void setup() {

    // get the swt bot items
    _xrefFromTree = swtbot().treeWithId("slizaa-id", "xref-from-treeviewer");
    _xrefCenterTree = swtbot().treeWithId("slizaa-id", "xref-center-treeviewer");
    _xrefToTree = swtbot().treeWithId("slizaa-id", "xref-to-treeviewer");
    _cropSelectionButton = swtbot().toolbarButtonWithId("slizaa-id", XRefComposite.ToolbarItems.CROP.name());
    _uncropButton = swtbot().toolbarButtonWithId("slizaa-id", XRefComposite.ToolbarItems.UNCROP.name());

    // patch the label provider
    XRefComposite xRefComposite = (XRefComposite) _xrefCenterTree.widget.getParent().getParent().getParent();
    ((IInterceptableLabelProvider) xRefComposite.centeredTreeViewComposite().getTreeViewer().getLabelProvider())
        .setLabelProviderInterceptor(new XRefTestLabelProviderInterceptor(
            (SelectedNodesLabelProviderInterceptor) ((IInterceptableLabelProvider) xRefComposite
                .centeredTreeViewComposite().getTreeViewer().getLabelProvider()).getLabelProviderInterceptor()));

    //
    testGraph().rootNode().setName("HG Root Node");
    workbenchModel().setRootNode(testGraph().rootNode());

    _modules = testGraph().rootNode().getChildren();
    _fromRootItem = fromTree().getTreeItem("HG Root Node");
    _centerRootItem = centerTree().getTreeItem("HG Root Node");
    _toRootItem = toTree().getTreeItem("HG Root Node");
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public SWTBotTreeItem fromRootItem() {
    return _fromRootItem;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public SWTBotTreeItem centerRootItem() {
    return _centerRootItem;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public SWTBotTreeItem toRootItem() {
    return _toRootItem;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public SWTBotToolbarButton cropSelectionButton() {
    return _cropSelectionButton;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public SWTBotToolbarButton uncropButton() {
    return _uncropButton;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public List<HGNode> modules() {
    return _modules;
  }

  /**
   * <p>
   * </p>
   */
  public SWTBotTree fromTree() {
    return _xrefFromTree;
  }

  /**
   * <p>
   * </p>
   */
  public SWTBotTree centerTree() {
    return _xrefCenterTree;
  }

  /**
   * <p>
   * </p>
   */
  public SWTBotTree toTree() {
    return _xrefToTree;
  }

  /**
   * <p>
   * </p>
   */
  public XRefPart part() {
    return _part;
  }

  /**
   * <p>
   * </p>
   *
   * @param name
   * @return
   */
  public String property(HGNode node, String name) {
    return node.getNodeSource(DefaultNodeSource.class).get().getProperties().get(name);
  }
}
