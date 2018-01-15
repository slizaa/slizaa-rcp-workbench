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
public class JavaSourceHandler implements IResourceHandler {

  @Override
  public boolean canHandle(IResource resource) {
    return false;
  }

  @Override
  public boolean handle(IResource resource) {
    return false;
  }
}
