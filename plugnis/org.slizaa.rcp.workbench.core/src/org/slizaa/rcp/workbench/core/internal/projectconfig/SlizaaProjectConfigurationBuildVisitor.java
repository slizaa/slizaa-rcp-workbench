package org.slizaa.rcp.workbench.core.internal.projectconfig;

import java.util.ArrayList;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.compiler.IProblem;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.slizaa.rcp.workbench.core.SlizaaWorkbenchCore;
import org.slizaa.rcp.workbench.core.internal.SlizaaProject;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class SlizaaProjectConfigurationBuildVisitor implements IResourceVisitor, IResourceDeltaVisitor {

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean visit(IResourceDelta delta) throws CoreException {

    // added
    if (delta.getKind() == IResourceDelta.ADDED) {
      return visit(delta.getResource());
    }

    // removed
    else if (delta.getKind() == IResourceDelta.REMOVED) {

      //
      if (delta.getResource().getName().endsWith(".java")) {
        deleteConfigurationModelForResource(delta.getResource());
      }
    }

    // changed
    else if (delta.getKind() == IResourceDelta.CHANGED) {
      return visit(delta.getResource());
    }

    //
    return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean visit(IResource resource) throws CoreException {

    //
    if (resource.getType() != IResource.FILE) {
      return true;
    }

    //
    handle(resource);

    //
    return false;
  }

  /**
   * <p>
   * </p>
   *
   * @param resource
   * @throws CoreException
   */
  private void handle(IResource resource) throws CoreException {

    //
    if (!resource.getName().endsWith(".java")) {
      return;
    }

    // get the corresponding java element
    IJavaElement element = JavaCore.create(resource);
    IJavaProject javaProject = JavaCore.create(resource.getProject());
    if (element == null || !javaProject.isOnClasspath(element) || !element.isStructureKnown()) {
      return;
    }

    // delete all markers
    try {
      resource.deleteMarkers(SlizaaWorkbenchCore.SLIZAA_CONFIGURATION_PROBLEM_MARKER, true, IResource.DEPTH_ZERO);
    } catch (CoreException e) {
      //
    }

    //
    parse((ICompilationUnit) element, resource);
  }

  /**
   * <p>
   * </p>
   *
   * @param icompilationUnit
   * @throws CoreException
   */
  private void parse(ICompilationUnit icompilationUnit, IResource resource) throws CoreException {

    // create the AST
    CompilationUnit compilationUnit = createAst(icompilationUnit);

    // do not process files with compile errors
    if (hasErrors(compilationUnit)) {
      return;
    }

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

  /**
   * <p>
   * </p>
   *
   * @param result
   * @return
   */
  private boolean hasErrors(CompilationUnit result) {
    for (IProblem problem : result.getProblems()) {
      if (problem.isError()) {
        return true;
      }
    }
    return false;
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

  /**
   * <p>
   * </p>
   *
   * @param icompilationUnit
   * @return
   */
  private CompilationUnit createAst(ICompilationUnit icompilationUnit) {
    ASTParser parser = ASTParser.newParser(AST.JLS9);
    parser.setSource(icompilationUnit);

    Map<String, String> options = JavaCore.getOptions();
    JavaCore.setComplianceOptions(JavaCore.VERSION_9, options);
    parser.setCompilerOptions(options);
    parser.setResolveBindings(true);
    CompilationUnit result = (CompilationUnit) parser.createAST(null);
    return result;
  }

}