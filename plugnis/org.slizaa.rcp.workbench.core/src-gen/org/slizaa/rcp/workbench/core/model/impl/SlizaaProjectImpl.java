/**
 */
package org.slizaa.rcp.workbench.core.model.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.slizaa.hierarchicalgraph.HGRootNode;
import org.slizaa.neo4j.dbadapter.Neo4jClient;
import org.slizaa.rcp.workbench.core.model.ModelPackage;
import org.slizaa.rcp.workbench.core.model.SlizaaProject;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension;
import org.slizaa.scanner.core.api.graphdb.IGraphDb;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Slizaa Project</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectImpl#getProject <em>Project</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.impl.SlizaaProjectImpl#getProjectExtensions <em>Project Extensions</em>}</li>
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
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getProject()
   * @generated
   * @ordered
   */
  protected static final IProject      PROJECT_EDEFAULT                 = null;

  /**
   * The cached value of the '{@link #getProject() <em>Project</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getProject()
   * @generated
   * @ordered
   */
  protected IProject                   project                          = PROJECT_EDEFAULT;

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
   * The cached value of the '{@link #getProjectExtensions() <em>Project Extensions</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProjectExtensions()
   * @generated
   * @ordered
   */
  protected EList<SlizaaProjectExtension> projectExtensions;

  /**
   * The default value of the '{@link #getGraphDatabaseInstance() <em>Graph Database Instance</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getGraphDatabaseInstance()
   * @generated
   * @ordered
   */
  protected static final IGraphDb      GRAPH_DATABASE_INSTANCE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getGraphDatabaseInstance() <em>Graph Database Instance</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getGraphDatabaseInstance()
   * @generated
   * @ordered
   */
  protected IGraphDb                   graphDatabaseInstance            = GRAPH_DATABASE_INSTANCE_EDEFAULT;

  /**
   * The cached value of the '{@link #getBoltClient() <em>Bolt Client</em>}' reference.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getBoltClient()
   * @generated
   * @ordered
   */
  protected Neo4jClient                boltClient;

  /**
   * The cached value of the '{@link #getHierachicalGraph() <em>Hierachical Graph</em>}' reference.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @see #getHierachicalGraph()
   * @generated
   * @ordered
   */
  protected HGRootNode                 hierachicalGraph;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected SlizaaProjectImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ModelPackage.Literals.SLIZAA_PROJECT;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IProject getProject() {
    return project;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SlizaaProjectConfigurationModel getConfiguration() {
    if (configuration != null && configuration.eIsProxy()) {
      InternalEObject oldConfiguration = (InternalEObject)configuration;
      configuration = (SlizaaProjectConfigurationModel)eResolveProxy(oldConfiguration);
      if (configuration != oldConfiguration) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.SLIZAA_PROJECT__CONFIGURATION, oldConfiguration, configuration));
      }
    }
    return configuration;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
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
  public EList<SlizaaProjectExtension> getProjectExtensions() {
    if (projectExtensions == null) {
      projectExtensions = new EObjectResolvingEList<SlizaaProjectExtension>(SlizaaProjectExtension.class, this, ModelPackage.SLIZAA_PROJECT__PROJECT_EXTENSIONS);
    }
    return projectExtensions;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IGraphDb getGraphDatabaseInstance() {
    return graphDatabaseInstance;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Neo4jClient getBoltClient() {
    if (boltClient != null && boltClient.eIsProxy()) {
      InternalEObject oldBoltClient = (InternalEObject)boltClient;
      boltClient = (Neo4jClient)eResolveProxy(oldBoltClient);
      if (boltClient != oldBoltClient) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.SLIZAA_PROJECT__BOLT_CLIENT, oldBoltClient, boltClient));
      }
    }
    return boltClient;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Neo4jClient basicGetBoltClient() {
    return boltClient;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public HGRootNode getHierachicalGraph() {
    if (hierachicalGraph != null && hierachicalGraph.eIsProxy()) {
      InternalEObject oldHierachicalGraph = (InternalEObject)hierachicalGraph;
      hierachicalGraph = (HGRootNode)eResolveProxy(oldHierachicalGraph);
      if (hierachicalGraph != oldHierachicalGraph) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.SLIZAA_PROJECT__HIERACHICAL_GRAPH, oldHierachicalGraph, hierachicalGraph));
      }
    }
    return hierachicalGraph;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public HGRootNode basicGetHierachicalGraph() {
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
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void parse(IProgressMonitor monitor) {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void startAndConnectDatabase(IProgressMonitor monitor) {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void dispose() {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ModelPackage.SLIZAA_PROJECT__PROJECT:
        return getProject();
      case ModelPackage.SLIZAA_PROJECT__CONFIGURATION:
        if (resolve) return getConfiguration();
        return basicGetConfiguration();
      case ModelPackage.SLIZAA_PROJECT__PROJECT_EXTENSIONS:
        return getProjectExtensions();
      case ModelPackage.SLIZAA_PROJECT__GRAPH_DATABASE_INSTANCE:
        return getGraphDatabaseInstance();
      case ModelPackage.SLIZAA_PROJECT__BOLT_CLIENT:
        if (resolve) return getBoltClient();
        return basicGetBoltClient();
      case ModelPackage.SLIZAA_PROJECT__HIERACHICAL_GRAPH:
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
      case ModelPackage.SLIZAA_PROJECT__PROJECT_EXTENSIONS:
        getProjectExtensions().clear();
        getProjectExtensions().addAll((Collection<? extends SlizaaProjectExtension>)newValue);
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
      case ModelPackage.SLIZAA_PROJECT__PROJECT_EXTENSIONS:
        getProjectExtensions().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case ModelPackage.SLIZAA_PROJECT__PROJECT:
        return PROJECT_EDEFAULT == null ? project != null : !PROJECT_EDEFAULT.equals(project);
      case ModelPackage.SLIZAA_PROJECT__CONFIGURATION:
        return configuration != null;
      case ModelPackage.SLIZAA_PROJECT__PROJECT_EXTENSIONS:
        return projectExtensions != null && !projectExtensions.isEmpty();
      case ModelPackage.SLIZAA_PROJECT__GRAPH_DATABASE_INSTANCE:
        return GRAPH_DATABASE_INSTANCE_EDEFAULT == null ? graphDatabaseInstance != null : !GRAPH_DATABASE_INSTANCE_EDEFAULT.equals(graphDatabaseInstance);
      case ModelPackage.SLIZAA_PROJECT__BOLT_CLIENT:
        return boltClient != null;
      case ModelPackage.SLIZAA_PROJECT__HIERACHICAL_GRAPH:
        return hierachicalGraph != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case ModelPackage.SLIZAA_PROJECT___CLEAN_BUILD:
        cleanBuild();
        return null;
      case ModelPackage.SLIZAA_PROJECT___PARSE__IPROGRESSMONITOR:
        parse((IProgressMonitor)arguments.get(0));
        return null;
      case ModelPackage.SLIZAA_PROJECT___START_AND_CONNECT_DATABASE__IPROGRESSMONITOR:
        startAndConnectDatabase((IProgressMonitor)arguments.get(0));
        return null;
      case ModelPackage.SLIZAA_PROJECT___DISPOSE:
        dispose();
        return null;
    }
    return super.eInvoke(operationID, arguments);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (project: ");
    result.append(project);
    result.append(", graphDatabaseInstance: ");
    result.append(graphDatabaseInstance);
    result.append(')');
    return result.toString();
  }

} // SlizaaProjectImpl
