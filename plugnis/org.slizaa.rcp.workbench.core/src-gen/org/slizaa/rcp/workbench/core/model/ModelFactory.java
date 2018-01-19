/**
 */
package org.slizaa.rcp.workbench.core.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.slizaa.rcp.workbench.core.model.ModelPackage
 * @generated
 */
public interface ModelFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ModelFactory eINSTANCE = org.slizaa.rcp.workbench.core.model.impl.ModelFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Slizaa Project</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Slizaa Project</em>'.
   * @generated
   */
  SlizaaProject createSlizaaProject();

  /**
   * Returns a new object of class '<em>Slizaa Project Configuration Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Slizaa Project Configuration Model</em>'.
   * @generated
   */
  SlizaaProjectConfigurationModel createSlizaaProjectConfigurationModel();

  /**
   * Returns a new object of class '<em>Slizaa Project Configuration Item Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Slizaa Project Configuration Item Model</em>'.
   * @generated
   */
  SlizaaProjectConfigurationItemModel createSlizaaProjectConfigurationItemModel();

  /**
   * Returns a new object of class '<em>Slizaa Project Configuration Problem</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Slizaa Project Configuration Problem</em>'.
   * @generated
   */
  SlizaaProjectConfigurationProblem createSlizaaProjectConfigurationProblem();

  /**
   * Returns a new object of class '<em>Slizaa Project Extension</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Slizaa Project Extension</em>'.
   * @generated
   */
  SlizaaProjectExtension createSlizaaProjectExtension();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ModelPackage getModelPackage();

} //ModelFactory
