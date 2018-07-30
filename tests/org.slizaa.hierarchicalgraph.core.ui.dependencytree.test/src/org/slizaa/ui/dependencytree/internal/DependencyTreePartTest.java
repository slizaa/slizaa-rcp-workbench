package org.slizaa.ui.dependencytree.internal;

import org.junit.Test;
import org.slizaa.hierarchicalgraph.core.selections.DependencySelection;
import org.slizaa.hierarchicalgraph.core.selections.SelectionsFactory;

/**
 * <p>
 * </p>
 */
public class DependencyTreePartTest extends AbstractDependencyTreePartTest {

  /**
   * <p>
   * </p>
   *
   * @throws InterruptedException
   */
  @Test
  public void test() throws InterruptedException {

    //
    DependencySelection dependencySelection = SelectionsFactory.eINSTANCE.createDependencySelection();
    dependencySelection.getDependencies()
        .addAll(testGraph().rootNode().getChildren().get(5).getAccumulatedOutgoingCoreDependencies());

    //
    part().handleMainDependencySelectionChanged(null, dependencySelection);
  }
}