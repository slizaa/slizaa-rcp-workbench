package org.slizaa.core.restservice;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.jackson.JacksonFeature;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class JerseyApplication extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    // https://stackoverflow.com/questions/48525205/how-to-resolve-jersey-internal-runtimedelegateimpl-with-jersey-on-osgi
    //
    Set<Class<?>> result = new HashSet<Class<?>>();

    //
    result.add(JacksonFeature.class);

    //
    result.add(StatusResource.class);

    //
    for (Class<?> clazz : SlizaaCoreRestServiceComponent.getBundleExtensionClasses(Path.class)) {
      result.add(clazz);
    }

    //
    return result;
  }

}