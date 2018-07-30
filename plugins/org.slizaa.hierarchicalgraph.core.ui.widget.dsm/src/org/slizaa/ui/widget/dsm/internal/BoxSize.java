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
import org.eclipse.swt.graphics.Font;

/**
 * <p>
 * </p>
 * 
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class BoxSize {

  /** - */
  private int _additionalVerticalPadding;;

  /** - */
  private int _horizontalBoxSize;

  public BoxSize(int horizontalBoxSize, int additionalVerticalPadding) {
    _horizontalBoxSize = (horizontalBoxSize > getVerticalBoxSize() ? horizontalBoxSize : getVerticalBoxSize());
    _additionalVerticalPadding = additionalVerticalPadding;
  }

  public int getVerticalBoxSize() {
    float[] dpiFactor = DpiUtilities.getCalculatedDpiFactors();
    return (int) (20 * dpiFactor[0]);
  }

  public int getHorizontalBoxSize() {
    return _horizontalBoxSize;
  }

  public int getPaddingVertical(Font font) {

    // compute padding vertical
    int fontHeight = FigureUtilities.getFontMetrics(font).getHeight();
    int paddingVertical = (getVerticalBoxSize() - fontHeight) / 2;
    paddingVertical = paddingVertical > 0 ? paddingVertical : 0;
    return paddingVertical + _additionalVerticalPadding;
  }

  public int getPaddingHorizontal(String text, Font font) {

    // compute padding vertical
    // compute padding horizontal
    int textWidth = FigureUtilities.getTextWidth(text, font);
    int paddingHorizontal = (getHorizontalBoxSize() - textWidth) / 2;
    paddingHorizontal = paddingHorizontal > 0 ? paddingHorizontal : 0;
    return paddingHorizontal;
  }
}
