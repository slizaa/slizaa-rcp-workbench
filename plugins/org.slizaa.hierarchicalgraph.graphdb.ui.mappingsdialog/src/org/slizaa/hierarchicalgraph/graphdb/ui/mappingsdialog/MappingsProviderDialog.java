package org.slizaa.hierarchicalgraph.graphdb.ui.mappingsdialog;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;
import java.util.function.Supplier;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.slizaa.hierarchicalgraph.graphdb.mapping.spi.IMappingProvider;
import org.slizaa.hierarchicalgraph.graphdb.ui.mappingsdialog.internal.Images;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class MappingsProviderDialog extends TitleAreaDialog {

  /** - */
  private Supplier<List<IMappingProvider>> _mappingProviderSupplier;

  /** - */
  private IMappingProvider                 _selectedMappingProvider;

  /**
   * <p>
   * Creates a new instance of type {@link MappingsProviderDialog}.
   * </p>
   *
   * @param parentShell
   * @param mappingProviderService
   */
  public MappingsProviderDialog(Shell parentShell, Supplier<List<IMappingProvider>> mappingProviderSupplier) {
    super(parentShell);
    setBlockOnOpen(true);

    //
    this._mappingProviderSupplier = checkNotNull(mappingProviderSupplier);
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public IMappingProvider getSelectedMappingProvider() {
    return this._selectedMappingProvider;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void configureShell(Shell shell) {
    super.configureShell(shell);
    shell.setText("Select Mapping");
    shell.setImage(Images.SLIZAA_16.getImage());
    shell.setSize(800, 800);
    Rectangle screen = shell.getDisplay().getMonitors()[0].getBounds();
    shell.setBounds((screen.width - shell.getSize().x) / 2, (screen.height - shell.getSize().y) / 2, shell.getSize().x,
        shell.getSize().y);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void create() {
    super.create();

    //
    setTitle("Select the graph mapping");
    setMessage("Select Mapping");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected Control createDialogArea(Composite parent) {
    Composite area = (Composite) super.createDialogArea(parent);

    Composite container = new Composite(area, SWT.NONE);
    container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    GridLayout layout = new GridLayout(2, false);
    container.setLayout(layout);

    final TreeViewer tv = new TreeViewer(container, SWT.SINGLE | SWT.BORDER);
    tv.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
    tv.setContentProvider(new MappingProviderTreeContentProvider(this._mappingProviderSupplier));
    tv.setLabelProvider(new MappingProviderLabelProvider());
    tv.setInput("root");
    tv.addDoubleClickListener(event -> {
      ISelection selection = event.getSelection();
      if (selection instanceof IStructuredSelection) {
        IStructuredSelection structuredSelection = (IStructuredSelection) selection;
        for (Object selectedElement : structuredSelection.toList()) {
          tv.setExpandedState(selectedElement, !tv.getExpandedState(selectedElement));
        }
      }
    });
    tv.addSelectionChangedListener(event -> {

      //
      Object selection = event.getStructuredSelection().getFirstElement();
      this._selectedMappingProvider = selection instanceof IMappingProvider ? (IMappingProvider) selection : null;

      //
      validate();
    });
    return area;
  }

  /**
   * <p>
   * </p>
   *
   */
  private void validate() {
    getButton(IDialogConstants.OK_ID).setEnabled(this._selectedMappingProvider != null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean isResizable() {
    return true;
  }
}