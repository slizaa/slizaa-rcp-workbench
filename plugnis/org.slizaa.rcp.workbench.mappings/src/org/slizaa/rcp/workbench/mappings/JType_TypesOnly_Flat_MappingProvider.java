package org.slizaa.rcp.workbench.mappings;

import org.slizaa.hierarchicalgraph.graphdb.mapping.spi.IMappingProvider.DefaultMappingProvider;
import org.slizaa.hierarchicalgraph.graphdb.mapping.spi.annotations.SlizaaMappingProvider;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 */
@SlizaaMappingProvider
public class JType_TypesOnly_Flat_MappingProvider extends DefaultMappingProvider {
	
	public JType_TypesOnly_Flat_MappingProvider() {

		//
		super(IMappingProviderMetadata.createMetadata("org.slizaa.jtype.core.TypesOnly_FlatPackages", "Slizaa JType (types only, flat packages)", null, null), new JType_TypesOnly_Flat_HierarchyProvider(),
				new JType_TypesOnly_DependencyProvider(), new JType_LabelProvider(true), new JType_NodeComparator());
	}

}
