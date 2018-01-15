/**
 *
 */
package org.slizaa.rcp.workbench.core.internal.builder;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

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

  /**
   * <p>
   * </p>
   *
   * @param resource
   * @throws CoreException 
   */
  void handleAddedOrChanged(IResource resource) throws CoreException;

  /**
   * <p>
   * </p>
   *
   * @param resource
   * @throws CoreException 
   */
  void handleRemoved(IResource resource) throws CoreException;
}
