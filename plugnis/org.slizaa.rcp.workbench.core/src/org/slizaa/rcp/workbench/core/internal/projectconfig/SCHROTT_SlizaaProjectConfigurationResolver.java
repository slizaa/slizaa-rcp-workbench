/**
 *
 */
package org.slizaa.rcp.workbench.core.internal.projectconfig;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.slizaa.rcp.workbench.core.ISlizaaProject;
import org.slizaa.rcp.workbench.core.api.projectconfig.SlizaaProjectConfiguration;
import org.slizaa.rcp.workbench.core.internal.Activator;
import org.slizaa.scanner.core.classpathscanner.IClasspathScanner;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 */
public class SCHROTT_SlizaaProjectConfigurationResolver {

  /**
   * <p>
   * </p>
   *
   * @param slizaaProject
   * @return
   * @throws Exception
   * @throws IOException
   */
  private static List<Object> findAnnotatedSlizaaProjectConfigurationClasses(ISlizaaProject slizaaProject) {

    //
    checkNotNull(slizaaProject);

    try (URLClassLoader classLoader = createClassLoader(slizaaProject)) {

      //
      IClasspathScanner classpathScanner = Activator.instance().getClasspathScannerFactory().createScanner(classLoader);

      //
      List<Object> result = new ArrayList<>();

      //
      classpathScanner.matchClassesWithAnnotation(SlizaaProjectConfiguration.class, (source, classes) -> {
        for (Class<?> clazz : classes) {
          try {
            result.add(clazz.newInstance());
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }).scan();

      //
      return result;
    } catch (Exception e2) {
      return Collections.emptyList();
    }
  }

  public static List<Method> getMethodsAnnotatedWith(final Class<?> type,
      final Class<? extends Annotation> annotation) {
    final List<Method> methods = new ArrayList<Method>();
    Class<?> klass = type;
    while (klass != Object.class) { // need to iterated thought hierarchy in order to retrieve methods from above the
                                    // current instance
      // iterate though the list of methods declared in the class represented by klass variable, and add those annotated
      // with the specified annotation
      final List<Method> allMethods = new ArrayList<Method>(Arrays.asList(klass.getDeclaredMethods()));
      for (final Method method : allMethods) {
        if (method.isAnnotationPresent(annotation)) {
          Annotation annotInstance = method.getAnnotation(annotation);
          // TODO process annotInstance
          methods.add(method);
        }
      }
      // move to the upper class in the hierarchy in search for more methods
      klass = klass.getSuperclass();
    }
    return methods;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   * @throws Exception
   */
  private static URLClassLoader createClassLoader(ISlizaaProject slizaaProject) throws Exception {

    //
    IJavaProject javaProject = JavaCore.create(slizaaProject.getProject());

    // TODO
    // https://sdqweb.ipd.kit.edu/wiki/JDT_Tutorial:_Class_Loading_in_a_running_plugin
    String[] classPathEntries = JavaRuntime.computeDefaultRuntimeClassPath(javaProject);

    List<URL> urlList = new ArrayList<URL>();
    for (int i = 0; i < classPathEntries.length; i++) {
      IPath path = new Path(classPathEntries[i]);
      urlList.add(path.toFile().toURI().toURL());
    }

    //
    ClassLoader parentClassLoader = SCHROTT_SlizaaProjectConfigurationResolver.class.getClassLoader();
    URL[] urls = urlList.toArray(new URL[urlList.size()]);

    //
    return new URLClassLoader(urls, parentClassLoader);
  }
}
