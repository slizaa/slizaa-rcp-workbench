/**
 */
package org.slizaa.rcp.workbench.core.model.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.slizaa.rcp.workbench.core.model.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.slizaa.rcp.workbench.core.model.ModelPackage
 * @generated
 */
public class ModelSwitch<T> extends Switch<T> {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ModelPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelSwitch() {
    if (modelPackage == null) {
      modelPackage = ModelPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage) {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID) {
      case ModelPackage.SLIZAA_PROJECT: {
        SlizaaProject slizaaProject = (SlizaaProject)theEObject;
        T result = caseSlizaaProject(slizaaProject);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelPackage.SLIZAA_PROJECT_CONFIGURATION_MODEL: {
        SlizaaProjectConfigurationModel slizaaProjectConfigurationModel = (SlizaaProjectConfigurationModel)theEObject;
        T result = caseSlizaaProjectConfigurationModel(slizaaProjectConfigurationModel);
        if (result == null) result = caseAbstractUserDefinedType(slizaaProjectConfigurationModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelPackage.SLIZAA_PROJECT_CONFIGURATION_ITEM_MODEL: {
        SlizaaProjectConfigurationItemModel slizaaProjectConfigurationItemModel = (SlizaaProjectConfigurationItemModel)theEObject;
        T result = caseSlizaaProjectConfigurationItemModel(slizaaProjectConfigurationItemModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelPackage.SLIZAA_PROJECT_CONFIGURATION_PROBLEM: {
        SlizaaProjectConfigurationProblem slizaaProjectConfigurationProblem = (SlizaaProjectConfigurationProblem)theEObject;
        T result = caseSlizaaProjectConfigurationProblem(slizaaProjectConfigurationProblem);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelPackage.SLIZAA_PROJECT_EXTENSION: {
        SlizaaProjectExtension slizaaProjectExtension = (SlizaaProjectExtension)theEObject;
        T result = caseSlizaaProjectExtension(slizaaProjectExtension);
        if (result == null) result = caseAbstractUserDefinedType(slizaaProjectExtension);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ModelPackage.ABSTRACT_USER_DEFINED_TYPE: {
        AbstractUserDefinedType abstractUserDefinedType = (AbstractUserDefinedType)theEObject;
        T result = caseAbstractUserDefinedType(abstractUserDefinedType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Slizaa Project</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Slizaa Project</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSlizaaProject(SlizaaProject object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Slizaa Project Configuration Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Slizaa Project Configuration Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSlizaaProjectConfigurationModel(SlizaaProjectConfigurationModel object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Slizaa Project Configuration Item Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Slizaa Project Configuration Item Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSlizaaProjectConfigurationItemModel(SlizaaProjectConfigurationItemModel object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Slizaa Project Configuration Problem</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Slizaa Project Configuration Problem</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSlizaaProjectConfigurationProblem(SlizaaProjectConfigurationProblem object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Slizaa Project Extension</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Slizaa Project Extension</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSlizaaProjectExtension(SlizaaProjectExtension object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract User Defined Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract User Defined Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractUserDefinedType(AbstractUserDefinedType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object) {
    return null;
  }

} //ModelSwitch
