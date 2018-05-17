package org.slizaa.core.restservice;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.ServletException;
import javax.ws.rs.ext.RuntimeDelegate;

import org.glassfish.jersey.servlet.ServletContainer;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;
import org.slizaa.scanner.core.classpathscanner.IClasspathScannerService;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
@Component
public class SlizaaCoreRestServiceComponent {

  /** the slizaa rest service alias */
  private static final String                   SLIZAA_REST_ALIAS = "/slizaa-rest";

  /** the HttpService */
  @Reference(cardinality = ReferenceCardinality.MANDATORY, policy = ReferencePolicy.STATIC)
  private HttpService                           _httpService;

  /** the IClasspathScannerService */
  @Reference(cardinality = ReferenceCardinality.MANDATORY, policy = ReferencePolicy.STATIC)
  private IClasspathScannerService              _classpathScannerService;

  /** the instance */
  private static SlizaaCoreRestServiceComponent instance;

  /**
   * <p>
   * Returns the component instance
   * </p>
   *
   * @return the component instance
   */
  public static SlizaaCoreRestServiceComponent instance() {
    return instance;
  }

  /**
   * <p>
   * Return all known extension classes with the given annotation
   * </p>
   *
   * @param annotationType
   * @return the list of classes
   */
  public static final List<Class<?>> getBundleExtensionClasses(Class<? extends Annotation> annotationType) {
    return instance != null ? instance()._classpathScannerService.getExtensionsWithClassAnnotation(annotationType)
        : Collections.emptyList();
  }

  /**
   * <p>
   * Activates this component instance.
   * </p>
   *
   * @throws ServletException
   * @throws NamespaceException
   */
  @Activate
  public void activate() throws ServletException, NamespaceException {

    // Workaround:
    // https://stackoverflow.com/questions/48525205/how-to-resolve-jersey-internal-runtimedelegateimpl-with-jersey-on-osgi
    RuntimeDelegate.setInstance(new org.glassfish.jersey.internal.RuntimeDelegateImpl());

    // the component instance
    SlizaaCoreRestServiceComponent.instance = this;

    try {
      this._httpService.registerServlet(SLIZAA_REST_ALIAS, new ServletContainer(), new Hashtable<String, String>() {
        {
          put("javax.ws.rs.Application", SlizaaJerseyApplication.class.getName());
          put("jersey.config.server.provider.packages", "com.fasterxml.jackson.jaxrs.json");
        }
      }, null);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * <p>
   * Deactivates this component instance.
   * </p>
   */
  @Deactivate
  public void deactivate() {

    //
    SlizaaCoreRestServiceComponent.instance = null;

    //
    this._httpService.unregister(SLIZAA_REST_ALIAS);
  }
}
