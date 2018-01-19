/**
 */
package org.slizaa.rcp.workbench.core.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Slizaa Project Configuration Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel#getProblems <em>Problems</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel#getConfigurationItems <em>Configuration Items</em>}</li>
 * </ul>
 *
 * @see org.slizaa.rcp.workbench.core.model.ModelPackage#getSlizaaProjectConfigurationModel()
 * @model
 * @generated
 */
public interface SlizaaProjectConfigurationModel extends AbstractUserDefinedType {
  /**
   * Returns the value of the '<em><b>Problems</b></em>' reference list.
   * The list contents are of type {@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationProblem}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Problems</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Problems</em>' reference list.
   * @see org.slizaa.rcp.workbench.core.model.ModelPackage#getSlizaaProjectConfigurationModel_Problems()
   * @model
   * @generated
   */
  EList<SlizaaProjectConfigurationProblem> getProblems();

  /**
   * Returns the value of the '<em><b>Configuration Items</b></em>' reference list.
   * The list contents are of type {@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationItemModel}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Configuration Items</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Configuration Items</em>' reference list.
   * @see org.slizaa.rcp.workbench.core.model.ModelPackage#getSlizaaProjectConfigurationModel_ConfigurationItems()
   * @model
   * @generated
   */
  EList<SlizaaProjectConfigurationItemModel> getConfigurationItems();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  <T> T createNewConfigurationItemInstance(Class<T> type);

} // SlizaaProjectConfigurationModel
