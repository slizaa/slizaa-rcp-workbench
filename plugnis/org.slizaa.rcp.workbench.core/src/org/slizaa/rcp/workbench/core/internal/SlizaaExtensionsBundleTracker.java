/**
 *
 */
package org.slizaa.rcp.workbench.core.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.wiring.BundleWiring;
import org.osgi.util.tracker.BundleTracker;
import org.slizaa.scanner.core.classpathscanner.ClasspathScannerFactoryBuilder;
import org.slizaa.scanner.core.classpathscanner.IClasspathScannerFactory;
import org.slizaa.scanner.core.spi.annotations.ContentDefinitionProvider;
import org.slizaa.scanner.core.spi.annotations.ParserFactory;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 */
public class SlizaaExtensionsBundleTracker extends BundleTracker<Map<Class<?>, List<Class<?>>>> {

  /** - */
  private IClasspathScannerFactory _classpathScannerFactory;

  /**
   * <p>
   * Creates a new instance of type {@link SlizaaExtensionsBundleTracker}.
   * </p>
   *
   * @param context
   */
  public SlizaaExtensionsBundleTracker(BundleContext context) {
    super(context, Bundle.RESOLVED | Bundle.STARTING | Bundle.ACTIVE, null);

    //
    this._classpathScannerFactory = ClasspathScannerFactoryBuilder.newClasspathScannerFactory()
        //
        .registerCodeSourceClassLoaderProvider(Bundle.class, (b) -> {
          return b.adapt(BundleWiring.class).getClassLoader();
        })
        //
        .create();
  }

  @Override
  public Map<Class<?>, List<Class<?>>> addingBundle(Bundle bundle, BundleEvent event) {

    //
    String slizaaExtension = bundle.getHeaders().get(IClasspathScannerFactory.SLIZAA_EXTENSION_BUNDLE_HEADER);

    //
    if (slizaaExtension != null && !slizaaExtension.isEmpty()) {

      // create the result map
      Map<Class<?>, List<Class<?>>> extensions = new HashMap<>();

      // scan the bundle
      this._classpathScannerFactory
          //
          .createScanner(bundle)
          // SlizaaContentDefinitionProvider
          .matchClassesWithAnnotation(ContentDefinitionProvider.class,
              (b, exts) -> extensions.computeIfAbsent(ContentDefinitionProvider.class, k -> new ArrayList<>())
                  .addAll(exts))
          // SlizaaContentDefinitionProvider
          .matchClassesWithAnnotation(ParserFactory.class,
              (b, exts) -> extensions.computeIfAbsent(ParserFactory.class, k -> new ArrayList<>()).addAll(exts))
          //
          .scan();

      //
      return extensions;
    }
    //
    else {
      return null;
    }
  }
}
