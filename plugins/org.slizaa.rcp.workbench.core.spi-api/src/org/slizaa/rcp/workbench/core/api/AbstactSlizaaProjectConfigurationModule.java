package org.slizaa.rcp.workbench.core.api;

import com.google.inject.AbstractModule;

/**
 */
public abstract class AbstactSlizaaProjectConfigurationModule extends AbstractModule {

  /** - */
  public static final String LOCAL_DATABASE_DIRECTORY = "local-database-directory";

  /**
   * {@inheritDoc}
   */
  @Override
  protected void configure() {
    // empty default implementation
  }
}
