/**
 */
package org.slizaa.rcp.workbench.core.model;


/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @generated
 */
public interface ModelFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ModelFactory INSTANCE = org.slizaa.rcp.workbench.core.model.impl.ModelFactoryImpl.eINSTANCE;

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
   * Returns a new object of class '<em>Slizaa Project Extension</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Slizaa Project Extension</em>'.
   * @generated
   */
  SlizaaProjectExtension createSlizaaProjectExtension();

  /**
   * Returns a new object of class '<em>Slizaa Extension Bundle</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Slizaa Extension Bundle</em>'.
   * @generated
   */
  SlizaaExtensionBundle createSlizaaExtensionBundle();

  /**
   * Returns a new object of class '<em>Slizaa Extension Bundle Extension</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Slizaa Extension Bundle Extension</em>'.
   * @generated
   */
  SlizaaExtensionBundleExtension createSlizaaExtensionBundleExtension();

} //ModelFactory
