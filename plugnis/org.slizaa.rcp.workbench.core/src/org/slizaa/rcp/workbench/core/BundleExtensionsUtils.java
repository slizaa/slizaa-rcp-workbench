/**
 *
 */
package org.slizaa.rcp.workbench.core;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.slizaa.neo4j.hierarchicalgraph.mapping.annotations.SlizaaMappingProvider;
import org.slizaa.neo4j.hierarchicalgraph.mapping.spi.IMappingProvider;
import org.slizaa.rcp.workbench.core.internal.Activator;
import org.slizaa.rcp.workbench.core.model.SlizaaExtensionBundle;
import org.slizaa.scanner.core.spi.annotations.ParserFactory;
import org.slizaa.scanner.core.spi.parser.IParserFactory;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 */

public class BundleExtensionsUtils {

  /**
   * <p>
   * </p>
   */
  public static final List<IParserFactory> getBundleExtensions_ParserFactory() {
    return getBundleExtensions(ParserFactory.class, IParserFactory.class);
  }

  /**
   * <p>
   * </p>
   *
   * @param slizaaProject
   * @return
   */
  public static final List<IMappingProvider> getBundleExtensions_MappingProvider() {
    return getBundleExtensions(SlizaaMappingProvider.class, IMappingProvider.class);
  }

  /**
   * <p>
   * </p>
   *
   * @param annotationType
   * @param instanceType
   * @return
   */
  private static final <T> List<T> getBundleExtensions(Class<? extends Annotation> annotationType,
      Class<T> instanceType) {

    //
    Collection<SlizaaExtensionBundle> extensionBundles = Activator.instance().getTrackedExtensionBundles().values();

    return extensionBundles.stream()

        //
        .flatMap(
            exBundle -> exBundle.getDefinedExtensions().getOrDefault(annotationType, Collections.emptyList()).stream())

        //
        .map(bundleExtension -> {

          try {
            return bundleExtension.createNewInstance(instanceType);
          } catch (Exception e) {
            e.printStackTrace();
            return null;
          }
        })

        //
        .filter(mappingProvider -> mappingProvider != null)

        //
        .collect(Collectors.toList());
  }
}
