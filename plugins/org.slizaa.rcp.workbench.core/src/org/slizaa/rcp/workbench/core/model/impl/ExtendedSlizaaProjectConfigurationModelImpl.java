/**
 *
 */
package org.slizaa.rcp.workbench.core.model.impl;

import org.slizaa.rcp.workbench.core.internal.utils.BuildHelper;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 */
public class ExtendedSlizaaProjectConfigurationModelImpl extends SlizaaProjectConfigurationModelImpl {

  private Injector _injector;

  @Override
  public Injector getInjector() {

    //
    if (this._injector == null) {
      this._injector = createInjector();
    }

    //
    return this._injector;
  }

  private Injector createInjector() {

    try {

      //
      Class<?> configurationClass = BuildHelper.createClassLoader(this.getProject()).loadClass(this.getTypeName());

      if (AbstractModule.class.isAssignableFrom(configurationClass)) {

        return Guice.createInjector((AbstractModule) configurationClass.newInstance());
      }
    }
    //
    catch (Exception e) {
      // TODO
      e.printStackTrace();

      //
      return null;
    }
    //
    return null;
  }
}
