package org.slizaa.ui.tree;

public interface ISlizaaActionContributionProvider {

  /**
   * <p>
   * </p>
   *
   * @return
   */
  ISlizaaActionGroupContribution[] getActionGroupContributions();

  /**
   * <p>
   * </p>
   *
   * @return
   */
  ISlizaaActionContribution[] getActionContributions();
}
