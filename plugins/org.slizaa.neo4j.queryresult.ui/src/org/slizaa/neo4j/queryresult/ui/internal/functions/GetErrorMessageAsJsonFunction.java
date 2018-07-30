package org.slizaa.neo4j.queryresult.ui.internal.functions;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;
import java.util.function.Supplier;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import com.google.gson.GsonBuilder;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class GetErrorMessageAsJsonFunction extends BrowserFunction {

  /** - */
  private Supplier<List<String>> _columnNameSupplier;

  /**
   * <p>
   * Creates a new instance of type {@link GetErrorMessageAsJsonFunction}.
   * </p>
   *
   * @param browser
   * @param name
   */
  public GetErrorMessageAsJsonFunction(Browser browser, Supplier<List<String>> errorMessageSupplier) {
    super(browser, "getErrorMessageAsJson");

    this._columnNameSupplier = checkNotNull(errorMessageSupplier);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object function(Object[] arguments) {
    return new GsonBuilder().disableHtmlEscaping().create().toJson(this._columnNameSupplier.get());
  }
}