package org.slizaa.ui.dependencytable;

import static org.slizaa.hierarchicalgraph.core.selections.SelectionFactoryMethods.createDependencySelection;

import java.util.Collection;

import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTable;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slizaa.hierarchicalgraph.core.model.HGCoreDependency;
import org.slizaa.hierarchicalgraph.core.testfwk.ui.AbstractXmiBasedTestGraphUiTest;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class DependencyTableTest extends AbstractXmiBasedTestGraphUiTest {

  /** - */
  private static DependencyTablePart _part;

  /**
   * <p>
   * </p>
   */
  @BeforeClass
  public static void createPart() {
    _part = openShell(new DependencyTablePart());
  }

  /**
   * <p>
   * </p>
   */
  @Test
  public void test() {

    //
    SWTBotTable tableBot = swtbot().table();

    //
    Collection<HGCoreDependency> dependencies = testGraph().node(28232)
        .getOutgoingDependenciesTo(testGraph().node(267432)).getCoreDependencies();

    //
    _part.handleDetailDependencySelectionChanged(null, createDependencySelection(dependencies));

    //
    swtbot().waitUntil(Conditions.tableHasRows(tableBot, dependencies.size()));

    // TODO: sort/filter/etc.
    // assert (tableBot.getTableItem(0).getText(0))
    // .equals("com.amazonaws.services.ec2.model.transform.DhcpConfigurationStaxUnmarshaller");
  }
}