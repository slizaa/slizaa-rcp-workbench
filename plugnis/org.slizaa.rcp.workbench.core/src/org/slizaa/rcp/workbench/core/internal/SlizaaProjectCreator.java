/**
 *
 */
package org.slizaa.rcp.workbench.core.internal;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.slizaa.rcp.workbench.core.EclipseProjectUtils;
import org.slizaa.rcp.workbench.core.SlizaaWorkbenchCore;
import org.slizaa.rcp.workbench.core.model.SlizaaProject;

import com.google.common.io.CharStreams;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class SlizaaProjectCreator {

  /**
   * <p>
   * </p>
   *
   * @param project
   * @return
   * @throws CoreException
   */
  public static SlizaaProject configureSlizaaProject(IProject project) throws CoreException {

    //
    checkNotNull(project);
    checkState(project.exists());

    // add the slizaa nature
    EclipseProjectUtils.addNature(project, SlizaaWorkbenchCore.SLIZAA_NATURE_ID);
    SlizaaProject result = SlizaaWorkbenchCore.getSlizaaProject(project);

    // configure as JDT project
    configureJDT(project);

    // return the project
    return result;
  }

  /**
   * <p>
   * </p>
   *
   * @param project
   * @throws CoreException
   * @throws JavaModelException
   */
  private static void configureJDT(IProject project) throws CoreException, JavaModelException {

    // set the Java nature
    EclipseProjectUtils.addNature(project, JavaCore.NATURE_ID);

    // create the java project
    IJavaProject javaProject = JavaCore.create(project);

    // set the build path
    IClasspathEntry[] buildPath = { JavaRuntime.getDefaultJREContainerEntry(),
        JavaCore.newContainerEntry(SlizaaWorkbenchCore.SLIZAA_CONTAINER_PATH),
        JavaCore.newSourceEntry(project.getFullPath().append("src")) };

    javaProject.setRawClasspath(buildPath, project.getFullPath().append("bin"), null);

    // create folder by using resources package
    IFolder folder = project.getFolder("src");
    folder.create(true, true, null);

    //
    createDefaultContent(project);
  }

  /**
   * <p>
   * </p>
   *
   * @param project
   * @throws CoreException
   * @throws JavaModelException
   */
  private static void createDefaultContent(IProject project) throws CoreException, JavaModelException {

    // create the java project
    IJavaProject javaProject = JavaCore.create(project);

    // get the source folder
    IFolder folder = project.getFolder("src");

    // add folder to Java element
    IPackageFragmentRoot srcFolder = javaProject.getPackageFragmentRoot(folder);

    // create package fragment
    IPackageFragment fragment = srcFolder.createPackageFragment("org.slizaa.examplecontent", true, null);

    // create compilation unit
    String content = loadFileContentToString("/" + SlizaaProjectCreator.class.getPackage().getName().replace('.', '/')
        + "/SlizaaProjectCreator_ProjectConf.template");

    ICompilationUnit cu = fragment.createCompilationUnit("ProjectConf.java", content, false, null);

    // create content folder
    IFolder contentFolder = project.getFolder("_content");
    contentFolder.create(true, true, null);

    Bundle[] bundles = FrameworkUtil.getBundle(SlizaaProjectCreator.class).getBundleContext().getBundles();
    for (Bundle bundle : bundles) {
      if ("com.google.guava".equals(bundle.getSymbolicName())) {

        try {

          IFile file = contentFolder.getFile(bundle.getSymbolicName() + "_" + bundle.getVersion() + ".jar");

          String location = bundle.getLocation();
          if (location.startsWith("reference:")) {
            location = location.substring("reference:".length());
          }

          URL url = new URL(location);

          try (InputStream inputStream = url.openStream()) {
            file.create(inputStream, true, null);
          }

        } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param fileName
   * @return
   * @throws IOException
   */
  public static String loadFileContentToString(String fileName) {

    // get the resource input stream
    InputStream inputStream = SlizaaProjectCreator.class.getClassLoader().getResourceAsStream(checkNotNull(fileName));

    //
    if (inputStream == null) {
      throw new RuntimeException("No content defined.");
    }

    //
    String text = null;
    try {
      try (final Reader reader = new InputStreamReader(inputStream)) {
        text = CharStreams.toString(reader);
      }
    } catch (Exception e) {
      return "no content defined";
    }

    //
    return text;
  }
}
