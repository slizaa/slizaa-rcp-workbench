package org.slizaa.rcp.workbench.core.test.config;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.junit.Assert;
import org.slizaa.rcp.workbench.core.test.SlizaaProjectRule.ExampleContentCreator;

import com.google.common.io.CharStreams;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class FileUtils {

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public static ExampleContentCreator createExampleContent(Class<?> testClass) {

    //
    checkNotNull(testClass);

    //
    return (slizaaProject, packageFragmentRoot) -> {

      // create package fragment
      IPackageFragment fragment = packageFragmentRoot.createPackageFragment("org.example", true, null);

      //
      ICompilationUnit cu = fragment.createCompilationUnit("Test.java",
          FileUtils.loadContentToString("/" + testClass.getName().replace('.', '/') + "_TestSource.txt"),
          false, null);

      assertThat(cu).isNotNull();
    };
  }

  /**
   * <p>
   * </p>
   *
   * @param fileName
   * @return
   * @throws IOException
   */
  public static String loadContentToString(String fileName) {

    // get the resource input stream
    InputStream inputStream = SimpleTest.class.getClassLoader().getResourceAsStream(checkNotNull(fileName));

    if (inputStream == null) {
      Assert.fail(String.format("Resource '%s' not found.", fileName));
    }

    String text = null;
    try {
      try (final Reader reader = new InputStreamReader(inputStream)) {
        text = CharStreams.toString(reader);
      }
    } catch (Exception e) {
      Assert.fail(e.getMessage());
    }

    return text;
  }
}
