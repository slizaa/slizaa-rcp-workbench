/**
 */
package org.slizaa.rcp.workbench.core.model;

import org.eclipse.core.resources.IProject;

import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import org.slizaa.hierarchicalgraph.HGRootNode;

import org.slizaa.neo4j.dbadapter.Neo4jClient;

import org.slizaa.scanner.core.api.graphdb.IGraphDb;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Slizaa Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#getProject <em>Project</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#getProjectExtensions <em>Project Extensions</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#getGraphDatabaseInstance <em>Graph Database Instance</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#getBoltClient <em>Bolt Client</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#getHierachicalGraph <em>Hierachical Graph</em>}</li>
 * </ul>
 *
 * @see org.slizaa.rcp.workbench.core.model.ModelPackage#getSlizaaProject()
 * @model
 * @generated
 */
public interface SlizaaProject extends EObject {
  /**
   * Returns the value of the '<em><b>Project</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Project</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Project</em>' attribute.
   * @see org.slizaa.rcp.workbench.core.model.ModelPackage#getSlizaaProject_Project()
   * @model dataType="org.slizaa.rcp.workbench.core.model.IProject" transient="true" changeable="false"
   * @generated
   */
  IProject getProject();

  /**
   * Returns the value of the '<em><b>Configuration</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Configuration</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Configuration</em>' reference.
   * @see org.slizaa.rcp.workbench.core.model.ModelPackage#getSlizaaProject_Configuration()
   * @model changeable="false"
   * @generated
   */
  SlizaaProjectConfigurationModel getConfiguration();

  /**
   * Returns the value of the '<em><b>Project Extensions</b></em>' reference list.
   * The list contents are of type {@link org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Project Extensions</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Project Extensions</em>' reference list.
   * @see org.slizaa.rcp.workbench.core.model.ModelPackage#getSlizaaProject_ProjectExtensions()
   * @model
   * @generated
   */
  EList<SlizaaProjectExtension> getProjectExtensions();

  /**
   * Returns the value of the '<em><b>Graph Database Instance</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Graph Database Instance</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Graph Database Instance</em>' attribute.
   * @see org.slizaa.rcp.workbench.core.model.ModelPackage#getSlizaaProject_GraphDatabaseInstance()
   * @model dataType="org.slizaa.rcp.workbench.core.model.IGraphDb" transient="true" changeable="false"
   * @generated
   */
  IGraphDb getGraphDatabaseInstance();

  /**
   * Returns the value of the '<em><b>Bolt Client</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bolt Client</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bolt Client</em>' reference.
   * @see org.slizaa.rcp.workbench.core.model.ModelPackage#getSlizaaProject_BoltClient()
   * @model changeable="false"
   * @generated
   */
  Neo4jClient getBoltClient();

  /**
   * Returns the value of the '<em><b>Hierachical Graph</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Hierachical Graph</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Hierachical Graph</em>' reference.
   * @see org.slizaa.rcp.workbench.core.model.ModelPackage#getSlizaaProject_HierachicalGraph()
   * @model changeable="false"
   * @generated
   */
  HGRootNode getHierachicalGraph();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  void cleanBuild();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model monitorDataType="org.slizaa.rcp.workbench.core.model.IProgressMonitor"
   * @generated
   */
  void parse(IProgressMonitor monitor);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model monitorDataType="org.slizaa.rcp.workbench.core.model.IProgressMonitor"
   * @generated
   */
  void startAndConnectDatabase(IProgressMonitor monitor);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  void dispose();

} // SlizaaProject
