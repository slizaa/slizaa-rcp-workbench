/**
 */
package org.slizaa.rcp.workbench.core.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "model";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://slizaa.org/rcp/workbench/core/model";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "org.slizaa.rcp.workbench.core.model";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ModelPackage eINSTANCE = org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl.init();

  /**
   * The meta object id for the '{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectImpl <em>Slizaa Project</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectImpl
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getSlizaaProject()
   * @generated
   */
  int SLIZAA_PROJECT = 0;

  /**
   * The feature id for the '<em><b>Project</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT__PROJECT = 0;

  /**
   * The feature id for the '<em><b>Configuration</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT__CONFIGURATION = 1;

  /**
   * The feature id for the '<em><b>Project Extensions</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT__PROJECT_EXTENSIONS = 2;

  /**
   * The feature id for the '<em><b>Graph Database Instance</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT__GRAPH_DATABASE_INSTANCE = 3;

  /**
   * The feature id for the '<em><b>Bolt Client</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT__BOLT_CLIENT = 4;

  /**
   * The feature id for the '<em><b>Hierachical Graph</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT__HIERACHICAL_GRAPH = 5;

  /**
   * The number of structural features of the '<em>Slizaa Project</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT_FEATURE_COUNT = 6;

  /**
   * The operation id for the '<em>Clean Build</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT___CLEAN_BUILD = 0;

  /**
   * The operation id for the '<em>Parse</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT___PARSE__IPROGRESSMONITOR = 1;

  /**
   * The operation id for the '<em>Start And Connect Database</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT___START_AND_CONNECT_DATABASE__IPROGRESSMONITOR = 2;

  /**
   * The operation id for the '<em>Dispose</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT___DISPOSE = 3;

  /**
   * The number of operations of the '<em>Slizaa Project</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT_OPERATION_COUNT = 4;

  /**
   * The meta object id for the '{@link org.slizaa.rcp.workbench.core.model.impl.AbstractUserDefinedTypeImpl <em>Abstract User Defined Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.rcp.workbench.core.model.impl.AbstractUserDefinedTypeImpl
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getAbstractUserDefinedType()
   * @generated
   */
  int ABSTRACT_USER_DEFINED_TYPE = 5;

  /**
   * The feature id for the '<em><b>Project</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_USER_DEFINED_TYPE__PROJECT = 0;

  /**
   * The feature id for the '<em><b>Resource Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_USER_DEFINED_TYPE__RESOURCE_PATH = 1;

  /**
   * The feature id for the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_USER_DEFINED_TYPE__TYPE_NAME = 2;

  /**
   * The number of structural features of the '<em>Abstract User Defined Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_USER_DEFINED_TYPE_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>Abstract User Defined Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_USER_DEFINED_TYPE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationModelImpl <em>Slizaa Project Configuration Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationModelImpl
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getSlizaaProjectConfigurationModel()
   * @generated
   */
  int SLIZAA_PROJECT_CONFIGURATION_MODEL = 1;

  /**
   * The feature id for the '<em><b>Project</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT_CONFIGURATION_MODEL__PROJECT = ABSTRACT_USER_DEFINED_TYPE__PROJECT;

  /**
   * The feature id for the '<em><b>Resource Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT_CONFIGURATION_MODEL__RESOURCE_PATH = ABSTRACT_USER_DEFINED_TYPE__RESOURCE_PATH;

  /**
   * The feature id for the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT_CONFIGURATION_MODEL__TYPE_NAME = ABSTRACT_USER_DEFINED_TYPE__TYPE_NAME;

  /**
   * The feature id for the '<em><b>Problems</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT_CONFIGURATION_MODEL__PROBLEMS = ABSTRACT_USER_DEFINED_TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Configuration Items</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT_CONFIGURATION_MODEL__CONFIGURATION_ITEMS = ABSTRACT_USER_DEFINED_TYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Slizaa Project Configuration Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT_CONFIGURATION_MODEL_FEATURE_COUNT = ABSTRACT_USER_DEFINED_TYPE_FEATURE_COUNT + 2;

  /**
   * The operation id for the '<em>Create New Configuration Item Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT_CONFIGURATION_MODEL___CREATE_NEW_CONFIGURATION_ITEM_INSTANCE__CLASS = ABSTRACT_USER_DEFINED_TYPE_OPERATION_COUNT + 0;

  /**
   * The number of operations of the '<em>Slizaa Project Configuration Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT_CONFIGURATION_MODEL_OPERATION_COUNT = ABSTRACT_USER_DEFINED_TYPE_OPERATION_COUNT + 1;

  /**
   * The meta object id for the '{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationItemModelImpl <em>Slizaa Project Configuration Item Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationItemModelImpl
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getSlizaaProjectConfigurationItemModel()
   * @generated
   */
  int SLIZAA_PROJECT_CONFIGURATION_ITEM_MODEL = 2;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT_CONFIGURATION_ITEM_MODEL__TYPE = 0;

  /**
   * The feature id for the '<em><b>Method Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT_CONFIGURATION_ITEM_MODEL__METHOD_NAME = 1;

  /**
   * The number of structural features of the '<em>Slizaa Project Configuration Item Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT_CONFIGURATION_ITEM_MODEL_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Slizaa Project Configuration Item Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT_CONFIGURATION_ITEM_MODEL_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationProblemImpl <em>Slizaa Project Configuration Problem</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationProblemImpl
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getSlizaaProjectConfigurationProblem()
   * @generated
   */
  int SLIZAA_PROJECT_CONFIGURATION_PROBLEM = 3;

  /**
   * The feature id for the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT_CONFIGURATION_PROBLEM__MESSAGE = 0;

  /**
   * The feature id for the '<em><b>Char Start</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT_CONFIGURATION_PROBLEM__CHAR_START = 1;

  /**
   * The feature id for the '<em><b>Char End</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT_CONFIGURATION_PROBLEM__CHAR_END = 2;

  /**
   * The number of structural features of the '<em>Slizaa Project Configuration Problem</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT_CONFIGURATION_PROBLEM_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>Slizaa Project Configuration Problem</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT_CONFIGURATION_PROBLEM_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectExtensionImpl <em>Slizaa Project Extension</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectExtensionImpl
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getSlizaaProjectExtension()
   * @generated
   */
  int SLIZAA_PROJECT_EXTENSION = 4;

  /**
   * The feature id for the '<em><b>Project</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT_EXTENSION__PROJECT = ABSTRACT_USER_DEFINED_TYPE__PROJECT;

  /**
   * The feature id for the '<em><b>Resource Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT_EXTENSION__RESOURCE_PATH = ABSTRACT_USER_DEFINED_TYPE__RESOURCE_PATH;

  /**
   * The feature id for the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT_EXTENSION__TYPE_NAME = ABSTRACT_USER_DEFINED_TYPE__TYPE_NAME;

  /**
   * The feature id for the '<em><b>Extension Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT_EXTENSION__EXTENSION_TYPE = ABSTRACT_USER_DEFINED_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Slizaa Project Extension</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT_EXTENSION_FEATURE_COUNT = ABSTRACT_USER_DEFINED_TYPE_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Create New Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT_EXTENSION___CREATE_NEW_INSTANCE__CLASS = ABSTRACT_USER_DEFINED_TYPE_OPERATION_COUNT + 0;

  /**
   * The number of operations of the '<em>Slizaa Project Extension</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SLIZAA_PROJECT_EXTENSION_OPERATION_COUNT = ABSTRACT_USER_DEFINED_TYPE_OPERATION_COUNT + 1;

  /**
   * The meta object id for the '<em>IProgress Monitor</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.core.runtime.IProgressMonitor
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getIProgressMonitor()
   * @generated
   */
  int IPROGRESS_MONITOR = 6;

  /**
   * The meta object id for the '<em>IProject</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.core.resources.IProject
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getIProject()
   * @generated
   */
  int IPROJECT = 7;

  /**
   * The meta object id for the '<em>IGraph Db</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.scanner.core.api.graphdb.IGraphDb
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getIGraphDb()
   * @generated
   */
  int IGRAPH_DB = 8;


  /**
   * Returns the meta object for class '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject <em>Slizaa Project</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Slizaa Project</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject
   * @generated
   */
  EClass getSlizaaProject();

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#getProject <em>Project</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Project</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject#getProject()
   * @see #getSlizaaProject()
   * @generated
   */
  EAttribute getSlizaaProject_Project();

  /**
   * Returns the meta object for the reference '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#getConfiguration <em>Configuration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Configuration</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject#getConfiguration()
   * @see #getSlizaaProject()
   * @generated
   */
  EReference getSlizaaProject_Configuration();

  /**
   * Returns the meta object for the reference list '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#getProjectExtensions <em>Project Extensions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Project Extensions</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject#getProjectExtensions()
   * @see #getSlizaaProject()
   * @generated
   */
  EReference getSlizaaProject_ProjectExtensions();

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#getGraphDatabaseInstance <em>Graph Database Instance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Graph Database Instance</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject#getGraphDatabaseInstance()
   * @see #getSlizaaProject()
   * @generated
   */
  EAttribute getSlizaaProject_GraphDatabaseInstance();

  /**
   * Returns the meta object for the reference '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#getBoltClient <em>Bolt Client</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Bolt Client</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject#getBoltClient()
   * @see #getSlizaaProject()
   * @generated
   */
  EReference getSlizaaProject_BoltClient();

  /**
   * Returns the meta object for the reference '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#getHierachicalGraph <em>Hierachical Graph</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Hierachical Graph</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject#getHierachicalGraph()
   * @see #getSlizaaProject()
   * @generated
   */
  EReference getSlizaaProject_HierachicalGraph();

  /**
   * Returns the meta object for the '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#cleanBuild() <em>Clean Build</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Clean Build</em>' operation.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject#cleanBuild()
   * @generated
   */
  EOperation getSlizaaProject__CleanBuild();

  /**
   * Returns the meta object for the '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#parse(org.eclipse.core.runtime.IProgressMonitor) <em>Parse</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Parse</em>' operation.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject#parse(org.eclipse.core.runtime.IProgressMonitor)
   * @generated
   */
  EOperation getSlizaaProject__Parse__IProgressMonitor();

  /**
   * Returns the meta object for the '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#startAndConnectDatabase(org.eclipse.core.runtime.IProgressMonitor) <em>Start And Connect Database</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Start And Connect Database</em>' operation.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject#startAndConnectDatabase(org.eclipse.core.runtime.IProgressMonitor)
   * @generated
   */
  EOperation getSlizaaProject__StartAndConnectDatabase__IProgressMonitor();

  /**
   * Returns the meta object for the '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#dispose() <em>Dispose</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Dispose</em>' operation.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject#dispose()
   * @generated
   */
  EOperation getSlizaaProject__Dispose();

  /**
   * Returns the meta object for class '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel <em>Slizaa Project Configuration Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Slizaa Project Configuration Model</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel
   * @generated
   */
  EClass getSlizaaProjectConfigurationModel();

  /**
   * Returns the meta object for the reference list '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel#getProblems <em>Problems</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Problems</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel#getProblems()
   * @see #getSlizaaProjectConfigurationModel()
   * @generated
   */
  EReference getSlizaaProjectConfigurationModel_Problems();

  /**
   * Returns the meta object for the reference list '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel#getConfigurationItems <em>Configuration Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Configuration Items</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel#getConfigurationItems()
   * @see #getSlizaaProjectConfigurationModel()
   * @generated
   */
  EReference getSlizaaProjectConfigurationModel_ConfigurationItems();

  /**
   * Returns the meta object for the '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel#createNewConfigurationItemInstance(java.lang.Class) <em>Create New Configuration Item Instance</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Create New Configuration Item Instance</em>' operation.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel#createNewConfigurationItemInstance(java.lang.Class)
   * @generated
   */
  EOperation getSlizaaProjectConfigurationModel__CreateNewConfigurationItemInstance__Class();

  /**
   * Returns the meta object for class '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationItemModel <em>Slizaa Project Configuration Item Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Slizaa Project Configuration Item Model</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationItemModel
   * @generated
   */
  EClass getSlizaaProjectConfigurationItemModel();

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationItemModel#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationItemModel#getType()
   * @see #getSlizaaProjectConfigurationItemModel()
   * @generated
   */
  EAttribute getSlizaaProjectConfigurationItemModel_Type();

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationItemModel#getMethodName <em>Method Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Method Name</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationItemModel#getMethodName()
   * @see #getSlizaaProjectConfigurationItemModel()
   * @generated
   */
  EAttribute getSlizaaProjectConfigurationItemModel_MethodName();

  /**
   * Returns the meta object for class '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationProblem <em>Slizaa Project Configuration Problem</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Slizaa Project Configuration Problem</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationProblem
   * @generated
   */
  EClass getSlizaaProjectConfigurationProblem();

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationProblem#getMessage <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationProblem#getMessage()
   * @see #getSlizaaProjectConfigurationProblem()
   * @generated
   */
  EAttribute getSlizaaProjectConfigurationProblem_Message();

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationProblem#getCharStart <em>Char Start</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Char Start</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationProblem#getCharStart()
   * @see #getSlizaaProjectConfigurationProblem()
   * @generated
   */
  EAttribute getSlizaaProjectConfigurationProblem_CharStart();

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationProblem#getCharEnd <em>Char End</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Char End</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationProblem#getCharEnd()
   * @see #getSlizaaProjectConfigurationProblem()
   * @generated
   */
  EAttribute getSlizaaProjectConfigurationProblem_CharEnd();

  /**
   * Returns the meta object for class '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension <em>Slizaa Project Extension</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Slizaa Project Extension</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension
   * @generated
   */
  EClass getSlizaaProjectExtension();

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension#getExtensionType <em>Extension Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Extension Type</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension#getExtensionType()
   * @see #getSlizaaProjectExtension()
   * @generated
   */
  EAttribute getSlizaaProjectExtension_ExtensionType();

  /**
   * Returns the meta object for the '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension#createNewInstance(java.lang.Class) <em>Create New Instance</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Create New Instance</em>' operation.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension#createNewInstance(java.lang.Class)
   * @generated
   */
  EOperation getSlizaaProjectExtension__CreateNewInstance__Class();

  /**
   * Returns the meta object for class '{@link org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType <em>Abstract User Defined Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract User Defined Type</em>'.
   * @see org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType
   * @generated
   */
  EClass getAbstractUserDefinedType();

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType#getProject <em>Project</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Project</em>'.
   * @see org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType#getProject()
   * @see #getAbstractUserDefinedType()
   * @generated
   */
  EAttribute getAbstractUserDefinedType_Project();

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType#getResourcePath <em>Resource Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Resource Path</em>'.
   * @see org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType#getResourcePath()
   * @see #getAbstractUserDefinedType()
   * @generated
   */
  EAttribute getAbstractUserDefinedType_ResourcePath();

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType#getTypeName <em>Type Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Name</em>'.
   * @see org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType#getTypeName()
   * @see #getAbstractUserDefinedType()
   * @generated
   */
  EAttribute getAbstractUserDefinedType_TypeName();

  /**
   * Returns the meta object for data type '{@link org.eclipse.core.runtime.IProgressMonitor <em>IProgress Monitor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>IProgress Monitor</em>'.
   * @see org.eclipse.core.runtime.IProgressMonitor
   * @model instanceClass="org.eclipse.core.runtime.IProgressMonitor" serializeable="false"
   * @generated
   */
  EDataType getIProgressMonitor();

  /**
   * Returns the meta object for data type '{@link org.eclipse.core.resources.IProject <em>IProject</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>IProject</em>'.
   * @see org.eclipse.core.resources.IProject
   * @model instanceClass="org.eclipse.core.resources.IProject" serializeable="false"
   * @generated
   */
  EDataType getIProject();

  /**
   * Returns the meta object for data type '{@link org.slizaa.scanner.core.api.graphdb.IGraphDb <em>IGraph Db</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>IGraph Db</em>'.
   * @see org.slizaa.scanner.core.api.graphdb.IGraphDb
   * @model instanceClass="org.slizaa.scanner.core.api.graphdb.IGraphDb" serializeable="false"
   * @generated
   */
  EDataType getIGraphDb();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ModelFactory getModelFactory();

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
  interface Literals {
    /**
     * The meta object literal for the '{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectImpl <em>Slizaa Project</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectImpl
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getSlizaaProject()
     * @generated
     */
    EClass SLIZAA_PROJECT = eINSTANCE.getSlizaaProject();

    /**
     * The meta object literal for the '<em><b>Project</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SLIZAA_PROJECT__PROJECT = eINSTANCE.getSlizaaProject_Project();

    /**
     * The meta object literal for the '<em><b>Configuration</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SLIZAA_PROJECT__CONFIGURATION = eINSTANCE.getSlizaaProject_Configuration();

    /**
     * The meta object literal for the '<em><b>Project Extensions</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SLIZAA_PROJECT__PROJECT_EXTENSIONS = eINSTANCE.getSlizaaProject_ProjectExtensions();

    /**
     * The meta object literal for the '<em><b>Graph Database Instance</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SLIZAA_PROJECT__GRAPH_DATABASE_INSTANCE = eINSTANCE.getSlizaaProject_GraphDatabaseInstance();

    /**
     * The meta object literal for the '<em><b>Bolt Client</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SLIZAA_PROJECT__BOLT_CLIENT = eINSTANCE.getSlizaaProject_BoltClient();

    /**
     * The meta object literal for the '<em><b>Hierachical Graph</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SLIZAA_PROJECT__HIERACHICAL_GRAPH = eINSTANCE.getSlizaaProject_HierachicalGraph();

    /**
     * The meta object literal for the '<em><b>Clean Build</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation SLIZAA_PROJECT___CLEAN_BUILD = eINSTANCE.getSlizaaProject__CleanBuild();

    /**
     * The meta object literal for the '<em><b>Parse</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation SLIZAA_PROJECT___PARSE__IPROGRESSMONITOR = eINSTANCE.getSlizaaProject__Parse__IProgressMonitor();

    /**
     * The meta object literal for the '<em><b>Start And Connect Database</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation SLIZAA_PROJECT___START_AND_CONNECT_DATABASE__IPROGRESSMONITOR = eINSTANCE.getSlizaaProject__StartAndConnectDatabase__IProgressMonitor();

    /**
     * The meta object literal for the '<em><b>Dispose</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation SLIZAA_PROJECT___DISPOSE = eINSTANCE.getSlizaaProject__Dispose();

    /**
     * The meta object literal for the '{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationModelImpl <em>Slizaa Project Configuration Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationModelImpl
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getSlizaaProjectConfigurationModel()
     * @generated
     */
    EClass SLIZAA_PROJECT_CONFIGURATION_MODEL = eINSTANCE.getSlizaaProjectConfigurationModel();

    /**
     * The meta object literal for the '<em><b>Problems</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SLIZAA_PROJECT_CONFIGURATION_MODEL__PROBLEMS = eINSTANCE.getSlizaaProjectConfigurationModel_Problems();

    /**
     * The meta object literal for the '<em><b>Configuration Items</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SLIZAA_PROJECT_CONFIGURATION_MODEL__CONFIGURATION_ITEMS = eINSTANCE.getSlizaaProjectConfigurationModel_ConfigurationItems();

    /**
     * The meta object literal for the '<em><b>Create New Configuration Item Instance</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation SLIZAA_PROJECT_CONFIGURATION_MODEL___CREATE_NEW_CONFIGURATION_ITEM_INSTANCE__CLASS = eINSTANCE.getSlizaaProjectConfigurationModel__CreateNewConfigurationItemInstance__Class();

    /**
     * The meta object literal for the '{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationItemModelImpl <em>Slizaa Project Configuration Item Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationItemModelImpl
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getSlizaaProjectConfigurationItemModel()
     * @generated
     */
    EClass SLIZAA_PROJECT_CONFIGURATION_ITEM_MODEL = eINSTANCE.getSlizaaProjectConfigurationItemModel();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SLIZAA_PROJECT_CONFIGURATION_ITEM_MODEL__TYPE = eINSTANCE.getSlizaaProjectConfigurationItemModel_Type();

    /**
     * The meta object literal for the '<em><b>Method Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SLIZAA_PROJECT_CONFIGURATION_ITEM_MODEL__METHOD_NAME = eINSTANCE.getSlizaaProjectConfigurationItemModel_MethodName();

    /**
     * The meta object literal for the '{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationProblemImpl <em>Slizaa Project Configuration Problem</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationProblemImpl
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getSlizaaProjectConfigurationProblem()
     * @generated
     */
    EClass SLIZAA_PROJECT_CONFIGURATION_PROBLEM = eINSTANCE.getSlizaaProjectConfigurationProblem();

    /**
     * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SLIZAA_PROJECT_CONFIGURATION_PROBLEM__MESSAGE = eINSTANCE.getSlizaaProjectConfigurationProblem_Message();

    /**
     * The meta object literal for the '<em><b>Char Start</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SLIZAA_PROJECT_CONFIGURATION_PROBLEM__CHAR_START = eINSTANCE.getSlizaaProjectConfigurationProblem_CharStart();

    /**
     * The meta object literal for the '<em><b>Char End</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SLIZAA_PROJECT_CONFIGURATION_PROBLEM__CHAR_END = eINSTANCE.getSlizaaProjectConfigurationProblem_CharEnd();

    /**
     * The meta object literal for the '{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectExtensionImpl <em>Slizaa Project Extension</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectExtensionImpl
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getSlizaaProjectExtension()
     * @generated
     */
    EClass SLIZAA_PROJECT_EXTENSION = eINSTANCE.getSlizaaProjectExtension();

    /**
     * The meta object literal for the '<em><b>Extension Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SLIZAA_PROJECT_EXTENSION__EXTENSION_TYPE = eINSTANCE.getSlizaaProjectExtension_ExtensionType();

    /**
     * The meta object literal for the '<em><b>Create New Instance</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation SLIZAA_PROJECT_EXTENSION___CREATE_NEW_INSTANCE__CLASS = eINSTANCE.getSlizaaProjectExtension__CreateNewInstance__Class();

    /**
     * The meta object literal for the '{@link org.slizaa.rcp.workbench.core.model.impl.AbstractUserDefinedTypeImpl <em>Abstract User Defined Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.slizaa.rcp.workbench.core.model.impl.AbstractUserDefinedTypeImpl
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getAbstractUserDefinedType()
     * @generated
     */
    EClass ABSTRACT_USER_DEFINED_TYPE = eINSTANCE.getAbstractUserDefinedType();

    /**
     * The meta object literal for the '<em><b>Project</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_USER_DEFINED_TYPE__PROJECT = eINSTANCE.getAbstractUserDefinedType_Project();

    /**
     * The meta object literal for the '<em><b>Resource Path</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_USER_DEFINED_TYPE__RESOURCE_PATH = eINSTANCE.getAbstractUserDefinedType_ResourcePath();

    /**
     * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_USER_DEFINED_TYPE__TYPE_NAME = eINSTANCE.getAbstractUserDefinedType_TypeName();

    /**
     * The meta object literal for the '<em>IProgress Monitor</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.core.runtime.IProgressMonitor
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getIProgressMonitor()
     * @generated
     */
    EDataType IPROGRESS_MONITOR = eINSTANCE.getIProgressMonitor();

    /**
     * The meta object literal for the '<em>IProject</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.core.resources.IProject
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getIProject()
     * @generated
     */
    EDataType IPROJECT = eINSTANCE.getIProject();

    /**
     * The meta object literal for the '<em>IGraph Db</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.slizaa.scanner.core.api.graphdb.IGraphDb
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getIGraphDb()
     * @generated
     */
    EDataType IGRAPH_DB = eINSTANCE.getIGraphDb();

  }

} //ModelPackage
