package org.slizaa.neo4j.ui.cypherview.internal.osgi;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slizaa.core.boltclient.IQueryResultConsumer;
import org.slizaa.core.boltclient.IQueryResultConsumerListener;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class QueryResultConsumerListener implements IQueryResultConsumerListener {

  /** - */
  private List<IQueryResultConsumer> _consumers;

  /**
   * <p>
   * Creates a new instance of type {@link QueryResultConsumerListener}.
   * </p>
   */
  public QueryResultConsumerListener() {
    _consumers = new CopyOnWriteArrayList<>();
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public List<IQueryResultConsumer> getConsumers() {
    return Collections.unmodifiableList(_consumers);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void queryResultConsumerAdded(IQueryResultConsumer consumer) {
    if (consumer != null) {
      _consumers.add(consumer);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void queryResultConsumerRemoved(IQueryResultConsumer consumer) {
    _consumers.remove(consumer);
  }
}
