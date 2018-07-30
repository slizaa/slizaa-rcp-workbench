package org.slizaa.ui.tree.interceptors;

import org.slizaa.hierarchicalgraph.core.model.HGNode;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 */
public interface ISlizaaTreeEventInterceptor {

  /**
   * <p>
   * </p>
   *
   * @param data
   */
  void handleSelect(HGNode data);

  /**
   * <p>
   * </p>
   *
   * @param data
   */
  void handleTreeExpand(HGNode data);

  /**
   * <p>
   * </p>
   *
   * @param data
   */
  void handleTreeCollapse(HGNode data);
}
