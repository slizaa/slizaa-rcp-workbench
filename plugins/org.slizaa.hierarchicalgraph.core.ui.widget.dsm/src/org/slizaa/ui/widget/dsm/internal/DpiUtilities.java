package org.slizaa.ui.widget.dsm.internal;

import org.eclipse.core.runtime.Assert;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;

/**
 * A collection of utility methods for SWT.
 */
public final class DpiUtilities {

	private final static float DEFAULT_DPI_X = 96.0f;
	private final static float DEFAULT_DPI_Y = 96.0f;
	private final static Point DEFAULT_DPI = new Point(Math.round(DEFAULT_DPI_X), Math.round(DEFAULT_DPI_Y));
	private static Point cachedDpi = null;

	/**
	 * Returns a point whose x coordinate is the horizontal dots per inch of the (current or default) display, and whose y coordinate is the vertical dots per
	 * inch of the display.
	 * 
	 * @return the horizontal and vertical DPI
	 */
	public static Point getDpi() {
		return getDpi(null);
	}

	/**
	 */
	public static Point getDefaultDpi() {
		return DEFAULT_DPI;
	}

	/**
	 * Returns a point whose x coordinate is the horizontal dots per inch of the display, and whose y coordinate is the vertical dots per inch of the display.
	 * 
	 * @param widget
	 *            if widget is not {@code null} return DPI of the display that's associated with the widget; otherwise return the DPI of the current or default
	 *            display
	 * @return the horizontal and vertical DPI
	 */
	public static Point getDpi(final Widget widget) {

		if (cachedDpi == null) {
			Display display = null;
			if (widget != null) {
				display = widget.getDisplay();
			}
			if (display == null) {
				display = getDisplay();
			}
			Assert.isNotNull(display, "No display exits"); //$NON-NLS-1$
			final Display d = display;
			display.syncExec(new Runnable() {
				public void run() {
					cachedDpi = d.getDPI();
				}
			});
		}

		return cachedDpi;

	}



	/**
	 * Returns the Display.
	 * 
	 * @return instance of Display or null if there is no display
	 * @since 6.1
	 */
	public static Display getDisplay() {

		Display display = null;
//		if (display == null) {
//			try {
//				display = RcpUtilities.getDisplay();
//			} catch (final RuntimeException e) {
//				display = null;
//			}
//		}
		if (display == null) {
			display = Display.getCurrent();
		}
		if (display == null) {
			display = Display.getDefault();
		}

		return display;

	}


  /**
   * Returns the scaling factors which can be used to scale pixel values the same amount as the current DPI differs from
   * the standard DPI (on Windows: 96 DPI).
   * 
   * @return x-factor and y-factors
   */
  public static float[] getCalculatedDpiFactors() {
    return getCalculatedDpiFactors(null);
  }

  /**
   * Returns the scaling factors which can be used to scale pixel values the same amount as the current DPI differs from
   * the standard DPI (on Windows: 96 DPI).
   * 
   * @return x-factor and y-factors
   */
  public static float[] getCalculatedDpiFactors(final Widget widget) {
    final Point dpi = getDpi(widget);
    final float[] factors = new float[2];
    factors[0] = dpi.x / DEFAULT_DPI_X;
    factors[1] = dpi.y / DEFAULT_DPI_Y;
    return factors;
  }
}