
package org.slizaa.hierarchicalgraph.core.ui.tree.fwk;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.slizaa.hierarchicalgraph.core.model.HGRootNode;
import org.slizaa.ui.shared.AbstractSlizaaWorkbenchModelComponent;
import org.slizaa.ui.tree.SlizaaTreeViewerFactory;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class DummySlizaaTreeViewerComponent extends AbstractSlizaaWorkbenchModelComponent {

  /** - */
  private TreeViewer _slizaaTreeViewer;

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public TreeViewer getTreeViewer() {
    return this._slizaaTreeViewer;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void createComposite(Composite parent) {

    //
    GridLayoutFactory.fillDefaults().applyTo(parent);

    //
    this._slizaaTreeViewer = SlizaaTreeViewerFactory.newSlizaaTreeViewer(parent).withStyle(SWT.NONE)
        .withAutoExpandLevel(1).create();

    //
    GridDataFactory.fillDefaults().grab(true, true).applyTo(this._slizaaTreeViewer.getControl());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void handleRootNodeChanged(HGRootNode oldValue, HGRootNode newValue) {
    this._slizaaTreeViewer.setInput(newValue);
  }
}
