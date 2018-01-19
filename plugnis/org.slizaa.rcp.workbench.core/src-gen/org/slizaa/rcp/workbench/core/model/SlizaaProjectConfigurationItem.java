/**
 */
package org.slizaa.rcp.workbench.core.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Slizaa Project Configuration Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationItem#getType <em>Type</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationItem#getMethodName <em>Method Name</em>}</li>
 * </ul>
 *
 * @see org.slizaa.rcp.workbench.core.model.ModelPackage#getSlizaaProjectConfigurationItem()
 * @model
 * @generated
 */
public interface SlizaaProjectConfigurationItem extends EObject {
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see org.slizaa.rcp.workbench.core.model.ModelPackage#getSlizaaProjectConfigurationItem_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationItem#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Returns the value of the '<em><b>Method Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Method Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Method Name</em>' attribute.
   * @see #setMethodName(String)
   * @see org.slizaa.rcp.workbench.core.model.ModelPackage#getSlizaaProjectConfigurationItem_MethodName()
   * @model
   * @generated
   */
  String getMethodName();

  /**
   * Sets the value of the '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationItem#getMethodName <em>Method Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Method Name</em>' attribute.
   * @see #getMethodName()
   * @generated
   */
  void setMethodName(String value);

} // SlizaaProjectConfigurationItem
