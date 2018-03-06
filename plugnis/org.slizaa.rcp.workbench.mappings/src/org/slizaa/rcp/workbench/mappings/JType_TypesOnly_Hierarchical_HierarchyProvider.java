package org.slizaa.rcp.workbench.mappings;

import org.slizaa.hierarchicalgraph.graphdb.mapping.spi.opencypher.AbstractQueryBasedHierarchyProvider;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class JType_TypesOnly_Hierarchical_HierarchyProvider extends AbstractQueryBasedHierarchyProvider {

  /**
   * <p>
   * </p>
   *
   * @return
   */
  @Override
  protected String[] toplevelNodeIdQueries() {
    return new String[] { "Match (module:Module) Return id(module) as id" };
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  @Override
  protected String[] parentChildNodeIdsQueries() {
    return new String[] {
        "Match (module:Module)-[:CONTAINS]->(d:Directory) Where Not (:Directory)-[:CONTAINS]->(d) Return id(module), id(d)",
        "Match (d1:Directory)-[:CONTAINS]->(d2:Directory) Return id(d1), id(d2)",
        "Match (d:Directory)-[:CONTAINS]->(r:Resource) Return id(d), id(r)",
        "Match (r:Resource)-[:CONTAINS]->(t:Type) Return id(r), id(t)"
        // ,"Match (t:Type)-[:CONTAINS]->(m:Method) Return id(t), id(m)",
        // "Match (t:Type)-[:CONTAINS]->(f:Field) Return id(t), id(f)"
    };
  }
}
