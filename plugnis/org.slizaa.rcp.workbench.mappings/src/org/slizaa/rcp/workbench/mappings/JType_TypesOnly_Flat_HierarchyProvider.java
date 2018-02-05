package org.slizaa.rcp.workbench.mappings;

import org.slizaa.neo4j.hierarchicalgraph.mapping.spi.opencypher.AbstractQueryBasedHierarchyProvider;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class JType_TypesOnly_Flat_HierarchyProvider extends AbstractQueryBasedHierarchyProvider {

  /**
   * <p>
   * </p>
   *
   * @return
   */
  protected String[] toplevelNodeIdQueries() {
    return new String[] { "Match (module:Module) Return id(module) as id" };
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  protected String[] parentChildNodeIdsQueries() {
    return new String[] {
        "Match (module:Module)-[:CONTAINS]->(d:Directory) WHERE d.isEmpty=false Return DISTINCT id(module), id(d)",
        "Match (d:Directory)-[:CONTAINS]->(r:Resource) Return id(d), id(r)",
        "Match (r:Resource)-[:CONTAINS]->(t:Type) Return id(r), id(t)" };
  }
}
