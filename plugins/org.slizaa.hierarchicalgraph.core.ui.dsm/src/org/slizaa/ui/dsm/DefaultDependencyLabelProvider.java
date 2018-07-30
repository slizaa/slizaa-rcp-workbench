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
package org.slizaa.ui.dsm;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.slizaa.hierarchicalgraph.core.model.HGAggregatedDependency;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class DefaultDependencyLabelProvider extends LabelProvider {

  /**
   * {@inheritDoc}
   */
  @Override
  public Image getImage(Object element) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getText(Object element) {

    //
    if (element instanceof HGAggregatedDependency) {
      HGAggregatedDependency dependency = ((HGAggregatedDependency) element);
      return dependency.getAggregatedWeight() + "";
    }

    //
    return "";
  }
}
