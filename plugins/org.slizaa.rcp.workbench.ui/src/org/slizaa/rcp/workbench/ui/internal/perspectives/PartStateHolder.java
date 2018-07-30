package org.slizaa.rcp.workbench.ui.internal.perspectives;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class PartStateHolder {

  /** - */
  private boolean _toBeRendered;

  /** - */
  private boolean _selected;

  /**
   * <p>
   * Creates a new instance of type {@link PartStateHolder}.
   * </p>
   *
   * @param toBeRendered
   */
  public PartStateHolder(boolean toBeRendered, boolean selected) {
    _toBeRendered = toBeRendered;
    _selected = selected;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public boolean isToBeRendered() {
    return _toBeRendered;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public boolean isSelected() {
    return _selected;
  }
}
