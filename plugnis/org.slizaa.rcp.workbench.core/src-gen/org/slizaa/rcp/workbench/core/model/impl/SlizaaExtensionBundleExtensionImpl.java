/**
 */
package org.slizaa.rcp.workbench.core.model.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.slizaa.rcp.workbench.core.model.SlizaaExtensionBundleExtension;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Slizaa Extension Bundle Extension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaExtensionBundleExtensionImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaExtensionBundleExtensionImpl#getAnnotationType <em>Annotation Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SlizaaExtensionBundleExtensionImpl extends MinimalEObjectImpl.Container implements SlizaaExtensionBundleExtension {
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected Class<?> type;

  /**
   * The cached value of the '{@link #getAnnotationType() <em>Annotation Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotationType()
   * @generated
   * @ordered
   */
  protected Class<?> annotationType;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SlizaaExtensionBundleExtensionImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelPackageImpl.Literals.SLIZAA_EXTENSION_BUNDLE_EXTENSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Class<?> getType() {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(Class<?> newType) {
    Class<?> oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.SLIZAA_EXTENSION_BUNDLE_EXTENSION__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Class<?> getAnnotationType() {
    return annotationType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAnnotationType(Class<?> newAnnotationType) {
    Class<?> oldAnnotationType = annotationType;
    annotationType = newAnnotationType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.SLIZAA_EXTENSION_BUNDLE_EXTENSION__ANNOTATION_TYPE, oldAnnotationType, annotationType));
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
      case ModelPackageImpl.SLIZAA_EXTENSION_BUNDLE_EXTENSION__TYPE:
        return getType();
      case ModelPackageImpl.SLIZAA_EXTENSION_BUNDLE_EXTENSION__ANNOTATION_TYPE:
        return getAnnotationType();
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
      case ModelPackageImpl.SLIZAA_EXTENSION_BUNDLE_EXTENSION__TYPE:
        setType((Class<?>)newValue);
        return;
      case ModelPackageImpl.SLIZAA_EXTENSION_BUNDLE_EXTENSION__ANNOTATION_TYPE:
        setAnnotationType((Class<?>)newValue);
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
      case ModelPackageImpl.SLIZAA_EXTENSION_BUNDLE_EXTENSION__TYPE:
        setType((Class<?>)null);
        return;
      case ModelPackageImpl.SLIZAA_EXTENSION_BUNDLE_EXTENSION__ANNOTATION_TYPE:
        setAnnotationType((Class<?>)null);
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
      case ModelPackageImpl.SLIZAA_EXTENSION_BUNDLE_EXTENSION__TYPE:
        return type != null;
      case ModelPackageImpl.SLIZAA_EXTENSION_BUNDLE_EXTENSION__ANNOTATION_TYPE:
        return annotationType != null;
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
      case ModelPackageImpl.SLIZAA_EXTENSION_BUNDLE_EXTENSION___CREATE_NEW_INSTANCE__CLASS:
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
    result.append(" (type: ");
    result.append(type);
    result.append(", annotationType: ");
    result.append(annotationType);
    result.append(')');
    return result.toString();
  }

} //SlizaaExtensionBundleExtensionImpl
