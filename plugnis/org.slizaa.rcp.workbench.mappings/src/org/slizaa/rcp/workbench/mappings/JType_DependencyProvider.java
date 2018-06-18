package org.slizaa.rcp.workbench.mappings;

import org.slizaa.hierarchicalgraph.graphdb.mapping.spi.opencypher.AbstractQueryBasedDependencyProvider;

public class JType_DependencyProvider extends AbstractQueryBasedDependencyProvider {

  /**
   * {@inheritDoc}
   */
  @Override
  protected void initialize() {

    // @formatter:off
    addProxyDependencyDefinitions(
        "Match (t1:Type)-[r:DEPENDS_ON]->(t2:Type) RETURN id(t1), id(t2), id(r), 'DEPENDS_ON'",
        new String[] {
            "MATCH (n1)-[rel]->(n2) "
            + "WHERE id(n1) in {from} AND id(n2) in {to} "
            + "AND ("
            + "(n1:Type)-[rel:EXTENDS|:IMPLEMENTS]->(n2:Type) "
            + "OR (n1:Method)-[rel:INVOKES]->(n2:Method) "
            + "OR (n1:Method)-[rel:READS|:WRITES]->(n2:Field) "
            + "OR (n1:Field)-[rel:IS_OF_TYPE]->(n2:Type) "
            + "OR (n1:Method)-[rel:THROWS]->(n2:Type) "
            + "OR (n1:Method)-[rel:RETURNS]->(n2:Type)"
            + "OR (n1:Method)-[rel:HAS_PARAMETER]->(n2:Type)"
            + ") "
            + "RETURN id(n1), id(n2), id(rel), type(rel)"
        });
    // @formatter:on
  }
}
