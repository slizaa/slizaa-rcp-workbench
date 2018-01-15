/**
 *
 */
package org.slizaa.rcp.workbench.core.internal.builder;

import org.eclipse.core.resources.IResource;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public interface IResourceHandler {

  /**
   * <p>
   * </p>
   *
   * @param resource
   * @return
   */
  boolean canHandle(IResource resource);

  boolean handle(IResource resource);
}
