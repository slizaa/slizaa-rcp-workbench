/**
 *
 */
package org.slizaa.rcp.workbench.core.test;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.junit.Assert;
import org.junit.rules.ExternalResource;
import org.slizaa.rcp.workbench.core.EclipseProjectUtils;
import org.slizaa.rcp.workbench.core.SlizaaWorkbenchCore;
import org.slizaa.rcp.workbench.core.model.SlizaaProject;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 */
public class SlizaaProjectRule extends ExternalResource {

  /** - */
  private String                _projectName;

  /** - */
  private IProject              _eclipseProject;

  /** - */
  private SlizaaProject         _slizaaProject;

  /** - */
  private ExampleContentCreator _exampleContentCreator;

  /** - */
  private boolean               _shouldFailOnErrors = true;

  /**
   * <p>
   * Creates a new instance of type {@link SlizaaProjectRule}.
   * </p>
   */
  public SlizaaProjectRule() {
    this(randomString(20), null, true);
  }

  /**
   * <p>
   * Creates a new instance of type {@link SlizaaProjectRule}.
   * </p>
   */
  public SlizaaProjectRule(ExampleContentCreator exampleContentCreator) {
    this(randomString(20), exampleContentCreator, true);
  }

  /**
   * <p>
   * Creates a new instance of type {@link SlizaaProjectRule}.
   * </p>
   *
   * @param exampleContentCreator
   * @param shouldFailOnErrors
   */
  public SlizaaProjectRule(ExampleContentCreator exampleContentCreator, boolean shouldFailOnErrors) {
    this(randomString(20), exampleContentCreator, shouldFailOnErrors);
  }

  /**
   * <p>
   * Creates a new instance of type {@link SlizaaProjectRule}.
   * </p>
   *
   * @param projectName
   */
  public SlizaaProjectRule(String projectName, ExampleContentCreator exampleContentCreator,
      boolean shouldFailOnErrors) {
    this._projectName = checkNotNull(projectName);
    this._exampleContentCreator = exampleContentCreator;
    this._shouldFailOnErrors = shouldFailOnErrors;
  }

  public String getProjectName() {
    return this._projectName;
  }

  public IProject getEclipseProject() {
    return this._eclipseProject;
  }

  public SlizaaProject getSlizaaProject() {
    return this._slizaaProject;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void before() throws Throwable {

    //
    this._projectName = randomString(20);

    //
    this._eclipseProject = EclipseProjectUtils.getOrCreateSimpleProject(this._projectName);
    assertThat(this._eclipseProject).isNotNull();

    //
    this._slizaaProject = SlizaaWorkbenchCore.configureSlizaaProject(this._eclipseProject);
    assertThat(this._slizaaProject).isNotNull();

    //
    if (this._exampleContentCreator != null) {

      //
      IFolder srcFolder = this._eclipseProject.getFolder("src");
      IJavaProject javaProject = JavaCore.create(this._eclipseProject);
      IPackageFragmentRoot packageFragmentRoot = javaProject.getPackageFragmentRoot(srcFolder);

      //
      this._exampleContentCreator.createExampleContent(this._slizaaProject, packageFragmentRoot);

      //
      // refresh and build
      this._eclipseProject.refreshLocal(IResource.DEPTH_INFINITE, null);
      try {
        this._eclipseProject.build(IncrementalProjectBuilder.CLEAN_BUILD, null);
        this._eclipseProject.build(IncrementalProjectBuilder.FULL_BUILD, null);
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      //
      if (shouldFailOnErrors()) {
        failOnErrors();
      }
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void after() {

    try {
      EclipseProjectUtils.deleteProjectIfExists(this._projectName);
    } catch (CoreException e) {
      //
      e.printStackTrace();
    }
  }

  public List<IMarker> getErrorMarkers() throws CoreException {

    List<IMarker> errors = new LinkedList<IMarker>();
    for (IMarker marker : _eclipseProject.findMarkers(null, true, IResource.DEPTH_INFINITE)) {
      if (marker.getAttribute(IMarker.SEVERITY).equals(IMarker.SEVERITY_ERROR)) {
        errors.add(marker);
      }
    }
    return errors;
  }

  /**
   * @param project
   * @throws CoreException
   */
  private void failOnErrors() throws CoreException {

    // check for errors
    List<IMarker> errors = getErrorMarkers();

    // fails if any errors
    if (!errors.isEmpty()) {

      //
      StringBuilder builder = new StringBuilder("The test project has compile errors:\n");

      //
      for (IMarker iMarker : errors) {
        builder.append(" - " + iMarker.getAttribute(IMarker.MESSAGE) + "(" + iMarker.getAttribute(IMarker.CHAR_START)
            + ", " + iMarker.getAttribute(IMarker.CHAR_START) + ")");
        builder.append("\n");
      }

      //
      Assert.fail(builder.toString());
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param targetStringLength
   * @return
   */
  private static String randomString(int targetStringLength) {

    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'
    Random random = new Random();

    StringBuilder buffer = new StringBuilder(targetStringLength);
    for (int i = 0; i < targetStringLength; i++) {
      int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
      buffer.append((char) randomLimitedInt);
    }

    //
    return buffer.toString();
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  private boolean shouldFailOnErrors() {
    return _shouldFailOnErrors;
  }

  /**
   * <p>
   * </p>
   *
   * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
   */
  @FunctionalInterface
  public interface ExampleContentCreator {

    void createExampleContent(SlizaaProject slizaaProject, IPackageFragmentRoot packageFragmentRoot) throws Exception;
  }

}
