package org.slizaa.rcp.workbench.ui.internal.wizards;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class NewCypherFileWizardPage extends WizardNewFileCreationPage {

  public NewCypherFileWizardPage(IStructuredSelection selection) {
    super("NewCypherFileWizardPage", selection);
    setTitle("Cypher File");
    setDescription("Creates a new Cypher File");
    setFileExtension("cypher");
  }

  @Override
  protected InputStream getInitialContents() {
    // Bundle bundle = FrameworkUtil.getBundle(this.getClass()).getBundleContext().getBundle();
    return new ByteArrayInputStream("".getBytes(StandardCharsets.UTF_8));
  }
}