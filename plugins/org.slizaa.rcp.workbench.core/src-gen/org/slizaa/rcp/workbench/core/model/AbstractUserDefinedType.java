/**
 */
package org.slizaa.rcp.workbench.core.model;

import org.eclipse.core.resources.IProject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract User Defined Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType#getProject <em>Project</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType#getResourcePath <em>Resource Path</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType#getTypeName <em>Type Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public interface AbstractUserDefinedType {
  /**
   * Returns the value of the '<em><b>Project</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Project</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Project</em>' attribute.
   * @see #setProject(IProject)
   * @generated
   */
  IProject getProject();

  /**
   * Sets the value of the '{@link org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType#getProject <em>Project</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Project</em>' attribute.
   * @see #getProject()
   * @generated
   */
  void setProject(IProject value);

  /**
   * Returns the value of the '<em><b>Resource Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Resource Path</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Resource Path</em>' attribute.
   * @see #setResourcePath(String)
   * @generated
   */
  String getResourcePath();

  /**
   * Sets the value of the '{@link org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType#getResourcePath <em>Resource Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Resource Path</em>' attribute.
   * @see #getResourcePath()
   * @generated
   */
  void setResourcePath(String value);

  /**
   * Returns the value of the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Name</em>' attribute.
   * @see #setTypeName(String)
   * @generated
   */
  String getTypeName();

  /**
   * Sets the value of the '{@link org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType#getTypeName <em>Type Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Name</em>' attribute.
   * @see #getTypeName()
   * @generated
   */
  void setTypeName(String value);

} // AbstractUserDefinedType
