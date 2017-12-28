package org.slizaa.rcp.workbench.discovery.ui;

import java.util.List;

import org.eclipse.jface.viewers.Viewer;
import org.osgi.service.component.annotations.Component;
import org.slizaa.ui.tree.ISlizaaActionContribution;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
@Component(service = ISlizaaActionContribution.class)
public class InstallSlizaaExtensionsContribution extends ISlizaaActionContribution.DefaultActionContribution {

  /**
   * <p>
   * Creates a new instance of type {@link InstallSlizaaExtensionsContribution}.
   * </p>
   */
  public InstallSlizaaExtensionsContribution() {
    super("Install Local Database Support...", null, null, 200);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean shouldShow(List<?> selection, Viewer viewer) {
    // TODO
    return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(List<?> selection, Viewer viewer) {
    ShowBundleCatalogCommandExecuter.executeShowBundleCatalogCommand();
  }
}
