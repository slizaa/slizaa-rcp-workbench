package org.slizaa.hierarchicalgraph.core.testfwk.ui.rules;

import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.junit.rules.ExternalResource;
import org.slizaa.ui.tree.SlizaaTreeViewerFactory;

public class SlizaaTreeViewerFactoryRule extends ExternalResource {

  /** - */
  private IEclipseContext                   _eclipseContext;

  /** - */
  private DefaultActionContributionProvider _defaultActionContributionProvider;

  /**
   * {@inheritDoc}
   */
  @Override
  protected void before() throws Throwable {

    //
    this._eclipseContext = EclipseContextFactory.create();
    this._defaultActionContributionProvider = new DefaultActionContributionProvider();

    //
    SlizaaTreeViewerFactory.setSlizaaTreeViewerCreator(this._defaultActionContributionProvider, () -> eclipseContext());
  }

  @Override
  protected void after() {
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public final IEclipseContext eclipseContext() {
    return this._eclipseContext;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public final DefaultActionContributionProvider defaultActionContributionProvider() {
    return this._defaultActionContributionProvider;
  }
}
