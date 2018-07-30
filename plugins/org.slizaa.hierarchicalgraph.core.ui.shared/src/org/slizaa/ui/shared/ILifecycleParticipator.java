/**
 *
 */
package org.slizaa.ui.shared;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 */
public interface ILifecycleParticipator<P> {

  /**
   * <p>
   * </p>
   *
   * @param part
   */
  void postCreate(P part);

  /**
   * <p>
   * </p>
   *
   * @param part
   */
  void preDestroy(P part);
}
