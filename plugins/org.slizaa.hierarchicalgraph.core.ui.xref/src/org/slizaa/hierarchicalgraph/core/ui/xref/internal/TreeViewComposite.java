package org.slizaa.hierarchicalgraph.core.ui.xref.internal;

import static com.google.common.base.Preconditions.checkState;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.slizaa.ui.tree.SlizaaTreeViewerFactory;
import org.slizaa.ui.tree.expand.IExpandStrategy;
import org.slizaa.ui.tree.interceptors.DependencyResolvingTreeEventInterceptor;

public class TreeViewComposite {

  /** the from tree viewer */
  private TreeViewer            _treeViewer;

  /** - */
  private IExpandStrategy       _treeExpandStrategy;

  /** - */
  private ToolBar               _toolBar;

  /** - */
  private Map<String, ToolItem> _toolItemMap;

  /**
   * <p>
   * Creates a new instance of type {@link TreeViewComposite}.
   * </p>
   *
   * @param parent
   * @param interceptor
   * @param expandStrategy
   * @param hAlign
   *          horizontal alignment. One of SWT.BEGINNING, SWT.CENTER, SWT.END, or SWT.FILL.
   */
  public TreeViewComposite(Composite parent, DependencyResolvingTreeEventInterceptor interceptor,
      IExpandStrategy expandStrategy, int hAlign) {

    //
    Composite composite = new Composite(parent, SWT.NONE);
    composite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
    GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).extendedMargins(0, 0, 0, 0).margins(0, 0)
        .applyTo(composite);

    //
    _toolBar = new ToolBar(composite, SWT.FLAT | SWT.HORIZONTAL);
    GridDataFactory.fillDefaults().align(hAlign, SWT.FILL).indent(0, 10).grab(true, false).applyTo(_toolBar);

    //
    _treeViewer = SlizaaTreeViewerFactory.newSlizaaTreeViewer(composite).withStyle(SWT.NO_BACKGROUND | SWT.MULTI)
        .withAutoExpandLevel(2).withTreeEventInterceptor(interceptor).create();

    _treeExpandStrategy = expandStrategy;

    //
    _toolItemMap = new HashMap<>();
  }

  /**
   * <p>
   * </p>
   *
   * @param parent
   * @return
   */
  public <E extends Enum<E>> ToolItem createToolItem(E key, Image image, Image disabledImage,
      Consumer<SelectionEvent> consumer) {

    checkState(!_toolItemMap.containsKey(key.name()));

    //
    ToolItem toolItem = new ToolItem(_toolBar, SWT.PUSH);
    toolItem.setImage(image);
    toolItem.setData("slizaa-id", key.name());
    toolItem.setDisabledImage(disabledImage);
    toolItem.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(final SelectionEvent e) {
        consumer.accept(e);
      }
    });

    //
    _toolItemMap.put(key.name(), toolItem);

    //
    return toolItem;
  }

  /**
   * <p>
   * </p>
   *
   * @param key
   * @return
   */
  public <E extends Enum<E>> ToolItem getToolItem(E key) {
    checkState(_toolItemMap.containsKey(key.name()));
    return _toolItemMap.get(key.name());
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public TreeViewer getTreeViewer() {
    return _treeViewer;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public ToolBar getToolBar() {
    return _toolBar;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public IExpandStrategy getTreeExpandStrategy() {
    return _treeExpandStrategy;
  }
}
