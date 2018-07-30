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

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.ScaledGraphics;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Translatable;

/**
 * <p>
 * This file was copied from 'org.eclipse.draw2d.examples'.
 * </p>
 */
public class ZoomContainer extends Figure {

  {
    setLayoutManager(new StackLayout());
  }

  public float zoom;

  /**
   * @see org.eclipse.draw2d.Figure#getClientArea()
   */
  @Override
  public Rectangle getClientArea(Rectangle rect) {
    super.getClientArea(rect);
    rect.width = (int) Math.ceil(rect.width / zoom);
    rect.height = (int) Math.ceil(rect.height / zoom);
    return rect;
  }

  @Override
  public Dimension getPreferredSize(int wHint, int hHint) {
    Dimension d = super.getPreferredSize(wHint, hHint);
    int w = getInsets().getWidth();
    int h = getInsets().getHeight();
    return d.getExpanded(-w, -h).scale(zoom).expand(w, h);
  }

  /**
   * @see org.eclipse.draw2d.Figure#paintClientArea(Graphics)
   */
  @Override
  protected void paintClientArea(Graphics graphics) {
    if (getChildren().isEmpty())
      return;

    boolean optimizeClip = getBorder() == null || getBorder().isOpaque();

    ScaledGraphics g = new ScaledGraphics(graphics);

    if (!optimizeClip)
      g.clipRect(getBounds().getShrinked(getInsets()));
    g.translate(getBounds().x + getInsets().left, getBounds().y + getInsets().top);
    g.scale(zoom);
    g.pushState();
    paintChildren(g);
    g.popState();
    g.dispose();
    graphics.restoreState();
  }

  public void setZoom(float zoom) {
    this.zoom = zoom;

    //
    for (Object child : getChildren()) {
      if (child instanceof ZoomContainer) {
        ((ZoomContainer) child).setZoom(this.zoom);
      }
    }

    //
    revalidate();
    repaint();
  }

  /**
   * @see org.eclipse.draw2d.Figure#translateToParent(Translatable)
   */
  @Override
  public void translateToParent(Translatable t) {
    t.performScale(zoom);
    super.translateToParent(t);
  }

  /**
   * @see org.eclipse.draw2d.Figure#translateFromParent(Translatable)
   */
  @Override
  public void translateFromParent(Translatable t) {
    super.translateFromParent(t);
    t.performScale(1 / zoom);
  }

  /**
   * @see org.eclipse.draw2d.Figure#useLocalCoordinates()
   */
  @Override
  protected boolean useLocalCoordinates() {
    return true;
  }
}
