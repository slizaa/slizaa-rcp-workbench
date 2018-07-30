package org.slizaa.hierarchicalgraph.graphdb.ui.hierarchicalgraphview;

import org.eclipse.jface.resource.ImageRegistry;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;
import org.slizaa.core.boltclient.testfwk.BoltClientConnectionRule;
import org.slizaa.hierarchicalgraph.core.model.HGRootNode;
import org.slizaa.hierarchicalgraph.core.model.spi.INodeLabelProvider;
import org.slizaa.hierarchicalgraph.core.testfwk.ui.AbstractSlizaaUiTest;
import org.slizaa.hierarchicalgraph.graphdb.mapping.service.IMappingService;
import org.slizaa.hierarchicalgraph.graphdb.mapping.service.MappingFactory;
import org.slizaa.hierarchicalgraph.graphdb.mapping.spi.IMappingProvider;
import org.slizaa.hierarchicalgraph.graphdb.testfwk.mapping.SimpleJTypeMappingProvider;
import org.slizaa.scanner.core.testfwk.PredefinedGraphDatabaseRule;
import org.slizaa.scanner.core.testfwk.TestDB;

public class HierarchicalGraphViewTest extends AbstractSlizaaUiTest {

  @ClassRule
  public static PredefinedGraphDatabaseRule _predefinedGraphDatabase = new PredefinedGraphDatabaseRule(TestDB.MAPSTRUCT,
      5001);

  @ClassRule
  public static BoltClientConnectionRule    _boltClientConnection    = new BoltClientConnectionRule("localhost", 5001);

  /**
   * <p>
   * </p>
   */
  @BeforeClass
  public static void createPart() {
    openShell(new HierarchicalGraphViewPart());
  }

  /**
   * <p>
   * </p>
   */
  @Test
  @Ignore
  public void testMappingService() {

    //
    IMappingService mappingService = MappingFactory.createMappingServiceForStandaloneSetup();

    //
    IMappingProvider mappingProvider = new SimpleJTypeMappingProvider();

    HGRootNode rootNode = mappingService.convert(mappingProvider, _boltClientConnection.getBoltClient(), null);

    //
    rootNode.registerExtension(INodeLabelProvider.class, new LabelDefinitionProvider2NoteLabelProviderAdapter(
        mappingProvider.getLabelDefinitionProvider(), new ImageRegistry(display())));

    //
    rootNode.registerExtension(IMappingProvider.class, mappingProvider);

    //
    workbenchModel().setRootNode(rootNode);
  }
}