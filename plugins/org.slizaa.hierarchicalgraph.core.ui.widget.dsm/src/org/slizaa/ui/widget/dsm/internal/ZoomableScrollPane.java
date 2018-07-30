/*******************************************************************************
 * Copyright (c) Gerd Wütherich 2012-2016.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *    Gerd Wütherich (gerd@gerd-wuetherich.de) - initial API and implementation
 ******************************************************************************/
package org.slizaa.ui.widget.dsm.internal;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ScrollPane;

/**
 * <p>
 * Implements a zoomable {@link ScrollPane}.
 * </p>
 * 
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class ZoomableScrollPane extends ScrollPane {

  /** the internal zoom container */
  private ZoomContainer _zoomContainer;

  /**
   * <p>
   * Creates a new instance of type {@link ZoomableScrollPane}.
   * </p>
   * 
   * @param figure
   * @param horizontalScrollBarVisibility
   * @param verticalScrollBarVisibility
   */
  public ZoomableScrollPane(IFigure figure, int horizontalScrollBarVisibility, int verticalScrollBarVisibility) {

    // assert not null
    Assert.isNotNull(figure);

    // set the zoom container
    _zoomContainer = new ZoomContainer();
    _zoomContainer.add(figure);
    _zoomContainer.setZoom(1.0f);
    setContents(_zoomContainer);

    // set up the scroll pane
    getVerticalScrollBar().setExtent(25);
    getHorizontalScrollBar().setExtent(25);
    setHorizontalScrollBarVisibility(horizontalScrollBarVisibility);
    setVerticalScrollBarVisibility(verticalScrollBarVisibility);
  }

  /**
   * {@inheritDoc}
   */
  public void setZoom(float zoom) {
    _zoomContainer.setZoom(zoom);
  }

  /**
   * {@inheritDoc}
   */
  public float getZoom() {
    return _zoomContainer.zoom;
  }
}
