/**
 *
 */
package org.slizaa.rcp.workbench.ui.internal.decorators;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class SlizaaProjectAdapter extends AdapterImpl {

  /**
   * {@inheritDoc}
   */
  @Override
  public void notifyChanged(Notification msg) {
    Display.getDefault().asyncExec(() -> {
      IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
      decoratorManager.update(SlizaaProjectDecorator.DECORATOR_ID);
    });
  }

}