package org.slizaa.hierarchicalgraph.core.testfwk.ui.rules;

import java.util.LinkedList;
import java.util.List;

import org.slizaa.ui.tree.ISlizaaActionContribution;
import org.slizaa.ui.tree.ISlizaaActionContributionProvider;
import org.slizaa.ui.tree.ISlizaaActionGroupContribution;

public class DefaultActionContributionProvider implements ISlizaaActionContributionProvider {

  /** - */
  private List<ISlizaaActionGroupContribution> _actionGroupContributions;

  /** - */
  private List<ISlizaaActionContribution> _actionContributions;

  public DefaultActionContributionProvider() {
    _actionGroupContributions = new LinkedList<>();
    _actionContributions = new LinkedList<>();
  }

  public List<ISlizaaActionGroupContribution> actionGroups() {
    return _actionGroupContributions;
  }

  public List<ISlizaaActionContribution> actions() {
    return _actionContributions;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ISlizaaActionGroupContribution[] getActionGroupContributions() {
    return _actionGroupContributions.toArray(new ISlizaaActionGroupContribution[0]);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ISlizaaActionContribution[] getActionContributions() {
    return _actionContributions.toArray(new ISlizaaActionContribution[0]);
  }
}
