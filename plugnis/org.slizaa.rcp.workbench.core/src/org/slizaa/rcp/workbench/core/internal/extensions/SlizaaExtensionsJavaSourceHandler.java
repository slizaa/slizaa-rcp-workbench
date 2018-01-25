/**
 *
 */
package org.slizaa.rcp.workbench.core.internal.extensions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

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

    //
    deleteExtensionsForResource(resource);

    // visit the AST
    SlizaaExtensionsAstVisitor astVisitor = new SlizaaExtensionsAstVisitor(resource.getProject());
    compilationUnit.accept(astVisitor);

    //
    if (!astVisitor.getExtensions().isEmpty()) {

      //
      SlizaaProject slizaaProject = SlizaaWorkbenchCore.getSlizaaProject(resource.getProject());

      //
      for (SlizaaProjectExtension extension : astVisitor.getExtensions()) {

        // set the resource path
        extension.setResourcePath(resource.getProjectRelativePath().toString());

        //
        List<SlizaaProjectExtension> slizaaProjectExtensions = new ArrayList<SlizaaProjectExtension>();

        //
        if (slizaaProject.getUserDefinedExtensions().containsKey(extension.getAnnotationType())) {
          slizaaProjectExtensions.addAll(slizaaProject.getUserDefinedExtensions().get(extension.getAnnotationType()));
        }

        //
        slizaaProjectExtensions.add(extension);

        //
        slizaaProject.getUserDefinedExtensions().put(extension.getAnnotationType(), slizaaProjectExtensions);
      }
    }
  }

  @Override
  public void handleRemoved(IResource resource) throws CoreException {

    //
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

    //
    String resourcePath = deletedResource.getProjectRelativePath().toString();

    //
    for (Entry<Class<?>, List<SlizaaProjectExtension>> entry : slizaaProject.getUserDefinedExtensions().entrySet()) {

      //
      Iterator<SlizaaProjectExtension> iterator = entry.getValue().iterator();
      while (iterator.hasNext()) {
        SlizaaProjectExtension projectExtension = iterator.next();
        if (projectExtension.getResourcePath().equals(resourcePath)) {
          iterator.remove();
        }
      }
    }
  }
}
