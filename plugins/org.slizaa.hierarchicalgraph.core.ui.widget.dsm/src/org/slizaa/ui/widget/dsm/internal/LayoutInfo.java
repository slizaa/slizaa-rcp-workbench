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

import static com.google.common.base.Preconditions.checkNotNull;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.slizaa.ui.widget.dsm.IDsmContentProvider;

public class LayoutInfo {

  private IDsmContentProvider _contentProvider;

  private ILabelProvider      _nodeLabelProvider;

  private ILabelProvider      _dependencyLabelProvider;

  private Font                _font;

  private int                 _verticalSideMakerWidth;

  private int                 _verticalSideMakerDelimiterSpace;;

  private int                 _horizontalSideMakerHeight;

  private int                 _horizontalBoxWidth;

  private int                 _additionalVerticalPadding;

  private BoxSize             _boxSize;

  public LayoutInfo(IDsmContentProvider contentProvider, ILabelProvider nodeLabelProvider,
      ILabelProvider dependencyLabelProvider, Font font) {

    _contentProvider = checkNotNull(contentProvider);
    _nodeLabelProvider = checkNotNull(nodeLabelProvider);
    _dependencyLabelProvider = checkNotNull(dependencyLabelProvider);
    _font = checkNotNull(font);

    //
    _verticalSideMakerDelimiterSpace = 10;
    _horizontalSideMakerHeight = 8;
    _additionalVerticalPadding = 2;

    _verticalSideMakerWidth = getLabelFontExtend(_font) + getLabelImageExtend() + _verticalSideMakerDelimiterSpace;
    _horizontalBoxWidth = getDependenciesFontExtend(_font) + (2 * _additionalVerticalPadding);

    _boxSize = new BoxSize(_horizontalBoxWidth, _additionalVerticalPadding);
  }

  public BoxSize getBoxSize() {
    return _boxSize;
  }

  public int getVerticalSideMakerWidth() {
    return _verticalSideMakerWidth;
  }

  public int getVerticalSideMakerDelimiterSpace() {
    return _verticalSideMakerDelimiterSpace;
  }

  public int getHorizontalSideMakerHeight() {
    return _horizontalSideMakerHeight;
  }

  public void setVerticalSideMakerWidth(int verticalSideMakerWidth) {
    _verticalSideMakerWidth = verticalSideMakerWidth;
  }

  public void setHorizontalSideMakerHeight(int horizontalSideMakerHeight) {
    _horizontalSideMakerHeight = horizontalSideMakerHeight;
  }

  /**
   * <p>
   * </p>
   *
   * @param values
   * @param font
   * @return
   */
  private int getDependenciesFontExtend(Font font) {
    int result = 0;
    
    for (int i = 0; i < _contentProvider.getDependencies().length; i++) {
      for (int j = 0; j < _contentProvider.getDependencies().length; j++) {
        if (i != j && _contentProvider.getDependencies()[i][j] != null) {
          String text = _dependencyLabelProvider.getText(_contentProvider.getDependencies()[i][j]);
          if (text != null) {
            int r = FigureUtilities.getTextWidth(text, font);
            if (r > result) {
              result = r;
            }
          }
        }
      }
    }
    
    float[] dpiFactor = DpiUtilities.getCalculatedDpiFactors();
    
    return result;
  }

  /**
   * <p>
   * </p>
   *
   * @param font
   * @return
   */
  private int getLabelFontExtend(Font font) {
    int result = 0;
    for (int i = 0; i < _contentProvider.getNodes().length; i++) {
      String text = _nodeLabelProvider.getText(_contentProvider.getNodes()[i]);
      if (text != null) {
        int r = FigureUtilities.getTextWidth(text, font);
        if (r > result) {
          result = r;
        }
      }
    }
    return result;
  }

  private int getLabelImageExtend() {
    int result = 0;
    for (int i = 0; i < _contentProvider.getNodes().length; i++) {
      Image image = _nodeLabelProvider.getImage(_contentProvider.getNodes()[i]);
      int r = image != null ? image.getBounds().width : 0;
      if (r > result) {
        result = r;
      }
    }
    return result;
  }
}
