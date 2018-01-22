/**
 *
 */
package org.slizaa.rcp.workbench.core.internal.extensions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.wiring.BundleWiring;
import org.osgi.util.tracker.BundleTracker;
import org.slizaa.rcp.workbench.core.internal.extensions.SlizaaExtensionsBundleTracker.SlizaaExtensionsHolder;
import org.slizaa.scanner.core.api.cypherregistry.ICypherStatement;
import org.slizaa.scanner.core.classpathscanner.ClasspathScannerFactoryBuilder;
import org.slizaa.scanner.core.classpathscanner.IClasspathScannerFactory;
import org.slizaa.scanner.core.cypherregistry.SlizaaCypherFileParser;
import org.slizaa.scanner.core.spi.annotations.ParserFactory;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 */
public class SlizaaExtensionsBundleTracker extends BundleTracker<SlizaaExtensionsHolder> {

  public static class SlizaaExtensionsHolder {

    /** - */
    private Map<Class<?>, List<Class<?>>> _extensions       = new HashMap<>();

    /** - */
    private List<ICypherStatement>        _cypherExtensions = new LinkedList<>();

    /**
     * <p>
     * </p>
     *
     * @return
     */
    public Map<Class<?>, List<Class<?>>> getExtensions() {
      return _extensions;
    }

    /**
     * <p>
     * </p>
     *
     * @return
     */
    public List<ICypherStatement> getCypherExtensions() {
      return _cypherExtensions;
    }
  }

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

  /**
   * {@inheritDoc}
   */
  @Override
  public SlizaaExtensionsHolder addingBundle(Bundle bundle, BundleEvent event) {

    //
    String slizaaExtension = bundle.getHeaders().get(IClasspathScannerFactory.SLIZAA_EXTENSION_BUNDLE_HEADER);

    //
    if (slizaaExtension != null && !slizaaExtension.isEmpty()) {

      // create the result
      SlizaaExtensionsHolder extensionsHolder = new SlizaaExtensionsHolder();

      // scan the bundle
      this._classpathScannerFactory
          //
          .createScanner(bundle)

          // parser factory
          .matchClassesWithAnnotation(ParserFactory.class,
              (b, exts) -> extensionsHolder.getExtensions().computeIfAbsent(ParserFactory.class, k -> new ArrayList<>())
                  .addAll(exts))

          // cypher extensions
          .matchFiles("cypher",
              (relativePath, inputStream, lengthBytes) -> SlizaaCypherFileParser.parse(relativePath, inputStream),
              (b, contentList) -> extensionsHolder.getCypherExtensions().addAll(contentList))

          //
          .scan();

      //
      return extensionsHolder;
    }
    //
    else {
      return null;
    }
  }
}
