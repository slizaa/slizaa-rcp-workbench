package org.slizaa.hierarchicalgraph.core.testfwk.ui.rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.slizaa.hierarchicalgraph.core.workbench.model.ModelFactory;
import org.slizaa.hierarchicalgraph.core.workbench.model.SlizaaWorkbenchModel;

public class SlizaaWorkbenchModelRule implements TestRule {

  /** - */
  private SlizaaWorkbenchModel _workbenchModel;

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public SlizaaWorkbenchModel getWorkbenchModel() {
    return _workbenchModel;
  }

  @Override
  public Statement apply(Statement base, Description description) {

    //
    return new Statement() {

      @Override
      public void evaluate() throws Throwable {
        try {

          //
          _workbenchModel = ModelFactory.eINSTANCE.createSlizaaWorkbenchModel();

          //
          base.evaluate();

        } finally {

          //
        }
      }
    };
  }
}
