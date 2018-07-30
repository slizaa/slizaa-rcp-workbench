package org.slizaa.hierarchicalgraph.graphdb.ui.mappingsdialog;

import java.util.Map;

import org.slizaa.hierarchicalgraph.core.model.spi.INodeComparator;
import org.slizaa.hierarchicalgraph.graphdb.mapping.spi.IDependencyDefinitionProvider;
import org.slizaa.hierarchicalgraph.graphdb.mapping.spi.IHierarchyDefinitionProvider;
import org.slizaa.hierarchicalgraph.graphdb.mapping.spi.ILabelDefinitionProvider;
import org.slizaa.hierarchicalgraph.graphdb.mapping.spi.IMappingProvider;

public class DummyMappingProvider implements IMappingProvider {

  /** - */
  private IMappingProviderMetadata _metadata;

  /**
   * <p>
   * Creates a new instance of type {@link DummyMappingProvider}.
   * </p>
   *
   * @param identifier
   * @param name
   * @param description
   * @param categories
   */
  public DummyMappingProvider(String identifier, String name, String description, Map<String, String> categories) {
    this._metadata = IMappingProviderMetadata.createMetadata(identifier, name, description, categories);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public IMappingProviderMetadata getMappingProviderMetadata() {
    return this._metadata;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public IHierarchyDefinitionProvider getHierarchyDefinitionProvider() {
    throw new UnsupportedOperationException();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public IDependencyDefinitionProvider getDependencyDefinitionProvider() {
    throw new UnsupportedOperationException();
  }

  @Override
  public ILabelDefinitionProvider getLabelDefinitionProvider() {
    throw new UnsupportedOperationException();
  }

  @Override
  public INodeComparator getNodeComparator() {
    throw new UnsupportedOperationException();
  }
}
