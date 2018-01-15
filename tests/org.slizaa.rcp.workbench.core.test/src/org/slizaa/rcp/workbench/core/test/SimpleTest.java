/**
 *
 */
package org.slizaa.rcp.workbench.core.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.junit.Rule;
import org.junit.Test;
import org.slizaa.rcp.workbench.core.test.SlizaaProjectRule.ExampleContentCreator;
import org.slizaa.scanner.core.contentdefinition.DirectoryBasedContentDefinitionProvider;
import org.slizaa.scanner.core.spi.contentdefinition.IContentDefinitionProvider;

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
    IContentDefinitionProvider contentDefinitionProvider = this._slizaaProjectRule.getSlizaaProject()
        .getContentDefinitionProvider();

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

      // init code string and create compilation unit
      // @formatter:off
      String str = "package org.example;\n"
          + "import org.slizaa.scanner.core.contentdefinition.DirectoryBasedContentDefinitionProvider;\n"
          + "@org.slizaa.rcp.workbench.core.api.annotations.SlizaaProjectConfiguration\n" 
          + "public class Test {\n"
          + "  @org.slizaa.rcp.workbench.core.api.annotations.SlizaaConfigurationItem\n"
          + "  public org.slizaa.scanner.core.spi.contentdefinition.IContentDefinitionProvider getValue() {\n"
          + "    DirectoryBasedContentDefinitionProvider result = new DirectoryBasedContentDefinitionProvider();\n"
          + "    return result;\n" + "  }\n" + "}";
      // @formatter:on

      //
      ICompilationUnit cu = fragment.createCompilationUnit("Test.java", str, false, null);
    };
  }
}
