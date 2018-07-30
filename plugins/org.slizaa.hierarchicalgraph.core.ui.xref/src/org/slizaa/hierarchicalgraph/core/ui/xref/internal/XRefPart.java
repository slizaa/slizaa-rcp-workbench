package org.slizaa.hierarchicalgraph.core.ui.xref.internal;

import java.util.Collections;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.widgets.Composite;
import org.slizaa.hierarchicalgraph.core.model.HGRootNode;
import org.slizaa.hierarchicalgraph.core.selections.FilterSelections;
import org.slizaa.hierarchicalgraph.core.selections.NodeSelection;
import org.slizaa.hierarchicalgraph.core.selections.SelectionHolder;
import org.slizaa.ui.shared.AbstractSlizaaWorkbenchModelComponent;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class XRefPart extends AbstractSlizaaWorkbenchModelComponent {

  /** - */
  private XRefComposite                  _composite;

  /** - */
  private SelectionHolder<NodeSelection> _filteredNodeSelection;

  /** - */
  private Adapter                        _filterObserver;

  /**
   * <p>
   * </p>
   *
   * @param parent
   */
  @PostConstruct
  public void createComposite(Composite parent) {

    //
    _filterObserver = new AdapterImpl() {
      @Override
      public void notifyChanged(Notification msg) {
        setFilter();
      }
    };

    //
    GridLayoutFactory.fillDefaults().applyTo(parent);

    //
    _composite = new XRefComposite(parent, dependencySelection -> {
      getWorkbenchModel().setMainDependencySelection(dependencySelection);
      getWorkbenchModel().setDetailDependencySelection(dependencySelection);
    });

    //
    GridDataFactory.fillDefaults().grab(true, true).applyTo(_composite);

    //
    handleRootNodeChanged(null, getWorkbenchModel().getRootNode());
  }

  @PreDestroy
  public void dispose() {

    // remove old selection
    if (getWorkbenchModel().getRootNode() != null) {
      FilterSelections.getOrCreateFilteredNodeSelectionHolder(getWorkbenchModel().getRootNode()).eAdapters()
          .remove(_filterObserver);
    }
  }

  @Override
  protected void handleRootNodeChanged(HGRootNode oldValue, HGRootNode newValue) {

    //
    if (oldValue == newValue) {
      return;
    }

    // remove old selection
    if (oldValue != null) {
      FilterSelections.getOrCreateFilteredNodeSelectionHolder(oldValue).eAdapters().remove(_filterObserver);
    }

    // set the new value
    if (newValue != null) {
      _filteredNodeSelection = FilterSelections.getOrCreateFilteredNodeSelectionHolder(newValue);
      _filteredNodeSelection.eAdapters().add(_filterObserver);
    } else {
      _filteredNodeSelection = null;
    }

    // immediately set if composite is already created
    if (_composite != null && !_composite.isDisposed()) {
      _composite.setRootNode(newValue);
      setFilter();
    }
  }

  /**
   * <p>
   * </p>
   */
  private void setFilter() {

    if (_composite != null && !_composite.isDisposed()) {

      //
      if (getWorkbenchModel().getRootNode() != null) {

        _composite.setFilteredNodes(
            _filteredNodeSelection != null ? _filteredNodeSelection.getSelection().getNodes() : Collections.emptyList(),
            true);

        if (!_composite.isDisposed()) {
          _composite.refresh();
        }
      }

    }
  }
}
