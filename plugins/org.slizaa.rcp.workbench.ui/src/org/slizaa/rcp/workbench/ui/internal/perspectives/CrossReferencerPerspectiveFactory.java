package org.slizaa.rcp.workbench.ui.internal.perspectives;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PerspectiveAdapter;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.internal.e4.compatibility.ModeledPageLayout;

public class CrossReferencerPerspectiveFactory implements IPerspectiveFactory {

  /** - */
  private static final String PERSPECTIVE_ID = "org.slizaa.rcp.workbench.ui.CrossReferencerPerspective";

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

    //
    layout.setEditorAreaVisible(true);
    layout.addShowViewShortcut(IPageLayout.ID_PROJECT_EXPLORER);
    layout.addShowViewShortcut("org.slizaa.ui.xref.XRefPart");
    layout.addShowViewShortcut("org.slizaa.ui.klighd.SlizaaDiagramViewPart");

    // ugly workaround: see https://www.eclipse.org/forums/index.php/t/1069917/
    IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    workbenchWindow.addPerspectiveListener(new PerspectiveAdapter() {

      @Override
      public void perspectiveOpened(IWorkbenchPage page, IPerspectiveDescriptor perspective) {
        super.perspectiveOpened(page, perspective);
        if (perspective.getId().equals(PERSPECTIVE_ID)) {
          IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
          IViewReference viewRef = activePage.findViewReference(IPageLayout.ID_PROJECT_EXPLORER, null);
          if (viewRef != null) {
            activePage.setPartState(viewRef, IWorkbenchPage.STATE_MINIMIZED);
          }

          // the work is done so remove this listener
          PlatformUI.getWorkbench().getActiveWorkbenchWindow().removePerspectiveListener(this);
        }
      }
    });
  }
}
