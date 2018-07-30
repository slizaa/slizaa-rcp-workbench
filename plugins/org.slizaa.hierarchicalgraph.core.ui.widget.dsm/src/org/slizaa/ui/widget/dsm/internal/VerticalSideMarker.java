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

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.slizaa.ui.widget.dsm.IDsmColorScheme;
import org.slizaa.ui.widget.dsm.IDsmContentProvider;

/**
 * <p>
 * </p>
 * 
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class VerticalSideMarker extends AbstractSideMarker {

  /**
   * <p>
   * Creates a new instance of type {@link VerticalSideMarker}.
   * </p>
   * 
   * @param contentProvider
   * @param matrixCycleDetector
   * @param colorScheme
   */
  public VerticalSideMarker(IDsmContentProvider contentProvider, ILabelProvider labelProvider,
      IDsmColorScheme colorScheme) {
    super(contentProvider, labelProvider, colorScheme);
  }

  @Override
  protected void onMouseReleased(MouseEvent me) {
    // int value = (int) Math.floor(me.getLocation().y / (double) getBoxSize().getVerticalBoxSize());
    // System.out.println("wert: " + getModel().getLabels()[value]);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void onMark(int oldValue, int newValue) {

    // repaint old
    repaint(0, getHorizontalSliceSize(newValue), getSize().width,
        getHorizontalSliceSize(newValue + 1) - getHorizontalSliceSize(newValue) + 1);

    // repaint new
    repaint(0, getHorizontalSliceSize(oldValue), getSize().width,
        getHorizontalSliceSize(oldValue + 1) - getHorizontalSliceSize(oldValue) + 1);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void paintClientArea(Graphics graphics) {
    super.paintClientArea(graphics);

    // resetSize();

    // push the state
    graphics.pushState();

    graphics.drawLine(0, getSize().height, getSize().width, getSize().height);

    // draw the background
    Color oldColor = graphics.getBackgroundColor();
    graphics.setBackgroundColor(getColorScheme().getSideMarkerBackgroundColor());
    graphics.fillRectangle(0, 0, getSize().width + 1,
        getContentProvider().getItemCount() * getBoxSize().getVerticalBoxSize());
    graphics.setBackgroundColor(oldColor);

    // int offset = (getBoxSize().getVerticalBoxSize() - getFontHeight()) / 2;

    // draw the rows/columns
    for (int i = 0; i < getContentProvider().getItemCount(); i++) {

      //
      boolean isInCycle = getContentProvider().isInCycle(i);

      // set new background color
      if (isInCycle || i == getMarkedItem() || i % 2 == 0) {

        // set background color
        oldColor = graphics.getBackgroundColor();

        if (i == getMarkedItem()) {
          if (isInCycle) {
            graphics.setBackgroundColor(getColorScheme().getCycleSideMarkerMarkedColor());
          } else {
            graphics.setBackgroundColor(getColorScheme().getSideMarkerMarkedColor());
          }
        } else {
          if (isInCycle) {
            graphics.setBackgroundColor(getColorScheme().getCycleSideMarkerColor());
          } else {
            graphics.setBackgroundColor(getColorScheme().getSideMarkerEvenColor());
          }
        }

        // draw cell
        graphics.fillRectangle(0, getVerticalSliceSize(i), getSize().width + 1,
            getVerticalSliceSize(i + 1) - getVerticalSliceSize(i) + 1);

        // unset background color
        graphics.setBackgroundColor(oldColor);
      }

      // draw text
      graphics.setForegroundColor(getColorScheme().getSideMarkerTextColor());

      // TODO
      // graphics.drawString(getLabelProvider().getText(getContentProvider().getNodes()[i]), new Point(10 +
      // (isDrawImages() ? 18 : 0),
      // (getBoxSize().getVerticalBoxSize() * i) + offset));

      int textStartX = 0;

      // draw image
      Image image = getLabelProvider().getImage(getContentProvider().getNodes()[i]);
      if (image != null) {
        // TODO: LayoutInfo! getVerticalSideMakerDelimiterSpace()
        graphics.drawImage(image, new Point(5, (getBoxSize().getVerticalBoxSize() * i) + 2));
        textStartX = image.getBounds().width;
      }

      // TODO: LayoutInfo! getVerticalSideMakerDelimiterSpace()
      graphics.drawString(getLabelProvider().getText(getContentProvider().getNodes()[i]),
          new Point(textStartX + 10, (getBoxSize().getVerticalBoxSize() * i) + getBoxSize().getPaddingVertical(getFont())));

      // draw
      if (isInCycle && getContentProvider().isInCycle(i - 1)) {
        graphics.setForegroundColor(getColorScheme().getCycleSideMarkerSeparatorColor());
      } else {
        // draw the separator lines
        graphics.setForegroundColor(getColorScheme().getSideMarkerSeparatorColor());
      }
      graphics.drawLine(0, getVerticalSliceSize(i), getSize().width + 1, getVerticalSliceSize(i));
    }

    graphics.drawLine(0, getSize().height, getSize().width, getSize().height);

    // graphics.drawString("S " + getSize().width, new Point(5, 5));
    
    // pop the state
    graphics.popState();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void resetSize() {

    // compute the size
    Dimension dimension = new Dimension(getSize().width,
        getBoxSize().getVerticalBoxSize() * getContentProvider().getItemCount());

    // reset the size
    if (!getSize().equals(dimension)) {
      setSize(dimension);
    }
  }
}
