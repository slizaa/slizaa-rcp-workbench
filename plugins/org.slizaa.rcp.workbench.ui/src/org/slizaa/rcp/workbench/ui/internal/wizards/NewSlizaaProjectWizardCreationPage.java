package org.slizaa.rcp.workbench.ui.internal.wizards;

import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

/**
 * <p>
 * A wizard page to enter the required settings for a BundleMaker project.
 * </p>
 */
public class NewSlizaaProjectWizardCreationPage extends WizardNewProjectCreationPage {

  /**
   * <p>
   * Creates a new instance of type {@link NewSlizaaProjectWizardCreationPage}.
   * </p>
   */
  public NewSlizaaProjectWizardCreationPage() {
    super("NewSlizaaProjectWizardCreationPage");

    setTitle("Create a Slizaa project");
    setDescription("Set project name.");
  }

}
