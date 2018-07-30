package org.slizaa.ui.tree.internal.menu;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.LinkedList;
import java.util.List;

import org.slizaa.ui.tree.ISlizaaActionGroupContribution;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class SlizaaTreeMenuGroup implements ISlizaaTreeMenuPart {

  /** - */
  private ISlizaaActionGroupContribution _actionGroupContribution;

  /** - */
  private List<ISlizaaTreeMenuPart>      _menuEntries;

  /** - */
  private String                         _id;

  /**
   * <p>
   * Creates a new instance of type {@link SlizaaTreeMenuGroup}.
   * </p>
   *
   * @param id
   */
  public SlizaaTreeMenuGroup(String id) {
    _id = checkNotNull(id);
    _menuEntries = new LinkedList<>();
  }

  @Override
  public int ranking() {
    return _actionGroupContribution != null ? _actionGroupContribution.getRanking() : 0;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public ISlizaaActionGroupContribution getActionGroupContribution() {
    return _actionGroupContribution;
  }

  /**
   * <p>
   * </p>
   *
   * @param actionGroupContribution
   */
  public void setActionGroupContribution(ISlizaaActionGroupContribution actionGroupContribution) {
    this._actionGroupContribution = actionGroupContribution;
  }

  public boolean isSubMenu() {
    return _actionGroupContribution != null ? _actionGroupContribution.isSubMenu() : false;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public String getId() {
    return _id;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public List<ISlizaaTreeMenuPart> getMenuEntries() {
    return _menuEntries;
  }
}
