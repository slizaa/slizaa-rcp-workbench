/**
 *
 */
package org.slizaa.neo4j.ui.cypherview.internal.handler;

import static com.google.common.base.Preconditions.checkNotNull;

import org.eclipse.swt.widgets.Display;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.exceptions.Neo4jException;
import org.slizaa.core.boltclient.IQueryResultConsumer;
import org.slizaa.neo4j.ui.cypherview.internal.utils.ViewUtils;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class FocusSettingDelegatingQueryResultConsumer implements IQueryResultConsumer {

  /** - */
  private static final String  ORG_SLIZAA_NEO4J_UI_CYPHERVIEW_CYPHER_VIEW_PART = "org.slizaa.neo4j.ui.cypherview.CypherViewPart";

  /** - */
  private IQueryResultConsumer _target;

  /**
   * <p>
   * Creates a new instance of type {@link FocusSettingDelegatingQueryResultConsumer}.
   * </p>
   *
   * @param target
   */
  public FocusSettingDelegatingQueryResultConsumer(IQueryResultConsumer target) {
    this._target = checkNotNull(target);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean canConsume(String cypherQuery) {
    return this._target.canConsume(cypherQuery);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void handleQueryStarted(String cypherQuery) {
    this._target.handleQueryStarted(cypherQuery);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void handleQueryResultReceived(String cypherQuery, StatementResult result) {
    this._target.handleQueryResultReceived(cypherQuery, result);
    forceFocus();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void handleError(String cypherQuery, StatementResult result, Neo4jException exception) {
    this._target.handleError(cypherQuery, result, exception);
    forceFocus();
  }

  private void forceFocus() {
    Display.getDefault().asyncExec(() -> ViewUtils.forceFocus(ORG_SLIZAA_NEO4J_UI_CYPHERVIEW_CYPHER_VIEW_PART));
  }
}
