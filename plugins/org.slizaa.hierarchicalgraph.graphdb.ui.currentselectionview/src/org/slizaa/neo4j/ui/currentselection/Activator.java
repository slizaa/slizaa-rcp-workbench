package org.slizaa.neo4j.ui.currentselection;

import static com.google.common.base.Preconditions.checkState;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;

import org.eclipse.core.runtime.FileLocator;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

  // The shared instance
  private static Activator   plugin;

  /** - */
  private String             _mainUrl;

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public String getMainUrl() {
    return _mainUrl;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void start(BundleContext context) throws Exception {
    plugin = this;

    //
    Bundle bundle = context.getBundle();

    Enumeration<String> contentEnumeration = bundle.getEntryPaths("content");

    checkState(contentEnumeration != null, "No bundle entry path 'content' found!");

    // extract content
    Collections.list(contentEnumeration).forEach((entry) -> {
      try {
        URL fileUrl = FileLocator.toFileURL(bundle.getEntry(entry));
        if (entry.endsWith("index.html")) {
          _mainUrl = fileUrl.toExternalForm();
          System.out.println(_mainUrl);
        } 
      } catch (IOException e) {
        e.printStackTrace();
      }
    });

    //
    if (_mainUrl == null) {
      throw new RuntimeException("Missing resource '/content/index.html'.");
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void stop(BundleContext context) throws Exception {
    plugin = null;
  }

  /**
   * Returns the shared instance
   *
   * @return the shared instance
   */
  public static Activator getDefault() {
    return plugin;
  }
}
