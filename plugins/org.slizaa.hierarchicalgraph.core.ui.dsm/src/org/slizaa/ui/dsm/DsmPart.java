/*******************************************************************************
 * Copyright (c) Gerd W�therich 2012-2016. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors: Gerd W�therich (gerd@gerd-wuetherich.de) - initial API and implementation
 ******************************************************************************/
package org.slizaa.ui.dsm;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.slizaa.hierarchicalgraph.core.model.HGAggregatedDependency;
import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.hierarchicalgraph.core.model.spi.INodeLabelProvider;
import org.slizaa.hierarchicalgraph.core.selections.DependencySelection;
import org.slizaa.hierarchicalgraph.core.selections.NodeSelection;
import org.slizaa.hierarchicalgraph.core.selections.SelectionsFactory;
import org.slizaa.ui.shared.AbstractSlizaaWorkbenchModelComponent;
import org.slizaa.ui.shared.context.BusyCursor;
import org.slizaa.ui.widget.dsm.DsmViewWidget;
import org.slizaa.ui.widget.dsm.IDsmContentProvider;
import org.slizaa.ui.widget.dsm.IMatrixListener;
import org.slizaa.ui.widget.dsm.MatrixEvent;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class DsmPart extends AbstractSlizaaWorkbenchModelComponent {

  /**
   * This is used as the DSMView's providerId for the xxxSelectionServices
   */
  public static String            DSM_ID = DsmPart.class.getName();

  /** - */
  private DsmViewWidget           _viewWidget;

  /** - */
  private DsmDetailComposite      _detailComposite;

  /** - */
  private int[]                   _selectedCell;

  /** - */
  private HGNode                  _fromArtifact;

  /** - */
  private HGNode                  _toArtifact;

  /** - */
  private IDsmContentProvider     _dsmContentProvider;

  /** - */
  private DelegatingLabelProvider _labelProvider;

  /**
   * <p>
   * </p>
   *
   * @param parent
   */
  @Override
  @PostConstruct
  public void createComposite(Composite parent) {
    parent.setLayout(new GridLayout(1, false));

    //
    this._labelProvider = new DelegatingLabelProvider();
    this._dsmContentProvider = new DefaultAnalysisModelElementDsmContentProvider();

    //
    this._viewWidget = new DsmViewWidget(this._dsmContentProvider, this._labelProvider,
        new DefaultDependencyLabelProvider(), parent);
    GridDataFactory.swtDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(this._viewWidget);
    this._viewWidget.setZoom((50 + 10) * 0.02f);

    //
    this._detailComposite = new DsmDetailComposite(parent);

    GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).applyTo(this._detailComposite);
    setDefaultDependencyDescription();

    //
    this._viewWidget.addMatrixListener(new IMatrixListener.Adapter() {

      @Override
      public void marked(MatrixEvent event) {

        // TODO!
        if (isCellSelected(event)) {

          HGAggregatedDependency dependency = (HGAggregatedDependency) DsmPart.this._dsmContentProvider
              .getDependency(event.getX(), event.getY());

          if (dependency != null) {
            DsmPart.this._detailComposite.setLabel(Integer.toString(dependency.getAggregatedWeight()),
                getName(DsmPart.this._dsmContentProvider.getNodes()[event.getY()]),
                getName(DsmPart.this._dsmContentProvider.getNodes()[event.getX()]));

            return;
          }
          // }
          //
          //
          // else if (_selectedCell != null) {
          // // TODO: use models
          // _detailComposite.getSelectionCountLabel().setText(Integer.toString(dependency.getWeight()));
          // _detailComposite.getSelectionCountLabel().setText(
          // getNullSafeString(_viewWidget.getDependenciesAsStrings()[_selectedCell[0]][_selectedCell[1]], "0"));
          // _detailComposite.getFromLabel().setText(getName(_dsmContentProvider.getNodes()[_selectedCell[1]]));
          // _detailComposite.getToLabel().setText(getName(_dsmContentProvider.getNodes()[_selectedCell[0]]));
        }

        setDefaultDependencyDescription();
      }

      /**
       * {@inheritDoc}
       */
      @Override
      public void singleClick(MatrixEvent event) {
        if (isCellSelected(event)) {

          DsmPart.this._selectedCell = new int[] { event.getX(), event.getY() };

          HGAggregatedDependency dependency = (HGAggregatedDependency) DsmPart.this._dsmContentProvider
              .getDependency(event.getX(), event.getY());

          final List<HGAggregatedDependency> dependencies = new LinkedList<>();
          if (dependency != null) {
            dependencies.add(dependency);
          }

          BusyCursor.execute(DsmPart.this._viewWidget, () -> {
            //
            DependencySelection dependencySelection = SelectionsFactory.eINSTANCE.createDependencySelection();
            dependencySelection.getDependencies().addAll(dependencies);
            getWorkbenchModel().setMainDependencySelection(dependencySelection);
          });

          DsmPart.this._fromArtifact = (HGNode) DsmPart.this._dsmContentProvider.getNodes()[event.getX()];
          DsmPart.this._toArtifact = (HGNode) DsmPart.this._dsmContentProvider.getNodes()[event.getY()];
        }
      }

    });

    //
    handleNodeSelectionChanged(null, getWorkbenchModel().getNodeSelection());
  }

  protected String getName(Object object) {
    return this._labelProvider.getText(object);
  }

  @Override
  protected void handleNodeSelectionChanged(NodeSelection oldValue, NodeSelection newValue) {

    if (this._viewWidget != null && this._detailComposite != null && !this._viewWidget.isDisposed()) {

      List<HGNode> selectedNodes = newValue != null ? newValue.getNodes() : Collections.emptyList();

      if (selectedNodes != null && !selectedNodes.isEmpty()) {
        this._dsmContentProvider = new DefaultAnalysisModelElementDsmContentProvider(selectedNodes);
        INodeLabelProvider itemLabelProvider = selectedNodes.toArray(new HGNode[0])[0].getRootNode()
            .getExtension(INodeLabelProvider.class);
        this._labelProvider.setItemLabelProvider(itemLabelProvider);
      } else {
        this._dsmContentProvider = new DefaultAnalysisModelElementDsmContentProvider();
      }

      //
      this._viewWidget.setModel(this._dsmContentProvider);

      // clear the dependency selection
      resetDependencySelection();

      setDefaultDependencyDescription();
    }
  }

  private boolean isCellSelected(MatrixEvent event) {
    return event.getX() <= this._dsmContentProvider.getItemCount() && event.getX() >= 0
        && event.getY() <= this._dsmContentProvider.getItemCount() && event.getY() >= 0;
  }

  /**
   * <p>
   * </p>
   *
   */
  private void setDefaultDependencyDescription() {
    this._detailComposite.unsetLabel();
  }

  private void resetDependencySelection() {

    //
    List<?> artifacts = Arrays.asList(this._dsmContentProvider.getNodes());

    //
    if (this._fromArtifact == null || this._toArtifact == null || !artifacts.contains(this._fromArtifact)
        || !artifacts.contains(this._toArtifact)) {

      //
      clearDependencySelection();
    }

    //
    else {

      //
      this._selectedCell = new int[] { artifacts.indexOf(this._fromArtifact), artifacts.indexOf(this._toArtifact) };

      HGAggregatedDependency dependency = (HGAggregatedDependency) this._dsmContentProvider
          .getDependency(this._selectedCell[0], this._selectedCell[1]);

      // Selection.instance().getDependencySelectionService().setSelection(Selection.MAIN_DEPENDENCY_SELECTION_ID,
      // DsmPart.DSM_EDITOR_ID, dependency);
    }
  }

  private void clearDependencySelection() {
    this._selectedCell = null;

    DependencySelection dependencySelection = SelectionsFactory.eINSTANCE.createDependencySelection();
    getWorkbenchModel().setMainDependencySelection(dependencySelection);
  }
}
