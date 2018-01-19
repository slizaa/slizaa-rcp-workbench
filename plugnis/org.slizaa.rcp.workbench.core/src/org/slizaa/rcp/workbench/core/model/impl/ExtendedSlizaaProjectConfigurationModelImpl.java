/**
 *
 */
package org.slizaa.rcp.workbench.core.model.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import java.lang.reflect.Method;

import org.slizaa.rcp.workbench.core.internal.utils.BuildHelper;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationItemModel;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 */
public class ExtendedSlizaaProjectConfigurationModelImpl extends SlizaaProjectConfigurationModelImpl {

  @SuppressWarnings("unchecked")
  @Override
  public <T> T createNewConfigurationItemInstance(Class<T> type) {

    //
    String typeName = checkNotNull(type.getName());

    //
    for (SlizaaProjectConfigurationItemModel configurationItemModel : this.configurationItems) {

      //
      if (typeName.equals(configurationItemModel.getType())) {

        try {

          //
          Class<?> configurationClass = BuildHelper.createClassLoader(this.getProject()).loadClass(this.getTypeName());

          Method method = configurationClass.getDeclaredMethod(configurationItemModel.getMethodName());

          Object result = method.invoke(configurationClass.newInstance());

          // TODO
          return (T) result;
        }
        //
        catch (Exception e) {
          // TODO
          e.printStackTrace();

          //
          return null;
        }
      }
    }

    //
    return null;
  }
}
