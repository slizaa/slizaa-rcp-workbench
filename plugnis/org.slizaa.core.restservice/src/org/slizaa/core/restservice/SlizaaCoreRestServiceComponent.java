package org.slizaa.core.restservice;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;

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

  /** - */
  private static final String                   SLIZAA_REST_ALIAS = "/slizaa-rest";

  /** LOGGER */
  private static final Logger                   LOGGER            = Logger
      .getLogger(SlizaaCoreRestServiceComponent.class.getName());

  /** - */
  @Reference(cardinality = ReferenceCardinality.MANDATORY, policy = ReferencePolicy.STATIC)
  private HttpService                           _httpService;

  /** - */
  @Reference(cardinality = ReferenceCardinality.MANDATORY, policy = ReferencePolicy.STATIC)
  private IClasspathScannerService              _classpathScannerService;

  /** - */
  private static SlizaaCoreRestServiceComponent instance;

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public static SlizaaCoreRestServiceComponent instance() {
    return instance;
  }

  /**
   * <p>
   * </p>
   *
   * @param annotationType
   * @return
   */
  public static final List<Class<?>> getBundleExtensionClasses(Class<? extends Annotation> annotationType) {

    //
    return instance != null ? instance()._classpathScannerService.getExtensionsWithClassAnnotation(annotationType)
        : Collections.emptyList();
  }

  /**
   * <p>
   * </p>
   *
   * @throws ServletException
   * @throws NamespaceException
   */
  @Activate
  public void activate() throws ServletException, NamespaceException {

    //
    LOGGER.info("SlizaaCoreRestServiceComponent.activate()");

    //
    SlizaaCoreRestServiceComponent.instance = this;

    //
    executeWithThreadContextClassLoader(() -> {
      try {
        this._httpService.registerServlet(SLIZAA_REST_ALIAS, new ServletContainer(), new Hashtable<String, String>() {
          {
            put("javax.ws.rs.Application", JerseyApplication.class.getName());
            // put("jersey.config.server.provider.packages", "com.fasterxml.jackson.jaxrs.json");
          }
        }, null);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    });
  }

  // <init-param>
  // <param-name>com.sun.jersey.api.json.POJOMappingFeature</param-name>
  // <param-value>true</param-value>
  // </init-param>
  //
  /**
   * <p>
   * </p>
   */
  @Deactivate
  public void deactivate() {

    //
    LOGGER.info("SlizaaCoreRestServiceComponent.deactivate()");

    //
    SlizaaCoreRestServiceComponent.instance = null;

    //
    this._httpService.unregister(SLIZAA_REST_ALIAS);
  }

  /**
   * <p>
   * </p>
   *
   * @param runnable
   */
  private void executeWithThreadContextClassLoader(Runnable runnable) {

    //
    ClassLoader originalContextClassLoader = Thread.currentThread().getContextClassLoader();

    //
    try {
      ClassLoader bundleClassLoader = getClass().getClassLoader();
      Thread.currentThread().setContextClassLoader(bundleClassLoader);
      runnable.run();
    }
    //
    finally {
      Thread.currentThread().setContextClassLoader(originalContextClassLoader);
    }
  }
}
