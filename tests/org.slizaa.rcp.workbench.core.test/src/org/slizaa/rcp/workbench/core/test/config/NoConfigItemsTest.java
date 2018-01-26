/**
 *
 */
package org.slizaa.rcp.workbench.core.test.config;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slizaa.rcp.workbench.core.test.config.FileUtils.createExampleContent;

import org.junit.Rule;
import org.junit.Test;
import org.slizaa.rcp.workbench.core.test.SlizaaProjectRule;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 */
public class NoConfigItemsTest {

  @Rule
  public SlizaaProjectRule _slizaaProjectRule = new SlizaaProjectRule(createExampleContent(NoConfigItemsTest.class),
      false);

  /**
   * <p>
   * </p>
   *
   * @throws Exception
   */
  @Test
  public void test() throws Exception {

    //
    assertThat(this._slizaaProjectRule.getSlizaaProject().getConfiguration()).isNull();

    //
    assertThat(_slizaaProjectRule.getErrorMarkers()).hasSize(1);
    // TODO:
  }
}
