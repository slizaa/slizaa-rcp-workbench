/**
 *
 */
package org.slizaa.rcp.workbench.core.model.impl;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 */
public class ExtendedSlizaaExtensionBundleExtensionImpl extends SlizaaExtensionBundleExtensionImpl {

  @Override
  public <T> T createNewInstance(Class<T> extensionType) {

    try {

      // TODO: isAssignableFrom
      return (T) checkNotNull(getType()).newInstance();
    }
    //
    catch (Exception e) {
      // TODO
      e.printStackTrace();
      return null;
    }
  }

}
