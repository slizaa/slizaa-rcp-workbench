/*******************************************************************************
 * Copyright (c) 2011-2015 slizaa project team. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: slizaa project team - initial API and implementation
 ******************************************************************************/
package org.slizaa.rcp.workbench.ui.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.slizaa.neo4j.hierarchicalgraph.mapping.service.IMappingService;
import org.slizaa.workbench.model.SlizaaWorkbenchModel;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

  /** The plug-in ID */
  public static final String                                         PLUGIN_ID                          = "org.bundlemaker.core.eclipse.ui";                             //$NON-NLS-1$

  /** - */
  public static final String                                         PERSPECTIVE_VISUALIZE_DEPENDENCIES = "org.slizaa.rcp.workbench.ui.VisualizeDependenciesPerspective";

  /** - */
  public static final String                                         CROSS_REFERENCER_PERSPECTIVE       = "org.slizaa.rcp.workbench.ui.CrossReferencerPerspective";

  // The shared instance
  private static Activator                                           plugin;

  private ServiceTracker<SlizaaWorkbenchModel, SlizaaWorkbenchModel> _workbenchModelTracker;

  /** - */
  private ServiceTracker<IMappingService, IMappingService>           _mappingServiceTracker;

  /*
   * (non-Javadoc)
   *
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    plugin = this;

    //
    this._workbenchModelTracker = new ServiceTracker<>(context, SlizaaWorkbenchModel.class, null);
    this._mappingServiceTracker = new ServiceTracker<>(context, IMappingService.class, null);

    //
    this._workbenchModelTracker.open();
    this._mappingServiceTracker.open();
  }

  /*
   * (non-Javadoc)
   *
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(BundleContext context) throws Exception {
    plugin = null;
    super.stop(context);

    //
    this._workbenchModelTracker.close();
    this._mappingServiceTracker.close();
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public SlizaaWorkbenchModel getWorkbenchModel() {
    return this._workbenchModelTracker.getService();
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public IMappingService getMappingServiceTracker() {
    return this._mappingServiceTracker.getService();
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
