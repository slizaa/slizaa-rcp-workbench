/**
 *
 */
package org.slizaa.rcp.workbench.core.test;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.junit.Rule;
import org.junit.Test;
import org.slizaa.rcp.workbench.core.test.SlizaaProjectRule.ExampleContentCreator;

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
    System.out.println(this._slizaaProjectRule.getSlizaaProject().getContentDefinitionProvider());
  }

  private static ExampleContentCreator createExampleContent() {

    return (slizaaProject, packageFragmentRoot) -> {

      // create package fragment
      IPackageFragment fragment = packageFragmentRoot.createPackageFragment("org.example", true, null);

      // init code string and create compilation unit
      //@formatter:off
      String str =
          "package org.example;\n" +
          "@org.slizaa.rcp.workbench.core.api.projectconfig.SlizaaProjectConfiguration\n" +
          "public class Test {\n" +
          "  @org.slizaa.rcp.workbench.core.api.projectconfig.SlizaaConfigurationItem\n" +
          "  public org.slizaa.scanner.core.spi.contentdefinition.IContentDefinitionProvider getValue() { return null; }" +
          "}";
      //@formatter:on

      ICompilationUnit cu = fragment.createCompilationUnit("Test.java", str, false, null);
    };
  }
}
