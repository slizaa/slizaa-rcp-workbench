/**
 *
 */
package org.slizaa.hierarchicalgraph.core.ui.dependencytree.internal.osgi;

import static com.google.common.base.Preconditions.checkNotNull;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.swt.widgets.Display;
import org.slizaa.hierarchicalgraph.core.selections.DependencySelection;
import org.slizaa.hierarchicalgraph.core.ui.dependencytree.internal.DependencyTreePart;
import org.slizaa.hierarchicalgraph.core.workbench.model.ModelPackage;
import org.slizaa.hierarchicalgraph.core.workbench.model.SlizaaWorkbenchModel;
import org.slizaa.ui.shared.ILifecycleParticipator;

import com.google.inject.Inject;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class DependencyTreePartLifecycleParticipator implements ILifecycleParticipator<DependencyTreePart> {

  @Inject
  private SlizaaWorkbenchModel _workbenchModel;

  /** - */
  private Adapter              _workbenchModelAdapter;

  /**
   * {@inheritDoc}
   */
  @Override
  public void postCreate(DependencyTreePart part) {

    // create and add the adapter
    this._workbenchModelAdapter = new MainDependencySelectionChangedAdapter(part);
    this._workbenchModel.eAdapters().add(this._workbenchModelAdapter);

    //
    part.handleMainDependencySelectionChanged(null, this._workbenchModel.getMainDependencySelection());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void preDestroy(DependencyTreePart part) {

    //
    this._workbenchModel.eAdapters().remove(this._workbenchModelAdapter);
  }

  /**
   * <p>
   * </p>
   *
   * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
   *
   */
  private final class MainDependencySelectionChangedAdapter extends AdapterImpl {

    /** - */
    private final DependencyTreePart _part;

    /**
     * <p>
     * Creates a new instance of type {@link MainDependencySelectionChangedAdapter}.
     * </p>
     *
     * @param part
     */
    private MainDependencySelectionChangedAdapter(DependencyTreePart part) {
      this._part = checkNotNull(part);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyChanged(Notification msg) {

      if (msg.getFeature() != null) {

        Display.getDefault().syncExec(() -> {

          if (msg.getFeature().equals(ModelPackage.eINSTANCE.getSlizaaWorkbenchModel_MainDependencySelection())) {

            this._part.handleMainDependencySelectionChanged((DependencySelection) msg.getOldValue(),
                (DependencySelection) msg.getNewValue());
          }
        });
      }
    }
  }
}
