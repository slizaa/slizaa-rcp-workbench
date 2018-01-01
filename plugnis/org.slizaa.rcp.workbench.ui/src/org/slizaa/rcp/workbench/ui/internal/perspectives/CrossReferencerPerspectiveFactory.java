package org.slizaa.rcp.workbench.ui.internal.perspectives;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.internal.e4.compatibility.ModeledPageLayout;

public class CrossReferencerPerspectiveFactory implements IPerspectiveFactory {

  /** - */
  private static final String FOLDER_UPPER_LEFT  = "upperleft";

  /** - */
  private static final String FOLDER_LOWER_LEFT  = "lowerleft";

  /** - */
  private static final String FOLDER_LOWER_RIGHT = "lowerright";

  @Override
  public void createInitialLayout(IPageLayout layout) {

    // add wizard shortcut
    SharedWizardShortcuts.addWizardShortcuts(layout);

    //
    IFolderLayout folderLayout = layout.createFolder(FOLDER_UPPER_LEFT, IPageLayout.LEFT, 0.2f,
        IPageLayout.ID_EDITOR_AREA);
    folderLayout.addView(IPageLayout.ID_PROJECT_EXPLORER);
    folderLayout.addView("org.slizaa.neo4j.restclient.ui.GraphDatabasesView");

    //
    folderLayout = layout.createFolder(FOLDER_LOWER_LEFT, IPageLayout.BOTTOM, 0.6f, FOLDER_UPPER_LEFT);

    // http://stackoverflow.com/questions/26776802/eclipse-rcp-open-a-view-in-the-editor-area-3-8-e4-hybrid
    ((ModeledPageLayout) layout).stackView("org.slizaa.ui.xref.XRefPart", IPageLayout.ID_EDITOR_AREA, false);

    //
    folderLayout = layout.createFolder(FOLDER_LOWER_RIGHT, IPageLayout.BOTTOM, 0.6f, IPageLayout.ID_EDITOR_AREA);
    folderLayout.addView("org.slizaa.ui.dependencytree.DependencyTreePart");
    folderLayout.addView("org.slizaa.ui.dependencytable.DependencyTablePart");
    folderLayout.addView("org.slizaa.neo4j.ui.cypherview.CypherViewPart");
    folderLayout.addPlaceholder(IConsoleConstants.ID_CONSOLE_VIEW);

    layout.setEditorAreaVisible(true);

    //
    layout.addShowViewShortcut(IPageLayout.ID_PROJECT_EXPLORER);
    layout.addShowViewShortcut("org.slizaa.ui.xref.XRefPart");
    layout.addShowViewShortcut("org.slizaa.ui.klighd.SlizaaDiagramViewPart");
    // layout.addShowViewShortcut(IPageLayout.ID_PROBLEM_VIEW);
    // layout.addShowViewShortcut(IPageLayout.ID_PROGRESS_VIEW);
    // layout.addShowViewShortcut(IPageLayout.ID_TASK_LIST);
  }
}
