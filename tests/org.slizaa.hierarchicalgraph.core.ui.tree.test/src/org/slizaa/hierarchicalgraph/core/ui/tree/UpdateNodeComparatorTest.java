package org.slizaa.hierarchicalgraph.core.ui.tree;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.assertj.core.api.Assertions.assertThat;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Test;
import org.slizaa.hierarchicalgraph.core.model.DefaultNodeSource;
import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.hierarchicalgraph.core.model.HGRootNode;
import org.slizaa.hierarchicalgraph.core.model.spi.INodeComparator;
import org.slizaa.hierarchicalgraph.core.ui.tree.fwk.AbstractSlizaaTreeViewerTest;

/**
 * <p>
 * </p>
 */
public class UpdateNodeComparatorTest extends AbstractSlizaaTreeViewerTest {

  /**
   * <p>
   * </p>
   *
   * @throws InterruptedException
   */
  @Test
  public void test() throws InterruptedException {

    // get the root nodes
    HGRootNode rootNode = testGraph().rootNode();

    // configure node comparator
    rootNode.registerExtension(INodeComparator.class, new TestNodeComparator(false));

    // we have to set the node
    part().handleRootNodeChanged(null, testGraph().rootNode());

    //
    SWTBotTreeItem[] treeItems = tree().getAllItems();

    assertThat(treeItems).hasSize(63);
    assertThat(treeItems[0].getText()).isEqualTo("/annotations-2.0.0.jar (16)");
    assertThat(treeItems[62].getText()).isEqualTo("/xstream-1.4.2.jar (306123)");

    // configure node comparator
    rootNode.registerExtension(INodeComparator.class, new TestNodeComparator(true));

    //
    treeItems = tree().getAllItems();
    assertThat(treeItems).hasSize(63);
    assertThat(treeItems[0].getText()).isEqualTo("/xstream-1.4.2.jar (306123)");
    assertThat(treeItems[62].getText()).isEqualTo("/annotations-2.0.0.jar (16)");
  }

  public static class TestNodeComparator implements INodeComparator {

    /** - */
    private boolean _sortInverse;

    /**
     * <p>
     * Creates a new instance of type {@link TestNodeComparator}.
     * </p>
     *
     * @param sortInverse
     */
    public TestNodeComparator(boolean sortInverse) {
      this._sortInverse = checkNotNull(sortInverse);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int category(Object element) {
      return 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compare(Object e1, Object e2) {

      //
      if (!(e1 instanceof HGNode && e2 instanceof HGNode)) {
        return 0;
      }

      //
      DefaultNodeSource nodeSource1 = ((HGNode) e1).getNodeSource(DefaultNodeSource.class).get();
      DefaultNodeSource nodeSource2 = ((HGNode) e2).getNodeSource(DefaultNodeSource.class).get();

      //
      String key = "fileName";
      if (nodeSource1.getProperties().containsKey(key) && nodeSource2.getProperties().containsKey(key)) {
        if (this._sortInverse) {
          return nodeSource2.getProperties().get(key).compareTo(nodeSource1.getProperties().get(key));
        } else {
          return nodeSource1.getProperties().get(key).compareTo(nodeSource2.getProperties().get(key));
        }
      }

      //
      return -1;
    }
  }

}