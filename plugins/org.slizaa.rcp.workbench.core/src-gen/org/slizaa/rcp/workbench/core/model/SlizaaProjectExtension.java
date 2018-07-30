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
 *   <li>{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension#getAnnotationType <em>Annotation Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public interface SlizaaProjectExtension extends AbstractUserDefinedType {
  /**
   * Returns the value of the '<em><b>Annotation Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Annotation Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Annotation Type</em>' attribute.
   * @see #setAnnotationType(Class)
   * @generated
   */
  Class<?> getAnnotationType();

  /**
   * Sets the value of the '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension#getAnnotationType <em>Annotation Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Annotation Type</em>' attribute.
   * @see #getAnnotationType()
   * @generated
   */
  void setAnnotationType(Class<?> value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  <T> T createNewInstance(Class<T> type);

} // SlizaaProjectExtension
