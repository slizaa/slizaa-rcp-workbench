/**
 */
package org.slizaa.rcp.workbench.core.model;

import java.util.List;
import java.util.Map;
import org.slizaa.scanner.core.api.cypherregistry.ICypherStatement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Slizaa Extension Bundle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.SlizaaExtensionBundle#getDefinedExtensions <em>Defined Extensions</em>}</li>
 *   <li>{@link org.slizaa.rcp.workbench.core.model.SlizaaExtensionBundle#getDefinedCypherStatements <em>Defined Cypher Statements</em>}</li>
 * </ul>
 *
 * @generated
 */
public interface SlizaaExtensionBundle {
  /**
   * Returns the value of the '<em><b>Defined Extensions</b></em>' map.
   * The key is of type {@link java.lang.Class<?>},
   * and the value is of type list of {@link org.slizaa.rcp.workbench.core.model.SlizaaExtensionBundleExtension},
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Defined Extensions</em>' map isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Defined Extensions</em>' map.
   * @generated
   */
  Map<Class<?>, List<SlizaaExtensionBundleExtension>> getDefinedExtensions();

  /**
   * Returns the value of the '<em><b>Defined Cypher Statements</b></em>' attribute list.
   * The list contents are of type {@link org.slizaa.scanner.core.api.cypherregistry.ICypherStatement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Defined Cypher Statements</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Defined Cypher Statements</em>' attribute list.
   * @generated
   */
  List<ICypherStatement> getDefinedCypherStatements();

} // SlizaaExtensionBundle
