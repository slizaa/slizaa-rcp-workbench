/**
 */
package org.slizaa.rcp.workbench.core.model.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.slizaa.rcp.workbench.core.model.ModelFactory;
import org.slizaa.rcp.workbench.core.model.ModelPackage;
import org.slizaa.rcp.workbench.core.model.SlizaaProject;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationItemModel;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationProblem;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class ModelFactoryImpl extends EFactoryImpl implements ModelFactory {
  /**
   * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public static ModelFactory init() {
    try {
      ModelFactory theModelFactory = (ModelFactory) EPackage.Registry.INSTANCE.getEFactory(ModelPackage.eNS_URI);
      if (theModelFactory != null) {
        return theModelFactory;
      }
    } catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ModelFactoryImpl();
  }

  /**
   * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public ModelFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
    case ModelPackage.SLIZAA_PROJECT:
      return createSlizaaProject();
    case ModelPackage.SLIZAA_PROJECT_CONFIGURATION_MODEL:
      return createSlizaaProjectConfigurationModel();
    case ModelPackage.SLIZAA_PROJECT_CONFIGURATION_ITEM_MODEL:
      return createSlizaaProjectConfigurationItemModel();
    case ModelPackage.SLIZAA_PROJECT_CONFIGURATION_PROBLEM:
      return createSlizaaProjectConfigurationProblem();
    case ModelPackage.SLIZAA_PROJECT_EXTENSION:
      return createSlizaaProjectExtension();
    default:
      throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue) {
    switch (eDataType.getClassifierID()) {
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue) {
    switch (eDataType.getClassifierID()) {
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated NOT
   */
  @Override
  public SlizaaProject createSlizaaProject() {
    SlizaaProjectImpl slizaaProject = new ExtendedSlizaaProjectImpl();
    return slizaaProject;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated NOT
   */
  @Override
  public SlizaaProjectConfigurationModel createSlizaaProjectConfigurationModel() {
    SlizaaProjectConfigurationModelImpl slizaaProjectConfigurationModel = new ExtendedSlizaaProjectConfigurationModelImpl();
    return slizaaProjectConfigurationModel;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public SlizaaProjectConfigurationItemModel createSlizaaProjectConfigurationItemModel() {
    SlizaaProjectConfigurationItemModelImpl slizaaProjectConfigurationItemModel = new SlizaaProjectConfigurationItemModelImpl();
    return slizaaProjectConfigurationItemModel;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public SlizaaProjectConfigurationProblem createSlizaaProjectConfigurationProblem() {
    SlizaaProjectConfigurationProblemImpl slizaaProjectConfigurationProblem = new SlizaaProjectConfigurationProblemImpl();
    return slizaaProjectConfigurationProblem;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated NOT
   */
  @Override
  public SlizaaProjectExtension createSlizaaProjectExtension() {
    SlizaaProjectExtensionImpl slizaaProjectExtension = new ExtendedSlizaaProjectExtensionImpl();
    return slizaaProjectExtension;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ModelPackage getModelPackage() {
    return (ModelPackage) getEPackage();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ModelPackage getPackage() {
    return ModelPackage.eINSTANCE;
  }

} // ModelFactoryImpl
