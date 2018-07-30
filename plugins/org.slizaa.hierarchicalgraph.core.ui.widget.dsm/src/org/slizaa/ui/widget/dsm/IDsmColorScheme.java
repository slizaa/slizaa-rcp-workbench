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
package org.slizaa.ui.widget.dsm;

import org.eclipse.swt.graphics.Color;

public interface IDsmColorScheme {

  Color getSideMarkerBackgroundColor();

  Color getSideMarkerEvenColor();

  Color getSideMarkerMarkedColor();

  Color getSideMarkerSeparatorColor();

  Color getSideMarkerTextColor();

  Color getMatrixSeparatorColor();

  Color getMatrixBackgroundColor();

  Color getMatrixTextColor();

  Color getMatrixDiagonalColor();

  Color getMatrixMarkedColumnRowColor();

  Color getMatrixMarkedCellColor();

  Color getCycleSideMarkerColor();

  Color getCycleMatrixMarkedColumnRowColor();

  Color getCycleSideMarkerSeparatorColor();

  Color getCycleMatrixMarkedCellColor();

  Color getCycleMatrixDiagonalColor();

  Color getCycleSideMarkerMarkedColor();
}
