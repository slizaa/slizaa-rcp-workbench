package org.slizaa.core.restservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * <p>
 * http://localhost:9090/slizaa-rest/status
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
@Path("status")
public class StatusResource {

  /**
   * <p>
   * </p>
   *
   * @return
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Status getStatus() {
    return new Status("OK");
  }
}