/**
 */
package org.slizaa.rcp.workbench.core.model.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import java.util.List;
import java.util.Map;
import org.eclipse.core.resources.IProject;

import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.slizaa.core.boltclient.IBoltClient;
import org.slizaa.hierarchicalgraph.graphdb.mapping.spi.IMappingProvider;
import org.slizaa.rcp.workbench.core.model.SlizaaProject;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension;

import org.slizaa.scanner.core.api.cypherregistry.ICypherStatement;

import org.slizaa.scanner.core.api.graphdb.IGraphDb;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Slizaa Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectImpl#getProject <em>Project</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectImpl#getUserDefinedExtensions <em>User Defined Extensions</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectImpl#getUserDefinedCypherStatements <em>User Defined Cypher Statements</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectImpl#getGraphDatabaseInstance <em>Graph Database Instance</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectImpl#getBoltClient <em>Bolt Client</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectImpl#getHierachicalGraph <em>Hierachical Graph</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SlizaaProjectImpl extends MinimalEObjectImpl.Container implements SlizaaProject {
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
   * The cached value of the '{@link #getConfiguration() <em>Configuration</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConfiguration()
   * @generated
   * @ordered
   */
  protected SlizaaProjectConfigurationModel configuration;

  /**
   * The cached value of the '{@link #getUserDefinedExtensions() <em>User Defined Extensions</em>}' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUserDefinedExtensions()
   * @generated
   * @ordered
   */
  protected EMap<Class<?>, List<SlizaaProjectExtension>> userDefinedExtensions;

  /**
   * The cached value of the '{@link #getUserDefinedCypherStatements() <em>User Defined Cypher Statements</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUserDefinedCypherStatements()
   * @generated
   * @ordered
   */
  protected EList<ICypherStatement> userDefinedCypherStatements;

  /**
   * The default value of the '{@link #getGraphDatabaseInstance() <em>Graph Database Instance</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGraphDatabaseInstance()
   * @generated
   * @ordered
   */
  protected static final IGraphDb GRAPH_DATABASE_INSTANCE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getGraphDatabaseInstance() <em>Graph Database Instance</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGraphDatabaseInstance()
   * @generated
   * @ordered
   */
  protected IGraphDb graphDatabaseInstance = GRAPH_DATABASE_INSTANCE_EDEFAULT;

  /**
   * The default value of the '{@link #getBoltClient() <em>Bolt Client</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBoltClient()
   * @generated
   * @ordered
   */
  protected static final IBoltClient BOLT_CLIENT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBoltClient() <em>Bolt Client</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBoltClient()
   * @generated
   * @ordered
   */
  protected IBoltClient boltClient = BOLT_CLIENT_EDEFAULT;

  /**
   * The cached value of the '{@link #getHierachicalGraph() <em>Hierachical Graph</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHierachicalGraph()
   * @generated
   * @ordered
   */
  protected org.slizaa.hierarchicalgraph.core.model.HGRootNode hierachicalGraph;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SlizaaProjectImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelPackageImpl.Literals.SLIZAA_PROJECT;
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
  public SlizaaProjectConfigurationModel getConfiguration() {
    if (configuration != null && ((EObject)configuration).eIsProxy()) {
      InternalEObject oldConfiguration = (InternalEObject)configuration;
      configuration = (SlizaaProjectConfigurationModel)eResolveProxy(oldConfiguration);
      if (configuration != oldConfiguration) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackageImpl.SLIZAA_PROJECT__CONFIGURATION, oldConfiguration, configuration));
      }
    }
    return configuration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SlizaaProjectConfigurationModel basicGetConfiguration() {
    return configuration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Map<Class<?>, List<SlizaaProjectExtension>> getUserDefinedExtensions() {
    if (userDefinedExtensions == null) {
      userDefinedExtensions = new EcoreEMap<Class<?>,List<SlizaaProjectExtension>>(ModelPackageImpl.Literals.ANNOTATION_TYPE_TO_SLIZAA_PROJECT_EXTENSION_MAP, AnnotationTypeToSlizaaProjectExtensionMapImpl.class, this, ModelPackageImpl.SLIZAA_PROJECT__USER_DEFINED_EXTENSIONS);
    }
    return userDefinedExtensions.map();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List<ICypherStatement> getUserDefinedCypherStatements() {
    if (userDefinedCypherStatements == null) {
      userDefinedCypherStatements = new EDataTypeUniqueEList<ICypherStatement>(ICypherStatement.class, this, ModelPackageImpl.SLIZAA_PROJECT__USER_DEFINED_CYPHER_STATEMENTS);
    }
    return userDefinedCypherStatements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IGraphDb getGraphDatabaseInstance() {
    return graphDatabaseInstance;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IBoltClient getBoltClient() {
    return boltClient;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBoltClient(IBoltClient newBoltClient) {
    IBoltClient oldBoltClient = boltClient;
    boltClient = newBoltClient;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ModelPackageImpl.SLIZAA_PROJECT__BOLT_CLIENT, oldBoltClient, boltClient));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.slizaa.hierarchicalgraph.core.model.HGRootNode getHierachicalGraph() {
    if (hierachicalGraph != null && hierachicalGraph.eIsProxy()) {
      InternalEObject oldHierachicalGraph = (InternalEObject)hierachicalGraph;
      hierachicalGraph = (org.slizaa.hierarchicalgraph.core.model.HGRootNode)eResolveProxy(oldHierachicalGraph);
      if (hierachicalGraph != oldHierachicalGraph) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackageImpl.SLIZAA_PROJECT__HIERACHICAL_GRAPH, oldHierachicalGraph, hierachicalGraph));
      }
    }
    return hierachicalGraph;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.slizaa.hierarchicalgraph.core.model.HGRootNode basicGetHierachicalGraph() {
    return hierachicalGraph;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void cleanBuild() {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void parse(IProgressMonitor monitor) {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void startAndConnectDatabase(IProgressMonitor monitor) {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.slizaa.hierarchicalgraph.core.model.HGRootNode mapToHierachicalGraph(IMappingProvider mappingProvider, IProgressMonitor monitor) {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void dispose() {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isDatabaseDirectoryPopulated() {
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
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ModelPackageImpl.SLIZAA_PROJECT__USER_DEFINED_EXTENSIONS:
        return ((InternalEList<?>)((EMap.InternalMapView<Class<?>, List<SlizaaProjectExtension>>)getUserDefinedExtensions()).eMap()).basicRemove(otherEnd, msgs);
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
      case ModelPackageImpl.SLIZAA_PROJECT__PROJECT:
        return getProject();
      case ModelPackageImpl.SLIZAA_PROJECT__CONFIGURATION:
        if (resolve) return getConfiguration();
        return basicGetConfiguration();
      case ModelPackageImpl.SLIZAA_PROJECT__USER_DEFINED_EXTENSIONS:
        if (coreType) return ((EMap.InternalMapView<Class<?>, List<SlizaaProjectExtension>>)getUserDefinedExtensions()).eMap();
        else return getUserDefinedExtensions();
      case ModelPackageImpl.SLIZAA_PROJECT__USER_DEFINED_CYPHER_STATEMENTS:
        return getUserDefinedCypherStatements();
      case ModelPackageImpl.SLIZAA_PROJECT__GRAPH_DATABASE_INSTANCE:
        return getGraphDatabaseInstance();
      case ModelPackageImpl.SLIZAA_PROJECT__BOLT_CLIENT:
        return getBoltClient();
      case ModelPackageImpl.SLIZAA_PROJECT__HIERACHICAL_GRAPH:
        if (resolve) return getHierachicalGraph();
        return basicGetHierachicalGraph();
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
      case ModelPackageImpl.SLIZAA_PROJECT__USER_DEFINED_EXTENSIONS:
        ((EStructuralFeature.Setting)((EMap.InternalMapView<Class<?>, List<SlizaaProjectExtension>>)getUserDefinedExtensions()).eMap()).set(newValue);
        return;
      case ModelPackageImpl.SLIZAA_PROJECT__USER_DEFINED_CYPHER_STATEMENTS:
        getUserDefinedCypherStatements().clear();
        getUserDefinedCypherStatements().addAll((Collection<? extends ICypherStatement>)newValue);
        return;
      case ModelPackageImpl.SLIZAA_PROJECT__BOLT_CLIENT:
        setBoltClient((IBoltClient)newValue);
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
      case ModelPackageImpl.SLIZAA_PROJECT__USER_DEFINED_EXTENSIONS:
        getUserDefinedExtensions().clear();
        return;
      case ModelPackageImpl.SLIZAA_PROJECT__USER_DEFINED_CYPHER_STATEMENTS:
        getUserDefinedCypherStatements().clear();
        return;
      case ModelPackageImpl.SLIZAA_PROJECT__BOLT_CLIENT:
        setBoltClient(BOLT_CLIENT_EDEFAULT);
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
      case ModelPackageImpl.SLIZAA_PROJECT__PROJECT:
        return PROJECT_EDEFAULT == null ? project != null : !PROJECT_EDEFAULT.equals(project);
      case ModelPackageImpl.SLIZAA_PROJECT__CONFIGURATION:
        return configuration != null;
      case ModelPackageImpl.SLIZAA_PROJECT__USER_DEFINED_EXTENSIONS:
        return userDefinedExtensions != null && !userDefinedExtensions.isEmpty();
      case ModelPackageImpl.SLIZAA_PROJECT__USER_DEFINED_CYPHER_STATEMENTS:
        return userDefinedCypherStatements != null && !userDefinedCypherStatements.isEmpty();
      case ModelPackageImpl.SLIZAA_PROJECT__GRAPH_DATABASE_INSTANCE:
        return GRAPH_DATABASE_INSTANCE_EDEFAULT == null ? graphDatabaseInstance != null : !GRAPH_DATABASE_INSTANCE_EDEFAULT.equals(graphDatabaseInstance);
      case ModelPackageImpl.SLIZAA_PROJECT__BOLT_CLIENT:
        return BOLT_CLIENT_EDEFAULT == null ? boltClient != null : !BOLT_CLIENT_EDEFAULT.equals(boltClient);
      case ModelPackageImpl.SLIZAA_PROJECT__HIERACHICAL_GRAPH:
        return hierachicalGraph != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case ModelPackageImpl.SLIZAA_PROJECT___CLEAN_BUILD:
        cleanBuild();
        return null;
      case ModelPackageImpl.SLIZAA_PROJECT___PARSE__IPROGRESSMONITOR:
        parse((IProgressMonitor)arguments.get(0));
        return null;
      case ModelPackageImpl.SLIZAA_PROJECT___START_AND_CONNECT_DATABASE__IPROGRESSMONITOR:
        startAndConnectDatabase((IProgressMonitor)arguments.get(0));
        return null;
      case ModelPackageImpl.SLIZAA_PROJECT___MAP_TO_HIERACHICAL_GRAPH__IMAPPINGPROVIDER_IPROGRESSMONITOR:
        return mapToHierachicalGraph((IMappingProvider)arguments.get(0), (IProgressMonitor)arguments.get(1));
      case ModelPackageImpl.SLIZAA_PROJECT___DISPOSE:
        dispose();
        return null;
      case ModelPackageImpl.SLIZAA_PROJECT___IS_DATABASE_DIRECTORY_POPULATED:
        return isDatabaseDirectoryPopulated();
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
    result.append(" (project: ");
    result.append(project);
    result.append(", userDefinedCypherStatements: ");
    result.append(userDefinedCypherStatements);
    result.append(", graphDatabaseInstance: ");
    result.append(graphDatabaseInstance);
    result.append(", boltClient: ");
    result.append(boltClient);
    result.append(')');
    return result.toString();
  }

} //SlizaaProjectImpl
