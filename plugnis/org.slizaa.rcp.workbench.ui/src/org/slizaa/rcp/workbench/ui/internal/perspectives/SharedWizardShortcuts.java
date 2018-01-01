package org.slizaa.rcp.workbench.ui.internal.perspectives;

import static com.google.common.base.Preconditions.checkNotNull;

import org.eclipse.ui.IPageLayout;

public class SharedWizardShortcuts {

  public static void addWizardShortcuts(IPageLayout layout) {

    // TODO

    checkNotNull(layout).addNewWizardShortcut("org.slizaa.ui.shared.newprojectwizard");
    layout.addNewWizardShortcut("org.slizaa.jqassistant.newCypherWizard");
  }
}
