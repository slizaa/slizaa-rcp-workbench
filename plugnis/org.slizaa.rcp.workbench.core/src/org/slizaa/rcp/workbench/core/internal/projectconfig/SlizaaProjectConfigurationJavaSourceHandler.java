/**
 *
 */
package org.slizaa.rcp.workbench.core.internal.projectconfig;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.slizaa.rcp.workbench.core.SlizaaWorkbenchCore;
import org.slizaa.rcp.workbench.core.internal.builder.IJavaSourceHandler;
import org.slizaa.rcp.workbench.core.model.SlizaaProject;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel;
import org.slizaa.rcp.workbench.core.model.impl.ExtendedSlizaaProjectImpl;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class SlizaaProjectConfigurationJavaSourceHandler implements IJavaSourceHandler {

  /**
   * {@inheritDoc}
   */
  @Override
  public void handleAddedOrChanged(IResource resource, CompilationUnit compilationUnit) throws CoreException {

    // visit the AST
    SlizaaProjectConfigurationAstVisitor astVisitor = new SlizaaProjectConfigurationAstVisitor(resource.getProject());
    compilationUnit.accept(astVisitor);

    // // Insane hack: we have to check whether types has been parsed or not
    // // Under some circumstances the JDT AST is empty and getComponentDescriptions() returns an empty list
    // // bug: https://github.com/wuetherich/ds-annotation-builder/issues/11
    // if (myAstVisitor.getComponentDescriptions().isEmpty() && myAstVisitor.hasTypes()) {
    // // delete any component description that eventually have been generated before for this resource
    // ComponentDescriptionFactory.getComponentDescriptionWriter().deleteGeneratedFiles(resource.getProject(),
    // resource.getProjectRelativePath());
    // }

    //
    deleteConfigurationModelForResource(resource);

    //
    if (!astVisitor.getSlizaaProjectConfigurationModels().isEmpty()) {

      // TODO: HANDLE MULTIPLE!
      SlizaaProjectConfigurationModel configurationModel = astVisitor.getSlizaaProjectConfigurationModels().get(0);
      configurationModel.setProject(resource.getProject());
      configurationModel.setResourcePath(resource.getProjectRelativePath().toString());

      //
      addConfigurationModelForResource(resource, configurationModel);
    }
  }

  @Override
  public void handleRemoved(IResource resource) throws CoreException {
    deleteConfigurationModelForResource(resource);
  }

  /**
   * <p>
   * </p>
   *
   * @param deletedResource
   * @throws CoreException
   */
  private void deleteConfigurationModelForResource(IResource deletedResource) throws CoreException {

    // get the model
    SlizaaProject slizaaProject = SlizaaWorkbenchCore.getSlizaaProject(deletedResource.getProject());

    //
    if (slizaaProject.getConfiguration() != null && deletedResource.getProjectRelativePath().toString()
        .equals(slizaaProject.getConfiguration().getResourcePath())) {

      //
      ((ExtendedSlizaaProjectImpl) slizaaProject).setConfiguration(null);
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param resource
   * @param configurationModel
   * @throws CoreException
   */
  private void addConfigurationModelForResource(IResource resource,
      SlizaaProjectConfigurationModel projectConfiguration) throws CoreException {

    // get the model
    SlizaaProject slizaaProject = SlizaaWorkbenchCore.getSlizaaProject(resource.getProject());

    //
    if (slizaaProject.getConfiguration() != null
        && !resource.getProjectRelativePath().toString().equals(slizaaProject.getConfiguration().getResourcePath())) {

      //
      throw new RuntimeException("Configuration already set!");
    }

    //
    else {

      //
      projectConfiguration.setResourcePath(resource.getProjectRelativePath().toString());
      ((ExtendedSlizaaProjectImpl) slizaaProject).setConfiguration(projectConfiguration);
    }
  }
}
