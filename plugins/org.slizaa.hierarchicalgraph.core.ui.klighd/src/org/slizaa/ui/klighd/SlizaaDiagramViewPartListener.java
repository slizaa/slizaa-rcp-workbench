package org.slizaa.ui.klighd;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.internal.PartSite;
import org.eclipse.ui.progress.UIJob;
import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.hierarchicalgraph.core.selections.NodeSelection;
import org.slizaa.hierarchicalgraph.core.selections.NodeSelection;
import org.slizaa.hierarchicalgraph.core.workbench.model.ModelPackage;
import org.slizaa.hierarchicalgraph.core.workbench.model.SlizaaWorkbenchModel;

import de.cau.cs.kieler.klighd.ui.DiagramViewManager;

/**
 *
 */
class SlizaaDiagramViewPartListener implements IPartListener2 {

  private static final String         UPDATE_JOB = "Updating Diagram";

  /** The related diagram view. */
  private final SlizaaDiagramViewPart _diagramView;

  /** - */
  private Set<HGNode>                 _currentNodeSelection;

  /** - */
  private Set<HGNode>                 _shownNodeSelection;

  /** - */
  private SlizaaWorkbenchModel        _slizaaWorkbenchModel;

  private Adapter                     _adapter;

  /**
   * Create a new listener handling events for the given {@link SlizaaDiagramViewPart}.
   * <p>
   *
   * @param diagramView
   *          The associated {@link SlizaaDiagramViewPart}
   */
  SlizaaDiagramViewPartListener(final SlizaaDiagramViewPart diagramView) {
    this._diagramView = checkNotNull(diagramView);
  }

  /**
   * Activated this adapter.
   */
  public void activate() {
    this._diagramView.getSite().getPage().addPartListener(this);

    //
    IEclipseContext context = ((PartSite) this._diagramView.getSite()).getContext();

    //
    this._slizaaWorkbenchModel = context.get(SlizaaWorkbenchModel.class);

    //
    this._adapter = new AdapterImpl() {
      @Override
      public void notifyChanged(Notification msg) {
        if (msg.getFeature() != null) {
          if (msg.getFeature().equals(ModelPackage.eINSTANCE.getSlizaaWorkbenchModel_NodeSelection())) {
            NodeSelection nodeSelection = (NodeSelection) msg.getNewValue();
            initSelection(nodeSelection != null ? new HashSet<>(nodeSelection.getNodes()) : Collections.emptySet());
          }
        }
      }
    };
    this._slizaaWorkbenchModel.eAdapters().add(this._adapter);

    //
    initSelection(this._slizaaWorkbenchModel.getNodeSelection() != null
        ? new HashSet<>(this._slizaaWorkbenchModel.getNodeSelection().getNodes())
        : Collections.emptySet());
  }

  /**
   * Deactivated this adapter.
   */
  public void deactivate() {
    this._diagramView.getSite().getPage().removePartListener(this);
    this._slizaaWorkbenchModel.eAdapters().remove(this._adapter);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void partOpened(final IWorkbenchPartReference partRef) {

    //
    if (!SlizaaDiagramViewPart.ID.equals(partRef.getId())) {
      return;
    }

    this._diagramView.updateDiagram();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void partClosed(final IWorkbenchPartReference partRef) {

    //
    if (!SlizaaDiagramViewPart.ID.equals(partRef.getId())) {
      return;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void partActivated(final IWorkbenchPartReference partRef) {

    //
    if (!SlizaaDiagramViewPart.ID.equals(partRef.getId())) {
      return;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void partBroughtToTop(final IWorkbenchPartReference partRef) {

    //
    if (!SlizaaDiagramViewPart.ID.equals(partRef.getId())) {
      return;
    }

    updateNodeSelection();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void partDeactivated(final IWorkbenchPartReference partRef) {

    //
    if (!SlizaaDiagramViewPart.ID.equals(partRef.getId())) {
      return;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void partHidden(final IWorkbenchPartReference partRef) {

    //
    if (!SlizaaDiagramViewPart.ID.equals(partRef.getId())) {
      return;
    }

    //
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void partVisible(final IWorkbenchPartReference partRef) {

    //
    if (!SlizaaDiagramViewPart.ID.equals(partRef.getId())) {
      return;
    }

    //
    updateNodeSelection();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void partInputChanged(final IWorkbenchPartReference partRef) {

    //
    if (!SlizaaDiagramViewPart.ID.equals(partRef.getId())) {
      return;
    }
  }

  private void initSelection(Set<HGNode> selectedNodes) {

    //
    this._currentNodeSelection = selectedNodes;

    //
    if (this._diagramView.getSite().getPage().isPartVisible(this._diagramView)) {
      updateNodeSelection();
    }
  }

  /**
   * @param selection
   */
  private void updateNodeSelection() {

    if (!equalLists(this._currentNodeSelection, this._shownNodeSelection)) {

      this._shownNodeSelection = this._currentNodeSelection;

      // Start update job
      new UIJob(UPDATE_JOB) {
        @Override
        public IStatus runInUIThread(final IProgressMonitor monitor) {
          DiagramViewManager.updateView("org.slizaa.ui.klighd.SlizaaDiagramViewPart", null,
              SlizaaDiagramViewPartListener.this._currentNodeSelection, null);
          return Status.OK_STATUS;
        }
      }.schedule();
    }
  }

  public boolean equalLists(Collection<HGNode> a, Collection<HGNode> b) {

    if (a == null && b == null) {
      return true;
    }

    //
    if ((a == null && b != null) || (a != null && b == null) || (a.size() != b.size())) {
      return false;
    }

    return a.equals(b);
  }
}
