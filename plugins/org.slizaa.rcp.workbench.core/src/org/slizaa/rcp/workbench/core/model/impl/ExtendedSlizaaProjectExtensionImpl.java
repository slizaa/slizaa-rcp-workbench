/**
 *
 */
package org.slizaa.rcp.workbench.core.model.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import org.slizaa.rcp.workbench.core.internal.utils.BuildHelper;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 */
public class ExtendedSlizaaProjectExtensionImpl extends SlizaaProjectExtensionImpl {

  /**
   * {@inheritDoc}
   */
  @Override
  public <T> T createNewInstance(Class<T> extensionType) {

    //
    String extensionTypeName = checkNotNull(extensionType.getName());

    //

    try {

      //
      Class<?> configurationClass = BuildHelper.createClassLoader(this.getProject()).loadClass(this.getTypeName());

      // TODO: isAssignableFrom
      return (T) configurationClass.newInstance();
    }
    //
    catch (Exception e) {
      // TODO
      e.printStackTrace();
      return null;
    }
  }

}
