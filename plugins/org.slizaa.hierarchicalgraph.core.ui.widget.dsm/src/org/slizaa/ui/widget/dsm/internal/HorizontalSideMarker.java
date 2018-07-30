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

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.jface.viewers.ILabelProvider;
import org.slizaa.ui.widget.dsm.IDsmColorScheme;
import org.slizaa.ui.widget.dsm.IDsmContentProvider;

/**
 * <p>
 * </p>
 * 
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class HorizontalSideMarker extends AbstractSideMarker {

  private boolean _rotateText = true;

  /**
   * <p>
   * Creates a new instance of type {@link HorizontalSideMarker}.
   * </p>
   * 
   * @param contentProvider
   * @param matrixCycleDetector
   * @param colorScheme
   */
  public HorizontalSideMarker(IDsmContentProvider contentProvider, ILabelProvider labelProvider,
      IDsmColorScheme colorScheme) {
    super(contentProvider, labelProvider, colorScheme);
  }

  /**
   * <p>
   * </p>
   * 
   * @param rotateText
   *          the rotateText to set
   */
  public final void setRotateText(boolean rotateText) {
    _rotateText = rotateText;
  }

  @Override
  protected void onMouseReleased(MouseEvent me) {
    // int value = (int) Math.floor(me.getLocation().x / (double) getBoxSize().getHorizontalBoxSize());
    // System.out.println("wert: " + getModel().getLabels()[value]);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void paintClientArea(Graphics graphics) {
    super.paintClientArea(graphics);

    // reset the size
    resetSize();

    // store the state
    graphics.pushState();

    // draw the background ("odd marker")
    graphics.setBackgroundColor(getColorScheme().getSideMarkerBackgroundColor());

    graphics.fillRectangle(0, 0, getContentProvider().getItemCount() * getBoxSize().getHorizontalBoxSize(),
        getSize().height + 1);

    // draw the makers
    for (int i = 0; i < getContentProvider().getItemCount(); i++) {

      //
      boolean isInCycle = getContentProvider().isInCycle(i);

      // draw the "even" marker
      if (isInCycle || getMarkedItem() == i || i % 2 == 0) {

        // set the background
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

        // draw the background
        graphics.fillRectangle(getHorizontalSliceSize(i), 0,
            getHorizontalSliceSize(i + 1) - getHorizontalSliceSize(i) + 1, getSize().height + 1);
      }

      if (isInCycle && getContentProvider().isInCycle(i - 1)) {
        graphics.setForegroundColor(getColorScheme().getCycleSideMarkerSeparatorColor());
      } else {
        // draw the separator lines
        graphics.setForegroundColor(getColorScheme().getSideMarkerSeparatorColor());
      }
      graphics.drawLine(getHorizontalSliceSize(i), 0, getHorizontalSliceSize(i), getSize().height);

    }

    // draw the last line
    graphics.drawLine(getSize().width, 0, getSize().width, getSize().height);

    // rotate
    if (_rotateText) {

      graphics.translate(getContentProvider().getItemCount() * getBoxSize().getHorizontalBoxSize(), 0);
      graphics.rotate(90f);
      // compute the text offset (to make the text centered)
      int offset = (getBoxSize().getHorizontalBoxSize() - getFontHeight()) / 2;
      for (int i = 0; i < getContentProvider().getItemCount(); i++) {

        graphics.setForegroundColor(getColorScheme().getSideMarkerTextColor());

        graphics.drawString(getLabelProvider().getText(getContentProvider().getNodes()[i]), new Point(10,
            (((getContentProvider().getItemCount() - (i + 1)) * getBoxSize().getHorizontalBoxSize())) + offset));
      }
    }

    // don't rotate
    else {
      graphics.setForegroundColor(getColorScheme().getSideMarkerTextColor());

      int centerOffset = (getBoxSize().getHorizontalBoxSize() / 2);
      int fontHeight = getFont().getFontData()[0].getHeight() + 2;
      int horizontalBoxSize = getBoxSize().getHorizontalBoxSize();
      for (int i = 0; i < getContentProvider().getItemCount(); i++) {
        String label = getLabelProvider().getText(getContentProvider().getNodes()[i]);
        int offset = i * horizontalBoxSize + centerOffset;
        for (int j = 0; j < label.length(); j++) {
          String currentChar = label.substring(j, j + 1);
          graphics.drawString(currentChar, offset - (FigureUtilities.getTextWidth(currentChar, getFont()) / 2),
              j * fontHeight);
        }
      }
    }

    // restore the state
    graphics.popState();
  }

  /**
   * <p>
   * Resizes this side marker
   * </p>
   */
  @Override
  public void resetSize() {

    Dimension dimension = new Dimension(getBoxSize().getHorizontalBoxSize() * getContentProvider().getItemCount(),
        getSize().height);

    // reset the size
    if (!getSize().equals(dimension)) {
      setSize(dimension);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void onMark(int oldValue, int x) {

    // repaint the old section
    repaint(getHorizontalSliceSize(oldValue), 0,
        getHorizontalSliceSize(oldValue + 1) - getHorizontalSliceSize(oldValue) + 1, getSize().height);

    // repaint the new section
    repaint(getHorizontalSliceSize(x), 0, getHorizontalSliceSize(x + 1) - getHorizontalSliceSize(x) + 1,
        getSize().height);
  }
}
