package org.slizaa.hierarchicalgraph.graphdb.ui.hierarchicalgraphview;

import org.osgi.service.component.annotations.Component;
import org.slizaa.core.boltclient.IBoltClient;
import org.slizaa.hierarchicalgraph.core.model.HGRootNode;
import org.slizaa.hierarchicalgraph.core.model.spi.INodeLabelProvider;
import org.slizaa.hierarchicalgraph.graphdb.mapping.service.IMappingParticipator;
import org.slizaa.hierarchicalgraph.graphdb.mapping.spi.IMappingProvider;

@Component
public class AdapterMappingParticipator implements IMappingParticipator {

  @Override
  public void postCreate(HGRootNode rootNode, IMappingProvider mappingDescriptor, IBoltClient boltClient) {
    rootNode.registerExtension(INodeLabelProvider.class,
        new LabelDefinitionProvider2NoteLabelProviderAdapter(mappingDescriptor.getLabelDefinitionProvider()));
  }
}
