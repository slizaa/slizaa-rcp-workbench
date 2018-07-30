package org.slizaa.rcp.workbench.discovery.ui;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.ui.IStartup;
import org.osgi.service.prefs.BackingStoreException;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class InstallSlizaaExtensionsStartupClass implements IStartup {

  /** - */
  private String  PLUGIN_ID     = "org.slizaa.rcp.workbench.discovery.ui";

  /** - */
  private String  KEY_FIRST_RUN = "FIRST_RUN";

  /** - */
  private boolean firstRun      = true;

  /**
   * {@inheritDoc}
   */
  @Override
  public void earlyStartup() {

    //
    loadPluginSettings();

    //
    if (this.firstRun) {

      this.firstRun = false;
      savePluginSettings();

      ShowBundleCatalogCommandExecuter.executeShowBundleCatalogCommand();
    }

  }

  /**
   * <p>
   * </p>
   */
  private void savePluginSettings() {

    // https://wiki.eclipse.org/FAQ_How_do_I_load_and_save_plug-in_preferences%3F

    // saves plug-in preferences at the workspace level
    IEclipsePreferences prefs = InstanceScope.INSTANCE.getNode(this.PLUGIN_ID);

    prefs.put(this.KEY_FIRST_RUN, Boolean.toString(this.firstRun));

    try {
      // prefs are automatically flushed during a plugin's "super.stop()".
      prefs.flush();
    } catch (BackingStoreException e) {
      // TODO write a real exception handler.
      e.printStackTrace();
    }
  }

  /**
   * <p>
   * </p>
   */
  private void loadPluginSettings() {

    //
    IEclipsePreferences prefs = InstanceScope.INSTANCE.getNode(this.PLUGIN_ID);

    //
    this.firstRun = prefs.getBoolean(this.KEY_FIRST_RUN, true);
  }
}
