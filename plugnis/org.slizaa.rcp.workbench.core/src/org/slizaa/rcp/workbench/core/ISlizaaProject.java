/*******************************************************************************
 * Copyright (c) 2011-2015 slizaa project team. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: slizaa project team - initial API and implementation
 ******************************************************************************/
package org.slizaa.rcp.workbench.core;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.slizaa.hierarchicalgraph.HGRootNode;
import org.slizaa.neo4j.dbadapter.Neo4jClient;
import org.slizaa.scanner.core.spi.contentdefinition.IContentDefinitionProvider;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public interface ISlizaaProject {

  /**
   * <p>
   * Returns the associated {@link IProject}.
   * </p>
   *
   * @return the associated {@link IProject}.
   */
  IProject getProject();

  /**
   * <p>
   * </p>
   *
   * @return
   */
  IContentDefinitionProvider getContentDefinitionProvider();

  /**
   * <p>
   * </p>
   *
   * @return
   */
  Neo4jClient getBoltClient();

  /**
   * <p>
   * Returns the default analysis model.
   * </p>
   *
   * @return the default analysis model.
   */
  HGRootNode getHierachicalGraph();

  /**
   * <p>
   * </p>
   *
   * @return
   */
  boolean isConnected();

  /**
   * <p>
   * </p>
   *
   * @return
   */
  boolean hasDatabase();

  /**
   * <p>
   * </p>
   *
   * @param progressMonitor
   * @throws CoreException
   */
  void initialize(IProgressMonitor progressMonitor) throws CoreException;

  /**
   * <p>
   * </p>
   *
   * @param progressMonitor
   * @throws CoreException
   */
  void parse(IProgressMonitor progressMonitor) throws CoreException;

  /**
   * <p>
   * </p>
   *
   * @param progressMonitor
   * @throws CoreException
   */
  void startAndConnectGraphDatabase(IProgressMonitor progressMonitor) throws CoreException;

  /**
   * <p>
   * </p>
   *
   * @throws CoreException
   */
  void createHierarchicalGraph() throws CoreException;

  /**
   * <p>
   * </p>
   *
   */
  void dispose();
}
