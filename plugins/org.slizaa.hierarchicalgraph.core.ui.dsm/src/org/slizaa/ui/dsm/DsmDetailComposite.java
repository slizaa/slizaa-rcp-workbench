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
package org.slizaa.ui.dsm;

import static com.google.common.base.Preconditions.checkNotNull;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class DsmDetailComposite extends Composite {

  /** - */
  private Label _selectionLabel;

  /**
   * <p>
   * Creates a new instance of type {@link DsmDetailComposite}.
   * </p>
   * 
   * @param parent
   * @param viewModel
   */
  public DsmDetailComposite(Composite parent) {
    super(parent, 0);

    GridLayout l = new GridLayout(1, false);
    this.setLayout(l);

    //
    _selectionLabel = new Label(this, SWT.LEAD);
    _selectionLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
  }

  /**
   * <p>
   * </p>
   *
   * @param count
   * @param fromLabel
   * @param toLabel
   */
  protected void setLabel(String count, String fromLabel, String toLabel) {
    _selectionLabel.setText(String.format("%s dependencies (%s -> %s)", checkNotNull(count), checkNotNull(fromLabel),
        checkNotNull(toLabel)));
  }

  protected void unsetLabel() {
    _selectionLabel.setText("");
  }
}
