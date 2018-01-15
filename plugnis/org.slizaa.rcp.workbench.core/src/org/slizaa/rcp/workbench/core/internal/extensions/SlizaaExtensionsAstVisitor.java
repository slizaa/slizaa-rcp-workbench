/**
 *
 */
package org.slizaa.rcp.workbench.core.internal.extensions;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.TypeDeclaration;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 */
public class SlizaaExtensionsAstVisitor extends ASTVisitor {

  /** the current type declaration */
  private Stack<TypeDeclaration>        _currentTypeDeclaration;

  /** the current method declaration */
  private MethodDeclaration             _currentMethodDeclaration;

  /** - */
  private Map<Class<?>, List<Class<?>>> _extensions;

  /** - */
  private IProject                      _project;

  /**
   * <p>
   * Creates a new instance of type {@link AbstractDsAnnotationAstVisitor}.
   * </p>
   */
  public SlizaaExtensionsAstVisitor(IProject project) {

    //
    this._project = checkNotNull(project);
    this._currentTypeDeclaration = new Stack<>();
    this._extensions = new HashMap<>();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean visit(TypeDeclaration node) {
    this._currentTypeDeclaration.push(node);
    return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void endVisit(TypeDeclaration node) {
    this._currentTypeDeclaration.pop();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean visit(MethodDeclaration node) {
    this._currentMethodDeclaration = node;
    return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void endVisit(MethodDeclaration node) {
    this._currentMethodDeclaration = null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean visit(MarkerAnnotation annotation) {

    // resolve the annotation type name
    String annotationTypeName = annotation.resolveTypeBinding().getQualifiedName();

    // TODO: HANDLE
    System.out.println("Found " + annotationTypeName);

    // only visit types and methods
    return this._currentMethodDeclaration == null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean visit(NormalAnnotation node) {

    // handle annotation
    if (!this._currentTypeDeclaration.isEmpty()) {

      System.out.println("NormalAnnotation");

      // try {
      // if (isComponentAnnotation(node)) {
      // handleComponentAnnotation(node);
      // } else if (isReferenceAnnotation(node)) {
      // handleReferenceAnnotation(node);
      // }
      // } catch (Exception e) {
      // handleException(node, e);
      // }
    }

    // only visit types and methods
    return this._currentMethodDeclaration == null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean visit(SingleMemberAnnotation node) {

    // handle annotation
    if (!this._currentTypeDeclaration.isEmpty()) {

      System.out.println("SingleMemberAnnotation");

      // if (isComponentAnnotation(node)) {
      // throw new UnsupportedOperationException();
      // } else if (isReferenceAnnotation(node)) {
      // throw new UnsupportedOperationException();
      // }
    }

    // only visit types and methods
    return this._currentMethodDeclaration == null;
  }
}
