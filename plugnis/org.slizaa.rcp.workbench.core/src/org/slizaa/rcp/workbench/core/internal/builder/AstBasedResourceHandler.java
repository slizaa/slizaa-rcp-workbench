package org.slizaa.rcp.workbench.core.internal.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.compiler.IProblem;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class AstBasedResourceHandler implements IResourceHandler {

  /** - */
  private List<IJavaSourceHandler> _javaSourceHandlers;

  /**
   * <p>
   * Creates a new instance of type {@link AstBasedResourceHandler}.
   * </p>
   *
   * @param javaSourceHandlers
   */
  public AstBasedResourceHandler(IJavaSourceHandler... javaSourceHandlers) {
    this._javaSourceHandlers = Arrays.asList(javaSourceHandlers);
  }

  /**
   * <p>
   * Creates a new instance of type {@link AstBasedResourceHandler}.
   * </p>
   *
   * @param javaSourceHandlers
   */
  public AstBasedResourceHandler(List<IJavaSourceHandler> javaSourceHandlers) {
    this._javaSourceHandlers = checkNotNull(javaSourceHandlers);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean canHandle(IResource resource) {
    return resource.getName().endsWith(".java");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void handleAddedOrChanged(IResource resource) throws CoreException {

    // get the corresponding java element
    IJavaElement element = JavaCore.create(resource);
    IJavaProject javaProject = JavaCore.create(resource.getProject());

    //
    if (element == null || !javaProject.isOnClasspath(element) || !element.isStructureKnown()) {
      return;
    }

    //
    if (!(element instanceof ICompilationUnit)) {
      return;
    }

    // create the AST
    CompilationUnit compilationUnit = createAst((ICompilationUnit) element);

    // do not process files with compile errors
    if (hasErrors(compilationUnit)) {
      return;
    }

    //
    for (IJavaSourceHandler javaSourceHandler : this._javaSourceHandlers) {
      javaSourceHandler.handleAddedOrChanged(resource, compilationUnit);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void handleRemoved(IResource resource) throws CoreException {
    for (IJavaSourceHandler javaSourceHandler : this._javaSourceHandlers) {
      javaSourceHandler.handleRemoved(resource);
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
