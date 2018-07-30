package org.slizaa.neo4j.ui.cypherview.internal.wizards;

import static com.google.common.base.Preconditions.checkNotNull;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

public class SaveAsCypherFileWizard extends BasicNewResourceWizard {

  /**
   * The wizard id for creating new files in the workspace.
   *
   * @since 3.4
   */
  public static final String        WIZARD_ID = "org.eclipse.ui.wizards.new.file"; //$NON-NLS-1$

  private WizardNewFileCreationPage mainPage;

  private String                    _content;

  /**
   * <p>
   * Creates a new instance of type {@link SaveAsCypherFileWizard}.
   * </p>
   *
   * @param content
   */
  public SaveAsCypherFileWizard(String content) {
    super();

    //
    this._content = checkNotNull(content);
  }

  @Override
  public void addPages() {
    super.addPages();
    this.mainPage = new SaveAsCypherFileWizardCreationPage("newFilePage1", getSelection(), this._content);
    this.mainPage.setTitle("File");
    this.mainPage.setDescription("Create a new file resource.");
    addPage(this.mainPage);
  }

  @Override
  public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
    super.init(workbench, currentSelection);
    setWindowTitle("New File");
    setNeedsProgressMonitor(true);
  }

  @Override
  protected void initializeDefaultPageImageDescriptor() {
    ImageDescriptor desc = IDEWorkbenchPlugin.getIDEImageDescriptor("wizban/newfile_wiz.png");//$NON-NLS-1$
    setDefaultPageImageDescriptor(desc);
  }

  @Override
  public boolean performFinish() {
    IFile file = this.mainPage.createNewFile();
    if (file == null) {
      return false;
    }

    selectAndReveal(file);

    // // Open editor on new file.
    // IWorkbenchWindow dw = getWorkbench().getActiveWorkbenchWindow();
    // try {
    // if (dw != null) {
    // IWorkbenchPage page = dw.getActivePage();
    // if (page != null) {
    // IDE.openEditor(page, file, true);
    // }
    // }
    // } catch (PartInitException e) {
    // DialogUtil.openError(dw.getShell(), "Problems Opening Editor", e.getMessage(), e);
    // }

    return true;
  }
}
