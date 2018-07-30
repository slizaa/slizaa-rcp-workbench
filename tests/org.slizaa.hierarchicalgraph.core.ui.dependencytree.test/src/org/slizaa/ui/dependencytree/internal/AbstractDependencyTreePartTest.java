package org.slizaa.ui.dependencytree.internal;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slizaa.hierarchicalgraph.core.testfwk.ui.AbstractXmiBasedTestGraphUiTest;
import org.slizaa.hierarchicalgraph.core.ui.dependencytree.internal.DependencyTreeComposite;
import org.slizaa.hierarchicalgraph.core.ui.dependencytree.internal.DependencyTreePart;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public abstract class AbstractDependencyTreePartTest extends AbstractXmiBasedTestGraphUiTest {

  /** - */
  private static DependencyTreePart _part;

  /** - */
  private SWTBotTree                _fromTree;

  /** - */
  private SWTBotTree                _toTree;

  /**
   * <p>
   * </p>
   */
  @BeforeClass
  public static void createPart() {

    //
    Injector injector = Guice.createInjector(new DependencyTreeTestModule());

    //
    _part = new DependencyTreePart();
    _part.createComposite(shell(), injector);

    //
    openShell();
  }

  /**
   * <p>
   * </p>
   *
   */
  @Before
  public void setup() {

    // create the SWTBotTrees
    this._fromTree = swtbot().treeWithId("slizaa-id", DependencyTreeComposite.SLIZAA_ID_DEPENDENCY_TREE_FROM_TREE);
    this._toTree = swtbot().treeWithId("slizaa-id", DependencyTreeComposite.SLIZAA_ID_DEPENDENCY_TREE_TO_TREE);
  }

  /**
   * <p>
   * </p>
   */
  public DependencyTreePart part() {
    return _part;
  }

  /**
   * <p>
   * </p>
   */
  public SWTBotTree fromTree() {
    return this._fromTree;
  }

  /**
   * <p>
   * </p>
   */
  public SWTBotTree toTree() {
    return this._toTree;
  }

}