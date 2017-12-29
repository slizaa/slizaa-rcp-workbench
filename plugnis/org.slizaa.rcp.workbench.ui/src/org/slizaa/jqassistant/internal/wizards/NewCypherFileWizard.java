package org.slizaa.jqassistant.internal.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;

public class NewCypherFileWizard extends Wizard implements INewWizard {

  private IStructuredSelection    _selection;

  private NewCypherFileWizardPage _newFileWizardPage;

  private IWorkbench              _workbench;

  /**
   * <p>
   * Creates a new instance of type {@link NewCypherFileWizard}.
   * </p>
   *
   */
  public NewCypherFileWizard() {
    setWindowTitle("New Cypher File");
  }

  @Override
  public void addPages() {
    _newFileWizardPage = new NewCypherFileWizardPage(_selection);
    addPage(_newFileWizardPage);
  }

  @Override
  public boolean performFinish() {
    IFile file = _newFileWizardPage.createNewFile();

    try {
      IWorkbenchWindow win = _workbench.getActiveWorkbenchWindow();
      IWorkbenchPage page = win.getActivePage();
      IDE.openEditor(page, file);
    } catch (PartInitException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    if (file != null)
      return true;
    else
      return false;
  }

  public void init(IWorkbench workbench, IStructuredSelection selection) {
    this._workbench = workbench;
    this._selection = selection;
  }
}
