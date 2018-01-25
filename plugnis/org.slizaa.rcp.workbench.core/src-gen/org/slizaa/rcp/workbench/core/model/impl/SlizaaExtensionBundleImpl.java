/**
 */
package org.slizaa.rcp.workbench.core.model.impl;

import java.util.Collection;

import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.slizaa.rcp.workbench.core.model.SlizaaExtensionBundle;
import org.slizaa.rcp.workbench.core.model.SlizaaExtensionBundleExtension;

import org.slizaa.scanner.core.api.cypherregistry.ICypherStatement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Slizaa Extension Bundle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaExtensionBundleImpl#getDefinedExtensions <em>Defined Extensions</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaExtensionBundleImpl#getDefinedCypherStatements <em>Defined Cypher Statements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SlizaaExtensionBundleImpl extends MinimalEObjectImpl.Container implements SlizaaExtensionBundle {
  /**
   * The cached value of the '{@link #getDefinedExtensions() <em>Defined Extensions</em>}' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefinedExtensions()
   * @generated
   * @ordered
   */
  protected EMap<Class<?>, List<SlizaaExtensionBundleExtension>> definedExtensions;

  /**
   * The cached value of the '{@link #getDefinedCypherStatements() <em>Defined Cypher Statements</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefinedCypherStatements()
   * @generated
   * @ordered
   */
  protected EList<ICypherStatement> definedCypherStatements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SlizaaExtensionBundleImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelPackageImpl.Literals.SLIZAA_EXTENSION_BUNDLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Map<Class<?>, List<SlizaaExtensionBundleExtension>> getDefinedExtensions() {
    if (definedExtensions == null) {
      definedExtensions = new EcoreEMap<Class<?>,List<SlizaaExtensionBundleExtension>>(ModelPackageImpl.Literals.ANNOTATION_TYPE_TO_SLIZAA_BUNDLE_EXTENSION_MAP, AnnotationTypeToSlizaaBundleExtensionMapImpl.class, this, ModelPackageImpl.SLIZAA_EXTENSION_BUNDLE__DEFINED_EXTENSIONS);
    }
    return definedExtensions.map();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List<ICypherStatement> getDefinedCypherStatements() {
    if (definedCypherStatements == null) {
      definedCypherStatements = new EDataTypeUniqueEList<ICypherStatement>(ICypherStatement.class, this, ModelPackageImpl.SLIZAA_EXTENSION_BUNDLE__DEFINED_CYPHER_STATEMENTS);
    }
    return definedCypherStatements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ModelPackageImpl.SLIZAA_EXTENSION_BUNDLE__DEFINED_EXTENSIONS:
        return ((InternalEList<?>)((EMap.InternalMapView<Class<?>, List<SlizaaExtensionBundleExtension>>)getDefinedExtensions()).eMap()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ModelPackageImpl.SLIZAA_EXTENSION_BUNDLE__DEFINED_EXTENSIONS:
        if (coreType) return ((EMap.InternalMapView<Class<?>, List<SlizaaExtensionBundleExtension>>)getDefinedExtensions()).eMap();
        else return getDefinedExtensions();
      case ModelPackageImpl.SLIZAA_EXTENSION_BUNDLE__DEFINED_CYPHER_STATEMENTS:
        return getDefinedCypherStatements();
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
      case ModelPackageImpl.SLIZAA_EXTENSION_BUNDLE__DEFINED_EXTENSIONS:
        ((EStructuralFeature.Setting)((EMap.InternalMapView<Class<?>, List<SlizaaExtensionBundleExtension>>)getDefinedExtensions()).eMap()).set(newValue);
        return;
      case ModelPackageImpl.SLIZAA_EXTENSION_BUNDLE__DEFINED_CYPHER_STATEMENTS:
        getDefinedCypherStatements().clear();
        getDefinedCypherStatements().addAll((Collection<? extends ICypherStatement>)newValue);
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
      case ModelPackageImpl.SLIZAA_EXTENSION_BUNDLE__DEFINED_EXTENSIONS:
        getDefinedExtensions().clear();
        return;
      case ModelPackageImpl.SLIZAA_EXTENSION_BUNDLE__DEFINED_CYPHER_STATEMENTS:
        getDefinedCypherStatements().clear();
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
      case ModelPackageImpl.SLIZAA_EXTENSION_BUNDLE__DEFINED_EXTENSIONS:
        return definedExtensions != null && !definedExtensions.isEmpty();
      case ModelPackageImpl.SLIZAA_EXTENSION_BUNDLE__DEFINED_CYPHER_STATEMENTS:
        return definedCypherStatements != null && !definedCypherStatements.isEmpty();
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
    result.append(" (definedCypherStatements: ");
    result.append(definedCypherStatements);
    result.append(')');
    return result.toString();
  }

} //SlizaaExtensionBundleImpl
