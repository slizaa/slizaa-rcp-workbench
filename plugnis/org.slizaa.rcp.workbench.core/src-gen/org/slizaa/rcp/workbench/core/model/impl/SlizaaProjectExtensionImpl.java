/**
 */
package org.slizaa.rcp.workbench.core.model.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.slizaa.rcp.workbench.core.model.ModelPackage;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Slizaa Project Extension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectExtensionImpl#getExtensionType <em>Extension Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SlizaaProjectExtensionImpl extends AbstractUserDefinedTypeImpl implements SlizaaProjectExtension {
  /**
   * The default value of the '{@link #getExtensionType() <em>Extension Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtensionType()
   * @generated
   * @ordered
   */
  protected static final String EXTENSION_TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExtensionType() <em>Extension Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtensionType()
   * @generated
   * @ordered
   */
  protected String extensionType = EXTENSION_TYPE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SlizaaProjectExtensionImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelPackage.Literals.SLIZAA_PROJECT_EXTENSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExtensionType() {
    return extensionType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtensionType(String newExtensionType) {
    String oldExtensionType = extensionType;
    extensionType = newExtensionType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SLIZAA_PROJECT_EXTENSION__EXTENSION_TYPE, oldExtensionType, extensionType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public <T> T createNewInstance(Class<T> type) {
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
      case ModelPackage.SLIZAA_PROJECT_EXTENSION__EXTENSION_TYPE:
        return getExtensionType();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case ModelPackage.SLIZAA_PROJECT_EXTENSION__EXTENSION_TYPE:
        setExtensionType((String)newValue);
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
      case ModelPackage.SLIZAA_PROJECT_EXTENSION__EXTENSION_TYPE:
        setExtensionType(EXTENSION_TYPE_EDEFAULT);
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
      case ModelPackage.SLIZAA_PROJECT_EXTENSION__EXTENSION_TYPE:
        return EXTENSION_TYPE_EDEFAULT == null ? extensionType != null : !EXTENSION_TYPE_EDEFAULT.equals(extensionType);
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
      case ModelPackage.SLIZAA_PROJECT_EXTENSION___CREATE_NEW_INSTANCE__CLASS:
        return createNewInstance((Class)arguments.get(0));
    }
    return super.eInvoke(operationID, arguments);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (extensionType: ");
    result.append(extensionType);
    result.append(')');
    return result.toString();
  }

} //SlizaaProjectExtensionImpl
