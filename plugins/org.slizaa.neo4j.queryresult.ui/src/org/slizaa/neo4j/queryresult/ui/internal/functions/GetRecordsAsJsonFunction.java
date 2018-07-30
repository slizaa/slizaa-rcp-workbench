package org.slizaa.neo4j.queryresult.ui.internal.functions;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.function.Supplier;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

public class GetRecordsAsJsonFunction extends BrowserFunction {

  /** - */
  private Supplier<JsonArray> _recordSupplier;

  /**
   * <p>
   * Creates a new instance of type {@link GetRecordsAsJsonFunction}.
   * </p>
   *
   * @param browser
   * @param name
   */
  public GetRecordsAsJsonFunction(Browser browser, Supplier<JsonArray> recordSupplier) {
    super(browser, "getRecordsAsJson");

    this._recordSupplier = checkNotNull(recordSupplier);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object function(Object[] arguments) {
    return new GsonBuilder().disableHtmlEscaping().create().toJson(this._recordSupplier.get());
  }
}