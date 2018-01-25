/**
 */
package org.slizaa.rcp.workbench.core.model.impl;

import java.util.Collection;

import java.util.List;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.slizaa.rcp.workbench.core.model.SlizaaExtensionBundleExtension;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation Type To Slizaa Bundle Extension Map</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.impl.AnnotationTypeToSlizaaBundleExtensionMapImpl#getTypedKey <em>Key</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.impl.AnnotationTypeToSlizaaBundleExtensionMapImpl#getTypedValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnnotationTypeToSlizaaBundleExtensionMapImpl extends MinimalEObjectImpl.Container implements BasicEMap.Entry<Class<?>,List<SlizaaExtensionBundleExtension>> {
  /**
   * The cached value of the '{@link #getTypedKey() <em>Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypedKey()
   * @generated
   * @ordered
   */
  protected Class<?> key;

  /**
   * The cached value of the '{@link #getTypedValue() <em>Value</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypedValue()
   * @generated
   * @ordered
   */
  protected EList<SlizaaExtensionBundleExtension> value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AnnotationTypeToSlizaaBundleExtensionMapImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelPackageImpl.Literals.ANNOTATION_TYPE_TO_SLIZAA_BUNDLE_EXTENSION_MAP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Class<?> getTypedKey() {
    return key;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypedKey(Class<?> newKey) {
    Class<?> oldKey = key;
    key = newKey;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.ANNOTATION_TYPE_TO_SLIZAA_BUNDLE_EXTENSION_MAP__KEY, oldKey, key));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List<SlizaaExtensionBundleExtension> getTypedValue() {
    if (value == null) {
      value = new EObjectResolvingEList<SlizaaExtensionBundleExtension>(SlizaaExtensionBundleExtension.class, this, ModelPackageImpl.ANNOTATION_TYPE_TO_SLIZAA_BUNDLE_EXTENSION_MAP__VALUE);
    }
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ModelPackageImpl.ANNOTATION_TYPE_TO_SLIZAA_BUNDLE_EXTENSION_MAP__KEY:
        return getTypedKey();
      case ModelPackageImpl.ANNOTATION_TYPE_TO_SLIZAA_BUNDLE_EXTENSION_MAP__VALUE:
        return getTypedValue();
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
      case ModelPackageImpl.ANNOTATION_TYPE_TO_SLIZAA_BUNDLE_EXTENSION_MAP__KEY:
        setTypedKey((Class<?>)newValue);
        return;
      case ModelPackageImpl.ANNOTATION_TYPE_TO_SLIZAA_BUNDLE_EXTENSION_MAP__VALUE:
        getTypedValue().clear();
        getTypedValue().addAll((Collection<? extends SlizaaExtensionBundleExtension>)newValue);
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
      case ModelPackageImpl.ANNOTATION_TYPE_TO_SLIZAA_BUNDLE_EXTENSION_MAP__KEY:
        setTypedKey((Class<?>)null);
        return;
      case ModelPackageImpl.ANNOTATION_TYPE_TO_SLIZAA_BUNDLE_EXTENSION_MAP__VALUE:
        getTypedValue().clear();
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
      case ModelPackageImpl.ANNOTATION_TYPE_TO_SLIZAA_BUNDLE_EXTENSION_MAP__KEY:
        return key != null;
      case ModelPackageImpl.ANNOTATION_TYPE_TO_SLIZAA_BUNDLE_EXTENSION_MAP__VALUE:
        return value != null && !value.isEmpty();
    }
    return super.eIsSet(featureID);
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
    result.append(" (key: ");
    result.append(key);
    result.append(')');
    return result.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected int hash = -1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getHash() {
    if (hash == -1) {
      Object theKey = getKey();
      hash = (theKey == null ? 0 : theKey.hashCode());
    }
    return hash;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHash(int hash) {
    this.hash = hash;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Class<?> getKey() {
    return getTypedKey();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKey(Class<?> key) {
    setTypedKey(key);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List<SlizaaExtensionBundleExtension> getValue() {
    return getTypedValue();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List<SlizaaExtensionBundleExtension> setValue(List<SlizaaExtensionBundleExtension> value) {
    List<SlizaaExtensionBundleExtension> oldValue = getValue();
    getTypedValue().clear();
    getTypedValue().addAll(value);
    return oldValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EMap<Class<?>, List<SlizaaExtensionBundleExtension>> getEMap() {
    EObject container = eContainer();
    return container == null ? null : (EMap<Class<?>, List<SlizaaExtensionBundleExtension>>)container.eGet(eContainmentFeature());
  }

} //AnnotationTypeToSlizaaBundleExtensionMapImpl
