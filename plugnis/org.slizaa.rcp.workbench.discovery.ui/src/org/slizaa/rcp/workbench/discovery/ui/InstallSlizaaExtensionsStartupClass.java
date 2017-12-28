package org.slizaa.rcp.workbench.discovery.ui;

import org.eclipse.ui.IStartup;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class InstallSlizaaExtensionsStartupClass implements IStartup {

  /**
   * {@inheritDoc}
   */
  @Override
  public void earlyStartup() {

    // http://www.wickedshell.net/blog/2010/03/executing-commands-programatically/
    // https://wiki.eclipse.org/FAQ_How_do_I_load_and_save_plug-in_preferences%3F

    ShowBundleCatalogCommandExecuter.executeShowBundleCatalogCommand();
  }
}
