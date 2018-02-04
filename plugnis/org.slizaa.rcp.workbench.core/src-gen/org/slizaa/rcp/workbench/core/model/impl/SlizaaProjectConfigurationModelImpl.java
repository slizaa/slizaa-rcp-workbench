/**
 */
package org.slizaa.rcp.workbench.core.model.impl;

import com.google.inject.Injector;
import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Slizaa Project Configuration Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class SlizaaProjectConfigurationModelImpl extends AbstractUserDefinedTypeImpl implements SlizaaProjectConfigurationModel {
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
  public Injector getInjector() {
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
  @SuppressWarnings({"rawtypes", "unchecked" })
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case ModelPackageImpl.SLIZAA_PROJECT_CONFIGURATION_MODEL___GET_INJECTOR:
        return getInjector();
    }
    return super.eInvoke(operationID, arguments);
  }

} //SlizaaProjectConfigurationModelImpl
