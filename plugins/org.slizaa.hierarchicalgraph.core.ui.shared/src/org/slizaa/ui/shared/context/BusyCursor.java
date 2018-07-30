package org.slizaa.ui.shared.context;

import static com.google.common.base.Preconditions.checkNotNull;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class BusyCursor {

  /**
   * <p>
   * </p>
   *
   * @param control
   * @param runnable
   */
  public static void execute(Control control, Runnable runnable) {

    checkNotNull(control);
    checkNotNull(runnable);

    Display.getDefault().syncExec(() -> {
      try {
        Cursor cursor = Display.getDefault().getSystemCursor(SWT.CURSOR_WAIT);
        control.setCursor(cursor);

        runnable.run();

      } finally {
        control.setCursor(null);
      }
    });
  }
}
