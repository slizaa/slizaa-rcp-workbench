/**
 *
 */
package org.slizaa.rcp.workbench.core.internal.projectconfig;

import static com.google.common.base.Preconditions.checkNotNull;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.slizaa.rcp.workbench.core.ISlizaaProject;
import org.slizaa.scanner.core.spi.contentdefinition.IContentDefinitionProvider;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class SlizaaProjectConfigurationModel {

  /** - */
  private String              _className;

  /** - */
  private IProject            _project;

  /** - */
  private Map<String, String> _configurationMethodsMap;

  /**
   * <p>
   * Creates a new instance of type {@link SlizaaProjectConfigurationModel}.
   * </p>
   *
   * @param project
   * @param className
   */
  public SlizaaProjectConfigurationModel(IProject project, String className) {

    //
    this._project = checkNotNull(project);
    this._className = checkNotNull(className);

    //
    this._configurationMethodsMap = new HashMap<>();
  }

  /**
   * <p>
   * </p>
   *
   * @param returnType
   * @param methodName
   */
  public void registerConfigurationMethod(String returnType, String methodName) {

    //
    checkNotNull(returnType);
    checkNotNull(methodName);

    //
    System.out.println("registerConfigurationMethod " + returnType + " : " + methodName);

    //
    this._configurationMethodsMap.put(returnType, methodName);
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
    ClassLoader parentClassLoader = SlizaaProjectConfigurationModel.class.getClassLoader();
    URL[] urls = urlList.toArray(new URL[urlList.size()]);

    //
    return new URLClassLoader(urls, parentClassLoader);
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public IContentDefinitionProvider getContentDefinitionProvider() {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public boolean hasProblems() {
    // TODO Auto-generated method stub
    return false;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public List<SlizaaProjectConfigurationProblem> getProblems() {
    // TODO Auto-generated method stub
    return null;
  }

}
