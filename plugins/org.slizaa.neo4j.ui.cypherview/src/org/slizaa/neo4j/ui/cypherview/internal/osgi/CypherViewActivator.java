package org.slizaa.neo4j.ui.cypherview.internal.osgi;

import java.util.List;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.slizaa.core.boltclient.IQueryResultConsumer;
import org.slizaa.core.boltclient.IQueryResultConsumerListener;
import org.slizaa.neo4j.ui.cypherview.CypherViewPart;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class CypherViewActivator extends AbstractUIPlugin {

  /** - */
  public static final String          ORG_SLIZAA_NEO4J_OPENCYPHER_OPENCYPHER = "org.slizaa.neo4j.opencypher.OpenCypher";

  /** - */
  private static CypherViewActivator  _instance;

  /** - */
  private CypherViewPart              _currentCypherViewPart;

  /** - */
  private QueryResultConsumerListener _queryResultConsumerListener;

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public static CypherViewActivator getInstance() {
    return _instance;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);

    // register as OSGi service
    _queryResultConsumerListener = new QueryResultConsumerListener();
    context.registerService(IQueryResultConsumerListener.class, _queryResultConsumerListener, null);

    //
    _instance = this;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void stop(BundleContext context) throws Exception {

    //
    _instance = null;

    //
    super.stop(context);
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public List<IQueryResultConsumer> getQueryResultConsumers() {
    return _queryResultConsumerListener.getConsumers();
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public boolean hasCurrentCypherViewPart() {
    return _currentCypherViewPart != null;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public CypherViewPart getCurrentCypherViewPart() {
    return _currentCypherViewPart;
  }

  /**
   * <p>
   * </p>
   *
   * @param currentCypherViewPart
   */
  public void setCurrentCypherViewPart(CypherViewPart currentCypherViewPart) {
    _currentCypherViewPart = currentCypherViewPart;
  }
}
