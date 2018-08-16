/**
 *
 */
package org.slizaa.rcp.workbench.discovery.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class ShowBundleCatalogCommandExecuter {

  /** - */
  public static String SLIZAA_EXTENSIONS_URL = "http://www.slizaa.org/p2/slizaa-extensions/M3/directory.xml";

  /**
   * <p>
   * </p>
   */
  public static final void executeShowBundleCatalogCommand() {

    //
    Display.getDefault().syncExec(() -> {

      // get the commad service
      ICommandService commandService = PlatformUI.getWorkbench().getService(ICommandService.class);

      try {

        // execute the command
        Command command = commandService.getCommand("org.eclipse.equinox.p2.ui.discovery.commands.ShowBundleCatalog");
        Command.DEBUG_COMMAND_EXECUTION = true;
        Map<String, String> parameters = new HashMap<>();
        parameters.put("org.eclipse.equinox.p2.ui.discovery.commands.DirectoryParameter", SLIZAA_EXTENSIONS_URL);
        command.executeWithChecks(new ExecutionEvent(command, parameters, null, null));
      }

      // TODO
      catch (Exception exception) {
        exception.printStackTrace();
      }
    });
  }
}
