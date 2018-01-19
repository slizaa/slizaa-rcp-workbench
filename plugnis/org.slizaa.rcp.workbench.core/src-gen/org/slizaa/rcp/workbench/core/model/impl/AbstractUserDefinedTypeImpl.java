/**
 */
package org.slizaa.rcp.workbench.core.model.impl;

import org.eclipse.core.resources.IProject;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType;
import org.slizaa.rcp.workbench.core.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract User Defined Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.impl.AbstractUserDefinedTypeImpl#getProject <em>Project</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.impl.AbstractUserDefinedTypeImpl#getResourcePath <em>Resource Path</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.impl.AbstractUserDefinedTypeImpl#getTypeName <em>Type Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractUserDefinedTypeImpl extends MinimalEObjectImpl.Container implements AbstractUserDefinedType {
  /**
   * The default value of the '{@link #getProject() <em>Project</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProject()
   * @generated
   * @ordered
   */
  protected static final IProject PROJECT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getProject() <em>Project</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProject()
   * @generated
   * @ordered
   */
  protected IProject project = PROJECT_EDEFAULT;

  /**
   * The default value of the '{@link #getResourcePath() <em>Resource Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResourcePath()
   * @generated
   * @ordered
   */
  protected static final String RESOURCE_PATH_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getResourcePath() <em>Resource Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResourcePath()
   * @generated
   * @ordered
   */
  protected String resourcePath = RESOURCE_PATH_EDEFAULT;

  /**
   * The default value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeName()
   * @generated
   * @ordered
   */
  protected static final String TYPE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeName()
   * @generated
   * @ordered
   */
  protected String typeName = TYPE_NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AbstractUserDefinedTypeImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelPackage.Literals.ABSTRACT_USER_DEFINED_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IProject getProject() {
    return project;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProject(IProject newProject) {
    IProject oldProject = project;
    project = newProject;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ABSTRACT_USER_DEFINED_TYPE__PROJECT, oldProject, project));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getResourcePath() {
    return resourcePath;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setResourcePath(String newResourcePath) {
    String oldResourcePath = resourcePath;
    resourcePath = newResourcePath;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ABSTRACT_USER_DEFINED_TYPE__RESOURCE_PATH, oldResourcePath, resourcePath));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTypeName() {
    return typeName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeName(String newTypeName) {
    String oldTypeName = typeName;
    typeName = newTypeName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ABSTRACT_USER_DEFINED_TYPE__TYPE_NAME, oldTypeName, typeName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ModelPackage.ABSTRACT_USER_DEFINED_TYPE__PROJECT:
        return getProject();
      case ModelPackage.ABSTRACT_USER_DEFINED_TYPE__RESOURCE_PATH:
        return getResourcePath();
      case ModelPackage.ABSTRACT_USER_DEFINED_TYPE__TYPE_NAME:
        return getTypeName();
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
      case ModelPackage.ABSTRACT_USER_DEFINED_TYPE__PROJECT:
        setProject((IProject)newValue);
        return;
      case ModelPackage.ABSTRACT_USER_DEFINED_TYPE__RESOURCE_PATH:
        setResourcePath((String)newValue);
        return;
      case ModelPackage.ABSTRACT_USER_DEFINED_TYPE__TYPE_NAME:
        setTypeName((String)newValue);
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
      case ModelPackage.ABSTRACT_USER_DEFINED_TYPE__PROJECT:
        setProject(PROJECT_EDEFAULT);
        return;
      case ModelPackage.ABSTRACT_USER_DEFINED_TYPE__RESOURCE_PATH:
        setResourcePath(RESOURCE_PATH_EDEFAULT);
        return;
      case ModelPackage.ABSTRACT_USER_DEFINED_TYPE__TYPE_NAME:
        setTypeName(TYPE_NAME_EDEFAULT);
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
      case ModelPackage.ABSTRACT_USER_DEFINED_TYPE__PROJECT:
        return PROJECT_EDEFAULT == null ? project != null : !PROJECT_EDEFAULT.equals(project);
      case ModelPackage.ABSTRACT_USER_DEFINED_TYPE__RESOURCE_PATH:
        return RESOURCE_PATH_EDEFAULT == null ? resourcePath != null : !RESOURCE_PATH_EDEFAULT.equals(resourcePath);
      case ModelPackage.ABSTRACT_USER_DEFINED_TYPE__TYPE_NAME:
        return TYPE_NAME_EDEFAULT == null ? typeName != null : !TYPE_NAME_EDEFAULT.equals(typeName);
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
    result.append(" (project: ");
    result.append(project);
    result.append(", resourcePath: ");
    result.append(resourcePath);
    result.append(", typeName: ");
    result.append(typeName);
    result.append(')');
    return result.toString();
  }

} //AbstractUserDefinedTypeImpl
