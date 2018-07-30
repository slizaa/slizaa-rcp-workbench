/*******************************************************************************
 * Copyright (c) Gerd W�therich 2012-2016. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors: Gerd W�therich (gerd@gerd-wuetherich.de) - initial API and implementation
 ******************************************************************************/
package org.slizaa.ui.dependencytable;

import java.util.Set;

import javax.annotation.PostConstruct;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.slizaa.hierarchicalgraph.core.model.AbstractHGDependency;
import org.slizaa.hierarchicalgraph.core.model.HGCoreDependency;
import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.hierarchicalgraph.core.model.HGProxyDependency;
import org.slizaa.hierarchicalgraph.core.selections.DependencySelection;
import org.slizaa.hierarchicalgraph.core.selections.DependencySelections;
import org.slizaa.ui.shared.AbstractSlizaaWorkbenchModelComponent;

public class DependencyTablePart extends AbstractSlizaaWorkbenchModelComponent {

  /** - */
  public static final String         ID                  = DependencyTablePart.class.getName();

  /** - */
  private TableViewer                _viewer;

  /** Comparator used to sort the columns */
  private DependencyComparator       _dependencyComparator;

  /** - */
  private ArtifactPathLabelGenerator _fromLabelGenerator = new ArtifactPathLabelGenerator();

  /** - */
  private ArtifactPathLabelGenerator _toLabelGenerator   = new ArtifactPathLabelGenerator();

  @Override
  @PostConstruct
  public void createComposite(Composite parent) {
    FillLayout fillLayout = new FillLayout();
    fillLayout.type = SWT.VERTICAL;

    parent.setLayout(fillLayout);

    Composite tableComposite = new Composite(parent, SWT.NONE);
    tableComposite.setLayout(new TableColumnLayout());

    this._dependencyComparator = new DependencyComparator(this._fromLabelGenerator, this._toLabelGenerator);

    this._viewer = new TableViewer(tableComposite,
        SWT.VIRTUAL | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.MULTI);
    final Table table = this._viewer.getTable();
    table.setHeaderVisible(true);
    table.setLinesVisible(true);
    this._viewer.setContentProvider(new LazyDependencyProvider(this._viewer));

    createColumns(tableComposite, this._viewer);

    if (getWorkbenchModel() != null) {
      handleDetailDependencySelectionChanged(null, getWorkbenchModel().getMainDependencySelection());
    }
  }

  @Override
  protected void handleDetailDependencySelectionChanged(DependencySelection oldValue, DependencySelection newValue) {

    if (this._viewer == null || this._viewer.getTable().isDisposed()) {
      return;
    }

    if (newValue == null || newValue.getDependencies().isEmpty()) {
      setColumnTitles("From", "To");
      this._viewer.setInput(new AbstractHGDependency[0]);
      this._viewer.getTable().redraw();
      return;
    }
    //
    else {

      HGNode toBaseArtifact = newValue.getDependencies().get(0).getFrom();

      HGNode fromBaseArtifact = newValue.getDependencies().get(0).getTo();

      if (newValue.getDependencies().size() != 1) {
        // TODO determine deepest common base of all dependencies
        toBaseArtifact = toBaseArtifact.getRootNode();
        fromBaseArtifact = fromBaseArtifact.getRootNode();
      }

      this._fromLabelGenerator.setBaseArtifact(fromBaseArtifact);
      this._toLabelGenerator.setBaseArtifact(toBaseArtifact);

      //
      String fromColumnTitle = "From " /* + _fromLabelGenerator.getTitle() */;
      String toColumnTitle = "To " /* + _toLabelGenerator.getTitle() */;

      setColumnTitles(fromColumnTitle, toColumnTitle);

      Set<HGCoreDependency> leafDependencies = DependencySelections.getCoreDependencies(newValue.getDependencies());

      AbstractHGDependency[] dependencies = leafDependencies.toArray(new AbstractHGDependency[0]);
      setOrderedDependencies(dependencies);
    }
  }

  private void createColumns(Composite parent, TableViewer viewer) {

    createTableViewerColumn(parent, viewer, 0, "From", 45, new DependencyColumnLabelProvider(this._fromLabelGenerator) {
      @Override
      protected HGNode getNode(AbstractHGDependency dependency) {
        return dependency.getFrom();
      }
    });

    //
    createTableViewerColumn(parent, viewer, 1, "Type", 10, new ColumnLabelProvider() {
      @Override
      public String getText(Object element) {
        if (element instanceof AbstractHGDependency) {
          AbstractHGDependency dependency = (AbstractHGDependency) element;
          if (dependency instanceof HGCoreDependency) {

            //
            if (dependency instanceof HGProxyDependency) {
              return "<<lazy dependency>>";
            }
            //
            else {
              return ((HGCoreDependency) dependency).getType();
            }
          }
          // return String.valueOf(dependency.getDependencyKind()).toLowerCase();
          return "depends on";
        }
        return super.getText(element);
      }

    });
    createTableViewerColumn(parent, viewer, 2, "To", 45, new DependencyColumnLabelProvider(this._toLabelGenerator) {

      @Override
      public HGNode getNode(AbstractHGDependency dependency) {
        return dependency.getTo();
      }
    });

  }

  private TableViewerColumn createTableViewerColumn(Composite tableComposite, TableViewer viewer, int index,
      String title, int weight, CellLabelProvider labelProvider) {
    final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
    final TableColumn column = viewerColumn.getColumn();
    column.setText(title);
    column.setResizable(true);
    column.setMoveable(false);

    TableColumnLayout tableLayout = (TableColumnLayout) tableComposite.getLayout();
    ColumnLayoutData columnLayoutData = new ColumnWeightData(weight);
    tableLayout.setColumnData(column, columnLayoutData);
    if (labelProvider != null) {
      viewerColumn.setLabelProvider(labelProvider);
    }
    column.addSelectionListener(getSelectionAdapter(column, index));
    return viewerColumn;

  }

  private SelectionAdapter getSelectionAdapter(final TableColumn column, final int index) {
    SelectionAdapter selectionAdapter = new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        DependencyTablePart.this._dependencyComparator.setColumn(index);
        int dir = DependencyTablePart.this._dependencyComparator.getDirection();
        DependencyTablePart.this._viewer.getTable().setSortDirection(dir);
        DependencyTablePart.this._viewer.getTable().setSortColumn(column);

        AbstractHGDependency[] currentDependencies = (AbstractHGDependency[]) DependencyTablePart.this._viewer
            .getInput();
        setOrderedDependencies(currentDependencies);

        DependencyTablePart.this._viewer.refresh();
      }
    };
    return selectionAdapter;
  }

  private void setColumnTitles(String fromColumnTitle, String toColumnTitle) {
    Table table = this._viewer.getTable();

    table.getColumn(0).setText(fromColumnTitle);
    table.getColumn(2).setText(toColumnTitle);
  }

  private void setOrderedDependencies(AbstractHGDependency[] dependencies) {
    this._dependencyComparator.sortDependencies(dependencies);

    this._viewer.setInput(dependencies);
    this._viewer.setItemCount(dependencies.length); // This is the difference when using a ILazyContentProvider
    // _viewer.getTable().redraw();
    this._viewer.refresh();
  }
}
