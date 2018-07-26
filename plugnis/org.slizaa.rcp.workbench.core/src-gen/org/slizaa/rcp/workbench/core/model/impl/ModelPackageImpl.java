/**
 */
package org.slizaa.rcp.workbench.core.model.impl;

import com.google.inject.Injector;
import java.util.Map;

import org.eclipse.core.resources.IProject;

import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.slizaa.core.boltclient.IBoltClient;
import org.slizaa.hierarchicalgraph.graphdb.mapping.spi.IMappingProvider;
import org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType;
import org.slizaa.rcp.workbench.core.model.ModelFactory;
import org.slizaa.rcp.workbench.core.model.Problem;
import org.slizaa.rcp.workbench.core.model.SlizaaProject;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension;

import org.slizaa.scanner.core.api.cypherregistry.ICypherStatement;

import org.slizaa.scanner.core.api.graphdb.IGraphDb;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.slizaa.rcp.workbench.core.model.ModelFactory
 * @generated
 */
public class ModelPackageImpl extends EPackageImpl {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String eNAME = "model";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String eNS_URI = "http://slizaa.org/rcp/workbench/core/model";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String eNS_PREFIX = "org.slizaa.rcp.workbench.core.model";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final ModelPackageImpl eINSTANCE = org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl.init();

  /**
   * The meta object id for the '{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectImpl <em>Slizaa Project</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectImpl
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getSlizaaProject()
   * @generated
   */
  public static final int SLIZAA_PROJECT = 0;

  /**
   * The feature id for the '<em><b>Project</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT__PROJECT = 0;

  /**
   * The feature id for the '<em><b>Configuration</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT__CONFIGURATION = 1;

  /**
   * The feature id for the '<em><b>User Defined Extensions</b></em>' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT__USER_DEFINED_EXTENSIONS = 2;

  /**
   * The feature id for the '<em><b>User Defined Cypher Statements</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT__USER_DEFINED_CYPHER_STATEMENTS = 3;

  /**
   * The feature id for the '<em><b>Graph Database Instance</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT__GRAPH_DATABASE_INSTANCE = 4;

  /**
   * The feature id for the '<em><b>Bolt Client</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT__BOLT_CLIENT = 5;

  /**
   * The feature id for the '<em><b>Hierachical Graph</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT__HIERACHICAL_GRAPH = 6;

  /**
   * The number of structural features of the '<em>Slizaa Project</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_FEATURE_COUNT = 7;

  /**
   * The operation id for the '<em>Clean Build</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT___CLEAN_BUILD = 0;

  /**
   * The operation id for the '<em>Parse</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT___PARSE__IPROGRESSMONITOR = 1;

  /**
   * The operation id for the '<em>Start And Connect Database</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT___START_AND_CONNECT_DATABASE__IPROGRESSMONITOR = 2;

  /**
   * The operation id for the '<em>Map To Hierachical Graph</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT___MAP_TO_HIERACHICAL_GRAPH__IMAPPINGPROVIDER_IPROGRESSMONITOR = 3;

  /**
   * The operation id for the '<em>Dispose</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT___DISPOSE = 4;

  /**
   * The operation id for the '<em>Is Database Directory Populated</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT___IS_DATABASE_DIRECTORY_POPULATED = 5;

  /**
   * The number of operations of the '<em>Slizaa Project</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_OPERATION_COUNT = 6;

  /**
   * The meta object id for the '{@link org.slizaa.rcp.workbench.core.model.impl.AbstractUserDefinedTypeImpl <em>Abstract User Defined Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.rcp.workbench.core.model.impl.AbstractUserDefinedTypeImpl
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getAbstractUserDefinedType()
   * @generated
   */
  public static final int ABSTRACT_USER_DEFINED_TYPE = 1;

  /**
   * The feature id for the '<em><b>Project</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int ABSTRACT_USER_DEFINED_TYPE__PROJECT = 0;

  /**
   * The feature id for the '<em><b>Resource Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int ABSTRACT_USER_DEFINED_TYPE__RESOURCE_PATH = 1;

  /**
   * The feature id for the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int ABSTRACT_USER_DEFINED_TYPE__TYPE_NAME = 2;

  /**
   * The number of structural features of the '<em>Abstract User Defined Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int ABSTRACT_USER_DEFINED_TYPE_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>Abstract User Defined Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int ABSTRACT_USER_DEFINED_TYPE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationModelImpl <em>Slizaa Project Configuration Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationModelImpl
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getSlizaaProjectConfigurationModel()
   * @generated
   */
  public static final int SLIZAA_PROJECT_CONFIGURATION_MODEL = 2;

  /**
   * The feature id for the '<em><b>Project</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_CONFIGURATION_MODEL__PROJECT = ABSTRACT_USER_DEFINED_TYPE__PROJECT;

  /**
   * The feature id for the '<em><b>Resource Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_CONFIGURATION_MODEL__RESOURCE_PATH = ABSTRACT_USER_DEFINED_TYPE__RESOURCE_PATH;

  /**
   * The feature id for the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_CONFIGURATION_MODEL__TYPE_NAME = ABSTRACT_USER_DEFINED_TYPE__TYPE_NAME;

  /**
   * The feature id for the '<em><b>Problems</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_CONFIGURATION_MODEL__PROBLEMS = ABSTRACT_USER_DEFINED_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Slizaa Project Configuration Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_CONFIGURATION_MODEL_FEATURE_COUNT = ABSTRACT_USER_DEFINED_TYPE_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Get Injector</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_CONFIGURATION_MODEL___GET_INJECTOR = ABSTRACT_USER_DEFINED_TYPE_OPERATION_COUNT + 0;

  /**
   * The number of operations of the '<em>Slizaa Project Configuration Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_CONFIGURATION_MODEL_OPERATION_COUNT = ABSTRACT_USER_DEFINED_TYPE_OPERATION_COUNT + 1;

  /**
   * The meta object id for the '{@link org.slizaa.rcp.workbench.core.model.impl.ProblemImpl <em>Problem</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.rcp.workbench.core.model.impl.ProblemImpl
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getProblem()
   * @generated
   */
  public static final int PROBLEM = 3;

  /**
   * The feature id for the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int PROBLEM__MESSAGE = 0;

  /**
   * The feature id for the '<em><b>Char Start</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int PROBLEM__CHAR_START = 1;

  /**
   * The feature id for the '<em><b>Char End</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int PROBLEM__CHAR_END = 2;

  /**
   * The number of structural features of the '<em>Problem</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int PROBLEM_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>Problem</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int PROBLEM_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectExtensionImpl <em>Slizaa Project Extension</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectExtensionImpl
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getSlizaaProjectExtension()
   * @generated
   */
  public static final int SLIZAA_PROJECT_EXTENSION = 4;

  /**
   * The feature id for the '<em><b>Project</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_EXTENSION__PROJECT = ABSTRACT_USER_DEFINED_TYPE__PROJECT;

  /**
   * The feature id for the '<em><b>Resource Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_EXTENSION__RESOURCE_PATH = ABSTRACT_USER_DEFINED_TYPE__RESOURCE_PATH;

  /**
   * The feature id for the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_EXTENSION__TYPE_NAME = ABSTRACT_USER_DEFINED_TYPE__TYPE_NAME;

  /**
   * The feature id for the '<em><b>Annotation Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_EXTENSION__ANNOTATION_TYPE = ABSTRACT_USER_DEFINED_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Slizaa Project Extension</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_EXTENSION_FEATURE_COUNT = ABSTRACT_USER_DEFINED_TYPE_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Create New Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_EXTENSION___CREATE_NEW_INSTANCE__CLASS = ABSTRACT_USER_DEFINED_TYPE_OPERATION_COUNT + 0;

  /**
   * The number of operations of the '<em>Slizaa Project Extension</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_EXTENSION_OPERATION_COUNT = ABSTRACT_USER_DEFINED_TYPE_OPERATION_COUNT + 1;

  /**
   * The meta object id for the '{@link org.slizaa.rcp.workbench.core.model.impl.AnnotationTypeToSlizaaProjectExtensionMapImpl <em>Annotation Type To Slizaa Project Extension Map</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.rcp.workbench.core.model.impl.AnnotationTypeToSlizaaProjectExtensionMapImpl
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getAnnotationTypeToSlizaaProjectExtensionMap()
   * @generated
   */
  public static final int ANNOTATION_TYPE_TO_SLIZAA_PROJECT_EXTENSION_MAP = 5;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int ANNOTATION_TYPE_TO_SLIZAA_PROJECT_EXTENSION_MAP__KEY = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int ANNOTATION_TYPE_TO_SLIZAA_PROJECT_EXTENSION_MAP__VALUE = 1;

  /**
   * The number of structural features of the '<em>Annotation Type To Slizaa Project Extension Map</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int ANNOTATION_TYPE_TO_SLIZAA_PROJECT_EXTENSION_MAP_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Annotation Type To Slizaa Project Extension Map</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int ANNOTATION_TYPE_TO_SLIZAA_PROJECT_EXTENSION_MAP_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '<em>IProgress Monitor</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.core.runtime.IProgressMonitor
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getIProgressMonitor()
   * @generated
   */
  public static final int IPROGRESS_MONITOR = 6;

  /**
   * The meta object id for the '<em>IProject</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.core.resources.IProject
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getIProject()
   * @generated
   */
  public static final int IPROJECT = 7;

  /**
   * The meta object id for the '<em>IGraph Db</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.scanner.core.api.graphdb.IGraphDb
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getIGraphDb()
   * @generated
   */
  public static final int IGRAPH_DB = 8;

  /**
   * The meta object id for the '<em>ICypher Statement</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.scanner.core.api.cypherregistry.ICypherStatement
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getICypherStatement()
   * @generated
   */
  public static final int ICYPHER_STATEMENT = 9;

  /**
   * The meta object id for the '<em>IMapping Provider</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.hierarchicalgraph.graphdb.mapping.spi.IMappingProvider
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getIMappingProvider()
   * @generated
   */
  public static final int IMAPPING_PROVIDER = 10;

  /**
   * The meta object id for the '<em>Injector</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.google.inject.Injector
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getInjector()
   * @generated
   */
  public static final int INJECTOR = 11;

  /**
   * The meta object id for the '<em>IBolt Client</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.core.boltclient.IBoltClient
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getIBoltClient()
   * @generated
   */
  public static final int IBOLT_CLIENT = 12;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass slizaaProjectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractUserDefinedTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass slizaaProjectConfigurationModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass problemEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass slizaaProjectExtensionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass annotationTypeToSlizaaProjectExtensionMapEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType iProgressMonitorEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType iProjectEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType iGraphDbEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType iCypherStatementEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType iMappingProviderEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType injectorEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType iBoltClientEDataType = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#eNS_URI
   * @see #init()
   * @generated
   */
  private ModelPackageImpl() {
    super(eNS_URI, ((EFactory)ModelFactory.INSTANCE));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link ModelPackageImpl#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ModelPackageImpl init() {
    if (isInited) return (ModelPackageImpl)EPackage.Registry.INSTANCE.getEPackage(ModelPackageImpl.eNS_URI);

    // Obtain or create and register package
    ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModelPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    org.slizaa.hierarchicalgraph.core.model.HierarchicalgraphPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theModelPackage.createPackageContents();

    // Initialize created meta-data
    theModelPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theModelPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ModelPackageImpl.eNS_URI, theModelPackage);
    return theModelPackage;
  }


  /**
   * Returns the meta object for class '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject <em>Slizaa Project</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Slizaa Project</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject
   * @generated
   */
  public EClass getSlizaaProject() {
    return slizaaProjectEClass;
  }

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#getProject <em>Project</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Project</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject#getProject()
   * @see #getSlizaaProject()
   * @generated
   */
  public EAttribute getSlizaaProject_Project() {
    return (EAttribute)slizaaProjectEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for the reference '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#getConfiguration <em>Configuration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Configuration</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject#getConfiguration()
   * @see #getSlizaaProject()
   * @generated
   */
  public EReference getSlizaaProject_Configuration() {
    return (EReference)slizaaProjectEClass.getEStructuralFeatures().get(1);
  }

  /**
   * Returns the meta object for the map '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#getUserDefinedExtensions <em>User Defined Extensions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the map '<em>User Defined Extensions</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject#getUserDefinedExtensions()
   * @see #getSlizaaProject()
   * @generated
   */
  public EReference getSlizaaProject_UserDefinedExtensions() {
    return (EReference)slizaaProjectEClass.getEStructuralFeatures().get(2);
  }

  /**
   * Returns the meta object for the attribute list '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#getUserDefinedCypherStatements <em>User Defined Cypher Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>User Defined Cypher Statements</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject#getUserDefinedCypherStatements()
   * @see #getSlizaaProject()
   * @generated
   */
  public EAttribute getSlizaaProject_UserDefinedCypherStatements() {
    return (EAttribute)slizaaProjectEClass.getEStructuralFeatures().get(3);
  }

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#getGraphDatabaseInstance <em>Graph Database Instance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Graph Database Instance</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject#getGraphDatabaseInstance()
   * @see #getSlizaaProject()
   * @generated
   */
  public EAttribute getSlizaaProject_GraphDatabaseInstance() {
    return (EAttribute)slizaaProjectEClass.getEStructuralFeatures().get(4);
  }

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#getBoltClient <em>Bolt Client</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Bolt Client</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject#getBoltClient()
   * @see #getSlizaaProject()
   * @generated
   */
  public EAttribute getSlizaaProject_BoltClient() {
    return (EAttribute)slizaaProjectEClass.getEStructuralFeatures().get(5);
  }

  /**
   * Returns the meta object for the reference '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#getHierachicalGraph <em>Hierachical Graph</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Hierachical Graph</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject#getHierachicalGraph()
   * @see #getSlizaaProject()
   * @generated
   */
  public EReference getSlizaaProject_HierachicalGraph() {
    return (EReference)slizaaProjectEClass.getEStructuralFeatures().get(6);
  }

  /**
   * Returns the meta object for the '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#cleanBuild() <em>Clean Build</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Clean Build</em>' operation.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject#cleanBuild()
   * @generated
   */
  public EOperation getSlizaaProject__CleanBuild() {
    return slizaaProjectEClass.getEOperations().get(0);
  }

  /**
   * Returns the meta object for the '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#parse(org.eclipse.core.runtime.IProgressMonitor) <em>Parse</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Parse</em>' operation.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject#parse(org.eclipse.core.runtime.IProgressMonitor)
   * @generated
   */
  public EOperation getSlizaaProject__Parse__IProgressMonitor() {
    return slizaaProjectEClass.getEOperations().get(1);
  }

  /**
   * Returns the meta object for the '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#startAndConnectDatabase(org.eclipse.core.runtime.IProgressMonitor) <em>Start And Connect Database</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Start And Connect Database</em>' operation.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject#startAndConnectDatabase(org.eclipse.core.runtime.IProgressMonitor)
   * @generated
   */
  public EOperation getSlizaaProject__StartAndConnectDatabase__IProgressMonitor() {
    return slizaaProjectEClass.getEOperations().get(2);
  }

  /**
   * Returns the meta object for the '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#mapToHierachicalGraph(org.slizaa.hierarchicalgraph.graphdb.mapping.spi.IMappingProvider, org.eclipse.core.runtime.IProgressMonitor) <em>Map To Hierachical Graph</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Map To Hierachical Graph</em>' operation.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject#mapToHierachicalGraph(org.slizaa.hierarchicalgraph.graphdb.mapping.spi.IMappingProvider, org.eclipse.core.runtime.IProgressMonitor)
   * @generated
   */
  public EOperation getSlizaaProject__MapToHierachicalGraph__IMappingProvider_IProgressMonitor() {
    return slizaaProjectEClass.getEOperations().get(3);
  }


  /**
   * Returns the meta object for the '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#dispose() <em>Dispose</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Dispose</em>' operation.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject#dispose()
   * @generated
   */
  public EOperation getSlizaaProject__Dispose() {
    return slizaaProjectEClass.getEOperations().get(4);
  }

  /**
   * Returns the meta object for the '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#isDatabaseDirectoryPopulated() <em>Is Database Directory Populated</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Is Database Directory Populated</em>' operation.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject#isDatabaseDirectoryPopulated()
   * @generated
   */
  public EOperation getSlizaaProject__IsDatabaseDirectoryPopulated() {
    return slizaaProjectEClass.getEOperations().get(5);
  }


  /**
   * Returns the meta object for class '{@link org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType <em>Abstract User Defined Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract User Defined Type</em>'.
   * @see org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType
   * @generated
   */
  public EClass getAbstractUserDefinedType() {
    return abstractUserDefinedTypeEClass;
  }

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType#getProject <em>Project</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Project</em>'.
   * @see org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType#getProject()
   * @see #getAbstractUserDefinedType()
   * @generated
   */
  public EAttribute getAbstractUserDefinedType_Project() {
    return (EAttribute)abstractUserDefinedTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType#getResourcePath <em>Resource Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Resource Path</em>'.
   * @see org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType#getResourcePath()
   * @see #getAbstractUserDefinedType()
   * @generated
   */
  public EAttribute getAbstractUserDefinedType_ResourcePath() {
    return (EAttribute)abstractUserDefinedTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType#getTypeName <em>Type Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Name</em>'.
   * @see org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType#getTypeName()
   * @see #getAbstractUserDefinedType()
   * @generated
   */
  public EAttribute getAbstractUserDefinedType_TypeName() {
    return (EAttribute)abstractUserDefinedTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * Returns the meta object for class '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel <em>Slizaa Project Configuration Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Slizaa Project Configuration Model</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel
   * @generated
   */
  public EClass getSlizaaProjectConfigurationModel() {
    return slizaaProjectConfigurationModelEClass;
  }

  /**
   * Returns the meta object for the reference list '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel#getProblems <em>Problems</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Problems</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel#getProblems()
   * @see #getSlizaaProjectConfigurationModel()
   * @generated
   */
  public EReference getSlizaaProjectConfigurationModel_Problems() {
    return (EReference)slizaaProjectConfigurationModelEClass.getEStructuralFeatures().get(0);
  }


  /**
   * Returns the meta object for the '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel#getInjector() <em>Get Injector</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Injector</em>' operation.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel#getInjector()
   * @generated
   */
  public EOperation getSlizaaProjectConfigurationModel__GetInjector() {
    return slizaaProjectConfigurationModelEClass.getEOperations().get(0);
  }


  /**
   * Returns the meta object for class '{@link org.slizaa.rcp.workbench.core.model.Problem <em>Problem</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Problem</em>'.
   * @see org.slizaa.rcp.workbench.core.model.Problem
   * @generated
   */
  public EClass getProblem() {
    return problemEClass;
  }


  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.Problem#getMessage <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message</em>'.
   * @see org.slizaa.rcp.workbench.core.model.Problem#getMessage()
   * @see #getProblem()
   * @generated
   */
  public EAttribute getProblem_Message() {
    return (EAttribute)problemEClass.getEStructuralFeatures().get(0);
  }


  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.Problem#getCharStart <em>Char Start</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Char Start</em>'.
   * @see org.slizaa.rcp.workbench.core.model.Problem#getCharStart()
   * @see #getProblem()
   * @generated
   */
  public EAttribute getProblem_CharStart() {
    return (EAttribute)problemEClass.getEStructuralFeatures().get(1);
  }


  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.Problem#getCharEnd <em>Char End</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Char End</em>'.
   * @see org.slizaa.rcp.workbench.core.model.Problem#getCharEnd()
   * @see #getProblem()
   * @generated
   */
  public EAttribute getProblem_CharEnd() {
    return (EAttribute)problemEClass.getEStructuralFeatures().get(2);
  }


  /**
   * Returns the meta object for class '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension <em>Slizaa Project Extension</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Slizaa Project Extension</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension
   * @generated
   */
  public EClass getSlizaaProjectExtension() {
    return slizaaProjectExtensionEClass;
  }

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension#getAnnotationType <em>Annotation Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Annotation Type</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension#getAnnotationType()
   * @see #getSlizaaProjectExtension()
   * @generated
   */
  public EAttribute getSlizaaProjectExtension_AnnotationType() {
    return (EAttribute)slizaaProjectExtensionEClass.getEStructuralFeatures().get(0);
  }


  /**
   * Returns the meta object for the '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension#createNewInstance(java.lang.Class) <em>Create New Instance</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Create New Instance</em>' operation.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension#createNewInstance(java.lang.Class)
   * @generated
   */
  public EOperation getSlizaaProjectExtension__CreateNewInstance__Class() {
    return slizaaProjectExtensionEClass.getEOperations().get(0);
  }

  /**
   * Returns the meta object for class '{@link java.util.Map.Entry <em>Annotation Type To Slizaa Project Extension Map</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Annotation Type To Slizaa Project Extension Map</em>'.
   * @see java.util.Map.Entry
   * @generated
   */
  public EClass getAnnotationTypeToSlizaaProjectExtensionMap() {
    return annotationTypeToSlizaaProjectExtensionMapEClass;
  }

  /**
   * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Key</em>'.
   * @see java.util.Map.Entry
   * @see #getAnnotationTypeToSlizaaProjectExtensionMap()
   * @generated
   */
  public EAttribute getAnnotationTypeToSlizaaProjectExtensionMap_Key() {
    return (EAttribute)annotationTypeToSlizaaProjectExtensionMapEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for the reference list '{@link java.util.Map.Entry <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Value</em>'.
   * @see java.util.Map.Entry
   * @see #getAnnotationTypeToSlizaaProjectExtensionMap()
   * @generated
   */
  public EReference getAnnotationTypeToSlizaaProjectExtensionMap_Value() {
    return (EReference)annotationTypeToSlizaaProjectExtensionMapEClass.getEStructuralFeatures().get(1);
  }

  /**
   * Returns the meta object for data type '{@link org.eclipse.core.runtime.IProgressMonitor <em>IProgress Monitor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>IProgress Monitor</em>'.
   * @see org.eclipse.core.runtime.IProgressMonitor
   * @generated
   */
  public EDataType getIProgressMonitor() {
    return iProgressMonitorEDataType;
  }

  /**
   * Returns the meta object for data type '{@link org.eclipse.core.resources.IProject <em>IProject</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>IProject</em>'.
   * @see org.eclipse.core.resources.IProject
   * @generated
   */
  public EDataType getIProject() {
    return iProjectEDataType;
  }

  /**
   * Returns the meta object for data type '{@link org.slizaa.scanner.core.api.graphdb.IGraphDb <em>IGraph Db</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>IGraph Db</em>'.
   * @see org.slizaa.scanner.core.api.graphdb.IGraphDb
   * @generated
   */
  public EDataType getIGraphDb() {
    return iGraphDbEDataType;
  }

  /**
   * Returns the meta object for data type '{@link org.slizaa.scanner.core.api.cypherregistry.ICypherStatement <em>ICypher Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>ICypher Statement</em>'.
   * @see org.slizaa.scanner.core.api.cypherregistry.ICypherStatement
   * @generated
   */
  public EDataType getICypherStatement() {
    return iCypherStatementEDataType;
  }

  /**
   * Returns the meta object for data type '{@link org.slizaa.hierarchicalgraph.graphdb.mapping.spi.IMappingProvider <em>IMapping Provider</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>IMapping Provider</em>'.
   * @see org.slizaa.hierarchicalgraph.graphdb.mapping.spi.IMappingProvider
   * @generated
   */
  public EDataType getIMappingProvider() {
    return iMappingProviderEDataType;
  }


  /**
   * Returns the meta object for data type '{@link com.google.inject.Injector <em>Injector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Injector</em>'.
   * @see com.google.inject.Injector
   * @generated
   */
  public EDataType getInjector() {
    return injectorEDataType;
  }


  /**
   * Returns the meta object for data type '{@link org.slizaa.core.boltclient.IBoltClient <em>IBolt Client</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>IBolt Client</em>'.
   * @see org.slizaa.core.boltclient.IBoltClient
   * @generated
   */
  public EDataType getIBoltClient() {
    return iBoltClientEDataType;
  }


  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  public ModelFactory getModelFactory() {
    return (ModelFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents() {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    slizaaProjectEClass = createEClass(SLIZAA_PROJECT);
    createEAttribute(slizaaProjectEClass, SLIZAA_PROJECT__PROJECT);
    createEReference(slizaaProjectEClass, SLIZAA_PROJECT__CONFIGURATION);
    createEReference(slizaaProjectEClass, SLIZAA_PROJECT__USER_DEFINED_EXTENSIONS);
    createEAttribute(slizaaProjectEClass, SLIZAA_PROJECT__USER_DEFINED_CYPHER_STATEMENTS);
    createEAttribute(slizaaProjectEClass, SLIZAA_PROJECT__GRAPH_DATABASE_INSTANCE);
    createEAttribute(slizaaProjectEClass, SLIZAA_PROJECT__BOLT_CLIENT);
    createEReference(slizaaProjectEClass, SLIZAA_PROJECT__HIERACHICAL_GRAPH);
    createEOperation(slizaaProjectEClass, SLIZAA_PROJECT___CLEAN_BUILD);
    createEOperation(slizaaProjectEClass, SLIZAA_PROJECT___PARSE__IPROGRESSMONITOR);
    createEOperation(slizaaProjectEClass, SLIZAA_PROJECT___START_AND_CONNECT_DATABASE__IPROGRESSMONITOR);
    createEOperation(slizaaProjectEClass, SLIZAA_PROJECT___MAP_TO_HIERACHICAL_GRAPH__IMAPPINGPROVIDER_IPROGRESSMONITOR);
    createEOperation(slizaaProjectEClass, SLIZAA_PROJECT___DISPOSE);
    createEOperation(slizaaProjectEClass, SLIZAA_PROJECT___IS_DATABASE_DIRECTORY_POPULATED);

    abstractUserDefinedTypeEClass = createEClass(ABSTRACT_USER_DEFINED_TYPE);
    createEAttribute(abstractUserDefinedTypeEClass, ABSTRACT_USER_DEFINED_TYPE__PROJECT);
    createEAttribute(abstractUserDefinedTypeEClass, ABSTRACT_USER_DEFINED_TYPE__RESOURCE_PATH);
    createEAttribute(abstractUserDefinedTypeEClass, ABSTRACT_USER_DEFINED_TYPE__TYPE_NAME);

    slizaaProjectConfigurationModelEClass = createEClass(SLIZAA_PROJECT_CONFIGURATION_MODEL);
    createEReference(slizaaProjectConfigurationModelEClass, SLIZAA_PROJECT_CONFIGURATION_MODEL__PROBLEMS);
    createEOperation(slizaaProjectConfigurationModelEClass, SLIZAA_PROJECT_CONFIGURATION_MODEL___GET_INJECTOR);

    problemEClass = createEClass(PROBLEM);
    createEAttribute(problemEClass, PROBLEM__MESSAGE);
    createEAttribute(problemEClass, PROBLEM__CHAR_START);
    createEAttribute(problemEClass, PROBLEM__CHAR_END);

    slizaaProjectExtensionEClass = createEClass(SLIZAA_PROJECT_EXTENSION);
    createEAttribute(slizaaProjectExtensionEClass, SLIZAA_PROJECT_EXTENSION__ANNOTATION_TYPE);
    createEOperation(slizaaProjectExtensionEClass, SLIZAA_PROJECT_EXTENSION___CREATE_NEW_INSTANCE__CLASS);

    annotationTypeToSlizaaProjectExtensionMapEClass = createEClass(ANNOTATION_TYPE_TO_SLIZAA_PROJECT_EXTENSION_MAP);
    createEAttribute(annotationTypeToSlizaaProjectExtensionMapEClass, ANNOTATION_TYPE_TO_SLIZAA_PROJECT_EXTENSION_MAP__KEY);
    createEReference(annotationTypeToSlizaaProjectExtensionMapEClass, ANNOTATION_TYPE_TO_SLIZAA_PROJECT_EXTENSION_MAP__VALUE);

    // Create data types
    iProgressMonitorEDataType = createEDataType(IPROGRESS_MONITOR);
    iProjectEDataType = createEDataType(IPROJECT);
    iGraphDbEDataType = createEDataType(IGRAPH_DB);
    iCypherStatementEDataType = createEDataType(ICYPHER_STATEMENT);
    iMappingProviderEDataType = createEDataType(IMAPPING_PROVIDER);
    injectorEDataType = createEDataType(INJECTOR);
    iBoltClientEDataType = createEDataType(IBOLT_CLIENT);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents() {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    org.slizaa.hierarchicalgraph.core.model.HierarchicalgraphPackage theHierarchicalgraphPackage = (org.slizaa.hierarchicalgraph.core.model.HierarchicalgraphPackage)EPackage.Registry.INSTANCE.getEPackage(org.slizaa.hierarchicalgraph.core.model.HierarchicalgraphPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    slizaaProjectConfigurationModelEClass.getESuperTypes().add(this.getAbstractUserDefinedType());
    slizaaProjectExtensionEClass.getESuperTypes().add(this.getAbstractUserDefinedType());

    // Initialize classes, features, and operations; add parameters
    initEClass(slizaaProjectEClass, SlizaaProject.class, "SlizaaProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSlizaaProject_Project(), this.getIProject(), "project", null, 0, 1, SlizaaProject.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSlizaaProject_Configuration(), this.getSlizaaProjectConfigurationModel(), null, "configuration", null, 0, 1, SlizaaProject.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSlizaaProject_UserDefinedExtensions(), this.getAnnotationTypeToSlizaaProjectExtensionMap(), null, "userDefinedExtensions", null, 0, -1, SlizaaProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSlizaaProject_UserDefinedCypherStatements(), this.getICypherStatement(), "userDefinedCypherStatements", null, 0, -1, SlizaaProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSlizaaProject_GraphDatabaseInstance(), this.getIGraphDb(), "graphDatabaseInstance", null, 0, 1, SlizaaProject.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSlizaaProject_BoltClient(), this.getIBoltClient(), "boltClient", null, 0, 1, SlizaaProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSlizaaProject_HierachicalGraph(), theHierarchicalgraphPackage.getHGRootNode(), null, "hierachicalGraph", null, 0, 1, SlizaaProject.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEOperation(getSlizaaProject__CleanBuild(), null, "cleanBuild", 0, 1, IS_UNIQUE, IS_ORDERED);

    EOperation op = initEOperation(getSlizaaProject__Parse__IProgressMonitor(), null, "parse", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getIProgressMonitor(), "monitor", 0, 1, IS_UNIQUE, IS_ORDERED);

    op = initEOperation(getSlizaaProject__StartAndConnectDatabase__IProgressMonitor(), null, "startAndConnectDatabase", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getIProgressMonitor(), "monitor", 0, 1, IS_UNIQUE, IS_ORDERED);

    op = initEOperation(getSlizaaProject__MapToHierachicalGraph__IMappingProvider_IProgressMonitor(), theHierarchicalgraphPackage.getHGRootNode(), "mapToHierachicalGraph", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getIMappingProvider(), "mappingProvider", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getIProgressMonitor(), "monitor", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getSlizaaProject__Dispose(), null, "dispose", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getSlizaaProject__IsDatabaseDirectoryPopulated(), ecorePackage.getEBoolean(), "isDatabaseDirectoryPopulated", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(abstractUserDefinedTypeEClass, AbstractUserDefinedType.class, "AbstractUserDefinedType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAbstractUserDefinedType_Project(), this.getIProject(), "project", null, 0, 1, AbstractUserDefinedType.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAbstractUserDefinedType_ResourcePath(), ecorePackage.getEString(), "resourcePath", null, 0, 1, AbstractUserDefinedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAbstractUserDefinedType_TypeName(), ecorePackage.getEString(), "typeName", null, 0, 1, AbstractUserDefinedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(slizaaProjectConfigurationModelEClass, SlizaaProjectConfigurationModel.class, "SlizaaProjectConfigurationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSlizaaProjectConfigurationModel_Problems(), this.getProblem(), null, "problems", null, 0, -1, SlizaaProjectConfigurationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEOperation(getSlizaaProjectConfigurationModel__GetInjector(), this.getInjector(), "getInjector", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(problemEClass, Problem.class, "Problem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getProblem_Message(), ecorePackage.getEString(), "message", null, 0, 1, Problem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getProblem_CharStart(), ecorePackage.getEInt(), "charStart", null, 0, 1, Problem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getProblem_CharEnd(), ecorePackage.getEInt(), "charEnd", null, 0, 1, Problem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(slizaaProjectExtensionEClass, SlizaaProjectExtension.class, "SlizaaProjectExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    EGenericType g1 = createEGenericType(ecorePackage.getEJavaClass());
    EGenericType g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    initEAttribute(getSlizaaProjectExtension_AnnotationType(), g1, "annotationType", null, 0, 1, SlizaaProjectExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    op = initEOperation(getSlizaaProjectExtension__CreateNewInstance__Class(), null, "createNewInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
    ETypeParameter t1 = addETypeParameter(op, "T");
    g1 = createEGenericType(ecorePackage.getEJavaClass());
    g2 = createEGenericType(t1);
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "type", 0, 1, IS_UNIQUE, IS_ORDERED);
    g1 = createEGenericType(t1);
    initEOperation(op, g1);

    initEClass(annotationTypeToSlizaaProjectExtensionMapEClass, Map.Entry.class, "AnnotationTypeToSlizaaProjectExtensionMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
    g1 = createEGenericType(ecorePackage.getEJavaClass());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    initEAttribute(getAnnotationTypeToSlizaaProjectExtensionMap_Key(), g1, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAnnotationTypeToSlizaaProjectExtensionMap_Value(), this.getSlizaaProjectExtension(), null, "value", null, 0, -1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize data types
    initEDataType(iProgressMonitorEDataType, IProgressMonitor.class, "IProgressMonitor", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(iProjectEDataType, IProject.class, "IProject", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(iGraphDbEDataType, IGraphDb.class, "IGraphDb", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(iCypherStatementEDataType, ICypherStatement.class, "ICypherStatement", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(iMappingProviderEDataType, IMappingProvider.class, "IMappingProvider", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(injectorEDataType, Injector.class, "Injector", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(iBoltClientEDataType, IBoltClient.class, "IBoltClient", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each operation of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  public interface Literals {
    /**
     * The meta object literal for the '{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectImpl <em>Slizaa Project</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectImpl
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getSlizaaProject()
     * @generated
     */
    public static final EClass SLIZAA_PROJECT = eINSTANCE.getSlizaaProject();

    /**
     * The meta object literal for the '<em><b>Project</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute SLIZAA_PROJECT__PROJECT = eINSTANCE.getSlizaaProject_Project();

    /**
     * The meta object literal for the '<em><b>Configuration</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference SLIZAA_PROJECT__CONFIGURATION = eINSTANCE.getSlizaaProject_Configuration();

    /**
     * The meta object literal for the '<em><b>User Defined Extensions</b></em>' map feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference SLIZAA_PROJECT__USER_DEFINED_EXTENSIONS = eINSTANCE.getSlizaaProject_UserDefinedExtensions();

    /**
     * The meta object literal for the '<em><b>User Defined Cypher Statements</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute SLIZAA_PROJECT__USER_DEFINED_CYPHER_STATEMENTS = eINSTANCE.getSlizaaProject_UserDefinedCypherStatements();

    /**
     * The meta object literal for the '<em><b>Graph Database Instance</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute SLIZAA_PROJECT__GRAPH_DATABASE_INSTANCE = eINSTANCE.getSlizaaProject_GraphDatabaseInstance();

    /**
     * The meta object literal for the '<em><b>Bolt Client</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute SLIZAA_PROJECT__BOLT_CLIENT = eINSTANCE.getSlizaaProject_BoltClient();

    /**
     * The meta object literal for the '<em><b>Hierachical Graph</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference SLIZAA_PROJECT__HIERACHICAL_GRAPH = eINSTANCE.getSlizaaProject_HierachicalGraph();

    /**
     * The meta object literal for the '<em><b>Clean Build</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EOperation SLIZAA_PROJECT___CLEAN_BUILD = eINSTANCE.getSlizaaProject__CleanBuild();

    /**
     * The meta object literal for the '<em><b>Parse</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EOperation SLIZAA_PROJECT___PARSE__IPROGRESSMONITOR = eINSTANCE.getSlizaaProject__Parse__IProgressMonitor();

    /**
     * The meta object literal for the '<em><b>Start And Connect Database</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EOperation SLIZAA_PROJECT___START_AND_CONNECT_DATABASE__IPROGRESSMONITOR = eINSTANCE.getSlizaaProject__StartAndConnectDatabase__IProgressMonitor();

    /**
     * The meta object literal for the '<em><b>Map To Hierachical Graph</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EOperation SLIZAA_PROJECT___MAP_TO_HIERACHICAL_GRAPH__IMAPPINGPROVIDER_IPROGRESSMONITOR = eINSTANCE.getSlizaaProject__MapToHierachicalGraph__IMappingProvider_IProgressMonitor();

    /**
     * The meta object literal for the '<em><b>Dispose</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EOperation SLIZAA_PROJECT___DISPOSE = eINSTANCE.getSlizaaProject__Dispose();

    /**
     * The meta object literal for the '<em><b>Is Database Directory Populated</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EOperation SLIZAA_PROJECT___IS_DATABASE_DIRECTORY_POPULATED = eINSTANCE.getSlizaaProject__IsDatabaseDirectoryPopulated();

    /**
     * The meta object literal for the '{@link org.slizaa.rcp.workbench.core.model.impl.AbstractUserDefinedTypeImpl <em>Abstract User Defined Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.slizaa.rcp.workbench.core.model.impl.AbstractUserDefinedTypeImpl
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getAbstractUserDefinedType()
     * @generated
     */
    public static final EClass ABSTRACT_USER_DEFINED_TYPE = eINSTANCE.getAbstractUserDefinedType();

    /**
     * The meta object literal for the '<em><b>Project</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute ABSTRACT_USER_DEFINED_TYPE__PROJECT = eINSTANCE.getAbstractUserDefinedType_Project();

    /**
     * The meta object literal for the '<em><b>Resource Path</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute ABSTRACT_USER_DEFINED_TYPE__RESOURCE_PATH = eINSTANCE.getAbstractUserDefinedType_ResourcePath();

    /**
     * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute ABSTRACT_USER_DEFINED_TYPE__TYPE_NAME = eINSTANCE.getAbstractUserDefinedType_TypeName();

    /**
     * The meta object literal for the '{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationModelImpl <em>Slizaa Project Configuration Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationModelImpl
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getSlizaaProjectConfigurationModel()
     * @generated
     */
    public static final EClass SLIZAA_PROJECT_CONFIGURATION_MODEL = eINSTANCE.getSlizaaProjectConfigurationModel();

    /**
     * The meta object literal for the '<em><b>Problems</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference SLIZAA_PROJECT_CONFIGURATION_MODEL__PROBLEMS = eINSTANCE.getSlizaaProjectConfigurationModel_Problems();

    /**
     * The meta object literal for the '<em><b>Get Injector</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EOperation SLIZAA_PROJECT_CONFIGURATION_MODEL___GET_INJECTOR = eINSTANCE.getSlizaaProjectConfigurationModel__GetInjector();

    /**
     * The meta object literal for the '{@link org.slizaa.rcp.workbench.core.model.impl.ProblemImpl <em>Problem</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.slizaa.rcp.workbench.core.model.impl.ProblemImpl
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getProblem()
     * @generated
     */
    public static final EClass PROBLEM = eINSTANCE.getProblem();

    /**
     * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute PROBLEM__MESSAGE = eINSTANCE.getProblem_Message();

    /**
     * The meta object literal for the '<em><b>Char Start</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute PROBLEM__CHAR_START = eINSTANCE.getProblem_CharStart();

    /**
     * The meta object literal for the '<em><b>Char End</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute PROBLEM__CHAR_END = eINSTANCE.getProblem_CharEnd();

    /**
     * The meta object literal for the '{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectExtensionImpl <em>Slizaa Project Extension</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectExtensionImpl
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getSlizaaProjectExtension()
     * @generated
     */
    public static final EClass SLIZAA_PROJECT_EXTENSION = eINSTANCE.getSlizaaProjectExtension();

    /**
     * The meta object literal for the '<em><b>Annotation Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute SLIZAA_PROJECT_EXTENSION__ANNOTATION_TYPE = eINSTANCE.getSlizaaProjectExtension_AnnotationType();

    /**
     * The meta object literal for the '<em><b>Create New Instance</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EOperation SLIZAA_PROJECT_EXTENSION___CREATE_NEW_INSTANCE__CLASS = eINSTANCE.getSlizaaProjectExtension__CreateNewInstance__Class();

    /**
     * The meta object literal for the '{@link org.slizaa.rcp.workbench.core.model.impl.AnnotationTypeToSlizaaProjectExtensionMapImpl <em>Annotation Type To Slizaa Project Extension Map</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.slizaa.rcp.workbench.core.model.impl.AnnotationTypeToSlizaaProjectExtensionMapImpl
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getAnnotationTypeToSlizaaProjectExtensionMap()
     * @generated
     */
    public static final EClass ANNOTATION_TYPE_TO_SLIZAA_PROJECT_EXTENSION_MAP = eINSTANCE.getAnnotationTypeToSlizaaProjectExtensionMap();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute ANNOTATION_TYPE_TO_SLIZAA_PROJECT_EXTENSION_MAP__KEY = eINSTANCE.getAnnotationTypeToSlizaaProjectExtensionMap_Key();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference ANNOTATION_TYPE_TO_SLIZAA_PROJECT_EXTENSION_MAP__VALUE = eINSTANCE.getAnnotationTypeToSlizaaProjectExtensionMap_Value();

    /**
     * The meta object literal for the '<em>IProgress Monitor</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.core.runtime.IProgressMonitor
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getIProgressMonitor()
     * @generated
     */
    public static final EDataType IPROGRESS_MONITOR = eINSTANCE.getIProgressMonitor();

    /**
     * The meta object literal for the '<em>IProject</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.core.resources.IProject
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getIProject()
     * @generated
     */
    public static final EDataType IPROJECT = eINSTANCE.getIProject();

    /**
     * The meta object literal for the '<em>IGraph Db</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.slizaa.scanner.core.api.graphdb.IGraphDb
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getIGraphDb()
     * @generated
     */
    public static final EDataType IGRAPH_DB = eINSTANCE.getIGraphDb();

    /**
     * The meta object literal for the '<em>ICypher Statement</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.slizaa.scanner.core.api.cypherregistry.ICypherStatement
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getICypherStatement()
     * @generated
     */
    public static final EDataType ICYPHER_STATEMENT = eINSTANCE.getICypherStatement();

    /**
     * The meta object literal for the '<em>IMapping Provider</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.slizaa.hierarchicalgraph.graphdb.mapping.spi.IMappingProvider
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getIMappingProvider()
     * @generated
     */
    public static final EDataType IMAPPING_PROVIDER = eINSTANCE.getIMappingProvider();

    /**
     * The meta object literal for the '<em>Injector</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.google.inject.Injector
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getInjector()
     * @generated
     */
    public static final EDataType INJECTOR = eINSTANCE.getInjector();

    /**
     * The meta object literal for the '<em>IBolt Client</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.slizaa.core.boltclient.IBoltClient
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getIBoltClient()
     * @generated
     */
    public static final EDataType IBOLT_CLIENT = eINSTANCE.getIBoltClient();

  }

} //ModelPackageImpl
