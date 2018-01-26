/**
 *
 */
package org.slizaa.rcp.workbench.core.internal.projectconfig;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.slizaa.rcp.workbench.core.api.annotations.SlizaaConfigurationItem;
import org.slizaa.rcp.workbench.core.api.annotations.SlizaaProjectConfiguration;
import org.slizaa.rcp.workbench.core.model.ModelFactory;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationItemModel;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationProblem;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 */
public class SlizaaProjectConfigurationAstVisitor extends ASTVisitor {

  /** the current type declaration */
  private Stack<TypeDeclaration>                 _currentTypeDeclaration;

  /** the current type declaration */
  private Stack<SlizaaProjectConfigurationModel> _currentSlizaaProjectConfigurationModel;

  /** - */
  private List<SlizaaProjectConfigurationModel>  _slizaaProjectConfigurationModels;

  /** the current method declaration */
  private MethodDeclaration                      _currentMethodDeclaration;

  /** - */
  private IProject                               _project;

  /**
   * <p>
   * Creates a new instance of type {@link AbstractDsAnnotationAstVisitor}.
   * </p>
   */
  public SlizaaProjectConfigurationAstVisitor(IProject project) {

    //
    this._project = checkNotNull(project);
    this._currentTypeDeclaration = new Stack<>();
    this._currentSlizaaProjectConfigurationModel = new Stack<>();
    this._slizaaProjectConfigurationModels = new ArrayList<>();
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public List<SlizaaProjectConfigurationModel> getSlizaaProjectConfigurationModels() {
    return this._slizaaProjectConfigurationModels;
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

    //
    if (!_currentSlizaaProjectConfigurationModel.isEmpty() && _currentSlizaaProjectConfigurationModel.peek()
        .getTypeName().equals(node.resolveBinding().getQualifiedName())) {

      //
      if (node.getMethods().length == 0) {

        SlizaaProjectConfigurationProblem problem = createSlizaaProjectConfigurationProblem(
            ProjectConfigurationErrorMessages.NO_CONFIGURATION_ITEMS_SPECIFIED, node.getStartPosition(),
            node.getStartPosition() + node.getLength());

        _currentSlizaaProjectConfigurationModel.peek().getProblems().add(problem);
      }
    }

    //
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

    //
    if (SlizaaProjectConfiguration.class.getName().equals(annotationTypeName)
        && !this._currentTypeDeclaration.isEmpty()) {

      //
      String currentTypeName = this._currentTypeDeclaration.peek().resolveBinding().getQualifiedName();

      //
      SlizaaProjectConfigurationModel configuration = ModelFactory.INSTANCE.createSlizaaProjectConfigurationModel();
      configuration.setTypeName(currentTypeName);

      //
      this._currentSlizaaProjectConfigurationModel.push(configuration);
      this._slizaaProjectConfigurationModels.add(configuration);
    }

    //
    if (SlizaaConfigurationItem.class.getName().equals(annotationTypeName) && this._currentMethodDeclaration != null) {

      //
      if (this._currentMethodDeclaration.parameters().size() == 0) {

        //
        SlizaaProjectConfigurationItemModel itemModel = ModelFactory.INSTANCE
            .createSlizaaProjectConfigurationItemModel();

        //
        itemModel.setType(this._currentMethodDeclaration.resolveBinding().getReturnType().getQualifiedName());
        itemModel.setMethodName(this._currentMethodDeclaration.getName().getFullyQualifiedName());

        //
        this._currentSlizaaProjectConfigurationModel.peek().getConfigurationItems().add(itemModel);
      }
      //
      else {
        // TODO
      }
    }

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

      // TODO
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

      // TODO
    }

    // only visit types and methods
    return this._currentMethodDeclaration == null;
  }

  /**
   * <p>
   * </p>
   *
   * @param msg
   * @param charStart
   * @param charEnd
   * @return
   */
  private SlizaaProjectConfigurationProblem createSlizaaProjectConfigurationProblem(String msg, int charStart,
      int charEnd) {

    SlizaaProjectConfigurationProblem result = ModelFactory.INSTANCE.createSlizaaProjectConfigurationProblem();
    result.setMessage(checkNotNull(msg));
    result.setCharStart(charStart);
    result.setCharEnd(charEnd);
    return result;
  }
}
