package org.slizaa.rcp.workbench.core.internal.builder;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.dom.CompilationUnit;

public interface IJavaSourceHandler {

  /**
   * <p>
   * </p>
   *
   * @param resource
   * @param compilationUnit
   */
  void handleAddedOrChanged(IResource resource, CompilationUnit compilationUnit) throws CoreException;

  /**
   * <p>
   * </p>
   *
   * @param resource
   */
  void handleRemoved(IResource resource) throws CoreException;
}
