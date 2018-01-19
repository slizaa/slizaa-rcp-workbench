/**
 */
package org.slizaa.rcp.workbench.core.model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.slizaa.rcp.workbench.core.model.ModelPackage;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationProblem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Slizaa Project Configuration Problem</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationProblemImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationProblemImpl#getCharStart <em>Char Start</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationProblemImpl#getCharEnd <em>Char End</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SlizaaProjectConfigurationProblemImpl extends MinimalEObjectImpl.Container implements SlizaaProjectConfigurationProblem {
  /**
   * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessage()
   * @generated
   * @ordered
   */
  protected static final String MESSAGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessage()
   * @generated
   * @ordered
   */
  protected String message = MESSAGE_EDEFAULT;

  /**
   * The default value of the '{@link #getCharStart() <em>Char Start</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCharStart()
   * @generated
   * @ordered
   */
  protected static final int CHAR_START_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getCharStart() <em>Char Start</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCharStart()
   * @generated
   * @ordered
   */
  protected int charStart = CHAR_START_EDEFAULT;

  /**
   * The default value of the '{@link #getCharEnd() <em>Char End</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCharEnd()
   * @generated
   * @ordered
   */
  protected static final int CHAR_END_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getCharEnd() <em>Char End</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCharEnd()
   * @generated
   * @ordered
   */
  protected int charEnd = CHAR_END_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SlizaaProjectConfigurationProblemImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelPackage.Literals.SLIZAA_PROJECT_CONFIGURATION_PROBLEM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMessage() {
    return message;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMessage(String newMessage) {
    String oldMessage = message;
    message = newMessage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SLIZAA_PROJECT_CONFIGURATION_PROBLEM__MESSAGE, oldMessage, message));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getCharStart() {
    return charStart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCharStart(int newCharStart) {
    int oldCharStart = charStart;
    charStart = newCharStart;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SLIZAA_PROJECT_CONFIGURATION_PROBLEM__CHAR_START, oldCharStart, charStart));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getCharEnd() {
    return charEnd;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCharEnd(int newCharEnd) {
    int oldCharEnd = charEnd;
    charEnd = newCharEnd;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SLIZAA_PROJECT_CONFIGURATION_PROBLEM__CHAR_END, oldCharEnd, charEnd));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ModelPackage.SLIZAA_PROJECT_CONFIGURATION_PROBLEM__MESSAGE:
        return getMessage();
      case ModelPackage.SLIZAA_PROJECT_CONFIGURATION_PROBLEM__CHAR_START:
        return getCharStart();
      case ModelPackage.SLIZAA_PROJECT_CONFIGURATION_PROBLEM__CHAR_END:
        return getCharEnd();
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
      case ModelPackage.SLIZAA_PROJECT_CONFIGURATION_PROBLEM__MESSAGE:
        setMessage((String)newValue);
        return;
      case ModelPackage.SLIZAA_PROJECT_CONFIGURATION_PROBLEM__CHAR_START:
        setCharStart((Integer)newValue);
        return;
      case ModelPackage.SLIZAA_PROJECT_CONFIGURATION_PROBLEM__CHAR_END:
        setCharEnd((Integer)newValue);
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
      case ModelPackage.SLIZAA_PROJECT_CONFIGURATION_PROBLEM__MESSAGE:
        setMessage(MESSAGE_EDEFAULT);
        return;
      case ModelPackage.SLIZAA_PROJECT_CONFIGURATION_PROBLEM__CHAR_START:
        setCharStart(CHAR_START_EDEFAULT);
        return;
      case ModelPackage.SLIZAA_PROJECT_CONFIGURATION_PROBLEM__CHAR_END:
        setCharEnd(CHAR_END_EDEFAULT);
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
      case ModelPackage.SLIZAA_PROJECT_CONFIGURATION_PROBLEM__MESSAGE:
        return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
      case ModelPackage.SLIZAA_PROJECT_CONFIGURATION_PROBLEM__CHAR_START:
        return charStart != CHAR_START_EDEFAULT;
      case ModelPackage.SLIZAA_PROJECT_CONFIGURATION_PROBLEM__CHAR_END:
        return charEnd != CHAR_END_EDEFAULT;
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
    result.append(" (message: ");
    result.append(message);
    result.append(", charStart: ");
    result.append(charStart);
    result.append(", charEnd: ");
    result.append(charEnd);
    result.append(')');
    return result.toString();
  }

} //SlizaaProjectConfigurationProblemImpl
