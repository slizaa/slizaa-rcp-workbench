/**
 *
 */
package org.slizaa.rcp.workbench.core.test.config;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slizaa.rcp.workbench.core.test.config.FileUtils.createExampleContent;

import org.junit.Rule;
import org.junit.Test;
import org.slizaa.rcp.workbench.core.test.SlizaaProjectRule;
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
  public SlizaaProjectRule _slizaaProjectRule = new SlizaaProjectRule(createExampleContent(SimpleTest.class));

  @Test
  public void test() throws Exception {

    //
    IContentDefinitionProvider contentDefinitionProvider = this._slizaaProjectRule.getSlizaaProject().getConfiguration()
        .getInjector().getInstance(IContentDefinitionProvider.class);

    //
    assertThat(contentDefinitionProvider).isNotNull();
    assertThat(contentDefinitionProvider).isInstanceOf(DirectoryBasedContentDefinitionProvider.class);
  }

}
