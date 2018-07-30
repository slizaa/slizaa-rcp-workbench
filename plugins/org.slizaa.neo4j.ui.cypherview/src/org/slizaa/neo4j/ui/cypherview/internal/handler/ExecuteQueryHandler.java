package org.slizaa.neo4j.ui.cypherview.internal.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;

public class ExecuteQueryHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    execute();
    return null;
  }

  @CanExecute
  @Override
  public boolean isEnabled() {
    return true;
  }

  @Execute
  public void execute() {

    //
    ExecuteQuery.executeQuery();
  }
}
