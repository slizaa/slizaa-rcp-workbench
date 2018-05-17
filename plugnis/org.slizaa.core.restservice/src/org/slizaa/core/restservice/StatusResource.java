package org.slizaa.core.restservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("status")
public class StatusResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Track getStatus() {
    return new Track("hurz", "di purz");
  }
}