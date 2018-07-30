package org.slizaa.ui.klighd;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.ui.statushandlers.StatusManager;
import org.slizaa.ui.klighd.nullmodel.NullModel;

import de.cau.cs.kieler.klighd.LightDiagramServices;
import de.cau.cs.kieler.klighd.ViewContext;
import de.cau.cs.kieler.klighd.kgraph.KNode;
import de.cau.cs.kieler.klighd.ui.parts.DiagramViewPart;
import de.cau.cs.kieler.klighd.ui.view.KlighdViewPlugin;
import de.cau.cs.kieler.klighd.ui.view.model.ErrorModel;
import de.cau.cs.kieler.klighd.util.KlighdSynthesisProperties;

public class SlizaaDiagramViewPart extends DiagramViewPart {

  // http://stackoverflow.com/questions/23992497/get-e4-service-without-injection

  // set the ID
  public static String                  ID                       = "org.slizaa.ui.klighd.SlizaaDiagramViewPart";

  /** UI job prefix. **/
  private static final String           UPDATE_JOB               = "Updating Diagram";

  private static final String           UPDATE_DIAGRAM_EXCEPTION = "Displaying diagram failed!";

  // -- ATTRIBUTES --

  /** The views root composite. */
  private Composite                     _viewComposite;

  /** - */
  private SlizaaDiagramViewPartListener _partListener;

  /** The menu manger. */
  private IMenuManager                  _menuManager;

  /** The toolbar manager. */
  private IToolBarManager               _toolBarManager;

  /**
   * 
   */
  public SlizaaDiagramViewPart() {

    //
    _partListener = new SlizaaDiagramViewPartListener(this);
  }

  @Override
  public void init(IViewSite site) throws PartInitException {
    super.init(site);

    //
    _partListener.activate();
  }

  @Override
  public void init(IViewSite site, IMemento memento) throws PartInitException {
    super.init(site, memento);

    _partListener.activate();
  }

  @Override
  public void dispose() {
    _partListener.deactivate();

    super.dispose();
  }

  @Override
  public String getPartId() {
    return ID;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void createPartControl(final Composite parent) {
    super.createPartControl(parent);
    _viewComposite = parent;

    IActionBars bars = getViewSite().getActionBars();
    _toolBarManager = bars.getToolBarManager();
    _menuManager = bars.getMenuManager();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void addButtons() {
    // Suppressing DiagramViewPart default buttons
  }

  /**
   * Updates the diagram.
   */
  public void updateDiagram() {
    KlighdSynthesisProperties properties = new KlighdSynthesisProperties();
    if (this.getViewer() != null && this.getViewer().getViewContext() != null) {
      properties.copyProperties(this.getViewContext());
    }
    updateDiagram(null, properties);
  }

  /**
   * Updates displayed diagram in a dedicated job.
   * 
   * @param model
   *          the new model
   * @param properties
   *          the properties
   */
  private void updateDiagram(final Object model, final KlighdSynthesisProperties properties) {

    // Adjust model
    Object displayModel = model;
    if (model == null) {
      displayModel = new NullModel();
    }
    final Object finalDisplayModel = displayModel;

    // Start update job
    new UIJob(UPDATE_JOB) {

      @Override
      public IStatus runInUIThread(final IProgressMonitor monitor) {
        doUpdateDiagram(finalDisplayModel, properties, false);
        return Status.OK_STATUS;
      }
    }.schedule();
  }

  /**
   * Performs the actual update on the diagram.
   * <p>
   * This method is intended to run in a separate UIJob.
   * 
   * @param model
   *          model to display
   * @param properties
   *          properties for configuration
   * @param usedController
   *          the controller related to this update
   * @param sourceEditor
   *          the editor related to the model
   * @param isErrorModel
   *          true indicates an re-invocation of update to show an error model concerning an error occurred in the
   *          actual update.
   */
  private void doUpdateDiagram(final Object model, final KlighdSynthesisProperties properties,
      final boolean isErrorModel) {

    try {

      // Indicated if the model type changed against the current model
      boolean modelTypeChanged = false;
      ViewContext viewContext = null;
      if (this.getViewer() == null || this.getViewer().getViewContext() == null) {
        // if viewer or context does not exist always init view
        modelTypeChanged = true;
      } else {
        viewContext = this.getViewer().getViewContext();
        if (viewContext.getInputModel() == null || viewContext.getInputModel().getClass() != model.getClass()) {
          modelTypeChanged = true;
        }
      }

      // --Update diagram--

      // Success flag indicating a successful synthesis and diagram update
      boolean success = false;

      // If the type changed the view must be reinitialized to provide a
      // correct ViewContext
      // otherwise the ViewContext can be simply updated
      if (modelTypeChanged) {

        // the (re)initialization case
        initialize(model, null, properties);
        success = true;

        // get newly create ViewContext
        viewContext = this.getViewer().getViewContext();

        // reset layout to resolve KISEMA-905
        resetLayoutConfig(false);
      } else {
        boolean hadChildContexts = !viewContext.getChildViewContexts(false).isEmpty();

        // Configure present view context
        viewContext.copyProperties(properties);

        // update case (keeps options and sidebar)
        success = LightDiagramServices.updateDiagram(this.getViewer().getViewContext(), model, properties);

        // Update side if the synthesis option changed due to child
        // syntheses
        if (success && (!viewContext.getChildViewContexts(false).isEmpty() || hadChildContexts)) {
          this.updateOptions(true);
        }
      }

      // check if update really was successful
      KNode currentDiagram = viewContext.getViewModel();
      if (!success || currentDiagram == null || (currentDiagram.getChildren().isEmpty() && !(model instanceof KNode))) {
        // throw new NullPointerException(DIAGRAM_IS_NULL);
        // simply ignore
      } else {
        _viewComposite.layout();
      }
    } catch (Exception e) {
      e.printStackTrace();
      if (!isErrorModel) {
        doUpdateDiagram(new ErrorModel(UPDATE_DIAGRAM_EXCEPTION, e), properties, true);
      } else {
        StatusManager.getManager().handle(
            new Status(IStatus.WARNING, KlighdViewPlugin.PLUGIN_ID, e.getLocalizedMessage(), e), StatusManager.SHOW);
      }

    }
  }
}
