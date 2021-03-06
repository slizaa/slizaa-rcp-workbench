/**
 */
package org.slizaa.rcp.workbench.core.model.impl;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.slizaa.core.boltclient.IBoltClient;
import org.slizaa.rcp.workbench.core.model.ModelFactory;
import org.slizaa.rcp.workbench.core.model.Problem;
import org.slizaa.rcp.workbench.core.model.SlizaaProject;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension;
import org.slizaa.scanner.core.api.cypherregistry.ICypherStatement;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class ModelFactoryImpl extends EFactoryImpl implements ModelFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public static final ModelFactoryImpl eINSTANCE = init();

  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public static ModelFactoryImpl init() {
    try {
      ModelFactoryImpl theModelFactory = (ModelFactoryImpl)EPackage.Registry.INSTANCE.getEFactory(ModelPackageImpl.eNS_URI);
      if (theModelFactory != null) {
        return theModelFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ModelFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ModelFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
      case ModelPackageImpl.SLIZAA_PROJECT: return (EObject)createSlizaaProject();
      case ModelPackageImpl.SLIZAA_PROJECT_CONFIGURATION_MODEL: return (EObject)createSlizaaProjectConfigurationModel();
      case ModelPackageImpl.PROBLEM: return (EObject)createProblem();
      case ModelPackageImpl.SLIZAA_PROJECT_EXTENSION: return (EObject)createSlizaaProjectExtension();
      case ModelPackageImpl.ANNOTATION_TYPE_TO_SLIZAA_PROJECT_EXTENSION_MAP: return (EObject)createAnnotationTypeToSlizaaProjectExtensionMap();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue) {
    switch (eDataType.getClassifierID()) {
      case ModelPackageImpl.ICYPHER_STATEMENT:
        return createICypherStatementFromString(eDataType, initialValue);
      case ModelPackageImpl.IBOLT_CLIENT:
        return createIBoltClientFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue) {
    switch (eDataType.getClassifierID()) {
      case ModelPackageImpl.ICYPHER_STATEMENT:
        return convertICypherStatementToString(eDataType, instanceValue);
      case ModelPackageImpl.IBOLT_CLIENT:
        return convertIBoltClientToString(eDataType, instanceValue);
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
   * @generated
   */
  @Override
  public Problem createProblem() {
    ProblemImpl problem = new ProblemImpl();
    return problem;
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
   * @generated
   */
  public Map.Entry<Class<?>, List<SlizaaProjectExtension>> createAnnotationTypeToSlizaaProjectExtensionMap() {
    AnnotationTypeToSlizaaProjectExtensionMapImpl annotationTypeToSlizaaProjectExtensionMap = new AnnotationTypeToSlizaaProjectExtensionMapImpl();
    return annotationTypeToSlizaaProjectExtensionMap;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ICypherStatement createICypherStatementFromString(EDataType eDataType, String initialValue) {
    return (ICypherStatement)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String convertICypherStatementToString(EDataType eDataType, Object instanceValue) {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IBoltClient createIBoltClientFromString(EDataType eDataType, String initialValue) {
    return (IBoltClient)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertIBoltClientToString(EDataType eDataType, Object instanceValue) {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ModelPackageImpl getModelPackage() {
    return (ModelPackageImpl)getEPackage();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ModelPackageImpl getPackage() {
    return ModelPackageImpl.eINSTANCE;
  }

} // ModelFactoryImpl
