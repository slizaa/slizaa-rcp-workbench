/**
 *
 */
package org.slizaa.rcp.workbench.core.internal.extensions;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.slizaa.rcp.workbench.core.SlizaaWorkbenchCore;
import org.slizaa.rcp.workbench.core.internal.builder.IJavaSourceHandler;
import org.slizaa.rcp.workbench.core.model.SlizaaProject;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class SlizaaExtensionsJavaSourceHandler implements IJavaSourceHandler {

  /**
   * {@inheritDoc}
   */
  @Override
  public void handleAddedOrChanged(IResource resource, CompilationUnit compilationUnit) throws CoreException {

    // visit the AST
    SlizaaExtensionsAstVisitor astVisitor = new SlizaaExtensionsAstVisitor(resource.getProject());
    compilationUnit.accept(astVisitor);

    //
    if (!astVisitor.getExtensions().isEmpty()) {

      SlizaaProject slizaaProject = SlizaaWorkbenchCore.getSlizaaProject(resource.getProject());

      for (SlizaaProjectExtension extension : astVisitor.getExtensions()) {
        extension.setResourcePath(resource.getProjectRelativePath().toString());
      }

      slizaaProject.getProjectExtensions().addAll(astVisitor.getExtensions());
    }
  }

  @Override
  public void handleRemoved(IResource resource) throws CoreException {
    deleteExtensionsForResource(resource);
  }

  /**
   * <p>
   * </p>
   *
   * @param deletedResource
   * @throws CoreException
   */
  private void deleteExtensionsForResource(IResource deletedResource) throws CoreException {

    // get the model
    SlizaaProject slizaaProject = SlizaaWorkbenchCore.getSlizaaProject(deletedResource.getProject());

    // TODO
    // //
    // if (slizaaProject.getConfiguration() != null && deletedResource.getProjectRelativePath().toString()
    // .equals(slizaaProject.getConfiguration().getResourcePath())) {
    //
    // //
    // ((ExtendedSlizaaProjectImpl) slizaaProject).setConfiguration(null);
    // }
  }
}
