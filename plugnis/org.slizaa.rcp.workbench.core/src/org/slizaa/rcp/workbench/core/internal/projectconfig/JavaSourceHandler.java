/**
 *
 */
package org.slizaa.rcp.workbench.core.internal.projectconfig;

import java.util.ArrayList;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.slizaa.rcp.workbench.core.SlizaaWorkbenchCore;
import org.slizaa.rcp.workbench.core.internal.SlizaaProject;
import org.slizaa.rcp.workbench.core.internal.builder.IJavaSourceHandler;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class JavaSourceHandler implements IJavaSourceHandler {

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
    for (SlizaaProjectConfigurationModel configurationModel : astVisitor.getSlizaaProjectConfigurationModels()) {

      // handle problems...
      if (configurationModel.hasProblems()) {

        try {

          for (SlizaaProjectConfigurationProblem problem : configurationModel.getProblems()) {
            IMarker marker = resource.createMarker(SlizaaWorkbenchCore.SLIZAA_CONFIGURATION_PROBLEM_MARKER);
            marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
            marker.setAttribute(IMarker.CHAR_START, problem.getCharStart());
            marker.setAttribute(IMarker.CHAR_END, problem.getCharEnd());
            marker.setAttribute(IMarker.MESSAGE, problem.getMessage());
          }

        } catch (CoreException e) {
          //
        }
      }

      //
      else {

        //
        addConfigurationModelForResource(resource, configurationModel);
      }
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
    SlizaaProject slizaaProject = (SlizaaProject) SlizaaWorkbenchCore.getSlizaaProject(deletedResource.getProject());
    slizaaProject.getProjectConfigurationModels().remove(deletedResource);
  }

  /**
   * <p>
   * </p>
   *
   * @param resource
   * @param configurationModel
   * @throws CoreException
   */
  private void addConfigurationModelForResource(IResource resource, SlizaaProjectConfigurationModel configurationModel)
      throws CoreException {

    //
    SlizaaProject slizaaProject = (SlizaaProject) SlizaaWorkbenchCore.getSlizaaProject(resource.getProject());
    slizaaProject.getProjectConfigurationModels().computeIfAbsent(resource, key -> new ArrayList<>())
        .add(configurationModel);
  }

}
