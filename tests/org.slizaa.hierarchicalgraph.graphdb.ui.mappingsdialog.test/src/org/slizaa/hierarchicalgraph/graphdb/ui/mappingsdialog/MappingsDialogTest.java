package org.slizaa.hierarchicalgraph.graphdb.ui.mappingsdialog;

import java.util.Arrays;
import java.util.Collections;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class MappingsDialogTest {

  /**
   * <p>
   * </p>
   *
   * @throws InterruptedException
   */
  @Test
  @Ignore
  public void testMappingsDialog() throws InterruptedException {

    //
    Shell shell = new Shell(Display.getDefault());

    //
    MappingsProviderDialog dialog = new MappingsProviderDialog(shell,
        () -> Arrays.asList(
            new DummyMappingProvider("test", "test", "description", Collections.singletonMap("location", "workspace")),
            new DummyMappingProvider("test", "test", "description", Collections.singletonMap("location", "provided"))));
    dialog.setBlockOnOpen(true);
    dialog.open();
    if (dialog.getReturnCode() == Window.OK) {
      System.out.println("SELECTED " + dialog.getSelectedMappingProvider());
    }

    // SWTBot swtBot = new SWTBot();
    // SWTBotTreeItem treeItem = swtBot.tree().getTreeItem("workspace");
    // treeItem.doubleClick();
    // swtBot.waitUntil(Conditions.treeItemHasNode(treeItem, "test"));
    // treeItem = swtBot.tree().getTreeItem("provided");
    // treeItem.doubleClick();
    // swtBot.waitUntil(Conditions.treeItemHasNode(treeItem, "test"));
  }
}
