/**
 */
package org.slizaa.rcp.workbench.core.model.impl;

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

import org.slizaa.hierarchicalgraph.HierarchicalgraphPackage;

import org.slizaa.neo4j.dbadapter.DbAdapterPackage;

import org.slizaa.neo4j.hierarchicalgraph.mapping.spi.IMappingProvider;
import org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType;
import org.slizaa.rcp.workbench.core.model.ModelFactory;
import org.slizaa.rcp.workbench.core.model.SlizaaExtensionBundle;
import org.slizaa.rcp.workbench.core.model.SlizaaExtensionBundleExtension;
import org.slizaa.rcp.workbench.core.model.SlizaaProject;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationItemModel;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationProblem;
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
   * The feature id for the '<em><b>Bolt Client</b></em>' reference.
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
   * The number of operations of the '<em>Slizaa Project</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_OPERATION_COUNT = 5;

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
   * The feature id for the '<em><b>Configuration Items</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_CONFIGURATION_MODEL__CONFIGURATION_ITEMS = ABSTRACT_USER_DEFINED_TYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Slizaa Project Configuration Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_CONFIGURATION_MODEL_FEATURE_COUNT = ABSTRACT_USER_DEFINED_TYPE_FEATURE_COUNT + 2;

  /**
   * The operation id for the '<em>Create New Configuration Item Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_CONFIGURATION_MODEL___CREATE_NEW_CONFIGURATION_ITEM_INSTANCE__CLASS = ABSTRACT_USER_DEFINED_TYPE_OPERATION_COUNT + 0;

  /**
   * The number of operations of the '<em>Slizaa Project Configuration Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_CONFIGURATION_MODEL_OPERATION_COUNT = ABSTRACT_USER_DEFINED_TYPE_OPERATION_COUNT + 1;

  /**
   * The meta object id for the '{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationItemModelImpl <em>Slizaa Project Configuration Item Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationItemModelImpl
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getSlizaaProjectConfigurationItemModel()
   * @generated
   */
  public static final int SLIZAA_PROJECT_CONFIGURATION_ITEM_MODEL = 3;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_CONFIGURATION_ITEM_MODEL__TYPE = 0;

  /**
   * The feature id for the '<em><b>Method Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_CONFIGURATION_ITEM_MODEL__METHOD_NAME = 1;

  /**
   * The number of structural features of the '<em>Slizaa Project Configuration Item Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_CONFIGURATION_ITEM_MODEL_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Slizaa Project Configuration Item Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_CONFIGURATION_ITEM_MODEL_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationProblemImpl <em>Slizaa Project Configuration Problem</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationProblemImpl
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getSlizaaProjectConfigurationProblem()
   * @generated
   */
  public static final int SLIZAA_PROJECT_CONFIGURATION_PROBLEM = 4;

  /**
   * The feature id for the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_CONFIGURATION_PROBLEM__MESSAGE = 0;

  /**
   * The feature id for the '<em><b>Char Start</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_CONFIGURATION_PROBLEM__CHAR_START = 1;

  /**
   * The feature id for the '<em><b>Char End</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_CONFIGURATION_PROBLEM__CHAR_END = 2;

  /**
   * The number of structural features of the '<em>Slizaa Project Configuration Problem</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_CONFIGURATION_PROBLEM_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>Slizaa Project Configuration Problem</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_PROJECT_CONFIGURATION_PROBLEM_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectExtensionImpl <em>Slizaa Project Extension</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectExtensionImpl
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getSlizaaProjectExtension()
   * @generated
   */
  public static final int SLIZAA_PROJECT_EXTENSION = 5;

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
   * The meta object id for the '{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaExtensionBundleImpl <em>Slizaa Extension Bundle</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.rcp.workbench.core.model.impl.SlizaaExtensionBundleImpl
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getSlizaaExtensionBundle()
   * @generated
   */
  public static final int SLIZAA_EXTENSION_BUNDLE = 6;

  /**
   * The feature id for the '<em><b>Defined Extensions</b></em>' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_EXTENSION_BUNDLE__DEFINED_EXTENSIONS = 0;

  /**
   * The feature id for the '<em><b>Defined Cypher Statements</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_EXTENSION_BUNDLE__DEFINED_CYPHER_STATEMENTS = 1;

  /**
   * The number of structural features of the '<em>Slizaa Extension Bundle</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_EXTENSION_BUNDLE_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Slizaa Extension Bundle</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_EXTENSION_BUNDLE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaExtensionBundleExtensionImpl <em>Slizaa Extension Bundle Extension</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.rcp.workbench.core.model.impl.SlizaaExtensionBundleExtensionImpl
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getSlizaaExtensionBundleExtension()
   * @generated
   */
  public static final int SLIZAA_EXTENSION_BUNDLE_EXTENSION = 7;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_EXTENSION_BUNDLE_EXTENSION__TYPE = 0;

  /**
   * The feature id for the '<em><b>Annotation Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_EXTENSION_BUNDLE_EXTENSION__ANNOTATION_TYPE = 1;

  /**
   * The number of structural features of the '<em>Slizaa Extension Bundle Extension</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_EXTENSION_BUNDLE_EXTENSION_FEATURE_COUNT = 2;

  /**
   * The operation id for the '<em>Create New Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_EXTENSION_BUNDLE_EXTENSION___CREATE_NEW_INSTANCE__CLASS = 0;

  /**
   * The number of operations of the '<em>Slizaa Extension Bundle Extension</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int SLIZAA_EXTENSION_BUNDLE_EXTENSION_OPERATION_COUNT = 1;

  /**
   * The meta object id for the '{@link org.slizaa.rcp.workbench.core.model.impl.AnnotationTypeToSlizaaProjectExtensionMapImpl <em>Annotation Type To Slizaa Project Extension Map</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.rcp.workbench.core.model.impl.AnnotationTypeToSlizaaProjectExtensionMapImpl
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getAnnotationTypeToSlizaaProjectExtensionMap()
   * @generated
   */
  public static final int ANNOTATION_TYPE_TO_SLIZAA_PROJECT_EXTENSION_MAP = 8;

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
   * The meta object id for the '{@link org.slizaa.rcp.workbench.core.model.impl.AnnotationTypeToSlizaaBundleExtensionMapImpl <em>Annotation Type To Slizaa Bundle Extension Map</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.rcp.workbench.core.model.impl.AnnotationTypeToSlizaaBundleExtensionMapImpl
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getAnnotationTypeToSlizaaBundleExtensionMap()
   * @generated
   */
  public static final int ANNOTATION_TYPE_TO_SLIZAA_BUNDLE_EXTENSION_MAP = 9;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int ANNOTATION_TYPE_TO_SLIZAA_BUNDLE_EXTENSION_MAP__KEY = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int ANNOTATION_TYPE_TO_SLIZAA_BUNDLE_EXTENSION_MAP__VALUE = 1;

  /**
   * The number of structural features of the '<em>Annotation Type To Slizaa Bundle Extension Map</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int ANNOTATION_TYPE_TO_SLIZAA_BUNDLE_EXTENSION_MAP_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Annotation Type To Slizaa Bundle Extension Map</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  public static final int ANNOTATION_TYPE_TO_SLIZAA_BUNDLE_EXTENSION_MAP_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '<em>IProgress Monitor</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.core.runtime.IProgressMonitor
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getIProgressMonitor()
   * @generated
   */
  public static final int IPROGRESS_MONITOR = 10;

  /**
   * The meta object id for the '<em>IProject</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.core.resources.IProject
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getIProject()
   * @generated
   */
  public static final int IPROJECT = 11;

  /**
   * The meta object id for the '<em>IGraph Db</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.scanner.core.api.graphdb.IGraphDb
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getIGraphDb()
   * @generated
   */
  public static final int IGRAPH_DB = 12;

  /**
   * The meta object id for the '<em>ICypher Statement</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.scanner.core.api.cypherregistry.ICypherStatement
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getICypherStatement()
   * @generated
   */
  public static final int ICYPHER_STATEMENT = 13;

  /**
   * The meta object id for the '<em>IMapping Provider</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.slizaa.neo4j.hierarchicalgraph.mapping.spi.IMappingProvider
   * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getIMappingProvider()
   * @generated
   */
  public static final int IMAPPING_PROVIDER = 14;

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
  private EClass slizaaProjectConfigurationItemModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass slizaaProjectConfigurationProblemEClass = null;

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
  private EClass slizaaExtensionBundleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass slizaaExtensionBundleExtensionEClass = null;

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
  private EClass annotationTypeToSlizaaBundleExtensionMapEClass = null;

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
    HierarchicalgraphPackage.eINSTANCE.eClass();
    DbAdapterPackage.eINSTANCE.eClass();

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
   * Returns the meta object for the reference '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#getBoltClient <em>Bolt Client</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Bolt Client</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject#getBoltClient()
   * @see #getSlizaaProject()
   * @generated
   */
  public EReference getSlizaaProject_BoltClient() {
    return (EReference)slizaaProjectEClass.getEStructuralFeatures().get(5);
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
   * Returns the meta object for the '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#mapToHierachicalGraph(org.slizaa.neo4j.hierarchicalgraph.mapping.spi.IMappingProvider, org.eclipse.core.runtime.IProgressMonitor) <em>Map To Hierachical Graph</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Map To Hierachical Graph</em>' operation.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject#mapToHierachicalGraph(org.slizaa.neo4j.hierarchicalgraph.mapping.spi.IMappingProvider, org.eclipse.core.runtime.IProgressMonitor)
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
   * Returns the meta object for the reference list '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel#getConfigurationItems <em>Configuration Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Configuration Items</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel#getConfigurationItems()
   * @see #getSlizaaProjectConfigurationModel()
   * @generated
   */
  public EReference getSlizaaProjectConfigurationModel_ConfigurationItems() {
    return (EReference)slizaaProjectConfigurationModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * Returns the meta object for the '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel#createNewConfigurationItemInstance(java.lang.Class) <em>Create New Configuration Item Instance</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Create New Configuration Item Instance</em>' operation.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel#createNewConfigurationItemInstance(java.lang.Class)
   * @generated
   */
  public EOperation getSlizaaProjectConfigurationModel__CreateNewConfigurationItemInstance__Class() {
    return slizaaProjectConfigurationModelEClass.getEOperations().get(0);
  }

  /**
   * Returns the meta object for class '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationItemModel <em>Slizaa Project Configuration Item Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Slizaa Project Configuration Item Model</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationItemModel
   * @generated
   */
  public EClass getSlizaaProjectConfigurationItemModel() {
    return slizaaProjectConfigurationItemModelEClass;
  }

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationItemModel#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationItemModel#getType()
   * @see #getSlizaaProjectConfigurationItemModel()
   * @generated
   */
  public EAttribute getSlizaaProjectConfigurationItemModel_Type() {
    return (EAttribute)slizaaProjectConfigurationItemModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationItemModel#getMethodName <em>Method Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Method Name</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationItemModel#getMethodName()
   * @see #getSlizaaProjectConfigurationItemModel()
   * @generated
   */
  public EAttribute getSlizaaProjectConfigurationItemModel_MethodName() {
    return (EAttribute)slizaaProjectConfigurationItemModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * Returns the meta object for class '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationProblem <em>Slizaa Project Configuration Problem</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Slizaa Project Configuration Problem</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationProblem
   * @generated
   */
  public EClass getSlizaaProjectConfigurationProblem() {
    return slizaaProjectConfigurationProblemEClass;
  }

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationProblem#getMessage <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationProblem#getMessage()
   * @see #getSlizaaProjectConfigurationProblem()
   * @generated
   */
  public EAttribute getSlizaaProjectConfigurationProblem_Message() {
    return (EAttribute)slizaaProjectConfigurationProblemEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationProblem#getCharStart <em>Char Start</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Char Start</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationProblem#getCharStart()
   * @see #getSlizaaProjectConfigurationProblem()
   * @generated
   */
  public EAttribute getSlizaaProjectConfigurationProblem_CharStart() {
    return (EAttribute)slizaaProjectConfigurationProblemEClass.getEStructuralFeatures().get(1);
  }

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationProblem#getCharEnd <em>Char End</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Char End</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationProblem#getCharEnd()
   * @see #getSlizaaProjectConfigurationProblem()
   * @generated
   */
  public EAttribute getSlizaaProjectConfigurationProblem_CharEnd() {
    return (EAttribute)slizaaProjectConfigurationProblemEClass.getEStructuralFeatures().get(2);
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
   * Returns the meta object for class '{@link org.slizaa.rcp.workbench.core.model.SlizaaExtensionBundle <em>Slizaa Extension Bundle</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Slizaa Extension Bundle</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaExtensionBundle
   * @generated
   */
  public EClass getSlizaaExtensionBundle() {
    return slizaaExtensionBundleEClass;
  }

  /**
   * Returns the meta object for the map '{@link org.slizaa.rcp.workbench.core.model.SlizaaExtensionBundle#getDefinedExtensions <em>Defined Extensions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the map '<em>Defined Extensions</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaExtensionBundle#getDefinedExtensions()
   * @see #getSlizaaExtensionBundle()
   * @generated
   */
  public EReference getSlizaaExtensionBundle_DefinedExtensions() {
    return (EReference)slizaaExtensionBundleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for the attribute list '{@link org.slizaa.rcp.workbench.core.model.SlizaaExtensionBundle#getDefinedCypherStatements <em>Defined Cypher Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Defined Cypher Statements</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaExtensionBundle#getDefinedCypherStatements()
   * @see #getSlizaaExtensionBundle()
   * @generated
   */
  public EAttribute getSlizaaExtensionBundle_DefinedCypherStatements() {
    return (EAttribute)slizaaExtensionBundleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * Returns the meta object for class '{@link org.slizaa.rcp.workbench.core.model.SlizaaExtensionBundleExtension <em>Slizaa Extension Bundle Extension</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Slizaa Extension Bundle Extension</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaExtensionBundleExtension
   * @generated
   */
  public EClass getSlizaaExtensionBundleExtension() {
    return slizaaExtensionBundleExtensionEClass;
  }

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.SlizaaExtensionBundleExtension#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaExtensionBundleExtension#getType()
   * @see #getSlizaaExtensionBundleExtension()
   * @generated
   */
  public EAttribute getSlizaaExtensionBundleExtension_Type() {
    return (EAttribute)slizaaExtensionBundleExtensionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for the attribute '{@link org.slizaa.rcp.workbench.core.model.SlizaaExtensionBundleExtension#getAnnotationType <em>Annotation Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Annotation Type</em>'.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaExtensionBundleExtension#getAnnotationType()
   * @see #getSlizaaExtensionBundleExtension()
   * @generated
   */
  public EAttribute getSlizaaExtensionBundleExtension_AnnotationType() {
    return (EAttribute)slizaaExtensionBundleExtensionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * Returns the meta object for the '{@link org.slizaa.rcp.workbench.core.model.SlizaaExtensionBundleExtension#createNewInstance(java.lang.Class) <em>Create New Instance</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Create New Instance</em>' operation.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaExtensionBundleExtension#createNewInstance(java.lang.Class)
   * @generated
   */
  public EOperation getSlizaaExtensionBundleExtension__CreateNewInstance__Class() {
    return slizaaExtensionBundleExtensionEClass.getEOperations().get(0);
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
   * Returns the meta object for class '{@link java.util.Map.Entry <em>Annotation Type To Slizaa Bundle Extension Map</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Annotation Type To Slizaa Bundle Extension Map</em>'.
   * @see java.util.Map.Entry
   * @generated
   */
  public EClass getAnnotationTypeToSlizaaBundleExtensionMap() {
    return annotationTypeToSlizaaBundleExtensionMapEClass;
  }

  /**
   * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Key</em>'.
   * @see java.util.Map.Entry
   * @see #getAnnotationTypeToSlizaaBundleExtensionMap()
   * @generated
   */
  public EAttribute getAnnotationTypeToSlizaaBundleExtensionMap_Key() {
    return (EAttribute)annotationTypeToSlizaaBundleExtensionMapEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for the reference list '{@link java.util.Map.Entry <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Value</em>'.
   * @see java.util.Map.Entry
   * @see #getAnnotationTypeToSlizaaBundleExtensionMap()
   * @generated
   */
  public EReference getAnnotationTypeToSlizaaBundleExtensionMap_Value() {
    return (EReference)annotationTypeToSlizaaBundleExtensionMapEClass.getEStructuralFeatures().get(1);
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
   * Returns the meta object for data type '{@link org.slizaa.neo4j.hierarchicalgraph.mapping.spi.IMappingProvider <em>IMapping Provider</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>IMapping Provider</em>'.
   * @see org.slizaa.neo4j.hierarchicalgraph.mapping.spi.IMappingProvider
   * @generated
   */
  public EDataType getIMappingProvider() {
    return iMappingProviderEDataType;
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
    createEReference(slizaaProjectEClass, SLIZAA_PROJECT__BOLT_CLIENT);
    createEReference(slizaaProjectEClass, SLIZAA_PROJECT__HIERACHICAL_GRAPH);
    createEOperation(slizaaProjectEClass, SLIZAA_PROJECT___CLEAN_BUILD);
    createEOperation(slizaaProjectEClass, SLIZAA_PROJECT___PARSE__IPROGRESSMONITOR);
    createEOperation(slizaaProjectEClass, SLIZAA_PROJECT___START_AND_CONNECT_DATABASE__IPROGRESSMONITOR);
    createEOperation(slizaaProjectEClass, SLIZAA_PROJECT___MAP_TO_HIERACHICAL_GRAPH__IMAPPINGPROVIDER_IPROGRESSMONITOR);
    createEOperation(slizaaProjectEClass, SLIZAA_PROJECT___DISPOSE);

    abstractUserDefinedTypeEClass = createEClass(ABSTRACT_USER_DEFINED_TYPE);
    createEAttribute(abstractUserDefinedTypeEClass, ABSTRACT_USER_DEFINED_TYPE__PROJECT);
    createEAttribute(abstractUserDefinedTypeEClass, ABSTRACT_USER_DEFINED_TYPE__RESOURCE_PATH);
    createEAttribute(abstractUserDefinedTypeEClass, ABSTRACT_USER_DEFINED_TYPE__TYPE_NAME);

    slizaaProjectConfigurationModelEClass = createEClass(SLIZAA_PROJECT_CONFIGURATION_MODEL);
    createEReference(slizaaProjectConfigurationModelEClass, SLIZAA_PROJECT_CONFIGURATION_MODEL__PROBLEMS);
    createEReference(slizaaProjectConfigurationModelEClass, SLIZAA_PROJECT_CONFIGURATION_MODEL__CONFIGURATION_ITEMS);
    createEOperation(slizaaProjectConfigurationModelEClass, SLIZAA_PROJECT_CONFIGURATION_MODEL___CREATE_NEW_CONFIGURATION_ITEM_INSTANCE__CLASS);

    slizaaProjectConfigurationItemModelEClass = createEClass(SLIZAA_PROJECT_CONFIGURATION_ITEM_MODEL);
    createEAttribute(slizaaProjectConfigurationItemModelEClass, SLIZAA_PROJECT_CONFIGURATION_ITEM_MODEL__TYPE);
    createEAttribute(slizaaProjectConfigurationItemModelEClass, SLIZAA_PROJECT_CONFIGURATION_ITEM_MODEL__METHOD_NAME);

    slizaaProjectConfigurationProblemEClass = createEClass(SLIZAA_PROJECT_CONFIGURATION_PROBLEM);
    createEAttribute(slizaaProjectConfigurationProblemEClass, SLIZAA_PROJECT_CONFIGURATION_PROBLEM__MESSAGE);
    createEAttribute(slizaaProjectConfigurationProblemEClass, SLIZAA_PROJECT_CONFIGURATION_PROBLEM__CHAR_START);
    createEAttribute(slizaaProjectConfigurationProblemEClass, SLIZAA_PROJECT_CONFIGURATION_PROBLEM__CHAR_END);

    slizaaProjectExtensionEClass = createEClass(SLIZAA_PROJECT_EXTENSION);
    createEAttribute(slizaaProjectExtensionEClass, SLIZAA_PROJECT_EXTENSION__ANNOTATION_TYPE);
    createEOperation(slizaaProjectExtensionEClass, SLIZAA_PROJECT_EXTENSION___CREATE_NEW_INSTANCE__CLASS);

    slizaaExtensionBundleEClass = createEClass(SLIZAA_EXTENSION_BUNDLE);
    createEReference(slizaaExtensionBundleEClass, SLIZAA_EXTENSION_BUNDLE__DEFINED_EXTENSIONS);
    createEAttribute(slizaaExtensionBundleEClass, SLIZAA_EXTENSION_BUNDLE__DEFINED_CYPHER_STATEMENTS);

    slizaaExtensionBundleExtensionEClass = createEClass(SLIZAA_EXTENSION_BUNDLE_EXTENSION);
    createEAttribute(slizaaExtensionBundleExtensionEClass, SLIZAA_EXTENSION_BUNDLE_EXTENSION__TYPE);
    createEAttribute(slizaaExtensionBundleExtensionEClass, SLIZAA_EXTENSION_BUNDLE_EXTENSION__ANNOTATION_TYPE);
    createEOperation(slizaaExtensionBundleExtensionEClass, SLIZAA_EXTENSION_BUNDLE_EXTENSION___CREATE_NEW_INSTANCE__CLASS);

    annotationTypeToSlizaaProjectExtensionMapEClass = createEClass(ANNOTATION_TYPE_TO_SLIZAA_PROJECT_EXTENSION_MAP);
    createEAttribute(annotationTypeToSlizaaProjectExtensionMapEClass, ANNOTATION_TYPE_TO_SLIZAA_PROJECT_EXTENSION_MAP__KEY);
    createEReference(annotationTypeToSlizaaProjectExtensionMapEClass, ANNOTATION_TYPE_TO_SLIZAA_PROJECT_EXTENSION_MAP__VALUE);

    annotationTypeToSlizaaBundleExtensionMapEClass = createEClass(ANNOTATION_TYPE_TO_SLIZAA_BUNDLE_EXTENSION_MAP);
    createEAttribute(annotationTypeToSlizaaBundleExtensionMapEClass, ANNOTATION_TYPE_TO_SLIZAA_BUNDLE_EXTENSION_MAP__KEY);
    createEReference(annotationTypeToSlizaaBundleExtensionMapEClass, ANNOTATION_TYPE_TO_SLIZAA_BUNDLE_EXTENSION_MAP__VALUE);

    // Create data types
    iProgressMonitorEDataType = createEDataType(IPROGRESS_MONITOR);
    iProjectEDataType = createEDataType(IPROJECT);
    iGraphDbEDataType = createEDataType(IGRAPH_DB);
    iCypherStatementEDataType = createEDataType(ICYPHER_STATEMENT);
    iMappingProviderEDataType = createEDataType(IMAPPING_PROVIDER);
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
    DbAdapterPackage theDbAdapterPackage = (DbAdapterPackage)EPackage.Registry.INSTANCE.getEPackage(DbAdapterPackage.eNS_URI);
    HierarchicalgraphPackage theHierarchicalgraphPackage = (HierarchicalgraphPackage)EPackage.Registry.INSTANCE.getEPackage(HierarchicalgraphPackage.eNS_URI);

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
    initEReference(getSlizaaProject_BoltClient(), theDbAdapterPackage.getNeo4jClient(), null, "boltClient", null, 0, 1, SlizaaProject.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
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

    initEClass(abstractUserDefinedTypeEClass, AbstractUserDefinedType.class, "AbstractUserDefinedType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAbstractUserDefinedType_Project(), this.getIProject(), "project", null, 0, 1, AbstractUserDefinedType.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAbstractUserDefinedType_ResourcePath(), ecorePackage.getEString(), "resourcePath", null, 0, 1, AbstractUserDefinedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAbstractUserDefinedType_TypeName(), ecorePackage.getEString(), "typeName", null, 0, 1, AbstractUserDefinedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(slizaaProjectConfigurationModelEClass, SlizaaProjectConfigurationModel.class, "SlizaaProjectConfigurationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSlizaaProjectConfigurationModel_Problems(), this.getSlizaaProjectConfigurationProblem(), null, "problems", null, 0, -1, SlizaaProjectConfigurationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSlizaaProjectConfigurationModel_ConfigurationItems(), this.getSlizaaProjectConfigurationItemModel(), null, "configurationItems", null, 0, -1, SlizaaProjectConfigurationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    op = initEOperation(getSlizaaProjectConfigurationModel__CreateNewConfigurationItemInstance__Class(), null, "createNewConfigurationItemInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
    ETypeParameter t1 = addETypeParameter(op, "T");
    EGenericType g1 = createEGenericType(ecorePackage.getEJavaClass());
    EGenericType g2 = createEGenericType(t1);
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "type", 0, 1, IS_UNIQUE, IS_ORDERED);
    g1 = createEGenericType(t1);
    initEOperation(op, g1);

    initEClass(slizaaProjectConfigurationItemModelEClass, SlizaaProjectConfigurationItemModel.class, "SlizaaProjectConfigurationItemModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSlizaaProjectConfigurationItemModel_Type(), ecorePackage.getEString(), "type", null, 0, 1, SlizaaProjectConfigurationItemModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSlizaaProjectConfigurationItemModel_MethodName(), ecorePackage.getEString(), "methodName", null, 0, 1, SlizaaProjectConfigurationItemModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(slizaaProjectConfigurationProblemEClass, SlizaaProjectConfigurationProblem.class, "SlizaaProjectConfigurationProblem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSlizaaProjectConfigurationProblem_Message(), ecorePackage.getEString(), "message", null, 0, 1, SlizaaProjectConfigurationProblem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSlizaaProjectConfigurationProblem_CharStart(), ecorePackage.getEInt(), "charStart", null, 0, 1, SlizaaProjectConfigurationProblem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSlizaaProjectConfigurationProblem_CharEnd(), ecorePackage.getEInt(), "charEnd", null, 0, 1, SlizaaProjectConfigurationProblem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(slizaaProjectExtensionEClass, SlizaaProjectExtension.class, "SlizaaProjectExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    g1 = createEGenericType(ecorePackage.getEJavaClass());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    initEAttribute(getSlizaaProjectExtension_AnnotationType(), g1, "annotationType", null, 0, 1, SlizaaProjectExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    op = initEOperation(getSlizaaProjectExtension__CreateNewInstance__Class(), null, "createNewInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
    t1 = addETypeParameter(op, "T");
    g1 = createEGenericType(ecorePackage.getEJavaClass());
    g2 = createEGenericType(t1);
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "type", 0, 1, IS_UNIQUE, IS_ORDERED);
    g1 = createEGenericType(t1);
    initEOperation(op, g1);

    initEClass(slizaaExtensionBundleEClass, SlizaaExtensionBundle.class, "SlizaaExtensionBundle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSlizaaExtensionBundle_DefinedExtensions(), this.getAnnotationTypeToSlizaaBundleExtensionMap(), null, "definedExtensions", null, 0, -1, SlizaaExtensionBundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSlizaaExtensionBundle_DefinedCypherStatements(), this.getICypherStatement(), "definedCypherStatements", null, 0, -1, SlizaaExtensionBundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(slizaaExtensionBundleExtensionEClass, SlizaaExtensionBundleExtension.class, "SlizaaExtensionBundleExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    g1 = createEGenericType(ecorePackage.getEJavaClass());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    initEAttribute(getSlizaaExtensionBundleExtension_Type(), g1, "type", null, 0, 1, SlizaaExtensionBundleExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    g1 = createEGenericType(ecorePackage.getEJavaClass());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    initEAttribute(getSlizaaExtensionBundleExtension_AnnotationType(), g1, "annotationType", null, 0, 1, SlizaaExtensionBundleExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    op = initEOperation(getSlizaaExtensionBundleExtension__CreateNewInstance__Class(), null, "createNewInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
    t1 = addETypeParameter(op, "T");
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

    initEClass(annotationTypeToSlizaaBundleExtensionMapEClass, Map.Entry.class, "AnnotationTypeToSlizaaBundleExtensionMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
    g1 = createEGenericType(ecorePackage.getEJavaClass());
    g2 = createEGenericType();
    g1.getETypeArguments().add(g2);
    initEAttribute(getAnnotationTypeToSlizaaBundleExtensionMap_Key(), g1, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAnnotationTypeToSlizaaBundleExtensionMap_Value(), this.getSlizaaExtensionBundleExtension(), null, "value", null, 0, -1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize data types
    initEDataType(iProgressMonitorEDataType, IProgressMonitor.class, "IProgressMonitor", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(iProjectEDataType, IProject.class, "IProject", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(iGraphDbEDataType, IGraphDb.class, "IGraphDb", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(iCypherStatementEDataType, ICypherStatement.class, "ICypherStatement", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(iMappingProviderEDataType, IMappingProvider.class, "IMappingProvider", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

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
     * The meta object literal for the '<em><b>Bolt Client</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference SLIZAA_PROJECT__BOLT_CLIENT = eINSTANCE.getSlizaaProject_BoltClient();

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
     * The meta object literal for the '<em><b>Configuration Items</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference SLIZAA_PROJECT_CONFIGURATION_MODEL__CONFIGURATION_ITEMS = eINSTANCE.getSlizaaProjectConfigurationModel_ConfigurationItems();

    /**
     * The meta object literal for the '<em><b>Create New Configuration Item Instance</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EOperation SLIZAA_PROJECT_CONFIGURATION_MODEL___CREATE_NEW_CONFIGURATION_ITEM_INSTANCE__CLASS = eINSTANCE.getSlizaaProjectConfigurationModel__CreateNewConfigurationItemInstance__Class();

    /**
     * The meta object literal for the '{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationItemModelImpl <em>Slizaa Project Configuration Item Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationItemModelImpl
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getSlizaaProjectConfigurationItemModel()
     * @generated
     */
    public static final EClass SLIZAA_PROJECT_CONFIGURATION_ITEM_MODEL = eINSTANCE.getSlizaaProjectConfigurationItemModel();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute SLIZAA_PROJECT_CONFIGURATION_ITEM_MODEL__TYPE = eINSTANCE.getSlizaaProjectConfigurationItemModel_Type();

    /**
     * The meta object literal for the '<em><b>Method Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute SLIZAA_PROJECT_CONFIGURATION_ITEM_MODEL__METHOD_NAME = eINSTANCE.getSlizaaProjectConfigurationItemModel_MethodName();

    /**
     * The meta object literal for the '{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationProblemImpl <em>Slizaa Project Configuration Problem</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectConfigurationProblemImpl
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getSlizaaProjectConfigurationProblem()
     * @generated
     */
    public static final EClass SLIZAA_PROJECT_CONFIGURATION_PROBLEM = eINSTANCE.getSlizaaProjectConfigurationProblem();

    /**
     * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute SLIZAA_PROJECT_CONFIGURATION_PROBLEM__MESSAGE = eINSTANCE.getSlizaaProjectConfigurationProblem_Message();

    /**
     * The meta object literal for the '<em><b>Char Start</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute SLIZAA_PROJECT_CONFIGURATION_PROBLEM__CHAR_START = eINSTANCE.getSlizaaProjectConfigurationProblem_CharStart();

    /**
     * The meta object literal for the '<em><b>Char End</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute SLIZAA_PROJECT_CONFIGURATION_PROBLEM__CHAR_END = eINSTANCE.getSlizaaProjectConfigurationProblem_CharEnd();

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
     * The meta object literal for the '{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaExtensionBundleImpl <em>Slizaa Extension Bundle</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.slizaa.rcp.workbench.core.model.impl.SlizaaExtensionBundleImpl
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getSlizaaExtensionBundle()
     * @generated
     */
    public static final EClass SLIZAA_EXTENSION_BUNDLE = eINSTANCE.getSlizaaExtensionBundle();

    /**
     * The meta object literal for the '<em><b>Defined Extensions</b></em>' map feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference SLIZAA_EXTENSION_BUNDLE__DEFINED_EXTENSIONS = eINSTANCE.getSlizaaExtensionBundle_DefinedExtensions();

    /**
     * The meta object literal for the '<em><b>Defined Cypher Statements</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute SLIZAA_EXTENSION_BUNDLE__DEFINED_CYPHER_STATEMENTS = eINSTANCE.getSlizaaExtensionBundle_DefinedCypherStatements();

    /**
     * The meta object literal for the '{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaExtensionBundleExtensionImpl <em>Slizaa Extension Bundle Extension</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.slizaa.rcp.workbench.core.model.impl.SlizaaExtensionBundleExtensionImpl
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getSlizaaExtensionBundleExtension()
     * @generated
     */
    public static final EClass SLIZAA_EXTENSION_BUNDLE_EXTENSION = eINSTANCE.getSlizaaExtensionBundleExtension();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute SLIZAA_EXTENSION_BUNDLE_EXTENSION__TYPE = eINSTANCE.getSlizaaExtensionBundleExtension_Type();

    /**
     * The meta object literal for the '<em><b>Annotation Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute SLIZAA_EXTENSION_BUNDLE_EXTENSION__ANNOTATION_TYPE = eINSTANCE.getSlizaaExtensionBundleExtension_AnnotationType();

    /**
     * The meta object literal for the '<em><b>Create New Instance</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EOperation SLIZAA_EXTENSION_BUNDLE_EXTENSION___CREATE_NEW_INSTANCE__CLASS = eINSTANCE.getSlizaaExtensionBundleExtension__CreateNewInstance__Class();

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
     * The meta object literal for the '{@link org.slizaa.rcp.workbench.core.model.impl.AnnotationTypeToSlizaaBundleExtensionMapImpl <em>Annotation Type To Slizaa Bundle Extension Map</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.slizaa.rcp.workbench.core.model.impl.AnnotationTypeToSlizaaBundleExtensionMapImpl
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getAnnotationTypeToSlizaaBundleExtensionMap()
     * @generated
     */
    public static final EClass ANNOTATION_TYPE_TO_SLIZAA_BUNDLE_EXTENSION_MAP = eINSTANCE.getAnnotationTypeToSlizaaBundleExtensionMap();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EAttribute ANNOTATION_TYPE_TO_SLIZAA_BUNDLE_EXTENSION_MAP__KEY = eINSTANCE.getAnnotationTypeToSlizaaBundleExtensionMap_Key();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EReference ANNOTATION_TYPE_TO_SLIZAA_BUNDLE_EXTENSION_MAP__VALUE = eINSTANCE.getAnnotationTypeToSlizaaBundleExtensionMap_Value();

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
     * @see org.slizaa.neo4j.hierarchicalgraph.mapping.spi.IMappingProvider
     * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl#getIMappingProvider()
     * @generated
     */
    public static final EDataType IMAPPING_PROVIDER = eINSTANCE.getIMappingProvider();

  }

} //ModelPackageImpl
