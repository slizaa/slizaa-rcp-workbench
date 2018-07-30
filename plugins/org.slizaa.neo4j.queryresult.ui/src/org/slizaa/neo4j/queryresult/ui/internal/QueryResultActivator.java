package org.slizaa.neo4j.queryresult.ui.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.osgi.service.urlconversion.URLConverter;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.slizaa.core.boltclient.IQueryResultConsumer;

public class QueryResultActivator extends AbstractUIPlugin {

  /** - */
  public static final String                         PAGE_URL_ERROR_MESSAGE = "/content/errorMessage.html";

  /** - */
  public static final String                         PAGE_URL_SPINNER       = "/content/spinner.html";

  /** - */
  public static final String                         PAGE_URL_QUERY_RESULT  = "/content/queryResult.html";

  // The plug-in ID
  public static final String                         PLUGIN_ID              = "org.slizaa.neo4j.hierarchicalgraph.mapping.service"; //$NON-NLS-1$

  // The shared instance
  private static QueryResultActivator                _instance;

  /** - */
  private QueryResultViewPart                        _queryResultViewPart;

  /** - */
  private ServiceTracker<URLConverter, URLConverter> _urlConverterServiceTracker;

  /** - */
  private Map<String, String>                        _resolvedUrlCache;

  /**
   * {@inheritDoc}
   */
  @Override
  public void start(BundleContext context) throws Exception {

    //
    super.start(context);

    //
    this._urlConverterServiceTracker = new ServiceTracker<URLConverter, URLConverter>(context, URLConverter.class,
        null);
    this._urlConverterServiceTracker.open();

    //
    this._resolvedUrlCache = new HashMap<>();

    //
    _instance = this;

    //
    CustomQueryResultConsumer queryResultConsumer = new CustomQueryResultConsumer();
    context.registerService(IQueryResultConsumer.class, queryResultConsumer, null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void stop(BundleContext context) throws Exception {

    //
    _instance = null;

    //
    this._urlConverterServiceTracker.close();
    this._resolvedUrlCache.clear();

    //
    super.stop(context);
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public String getCachedUrl(String path) {

    //
    if (!this._resolvedUrlCache.containsKey(checkNotNull(path))) {

      //
      URL url = getBundle().getEntry(path);

      if (url != null) {

        try {
          return this._urlConverterServiceTracker.getService().toFileURL(url).toExternalForm();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
          return null;
        }
      } else {
        throw new RuntimeException("No entry for path '" + path + "'.");
      }
    }

    //
    return this._resolvedUrlCache.get(checkNotNull(path));
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public boolean hasQueryResultViewPart() {
    return this._queryResultViewPart != null;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public QueryResultViewPart getQueryResultViewPart() {
    return this._queryResultViewPart;
  }

  /**
   * <p>
   * </p>
   *
   * @param queryResultViewPart
   */
  public void setQueryResultViewPart(QueryResultViewPart queryResultViewPart) {
    this._queryResultViewPart = queryResultViewPart;
  }

  /**
   * Returns the shared instance
   *
   * @return the shared instance
   */
  public static QueryResultActivator getDefault() {
    return _instance;
  }
}
