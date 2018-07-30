/*******************************************************************************
 * Copyright (c) Gerd W�therich 2012-2016.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *    Gerd W�therich (gerd@gerd-wuetherich.de) - initial API and implementation
 ******************************************************************************/
package org.slizaa.ui.dependencytable;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.ILazyContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.slizaa.hierarchicalgraph.core.model.AbstractHGDependency;

/**
 * <p>
 * </p>
 * 
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class LazyDependencyProvider implements ILazyContentProvider {

  /** - */
  private TableViewer   _tableViewer;

  /** - */
  private AbstractHGDependency[] _dependencies;

  /**
   * <p>
   * Creates a new instance of type {@link LazyDependencyProvider}.
   * </p>
   * 
   * @param tableViewer
   */
  public LazyDependencyProvider(TableViewer tableViewer) {
    Assert.isNotNull(tableViewer);

    _tableViewer = tableViewer;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void dispose() {
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    this._dependencies = (AbstractHGDependency[]) newInput;

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void updateElement(int index) {
    if (_dependencies.length > index) {
      _tableViewer.replace(_dependencies[index], index);
    }
  }
}
