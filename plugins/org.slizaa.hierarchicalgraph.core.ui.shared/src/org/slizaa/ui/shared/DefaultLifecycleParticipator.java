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
public class DefaultLifecycleParticipator<P> implements ILifecycleParticipator<P> {

  @Override
  public void postCreate(P part) {
    // do nothing
  }

  @Override
  public void preDestroy(P part) {
    // do nothing
  }
}
