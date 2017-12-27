/*******************************************************************************
 * Copyright (c) 2011-2015 slizaa project team.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    slizaa project team - initial API and implementation
 ******************************************************************************/
package org.slizaa.product.ui.project;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * A vertical-aligned button bar on a Form
 * 
 * @author Nils Hartmann (nils@nilshartmann.net)
 * 
 */
public class VerticalFormButtonBar {

  private final FormToolkit _formToolkit;

  private final Composite   _buttonBar;

  /**
   * Creates a new VerticalFormButtonBar
   * 
   * @param parentComposite
   *          The parent composite
   * @param toolkit
   *          The toolkit that is used to create the button bar and the actual buttons
   */
  public VerticalFormButtonBar(Composite parentComposite, FormToolkit toolkit) {
    _formToolkit = toolkit;
    _buttonBar = toolkit.createComposite(parentComposite);
    _buttonBar.setLayout(new GridLayout(1, false));
    GridData gd = new GridData();
    gd.verticalAlignment = GridData.FILL;
    gd.horizontalAlignment = GridData.FILL;
    gd.grabExcessVerticalSpace = true;
    gd.horizontalIndent = 0;
    _buttonBar.setLayoutData(gd);
  }

  /**
   * Adds a new button to the button bar with specified text.
   * 
   * @param text
   * @param selectionListener
   *          A selection listener that will be added to the button or null
   * @return the button that has been created
   */
  public Button newButton(String text, SelectionListener selectionListener) {
    // Create the button
    final Button button = _formToolkit.createButton(_buttonBar, text, SWT.PUSH);

    // Set Layout data
    GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
    layoutData.horizontalIndent = 0;
    button.setLayoutData(layoutData);

    // add selection listener if specified
    if (selectionListener != null) {
      button.addSelectionListener(selectionListener);
    }

    // return the button
    return button;
  }

}
