/**
 *
 */
package org.slizaa.neo4j.ui.cypherview.internal.handler;

import java.util.List;

import org.slizaa.core.boltclient.IQueryResultConsumer;
import org.slizaa.neo4j.ui.cypherview.CypherViewPart;
import org.slizaa.neo4j.ui.cypherview.internal.osgi.CypherViewActivator;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class ExecuteQuery {

  /**
   * <p>
   * </p>
   *
   */
  public static void executeQuery() {

    //
    CypherViewPart cypherViewPart = CypherViewActivator.getInstance().getCurrentCypherViewPart();

    List<IQueryResultConsumer> queryResultConsumers = CypherViewActivator.getInstance().getQueryResultConsumers();

    // TODO!!
    if (cypherViewPart != null && cypherViewPart.getBoltClient() != null && !queryResultConsumers.isEmpty()) {

      try {

        //
        FocusSettingDelegatingQueryResultConsumer consumer = new FocusSettingDelegatingQueryResultConsumer(
            queryResultConsumers.get(0));

        //
        cypherViewPart.getBoltClient().asyncExecCypherQuery(cypherViewPart.getModel(), consumer);

      } catch (Exception exception) {
        // _executeAction.setEnabled(true);
      }
    }
  }
}
