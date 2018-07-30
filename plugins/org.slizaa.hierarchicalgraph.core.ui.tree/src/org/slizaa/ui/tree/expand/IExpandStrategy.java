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

/**
 * <p>
 * Interface that defines the methods that
 * </p>
 * 
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public interface IExpandStrategy {

  /**
   * <p>
   * </p>
   * 
   * @param treeViewer
   */
  void init(TreeViewer treeViewer);

  /**
   * <p>
   * </p>
   *
   * @param treeViewer
   */
  void dispose();

  /**
   * <p>
   * </p>
   * 
   * @param treeViewer
   * @param visibleArtifacts
   */
  void expand(Collection<HGNode> visibleArtifacts);
  
  /**
   * <p>
   * </p>
   *
   * @return
   */
  TreeViewer getTreeViewer();
}
