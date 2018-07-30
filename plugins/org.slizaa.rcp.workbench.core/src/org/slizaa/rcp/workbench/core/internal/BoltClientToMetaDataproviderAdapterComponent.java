package org.slizaa.rcp.workbench.core.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.slizaa.core.boltclient.IBoltClient;
import org.slizaa.neo4j.opencypher.spi.IGraphMetaDataProvider;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
@Component
public class BoltClientToMetaDataproviderAdapterComponent {

  /** - */
  private Map<IBoltClient, ServiceRegistration<IGraphMetaDataProvider>> _providerMap = new HashMap<>();

  /** - */
  private BundleContext                                                 _bundleContext;

  /**
   * <p>
   * </p>
   *
   * @param bundleContext
   */
  public void activate(BundleContext bundleContext) {
    _bundleContext = bundleContext;
  }

  /**
   * <p>
   * </p>
   *
   * @param boltClient
   */
  @Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
  public void addBoltClient(IBoltClient boltClient) {

    //
    MetaDataproviderAdapter adapter = new MetaDataproviderAdapter(boltClient);

    //
    ServiceRegistration<IGraphMetaDataProvider> registration = _bundleContext
        .registerService(IGraphMetaDataProvider.class, adapter, null);

    //
    _providerMap.put(boltClient, registration);
  }

  /**
   * <p>
   * </p>
   *
   * @param boltClient
   */
  public void removeBoltClient(IBoltClient boltClient) {

    //
    if (_providerMap.containsKey(boltClient)) {
      _providerMap.remove(boltClient).unregister();
      ;
    }
  }

  /**
   * <p>
   * </p>
   *
   * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
   *
   */
  private static class MetaDataproviderAdapter implements IGraphMetaDataProvider {

    /** - */
    private IBoltClient _boltClient;

    /**
     * <p>
     * Creates a new instance of type {@link MetaDataproviderAdapter}.
     * </p>
     *
     * @param boltClient
     */
    public MetaDataproviderAdapter(IBoltClient boltClient) {
      _boltClient = checkNotNull(boltClient);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getNodeLabels() {
      return _boltClient.getNodeLabels();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getPropertyKeys() {
      return _boltClient.getPropertyKeys();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getRelationshipTypes() {
      return _boltClient.getRelationshipTypes();
    }
  }
}
