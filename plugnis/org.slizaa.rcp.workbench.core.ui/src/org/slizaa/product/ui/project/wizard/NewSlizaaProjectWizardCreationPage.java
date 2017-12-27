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
package org.slizaa.product.ui.project.wizard;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
//import org.eclipse.debug.internal.ui.SWTFactory;
//import org.eclipse.jdt.internal.debug.ui.jres.BuildJREDescriptor;
//import org.eclipse.jdt.internal.debug.ui.jres.JREsComboBlock;
//import org.eclipse.jdt.launching.JavaRuntime;

/**
 * <p>
 * A wizard page to enter the required settings for a BundleMaker project.
 * </p>
 * 
 * 
 * @author Nils Hartmann (nils@nilshartmann.net)
 * 
 */
public class NewSlizaaProjectWizardCreationPage extends WizardNewProjectCreationPage {

  /**
   * The block that allows selecting the JRE/Execution Environment
   */
//  private JREsComboBlock _jreComboBlock;

  Button                 _enableTransformationScriptSupportButton;

  public NewSlizaaProjectWizardCreationPage() {
    super("NewSlizaaProjectWizardCreationPage");

    setTitle("Create a Slizaa project");
    setDescription("Set project name.");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void createControl(Composite parent) {
    // add controls from default basic wizard page
    super.createControl(parent);
    Composite control = (Composite) getControl();

    // Create the JRE selection box
//    createJreGroup(control);

//    createTransformationScriptBlock(control);

    // Pre-select default JRE
//    preselectJre();
  }

  /**
   * <p>
   * Creates the group for selecting the project JRE
   * </p>
   * 
   * @param parent
   */
  private final void createJreGroup(Composite parent) {
    // jre setting group
    Composite jreGroup = new Composite(parent, SWT.NONE);
    jreGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
    jreGroup.setLayout(new GridLayout(2, false));

//    _jreComboBlock = new JREsComboBlock(true);
//    _jreComboBlock.setDefaultJREDescriptor(new BuildJREDescriptor());
//    _jreComboBlock.setTitle("JRE");
//    _jreComboBlock.createControl(jreGroup);
//    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
//    _jreComboBlock.getControl().setLayoutData(gd);
//    _jreComboBlock.addPropertyChangeListener(new IPropertyChangeListener() {
//      @Override
//      public void propertyChange(PropertyChangeEvent event) {
//        setErrorMessageFromStatus(_jreComboBlock.getStatus());
//      }
//    });

  }

//  private void createTransformationScriptBlock(Composite parent) {
//    Composite parentGroup = new Composite(parent, SWT.NONE);
//    parentGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
//    parentGroup.setLayout(new GridLayout(2, false));
//
//    Group group = SWTFactory.createGroup(parentGroup, "Transformation Scripts", 1, 1, GridData.FILL_HORIZONTAL);
//    Composite comp = SWTFactory.createComposite(group, group.getFont(), 1, 1, GridData.FILL_BOTH, 0, 0);
//
//    _enableTransformationScriptSupportButton = new Button(comp, SWT.CHECK);
//    _enableTransformationScriptSupportButton.setText("Enable Transformation Script support (experimental)");
//    _enableTransformationScriptSupportButton.setSelection(false);
//    Label label = new Label(comp, SWT.NONE);
//    label
//        .setText("Enabling transformation script support allows you to directly write transformation scripts in your BundleMaker project.\nIf you now deceide to not enable this support you still can later add it at any time.");
//  }

  /**
   * Sets the message from given IStatus as the dialog's error message, if status is not OK. Otherwise sets error
   * message to null.
   * 
   * @param status
   */
  private void setErrorMessageFromStatus(IStatus status) {
    if (status == null || status.isOK()) {
      setErrorMessage(null);
    } else {
      setErrorMessage(status.getMessage());
    }
  }

//  /**
//   * Initializes the JRE selection
//   */
//  protected void preselectJre() {
//    _jreComboBlock.setPath(JavaRuntime.newDefaultJREContainerPath());
//  }
//
//  public String getSelectedJreId() {
//    return _jreComboBlock.getPath().toString();
//  }
//
//  public boolean isTransformationScriptSupportSelected() {
//    return _enableTransformationScriptSupportButton.getSelection();
//  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.dialogs.WizardNewProjectCreationPage#validatePage()
   */
  @Override
  protected boolean validatePage() {
    if (!super.validatePage()) {
      return false;
    }

//    // Validate JRE selection
//    IStatus status = _jreComboBlock.getStatus();
//    setErrorMessageFromStatus(status);
//
//    return status.isOK();
    return true;
  }

}
