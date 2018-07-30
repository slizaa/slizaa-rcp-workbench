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

import java.util.Observer;

public interface IDsmContentProvider {

  void addObserver(Observer observer);

  void deleteObserver(Observer observer);

  int getItemCount();

  Object getDependency(int j, int i);

  Object[][] getDependencies();

  Object[] getNodes();

  int[][] getCycles();

  boolean isInCycle(int x, int y);

  boolean isInCycle(int i);
}
