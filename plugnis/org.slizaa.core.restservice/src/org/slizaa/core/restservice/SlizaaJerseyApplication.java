package org.slizaa.core.restservice;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.jackson.JacksonFeature;

/**
 * <p>
 * Configures the
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class SlizaaJerseyApplication extends Application {

  /**
   * {@inheritDoc}
   */
  @Override
  public Set<Class<?>> getClasses() {

    // create the result set
    Set<Class<?>> result = new HashSet<Class<?>>();

    // add the jackson feature
    result.add(JacksonFeature.class);
    result.add(StatusResource.class);

    //
    for (Class<?> clazz : SlizaaCoreRestServiceComponent.getBundleExtensionClasses(Path.class)) {
      result.add(clazz);
    }

    //
    return result;
  }

}