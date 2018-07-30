package org.slizaa.neo4j.ui.cypherview.internal.handler;

import javax.inject.Named;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.slizaa.neo4j.ui.cypherview.CypherViewPart;
import org.slizaa.neo4j.ui.cypherview.internal.osgi.CypherViewActivator;
import org.slizaa.neo4j.ui.cypherview.internal.wizards.SaveAsCypherFileWizard;

public final class SaveAsCypherFileHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {

    //
    CypherViewPart cypherViewPart = CypherViewActivator.getInstance().getCurrentCypherViewPart();

    //
    String currentModel = cypherViewPart.getModel();
    Shell shell = Display.getDefault().getActiveShell();

    //
    saveCypherFile(shell, currentModel);

    //
    return null;
  }

  @Execute
  public void run(@Named(IServiceConstants.ACTIVE_PART) MPart mPart, final Shell shell) {

    //
    CypherViewPart part = (CypherViewPart) mPart.getObject();

    //
    saveCypherFile(shell, part.getModel());
  }

  /**
   * <p>
   * </p>
   *
   * @param currentModel
   * @param shell
   *
   */
  private void saveCypherFile(Shell shell, String currentModel) {

    SaveAsCypherFileWizard wizard = new SaveAsCypherFileWizard(currentModel);
    wizard.init(PlatformUI.getWorkbench(), new StructuredSelection());
    WizardDialog dialog = new WizardDialog(shell, wizard);
    dialog.open();
  }
}