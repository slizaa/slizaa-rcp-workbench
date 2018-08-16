/**
 */
package org.slizaa.rcp.workbench.core.model;

import java.util.List;
import java.util.Map;
import org.eclipse.core.resources.IProject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.slizaa.core.boltclient.IBoltClient;
import org.slizaa.hierarchicalgraph.core.model.HGRootNode;
import org.slizaa.hierarchicalgraph.graphdb.mapping.spi.IMappingProvider;
import org.slizaa.scanner.core.api.cypherregistry.ICypherStatement;

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
 *   <li>{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#getUserDefinedExtensions <em>User Defined Extensions</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#getUserDefinedCypherStatements <em>User Defined Cypher Statements</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#getGraphDatabaseInstance <em>Graph Database Instance</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#getBoltClient <em>Bolt Client</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#getHierachicalGraph <em>Hierachical Graph</em>}</li>
 * </ul>
 *
 * @generated
 */
public interface SlizaaProject {
  /**
   * Returns the value of the '<em><b>Project</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Project</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Project</em>' attribute.
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
   * @generated
   */
  SlizaaProjectConfigurationModel getConfiguration();

  /**
   * Returns the value of the '<em><b>User Defined Extensions</b></em>' map.
   * The key is of type {@link java.lang.Class<?>},
   * and the value is of type list of {@link org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension},
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>User Defined Extensions</em>' map isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>User Defined Extensions</em>' map.
   * @generated
   */
  Map<Class<?>, List<SlizaaProjectExtension>> getUserDefinedExtensions();

  /**
   * Returns the value of the '<em><b>User Defined Cypher Statements</b></em>' attribute list.
   * The list contents are of type {@link org.slizaa.scanner.core.api.cypherregistry.ICypherStatement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>User Defined Cypher Statements</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>User Defined Cypher Statements</em>' attribute list.
   * @generated
   */
  List<ICypherStatement> getUserDefinedCypherStatements();

  /**
   * Returns the value of the '<em><b>Graph Database Instance</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Graph Database Instance</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Graph Database Instance</em>' attribute.
   * @generated
   */
  IGraphDb getGraphDatabaseInstance();

  /**
   * Returns the value of the '<em><b>Bolt Client</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bolt Client</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bolt Client</em>' attribute.
   * @see #setBoltClient(IBoltClient)
   * @generated
   */
  IBoltClient getBoltClient();

  /**
   * Sets the value of the '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject#getBoltClient <em>Bolt Client</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bolt Client</em>' attribute.
   * @see #getBoltClient()
   * @generated
   */
  void setBoltClient(IBoltClient value);

  /**
   * Returns the value of the '<em><b>Hierachical Graph</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Hierachical Graph</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Hierachical Graph</em>' reference.
   * @generated
   */
  HGRootNode getHierachicalGraph();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  void cleanBuild();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  void parse(IProgressMonitor monitor);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  void startAndConnectDatabase(IProgressMonitor monitor);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  void disconnectAndStopDatabase(IProgressMonitor monitor);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  HGRootNode mapToHierachicalGraph(IMappingProvider mappingProvider, IProgressMonitor monitor);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  void dispose();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  boolean isDatabaseDirectoryPopulated();

} // SlizaaProject
