package org.slizaa.rcp.workbench.core.internal.extensions;

import java.util.Map;

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

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class SlizaaExtensionsBuildVisitor implements IResourceVisitor, IResourceDeltaVisitor {

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
      if (delta.getResource().getName().endsWith(".java")) {
        // TODO: DELETE
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
    if (!resource.getName().endsWith(".java")) {
      return false;
    }

    // get the corresponding java element
    IJavaElement element = JavaCore.create(resource);
    IJavaProject javaProject = JavaCore.create(resource.getProject());
    if (element == null || !javaProject.isOnClasspath(element) || !element.isStructureKnown()) {
      return false;
    }

    // create the AST
    CompilationUnit compilationUnit = createAst((ICompilationUnit) element);

    // do not process files with compile errors
    if (!hasErrors(compilationUnit)) {

      // visit the AST
      SlizaaExtensionsAstVisitor astVisitor = new SlizaaExtensionsAstVisitor(resource.getProject());
      compilationUnit.accept(astVisitor);
    }

    //
    return false;
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