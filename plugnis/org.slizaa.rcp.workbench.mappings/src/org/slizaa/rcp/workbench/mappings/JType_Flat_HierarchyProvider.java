package org.slizaa.rcp.workbench.mappings;

import org.slizaa.hierarchicalgraph.graphdb.mapping.spi.opencypher.AbstractQueryBasedHierarchyProvider;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class JType_Flat_HierarchyProvider extends AbstractQueryBasedHierarchyProvider {

  /**
   * <p>
   * </p>
   *
   * @return
   */
  @Override
  protected String[] toplevelNodeIdQueries() {
    return new String[] { "MATCH (g:Group) WHERE NOT ()-[:CONTAINS]->(g) RETURN id(g)", 
        "MATCH (m:Module) WHERE NOT ()-[:CONTAINS]->(m) RETURN id(m)" };
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
        "MATCH (g:Group)-[:CONTAINS]->(m:Module) RETURN id(g), id(m)",
        "MATCH (g1:Group)-[:CONTAINS]->(g2:Group) RETURN id(g1), id(g2)",
        "Match (module:Module)-[:CONTAINS]->(d:Directory) WHERE d.isEmpty=false Return DISTINCT id(module), id(d)",
        "Match (d:Directory)-[:CONTAINS]->(r:Resource) Return id(d), id(r)",
        "Match (r:Resource)-[:CONTAINS]->(t:Type) Return id(r), id(t)",
        "Match (t:Type)-[:CONTAINS]->(m:Method) Return id(t), id(m)",
        "Match (t:Type)-[:CONTAINS]->(f:Field) Return id(t), id(f)"
    };
  }
}
