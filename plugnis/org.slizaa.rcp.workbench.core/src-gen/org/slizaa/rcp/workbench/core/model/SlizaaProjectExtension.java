/**
 */
package org.slizaa.rcp.workbench.core.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Slizaa Project Extension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension#getExtensionType <em>Extension Type</em>}</li>
 * </ul>
 *
 * @see org.slizaa.rcp.workbench.core.model.ModelPackage#getSlizaaProjectExtension()
 * @model
 * @generated
 */
public interface SlizaaProjectExtension extends AbstractUserDefinedType {
  /**
   * Returns the value of the '<em><b>Extension Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extension Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extension Type</em>' attribute.
   * @see #setExtensionType(String)
   * @see org.slizaa.rcp.workbench.core.model.ModelPackage#getSlizaaProjectExtension_ExtensionType()
   * @model
   * @generated
   */
  String getExtensionType();

  /**
   * Sets the value of the '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension#getExtensionType <em>Extension Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extension Type</em>' attribute.
   * @see #getExtensionType()
   * @generated
   */
  void setExtensionType(String value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  <T> T createNewInstance(Class<T> type);

} // SlizaaProjectExtension
