package org.slizaa.ui.shared;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.slizaa.hierarchicalgraph.core.model.HGRootNode;
import org.slizaa.hierarchicalgraph.core.selections.DependencySelection;
import org.slizaa.hierarchicalgraph.core.selections.NodeSelection;
import org.slizaa.hierarchicalgraph.core.workbench.model.ModelPackage;
import org.slizaa.hierarchicalgraph.core.workbench.model.SlizaaWorkbenchModel;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public abstract class AbstractSlizaaWorkbenchModelComponent {

  /** - */
  private SlizaaWorkbenchModel _workbenchModel;

  /** - */
  private Adapter              _workbenchModelObserver;

  @PostConstruct
  public abstract void createComposite(Composite parent);

  /**
   * <p>
   * </p>
   */
  @PostConstruct
  @Inject
  public final void initializeAbstractSlizaaPart(SlizaaWorkbenchModel workbenchModel) {

    this._workbenchModel = checkNotNull(workbenchModel, "SlizaaWorkbenchModel must not be null.");

    //
    this._workbenchModelObserver = new AdapterImpl() {
      @Override
      public void notifyChanged(Notification msg) {
        if (msg.getFeature() != null) {

          //
          Display.getDefault().syncExec(() -> {
            //
            if (msg.getFeature().equals(ModelPackage.eINSTANCE.getSlizaaWorkbenchModel_RootNode())) {
              handleRootNodeChanged((HGRootNode) msg.getOldValue(), (HGRootNode) msg.getNewValue());
            }
            //
            else if (msg.getFeature()
                .equals(ModelPackage.eINSTANCE.getSlizaaWorkbenchModel_MainDependencySelection())) {
              handleMainDependencySelectionChanged((DependencySelection) msg.getOldValue(),
                  (DependencySelection) msg.getNewValue());
            }
            //
            else if (msg.getFeature()
                .equals(ModelPackage.eINSTANCE.getSlizaaWorkbenchModel_DetailDependencySelection())) {
              handleDetailDependencySelectionChanged((DependencySelection) msg.getOldValue(),
                  (DependencySelection) msg.getNewValue());
            }
            //
            else if (msg.getFeature().equals(ModelPackage.eINSTANCE.getSlizaaWorkbenchModel_NodeSelection())) {
              handleNodeSelectionChanged((NodeSelection) msg.getOldValue(), (NodeSelection) msg.getNewValue());
            }
          });
        }
      }
    };

    //
    this._workbenchModel.eAdapters().add(this._workbenchModelObserver);
  }

  /**
   * <p>
   * </p>
   */
  @PreDestroy
  public final void disposeAbstractSlizaaPart() {

    //
    this._workbenchModel.eAdapters().remove(this._workbenchModelObserver);
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public SlizaaWorkbenchModel getWorkbenchModel() {
    checkState(this._workbenchModel != null,
        "Component has not been initialized (invoke 'initializeAbstractSlizaaPart(SlizaaWorkbenchModel)').");
    return this._workbenchModel;
  }

  /**
   * <p>
   * </p>
   *
   * @param oldValue
   * @param newValue
   */
  protected void handleRootNodeChanged(HGRootNode oldValue, HGRootNode newValue) {
    // do nothing
  }

  protected void handleDetailDependencySelectionChanged(DependencySelection oldValue, DependencySelection newValue) {
    // do nothing
  }

  protected void handleMainDependencySelectionChanged(DependencySelection oldValue, DependencySelection newValue) {
    // do nothing
  }

  protected void handleNodeSelectionChanged(NodeSelection oldValue, NodeSelection newValue) {
    // do nothing
  }
}
