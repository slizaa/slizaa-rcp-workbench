package org.slizaa.ui.tree.internal;

import org.slizaa.ui.tree.interceptors.ISlizaaLabelProviderInterceptor;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public interface IInterceptableLabelProvider {

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public ISlizaaLabelProviderInterceptor getLabelProviderInterceptor();

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public boolean hasLabelProviderInterceptor();

  /**
   * <p>
   * </p>
   *
   * @param labelProviderInterceptor
   */
  public void setLabelProviderInterceptor(ISlizaaLabelProviderInterceptor labelProviderInterceptor);
}
