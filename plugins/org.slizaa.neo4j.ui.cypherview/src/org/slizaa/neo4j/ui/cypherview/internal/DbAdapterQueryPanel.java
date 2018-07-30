package org.slizaa.neo4j.ui.cypherview.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.function.Supplier;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceRegistration;
import org.slizaa.core.boltclient.IBoltClient;
import org.slizaa.core.boltclient.IBoltClientListener;
import org.slizaa.neo4j.ui.cypherview.internal.handler.ExecuteQuery;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class DbAdapterQueryPanel extends Composite implements IBoltClientListener {

  /** - */
  private Text                                     _activeDatabaseLabel;

  /** - */
  private IBoltClient                              _boltClient;

  /** - */
  private Composite                                _panel;

  /** - */
  private ServiceRegistration<IBoltClientListener> _serviceRegistration;

  /** - */
  private ToolItem                                 _executeAction;

  /**
   * <p>
   * Creates a new instance of type {@link DbAdapterQueryPanel}.
   * </p>
   *
   * @param parent
   * @param cypherQuerySupplier
   */
  public DbAdapterQueryPanel(Composite parent, Supplier<String> cypherQuerySupplier) {
    super(parent, SWT.NONE);

    //
    checkNotNull(cypherQuerySupplier);

    this.setLayout(GridLayoutFactory.fillDefaults().equalWidth(false).numColumns(1).margins(0, 0).create());

    createQueryComposite(this, cypherQuerySupplier);

    this._panel = new Composite(this, SWT.NONE);
    this._panel.setLayout(new FillLayout());
    this._panel.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public IBoltClient getBoltClient() {
    return this._boltClient;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public Composite getEditorArea() {
    return this._panel;
  }

  @Override
  public void boltClientAdded(IBoltClient client) {
    setBoltClient(client);
  }

  @Override
  public void boltClientRemoved(IBoltClient client) {

  }

  /**
   * <p>
   * </p>
   */
  public void registerGraphDatabaseClientAdapterAwareOSGiService() {

    // register as OSGi service
    try {
      this._serviceRegistration = FrameworkUtil.getBundle(DbAdapterQueryPanel.class).getBundleContext()
          .registerService(IBoltClientListener.class, this, null);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * <p>
   * </p>
   */
  public void unregisterGraphDatabaseClientAdapterAwareOSGiService() {

    if (this._serviceRegistration != null) {
      // deregister as OSGi service
      this._serviceRegistration.unregister();
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param parent
   */
  private void createQueryComposite(Composite parent, Supplier<String> cypherQuerySupplier) {

    //
    Composite composite = new Composite(parent, SWT.NONE);
    GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 5;
    gridLayout.makeColumnsEqualWidth = false;
    composite.setLayout(gridLayout);
    composite.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));

    //
    Label label = new Label(composite, SWT.NO_BACKGROUND);
    label.setText("Query against:");
    label.setAlignment(SWT.RIGHT);
    label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, true));

    //
    this._activeDatabaseLabel = new Text(composite, SWT.NONE);
    this._activeDatabaseLabel.setEditable(false);
    GridData gridData = new GridData(30 * 10, SWT.DEFAULT);
    this._activeDatabaseLabel.setLayoutData(gridData);

    //
    ToolBar toolBar = new ToolBar(composite, SWT.FLAT);
    toolBar.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true));

    //
    // IWorkbench wb = PlatformUI.getWorkbench();
    // IWorkbenchWindow win = wb.getActiveWorkbenchWindow();

    this._executeAction = new ToolItem(toolBar, SWT.PUSH);
    this._executeAction.setEnabled(false);
    this._executeAction.setImage(OpenCypherUiImages.EXECUTE_QUERY.getImage());
    this._executeAction.addSelectionListener(new SelectionListener() {

      @Override
      public void widgetSelected(SelectionEvent e) {

        //
        ExecuteQuery.executeQuery();

        // String cypherString = cypherQuerySupplier.get();
        //
        // if (_queryResultConsumers.size() == 0) {
        // return;
        // }
        //
        // if (DbAdapterQueryPanel.this._boltClient != null) {
        // DbAdapterQueryPanel.this._executeAction.setEnabled(false);
        // try {
        //
        // // TODO
        //
        // ErrorMessageQueryResultConsumer consumer = new ErrorMessageQueryResultConsumer(
        // _queryResultConsumers.get(0));
        //
        // //
        // final Future<?> future = DbAdapterQueryPanel.this._boltClient.executeCypherQuery(cypherString, consumer);
        // new Thread(() -> {
        // try {
        // while (!(future.isDone() || future.isCancelled())) {
        // Thread.sleep(500);
        // }
        // } catch (Exception exception) {
        // exception.printStackTrace();
        // } finally {
        // Display.getDefault().syncExec(() -> DbAdapterQueryPanel.this._executeAction.setEnabled(true));
        // }
        // }).start();
        //
        // } catch (Exception exception) {
        // DbAdapterQueryPanel.this._executeAction.setEnabled(true);
        // }
        // }

      }

      @Override
      public void widgetDefaultSelected(SelectionEvent e) {
        //
      }
    });

    // CommandContributionItemParameter param = new CommandContributionItemParameter(win, "myCommand",
    // "org.slizaa.neo4j.ui.cypherview.executeCypherQuery", CommandContributionItem.STYLE_PUSH);
    // param.icon = OpenCypherUiImages.EXECUTE_QUERY.getImageDescriptor();
    // param.mode = 0;
    // param.style = CommandContributionItem.STYLE_PUSH;
    // this._item = new CommandContributionItem(param) {
    //
    // @Override
    // public boolean isDirty() {
    // return true;
    // }
    //
    // @Override
    // public boolean isDynamic() {
    // return true;
    // }
    //
    // };
    // this._item.fill(toolBar, -1);
  }

  /**
   * <p>
   * </p>
   *
   * @param client
   */
  private void setBoltClient(IBoltClient client) {

    //
    if (isDisposed()) {
      return;
    }

    // set the bolt client
    this._boltClient = client;

    // update ui
    Display.getDefault().syncExec(() -> {
      if (this._boltClient != null) {
        this._activeDatabaseLabel.setText(this._boltClient.getName());
        this._executeAction.setEnabled(true);
      } else {
        this._activeDatabaseLabel.setText("");
        this._executeAction.setEnabled(false);
      }
    });
  }
}
