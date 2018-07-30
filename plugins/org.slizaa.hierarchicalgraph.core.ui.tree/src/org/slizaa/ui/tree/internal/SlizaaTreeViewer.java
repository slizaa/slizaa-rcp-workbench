package org.slizaa.ui.tree.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TreeEvent;
import org.eclipse.swt.widgets.Composite;
import org.slizaa.hierarchicalgraph.core.model.HGRootNode;
import org.slizaa.hierarchicalgraph.core.model.HierarchicalgraphPackage;
import org.slizaa.hierarchicalgraph.core.model.impl.ExtendedHGNodeImpl;
import org.slizaa.hierarchicalgraph.core.model.spi.INodeComparator;
import org.slizaa.ui.shared.NodeComparator2ViewerComparatorAdapter;
import org.slizaa.ui.shared.context.BusyCursor;
import org.slizaa.ui.tree.interceptors.ISlizaaTreeEventInterceptor;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class SlizaaTreeViewer extends TreeViewer {

  /** - */
  private ISlizaaTreeEventInterceptor _eventInterceptor;

  /** - */
  private Adapter                     _adapter;

  /**
   * <p>
   * Creates a new instance of type {@link SlizaaTreeViewer}.
   * </p>
   *
   * @param parent
   * @param style
   * @param eventInterceptor
   */
  public SlizaaTreeViewer(Composite parent, int style, ISlizaaTreeEventInterceptor eventInterceptor,
      int autoExpandLevel) {
    super(parent, style);

    //
    this._eventInterceptor = eventInterceptor;

    //
    setAutoExpandLevel(autoExpandLevel);
    setUseHashlookup(true);

    //
    this._adapter = new AdapterImpl() {

      @Override
      public void notifyChanged(Notification notification) {

        switch (notification.getFeatureID(HGRootNode.class)) {
        case HierarchicalgraphPackage.HG_ROOT_NODE__EXTENSION_REGISTRY: {

          @SuppressWarnings("unchecked")
          BasicEMap.Entry<String, Object> newValue = (BasicEMap.Entry<String, Object>) notification.getNewValue();

          switch (newValue.getKey()) {
          case "org.slizaa.hierarchicalgraph.core.model.spi.INodeComparator":
            updateNodeComparator((HGRootNode) getInput());
            break;
          default:
            break;
          }

          break;
        }
        default:
          break;
        }
      }
    };
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void handleSelect(SelectionEvent event) {

    //
    if (event.item.getData() instanceof ExtendedHGNodeImpl) {

      BusyCursor.execute(getTree().getParent(), () -> {

        //
        if (this._eventInterceptor != null) {
          this._eventInterceptor.handleSelect((ExtendedHGNodeImpl) event.item.getData());
        }

        ExtendedHGNodeImpl hgNode = (ExtendedHGNodeImpl) event.item.getData();
        hgNode.onSelect();
      });
    }
    super.handleSelect(event);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void handleTreeExpand(TreeEvent event) {

    //
    if (event.item.getData() instanceof ExtendedHGNodeImpl) {

      BusyCursor.execute(getTree().getParent(), () -> {

        //
        if (this._eventInterceptor != null) {
          this._eventInterceptor.handleTreeExpand((ExtendedHGNodeImpl) event.item.getData());
        }

        ExtendedHGNodeImpl hgNode = (ExtendedHGNodeImpl) event.item.getData();
        hgNode.onExpand();
      });
    }
    super.handleTreeExpand(event);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void handleTreeCollapse(TreeEvent event) {

    //
    if (event.item.getData() instanceof ExtendedHGNodeImpl) {

      BusyCursor.execute(getTree().getParent(), () -> {

        //
        if (this._eventInterceptor != null) {
          this._eventInterceptor.handleTreeCollapse((ExtendedHGNodeImpl) event.item.getData());
        }

        //
        ExtendedHGNodeImpl hgNode = (ExtendedHGNodeImpl) event.item.getData();
        hgNode.onCollapse();
      });
    }
    super.handleTreeCollapse(event);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void inputChanged(Object newInput, Object oldInput) {

    // handle new input
    if (newInput instanceof HGRootNode) {

      // initial setup
      updateNodeComparator((HGRootNode) newInput);

      // add adapters
      ((HGRootNode) newInput).eAdapters().add(this._adapter);
    }

    // remove the old adapter
    if (oldInput instanceof HGRootNode) {

      //
      ((HGRootNode) oldInput).eAdapters().remove(this._adapter);
    }

    //
    super.inputChanged(newInput, oldInput);
  }

  /**
   * <p>
   * </p>
   *
   * @param rootNode
   */
  protected void updateNodeComparator(HGRootNode rootNode) {

    //
    if (checkNotNull(rootNode).hasExtension(INodeComparator.class)) {
      this.setComparator(new NodeComparator2ViewerComparatorAdapter(rootNode.getExtension(INodeComparator.class)));
    }
  }
}
