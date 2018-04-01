/*******************************************************************************
 * Copyright (c) 2011-2015 slizaa project team. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: slizaa project team - initial API and implementation
 ******************************************************************************/
package org.slizaa.rcp.workbench.ui.internal;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.slizaa.rcp.workbench.ui.internal.decorators.SlizaaProjectListener;
import org.slizaa.workbench.model.ModelPackage;
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

  /** the shared instance */
  private static Activator                                           plugin;

  /** - */
  private ServiceTracker<SlizaaWorkbenchModel, SlizaaWorkbenchModel> _workbenchModelTracker;

  /** - */
  private SlizaaProjectListener                                      _projectListener;

  /** - */
  private Adapter                                                    _adapter;

  /**
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);

    //
    plugin = this;

    //
    this._adapter = new AdapterImpl() {

      @Override
      public void notifyChanged(Notification msg) {
        if (msg.getFeature() != null) {

          //
          Display.getDefault().syncExec(() -> {
            //
            if (msg.getFeature().equals(ModelPackage.eINSTANCE.getSlizaaWorkbenchModel_RootNode())) {

              //
            }
            //
            else if (msg.getFeature()
                .equals(ModelPackage.eINSTANCE.getSlizaaWorkbenchModel_MainDependencySelection())) {

              //
              ViewUtils.activate("org.slizaa.ui.dependencytree.DependencyTreePart", false);
            }
            //
            else if (msg.getFeature()
                .equals(ModelPackage.eINSTANCE.getSlizaaWorkbenchModel_DetailDependencySelection())) {

              //
              ViewUtils.activate("org.slizaa.ui.dependencytree.DependencyTreePart", false);
            }
            //
            else if (msg.getFeature().equals(ModelPackage.eINSTANCE.getSlizaaWorkbenchModel_NodeSelection())) {
              //
            }
          });
        }
      }
    };

    //
    this._workbenchModelTracker = new ServiceTracker<SlizaaWorkbenchModel, SlizaaWorkbenchModel>(context,
        SlizaaWorkbenchModel.class, null) {

      @Override
      public SlizaaWorkbenchModel addingService(ServiceReference<SlizaaWorkbenchModel> reference) {
        SlizaaWorkbenchModel model = super.addingService(reference);
        model.eAdapters().add(Activator.this._adapter);
        return model;
      }

      @Override
      public void removedService(ServiceReference<SlizaaWorkbenchModel> reference, SlizaaWorkbenchModel model) {
        model.eAdapters().remove(Activator.this._adapter);
        super.removedService(reference, model);
      }
    };
    this._workbenchModelTracker.open();

    //
    this._projectListener = new SlizaaProjectListener();
    this._projectListener.initialize();
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

    //
    this._projectListener.dispose();
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
   * Returns the shared instance
   *
   * @return the shared instance
   */
  public static Activator getDefault() {
    return plugin;
  }
}
