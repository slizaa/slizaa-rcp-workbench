package org.slizaa.rcp.workbench.mappings;

import org.slizaa.neo4j.hierarchicalgraph.mapping.spi.opencypher.AbstractQueryBasedDependencyProvider;

public class JType_TypesOnly_DependencyProvider extends AbstractQueryBasedDependencyProvider {

	@Override
	protected String[] simpleDependenciesQueries() {
		return new String[] { "Match (t1:Type)-[r:DEPENDS_ON]->(t2:Type) RETURN id(t1), id(t2), id(r), 'DEPENDS_ON'" };
	}
}
