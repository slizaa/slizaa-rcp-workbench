package org.slizaa.ui.tree.internal.osgi;

import static com.google.common.base.Preconditions.checkNotNull;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.slizaa.ui.tree.ISlizaaActionContribution;
import org.slizaa.ui.tree.ISlizaaActionContributionProvider;
import org.slizaa.ui.tree.ISlizaaActionGroupContribution;

public class OSGiBasedActionContributionProvider implements ISlizaaActionContributionProvider {

  /** - */
  private ServiceTracker<ISlizaaActionContribution, ISlizaaActionContribution>           _slizaaTreeActionTracker;

  /** - */
  private ServiceTracker<ISlizaaActionGroupContribution, ISlizaaActionGroupContribution> _slizaaActionGroupContribution;

  /** - */
  private BundleContext                                                                  _context;

  /**
   * <p>
   * Creates a new instance of type {@link OSGiBasedActionContributionProvider}.
   * </p>
   *
   * @param context
   */
  public OSGiBasedActionContributionProvider(BundleContext context) {
    _context = checkNotNull(context);
  }

  /**
   * <p>
   * </p>
   */
  public void init() {

    //
    _slizaaTreeActionTracker = new ServiceTracker<>(_context, ISlizaaActionContribution.class, null);
    _slizaaActionGroupContribution = new ServiceTracker<>(_context, ISlizaaActionGroupContribution.class, null);

    //
    _slizaaTreeActionTracker.open();
    _slizaaActionGroupContribution.open();
  }

  /**
   * <p>
   * </p>
   *
   */
  public void dispose() {

    //
    _slizaaTreeActionTracker.close();
    _slizaaActionGroupContribution.close();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ISlizaaActionGroupContribution[] getActionGroupContributions() {
    return _slizaaActionGroupContribution.getServices(new ISlizaaActionGroupContribution[0]);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ISlizaaActionContribution[] getActionContributions() {
    return _slizaaTreeActionTracker.getServices(new ISlizaaActionContribution[0]);
  }
}
