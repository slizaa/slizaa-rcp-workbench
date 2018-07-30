package org.slizaa.neo4j.queryresult.ui.internal;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.exceptions.Neo4jException;
import org.slizaa.core.boltclient.IQueryResultConsumer;
import org.slizaa.neo4j.queryresult.ui.QueryResultViewConstants;

public class CustomQueryResultConsumer implements IQueryResultConsumer {

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean canConsume(String cypherQuery) {
    return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void handleQueryStarted(String cypherQuery) {

    //
    bringQueryResultViewToFront();

    //
    if (QueryResultActivator.getDefault() != null && QueryResultActivator.getDefault().hasQueryResultViewPart()) {
      QueryResultActivator.getDefault().getQueryResultViewPart().handleQueryStarted();
    }
  }

  @Override
  public void handleQueryResultReceived(String cypherQuery, StatementResult result) {

    //
    bringQueryResultViewToFront();

    //
    if (QueryResultActivator.getDefault() != null && QueryResultActivator.getDefault().hasQueryResultViewPart()) {
      QueryResultActivator.getDefault().getQueryResultViewPart().handleQueryResultReceived(cypherQuery, result);
    }
  }

  @Override
  public void handleError(String cypherQuery, StatementResult result, Neo4jException exception) {

    //
    bringQueryResultViewToFront();

    //
    if (QueryResultActivator.getDefault() != null && QueryResultActivator.getDefault().hasQueryResultViewPart()) {
      QueryResultActivator.getDefault().getQueryResultViewPart().handleError(cypherQuery, result, exception);
    }
  }

  /**
   * <p>
   * </p>
   */
  private void bringQueryResultViewToFront() {

    //
    Display.getDefault().syncExec(() -> {
      try {
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(QueryResultViewConstants.VIEW_ID);
      } catch (PartInitException e) {
        // do nothing
      }
    });
  }
}
