/**
 *
 */
package org.slizaa.rcp.workbench.core.test;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.slizaa.rcp.workbench.core.test.SlizaaProjectRule.ExampleContentCreator;
import org.slizaa.scanner.core.contentdefinition.DirectoryBasedContentDefinitionProvider;
import org.slizaa.scanner.core.spi.contentdefinition.IContentDefinitionProvider;

import com.google.common.io.CharStreams;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 */
public class SimpleTest {

  @Rule
  public SlizaaProjectRule _slizaaProjectRule = new SlizaaProjectRule(createExampleContent());

  @Test
  public void test() throws Exception {

    //
    IContentDefinitionProvider contentDefinitionProvider = this._slizaaProjectRule.getSlizaaProject().getConfiguration()
        .createNewConfigurationItemInstance(IContentDefinitionProvider.class);

    assertThat(contentDefinitionProvider).isNotNull();
    assertThat(contentDefinitionProvider).isInstanceOf(DirectoryBasedContentDefinitionProvider.class);
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  protected static ExampleContentCreator createExampleContent() {

    //
    return (slizaaProject, packageFragmentRoot) -> {

      // create package fragment
      IPackageFragment fragment = packageFragmentRoot.createPackageFragment("org.example", true, null);

      //
      ICompilationUnit cu = fragment.createCompilationUnit("Test.java",
          loadExampleSource("/org/slizaa/rcp/workbench/core/test/SimpleTest_TestSource.txt"), false, null);

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
  private static String loadExampleSource(String fileName) {

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
