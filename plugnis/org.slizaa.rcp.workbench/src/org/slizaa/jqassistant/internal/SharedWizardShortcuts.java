package org.slizaa.jqassistant.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import org.eclipse.ui.IPageLayout;

public class SharedWizardShortcuts {

  public static void addWizardShortcuts(IPageLayout layout) {
    checkNotNull(layout).addNewWizardShortcut("org.slizaa.ui.shared.newprojectwizard");
    layout.addNewWizardShortcut("org.slizaa.jqassistant.newDbdefWizard");
    layout.addNewWizardShortcut("org.slizaa.jqassistant.newCypherWizard");
  }
}
