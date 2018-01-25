/**
 */
package org.slizaa.rcp.workbench.core.model.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import java.util.List;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationItemModel;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationProblem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Slizaa Project Configuration Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationModelImpl#getProblems <em>Problems</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationModelImpl#getConfigurationItems <em>Configuration Items</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SlizaaProjectConfigurationModelImpl extends AbstractUserDefinedTypeImpl implements SlizaaProjectConfigurationModel {
  /**
   * The cached value of the '{@link #getProblems() <em>Problems</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProblems()
   * @generated
   * @ordered
   */
  protected EList<SlizaaProjectConfigurationProblem> problems;

  /**
   * The cached value of the '{@link #getConfigurationItems() <em>Configuration Items</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConfigurationItems()
   * @generated
   * @ordered
   */
  protected EList<SlizaaProjectConfigurationItemModel> configurationItems;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SlizaaProjectConfigurationModelImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelPackageImpl.Literals.SLIZAA_PROJECT_CONFIGURATION_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List<SlizaaProjectConfigurationProblem> getProblems() {
    if (problems == null) {
      problems = new EObjectResolvingEList<SlizaaProjectConfigurationProblem>(SlizaaProjectConfigurationProblem.class, this, ModelPackageImpl.SLIZAA_PROJECT_CONFIGURATION_MODEL__PROBLEMS);
    }
    return problems;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List<SlizaaProjectConfigurationItemModel> getConfigurationItems() {
    if (configurationItems == null) {
      configurationItems = new EObjectResolvingEList<SlizaaProjectConfigurationItemModel>(SlizaaProjectConfigurationItemModel.class, this, ModelPackageImpl.SLIZAA_PROJECT_CONFIGURATION_MODEL__CONFIGURATION_ITEMS);
    }
    return configurationItems;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public <T> T createNewConfigurationItemInstance(Class<T> type) {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ModelPackageImpl.SLIZAA_PROJECT_CONFIGURATION_MODEL__PROBLEMS:
        return getProblems();
      case ModelPackageImpl.SLIZAA_PROJECT_CONFIGURATION_MODEL__CONFIGURATION_ITEMS:
        return getConfigurationItems();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case ModelPackageImpl.SLIZAA_PROJECT_CONFIGURATION_MODEL__PROBLEMS:
        getProblems().clear();
        getProblems().addAll((Collection<? extends SlizaaProjectConfigurationProblem>)newValue);
        return;
      case ModelPackageImpl.SLIZAA_PROJECT_CONFIGURATION_MODEL__CONFIGURATION_ITEMS:
        getConfigurationItems().clear();
        getConfigurationItems().addAll((Collection<? extends SlizaaProjectConfigurationItemModel>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case ModelPackageImpl.SLIZAA_PROJECT_CONFIGURATION_MODEL__PROBLEMS:
        getProblems().clear();
        return;
      case ModelPackageImpl.SLIZAA_PROJECT_CONFIGURATION_MODEL__CONFIGURATION_ITEMS:
        getConfigurationItems().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case ModelPackageImpl.SLIZAA_PROJECT_CONFIGURATION_MODEL__PROBLEMS:
        return problems != null && !problems.isEmpty();
      case ModelPackageImpl.SLIZAA_PROJECT_CONFIGURATION_MODEL__CONFIGURATION_ITEMS:
        return configurationItems != null && !configurationItems.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  @SuppressWarnings({"rawtypes", "unchecked" })
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case ModelPackageImpl.SLIZAA_PROJECT_CONFIGURATION_MODEL___CREATE_NEW_CONFIGURATION_ITEM_INSTANCE__CLASS:
        return createNewConfigurationItemInstance((Class)arguments.get(0));
    }
    return super.eInvoke(operationID, arguments);
  }

} //SlizaaProjectConfigurationModelImpl
