/**
 *
 */
package org.slizaa.rcp.workbench.core;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.slizaa.neo4j.hierarchicalgraph.mapping.annotations.SlizaaMappingProvider;
import org.slizaa.neo4j.hierarchicalgraph.mapping.spi.IMappingProvider;
import org.slizaa.rcp.workbench.core.model.SlizaaProject;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension;
import org.slizaa.scanner.core.spi.annotations.ParserFactory;
import org.slizaa.scanner.core.spi.parser.IParserFactory;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 */

public class ProjectExtensionsUtils {

  /**
   * <p>
   * </p>
   *
   * @param slizaaProject
   * @return
   */
  public static final List<IParserFactory> getProjectExtensions_ParserFactory(SlizaaProject slizaaProject) {
    return getProjectExtensions(slizaaProject, ParserFactory.class, IParserFactory.class);
  }

  /**
   * <p>
   * </p>
   *
   * @param slizaaProject
   * @return
   */
  public static final List<IMappingProvider> getProjectExtensions_MappingProvider(SlizaaProject slizaaProject) {

    //
    List<IMappingProvider> result = getProjectExtensions(slizaaProject, SlizaaMappingProvider.class,
        IMappingProvider.class);

    //
    return result;
  }

  /**
   * <p>
   * </p>
   *
   * @param slizaaProject
   * @param annotationType
   * @param instanceType
   * @return
   */
  private static final <T> List<T> getProjectExtensions(SlizaaProject slizaaProject,
      Class<? extends Annotation> annotationType, Class<T> instanceType) {

    // step 1: get all the extensions
    List<SlizaaProjectExtension> extensions = slizaaProject.getUserDefinedExtensions().get(annotationType);

    // step 2: check if there are extensions
    if (extensions == null) {
      return Collections.emptyList();
    }

    // step 3: try to create instances
    return extensions.stream()

        //
        .map(ext -> {
          try {
            return ext.createNewInstance(instanceType);
          } catch (Exception e) {
            return null;
          }
        })

        //
        .filter(mappingProvider -> mappingProvider != null)

        //
        .collect(Collectors.toList());
  }
}
