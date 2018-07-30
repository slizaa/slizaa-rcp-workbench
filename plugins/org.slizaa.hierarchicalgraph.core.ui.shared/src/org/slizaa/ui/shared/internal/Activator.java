/*******************************************************************************
 * Copyright (c) Gerd W�therich 2012-2016.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *    Gerd W�therich (gerd@gerd-wuetherich.de) - initial API and implementation
 ******************************************************************************/
package org.slizaa.ui.shared.internal;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

  // The plug-in ID
  public static final String PLUGIN_ID = "org.slizaa.ui.shared"; //$NON-NLS-1$

  // The shared instance
  private static Activator   plugin;

  /** - */
  private static Color              _sashBackgroundColor;

  /** - */
  private static Color              _scrollbarThumbColor;

  /**
   * The constructor
   */
  public Activator() {
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    plugin = this;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(BundleContext context) throws Exception {
    plugin = null;
    if (_sashBackgroundColor != null) {
      _sashBackgroundColor.dispose();
    }
    super.stop(context);
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public static Color getSashBackgroundColor() {
    if (_sashBackgroundColor == null) {
      _sashBackgroundColor = new Color(Display.getCurrent(), 181, 197, 212);
    }
    return _sashBackgroundColor;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public static Color getScrollbarThumbColor() {
    if (_scrollbarThumbColor == null) {
      _scrollbarThumbColor = new Color(Display.getCurrent(), 100, 138, 175);
    }
    return _scrollbarThumbColor;
  }

  /**
   * Returns the shared instance
   * 
   * @return the shared instance
   */
  public static Activator getDefault() {
    return plugin;
  }
}
