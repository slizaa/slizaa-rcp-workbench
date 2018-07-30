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
public interface IMatrixListener {

  /**
   * <p>
   * </p>
   * 
   * @param event
   */
  public void singleClick(MatrixEvent event);

  /**
   * <p>
   * </p>
   * 
   * @param event
   */
  public void doubleClick(MatrixEvent event);

  /**
   * <p>
   * </p>
   * 
   * @param event
   */
  public void toolTip(MatrixEvent event);

  /**
   * <p>
   * </p>
   * 
   * @param event
   */
  public void marked(MatrixEvent event);

  /**
   * <p>
   * </p>
   * 
   * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
   */
  public static class Adapter implements IMatrixListener {

    /**
     * {@inheritDoc}
     */
    @Override
    public void singleClick(MatrixEvent event) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doubleClick(MatrixEvent event) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void toolTip(MatrixEvent event) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void marked(MatrixEvent event) {
    }
  }
}
