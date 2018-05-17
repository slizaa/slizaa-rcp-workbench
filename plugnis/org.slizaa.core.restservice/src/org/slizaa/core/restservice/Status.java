package org.slizaa.core.restservice;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class Status {

  /** - */
  @JsonProperty("status")
  private String _status;

  /**
   * <p>
   * Creates a new instance of type {@link Status}.
   * </p>
   *
   * @param status
   */
  public Status(String status) {
    this._status = status;
  }
}