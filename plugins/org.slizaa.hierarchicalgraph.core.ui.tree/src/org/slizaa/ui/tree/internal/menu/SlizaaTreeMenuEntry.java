package org.slizaa.ui.tree.internal.menu;

import static com.google.common.base.Preconditions.checkNotNull;

import org.slizaa.ui.tree.ISlizaaActionContribution;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class SlizaaTreeMenuEntry implements ISlizaaTreeMenuPart {

  /** - */
  private ISlizaaActionContribution actionContribution;

  /**
   * <p>
   * Creates a new instance of type {@link SlizaaTreeMenuEntry}.
   * </p>
   *
   * @param actionContribution
   */
  public SlizaaTreeMenuEntry(ISlizaaActionContribution actionContribution) {
    this.actionContribution = checkNotNull(actionContribution);
  }

  
  
  @Override
  public int ranking() {
    return actionContribution.getRanking();
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public ISlizaaActionContribution getActionContribution() {
    return actionContribution;
  }
}
