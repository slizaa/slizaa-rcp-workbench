/*******************************************************************************
 * Copyright (c) 2011-2015 slizaa project team. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: slizaa project team - initial API and implementation
 ******************************************************************************/
package org.slizaa.rcp.workbench.core.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.ResourcesPlugin;
import org.slizaa.rcp.workbench.core.model.SlizaaProject;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class SlizaaProjectCache {

  private static SlizaaProjectCache _instance;

  /**
   * <p>
   * </p>
   *
   * @returns
   */
  public static SlizaaProjectCache instance() {

    //
    if (_instance == null) {
      _instance = new SlizaaProjectCache();
    }

    //
    return _instance;
  }

  /** the project cache */
  private Map<IProject, SlizaaProject> _projectCache;

  /**
   * <p>
   * </p>
   *
   * @param project
   * @return
   */
  public SlizaaProject getSlizaaProject(IProject project) {
    return this._projectCache.get(project);
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public Collection<SlizaaProject> getSlizaaProjects() {

    //
    return Collections.unmodifiableCollection(this._projectCache.values());
  }

  /**
   * <p>
   * </p>
   *
   * @param project
   * @param slizaaProject
   */
  public void cacheBundleMakerProject(IProject project, SlizaaProject slizaaProject) {
    this._projectCache.put(project, slizaaProject);
  }

  /**
   * <p>
   * </p>
   *
   * @param project
   */
  public void removeCachedBundleMakerProject(IProject project) {
    this._projectCache.remove(project);
  }

  /**
   * <p>
   * Creates a new instance of type {@link SlizaaProjectCache}.
   * </p>
   *
   */
  private SlizaaProjectCache() {

    // create the maps and caches
    this._projectCache = new HashMap<IProject, SlizaaProject>();

    //
    ResourcesPlugin.getWorkspace().addResourceChangeListener(event -> {
      if (event.getType() == IResourceChangeEvent.PRE_DELETE && event.getResource() instanceof IProject
          && SlizaaProjectCache.this._projectCache.containsKey(event.getResource())) {

        SlizaaProject slizaaProject = SlizaaProjectCache.this._projectCache.get(event.getResource());

        // notifies listeners and removes itself from the cache
        slizaaProject.dispose();

      }
    }, IResourceChangeEvent.PRE_DELETE);
  }
}
