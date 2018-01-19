/**
 */
package org.slizaa.rcp.workbench.core.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Slizaa Project Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfiguration#getResourcePath <em>Resource Path</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfiguration#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfiguration#getConfigurationItems <em>Configuration Items</em>}</li>
 * </ul>
 *
 * @see org.slizaa.rcp.workbench.core.model.ModelPackage#getSlizaaProjectConfiguration()
 * @model
 * @generated
 */
public interface SlizaaProjectConfiguration extends EObject {
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
   * @see org.slizaa.rcp.workbench.core.model.ModelPackage#getSlizaaProjectConfiguration_ResourcePath()
   * @model
   * @generated
   */
  String getResourcePath();

  /**
   * Sets the value of the '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfiguration#getResourcePath <em>Resource Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Resource Path</em>' attribute.
   * @see #getResourcePath()
   * @generated
   */
  void setResourcePath(String value);

  /**
   * Returns the value of the '<em><b>Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Class Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Class Name</em>' attribute.
   * @see #setClassName(String)
   * @see org.slizaa.rcp.workbench.core.model.ModelPackage#getSlizaaProjectConfiguration_ClassName()
   * @model
   * @generated
   */
  String getClassName();

  /**
   * Sets the value of the '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfiguration#getClassName <em>Class Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Class Name</em>' attribute.
   * @see #getClassName()
   * @generated
   */
  void setClassName(String value);

  /**
   * Returns the value of the '<em><b>Configuration Items</b></em>' reference list.
   * The list contents are of type {@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationItem}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Configuration Items</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Configuration Items</em>' reference list.
   * @see org.slizaa.rcp.workbench.core.model.ModelPackage#getSlizaaProjectConfiguration_ConfigurationItems()
   * @model
   * @generated
   */
  EList<SlizaaProjectConfigurationItem> getConfigurationItems();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  <T> T createNewInstance(Class<T> type);

} // SlizaaProjectConfiguration
