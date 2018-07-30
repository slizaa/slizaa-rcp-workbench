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

/**
 * <p>
 * </p>
 * 
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class MatrixEvent {

  /** - */
  private int _x;

  /** - */
  private int _y;

  /**
   * <p>
   * Creates a new instance of type {@link MatrixEvent}.
   * </p>
   * 
   * @param x
   * @param y
   */
  public MatrixEvent(int x, int y) {
    _x = x;
    _y = y;
  }

  /**
   * <p>
   * </p>
   * 
   * @return
   */
  public int getX() {
    return _x;
  }

  /**
   * <p>
   * </p>
   * 
   * @return
   */
  public int getY() {
    return _y;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + _x;
    result = prime * result + _y;
    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    MatrixEvent other = (MatrixEvent) obj;
    if (_x != other._x)
      return false;
    if (_y != other._y)
      return false;
    return true;
  }
}
