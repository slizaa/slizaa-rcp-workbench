package org.slizaa.hierarchicalgraph.core.testfwk.ui.rules;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.junit.rules.ExternalResource;

public class SwtBotRule extends ExternalResource {

  /** - */
  private SWTBot  _swtbot;

  /** - */
  private Shell   _shell;

  /** - */
  private Display _display;

  /**
   * {@inheritDoc}
   */
  @Override
  protected void before() throws Throwable {

    //
    _display = Display.getDefault();
    _display.syncExec(() -> {
      _shell = new Shell(_display);
      _shell.setLayout(new FillLayout());
      _shell.setSize(800, 400);
    });
  };

  /**
   * {@inheritDoc}
   */
  @Override
  protected void after() {
    _display.syncExec(() -> {
      if (_shell != null && !_shell.isDisposed()) {
        _shell.dispose();
        _shell = null;
      }
    });
  };

  public void openShell() {
    _shell.open();
    _swtbot = new SWTBot(_shell);
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public Shell shell() {
    return _shell;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public Display display() {
    return _display;
  }

  /**
   * <p>
   * </p>
   */
  public final SWTBot swtbot() {
    return _swtbot;
  }

  /**
   * <p>
   * </p>
   */
  public final void displaySleep() {
    while (!shell().isDisposed()) {
      if (!display().readAndDispatch())
        display().sleep();
    }
  }
}
