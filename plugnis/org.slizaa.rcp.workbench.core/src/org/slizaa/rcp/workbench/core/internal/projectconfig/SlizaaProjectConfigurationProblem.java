package org.slizaa.rcp.workbench.core.internal.projectconfig;

import org.eclipse.core.runtime.Assert;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class SlizaaProjectConfigurationProblem {

  private String _message;

  private int    _charStart;

  private int    _charEnd;

  /**
   * <p>
   * Creates a new instance of type {@link SlizaaProjectConfigurationProblem}.
   * </p>
   *
   * @param message
   * @param charStart
   * @param charEnd
   */
  public SlizaaProjectConfigurationProblem(String message, int charStart, int charEnd) {
    Assert.isNotNull(message);

    this._message = message;
    this._charStart = charStart;
    this._charEnd = charEnd;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public String getMessage() {
    return this._message;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public int getCharStart() {
    return this._charStart;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public int getCharEnd() {
    return this._charEnd;
  }
}