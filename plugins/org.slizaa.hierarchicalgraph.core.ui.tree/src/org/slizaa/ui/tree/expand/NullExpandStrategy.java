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
package org.slizaa.ui.tree.expand;

import java.util.Collection;

import org.eclipse.jface.viewers.TreeViewer;
import org.slizaa.hierarchicalgraph.core.model.HGNode;

public class NullExpandStrategy implements IExpandStrategy {
  
  private TreeViewer _treeviewer;

  @Override
  public void init(TreeViewer treeViewer) {
    
    //
    _treeviewer = treeViewer;
  }

  @Override
  public void dispose() {
  }

  @Override
  public void expand(Collection<HGNode> visibleElements) {
    
    //
  }

  @Override
  public TreeViewer getTreeViewer() {
    return _treeviewer;
  }
}
