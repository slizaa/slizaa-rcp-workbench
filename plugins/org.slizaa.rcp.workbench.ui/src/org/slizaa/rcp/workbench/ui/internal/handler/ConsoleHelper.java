/**
 *
 */
package org.slizaa.rcp.workbench.ui.internal.handler;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.PrintStream;

import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class ConsoleHelper {

  private static final String SLIZAA_CONSOLE = "Slizaa Console";

  /**
   * <p>
   * </p>
   *
   * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
   */
  @FunctionalInterface
  public interface ConsoleAction {

    /**
     * <p>
     * </p>
     */
    public void execute() throws Exception;
  }

  /**
   * <p>
   * </p>
   *
   * @param runnable
   * @throws Exception
   */
  public static void executeWithConsole(ConsoleAction consoleAction) throws Exception {

    //
    checkNotNull(consoleAction);

    //
    MessageConsole myConsole = ConsoleHelper.findConsole(SLIZAA_CONSOLE);

    PrintStream originalOutStream = System.out;
    PrintStream originalErrStream = System.err;

    try (PrintStream out = new PrintStream(myConsole.newOutputStream())) {
      System.setOut(out);
      System.setErr(out);

      consoleAction.execute();

    } finally {
      System.setOut(originalOutStream);
      System.setErr(originalErrStream);
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param name
   * @return
   */
  public static MessageConsole findConsole(String name) {
    ConsolePlugin plugin = ConsolePlugin.getDefault();
    IConsoleManager conMan = plugin.getConsoleManager();
    IConsole[] existing = conMan.getConsoles();
    for (int i = 0; i < existing.length; i++) {
      if (name.equals(existing[i].getName())) {
        return (MessageConsole) existing[i];
      }
    }
    // no console found, so create a new one
    MessageConsole myConsole = new MessageConsole(name, null);
    conMan.addConsoles(new IConsole[] { myConsole });
    return myConsole;
  }

  /**
   * <p>
   * </p>
   *
   * @param console
   */
  public static void showConsole(IConsole console) {

    try {
      IWorkbench wb = PlatformUI.getWorkbench();
      IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
      IWorkbenchPage page = win.getActivePage();

      String id = IConsoleConstants.ID_CONSOLE_VIEW;
      IConsoleView view = (IConsoleView) page.showView(id);
      view.display(console);

    }
    //
    catch (PartInitException e) {
      e.printStackTrace();
    }
  }
}
