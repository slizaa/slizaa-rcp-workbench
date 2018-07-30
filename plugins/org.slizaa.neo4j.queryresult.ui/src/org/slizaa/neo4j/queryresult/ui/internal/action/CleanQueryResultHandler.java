package org.slizaa.neo4j.queryresult.ui.internal.action;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.slizaa.neo4j.queryresult.ui.internal.QueryResultViewPart;

public class CleanQueryResultHandler {

  @Execute
  public void execute(EPartService ePartService) {
    MPart part = ePartService.findPart("org.slizaa.neo4j.queryresult.ui.QueryResultViewPart");
    QueryResultViewPart queryResultViewPart = (QueryResultViewPart) part.getObject();
    queryResultViewPart.clean();
  }

  @CanExecute
  public boolean canExecute() {
    return true;
  }
}