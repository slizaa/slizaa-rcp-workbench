package org.slizaa.ui.tree.interceptors;

import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public interface ISlizaaLabelProviderInterceptor {

  /**
   * <p>
   * </p>
   *
   * @param object
   * @param text
   * @return
   */
  String alterText(Object object, String text);

  /**
   * <p>
   * </p>
   *
   * @param object
   * @param styledString
   * @return
   */
  StyledString alterStyledText(Object object, StyledString styledString);

  /**
   * <p>
   * </p>
   *
   * @param object
   * @return
   */
  Font alterFont(Object object);

  /**
   * <p>
   * </p>
   *
   * @param object
   * @return
   */
  Color alterForeground(Object object);

  /**
   * <p>
   * </p>
   *
   * @param object
   * @return
   */
  Color alterBackground(Object object);

  /**
   * <p>
   * </p>
   *
   * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
   */
  public static class Adapter implements ISlizaaLabelProviderInterceptor {

    /**
     * {@inheritDoc}
     */
    @Override
    public String alterText(Object object, String text) {
      return text;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StyledString alterStyledText(Object object, StyledString styledString) {
      return styledString;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Font alterFont(Object object) {
      return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Color alterForeground(Object object) {
      return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Color alterBackground(Object object) {
      return null;
    }
  }
}
