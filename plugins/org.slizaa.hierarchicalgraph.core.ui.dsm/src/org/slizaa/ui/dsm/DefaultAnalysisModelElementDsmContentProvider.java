/*******************************************************************************
 * Copyright (c) Gerd W�therich 2012-2016.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *    Gerd W�therich (gerd@gerd-wuetherich.de) - initial API and implementation
 ******************************************************************************/
package org.slizaa.ui.dsm;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

import org.eclipse.core.runtime.Assert;
import org.slizaa.hierarchicalgraph.core.model.HGAggregatedDependency;
import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.ui.widget.dsm.IDsmContentProvider;

public class DefaultAnalysisModelElementDsmContentProvider extends Observable implements IDsmContentProvider {

  /** - */
  private static final List<HGNode>  EMPTY_MODEL_ELEMENTS = Collections.emptyList();

  /** - */
  private CycleDetector              _cycleDetector;

  /** - */
  private HGAggregatedDependency[][] _dependencies;

  /**
   * <p>
   * Creates a new instance of type {@link DefaultAnalysisModelElementDsmContentProvider}.
   * </p>
   * 
   * @param unorderedArtifacts
   */
  public DefaultAnalysisModelElementDsmContentProvider(Collection<HGNode> unorderedArtifacts) {
    _dependencies = new HGAggregatedDependency[0][0];
    initialize(unorderedArtifacts);
  }

  /**
   * <p>
   * Creates a new instance of type {@link DefaultAnalysisModelElementDsmContentProvider}.
   * </p>
   */
  public DefaultAnalysisModelElementDsmContentProvider() {
    this(EMPTY_MODEL_ELEMENTS);
  }

  /**
   * {@inheritDoc}
   */
  public int getItemCount() {
    return _cycleDetector.getOrderedArtifacts().length;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object[][] getDependencies() {
    return _dependencies;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object[] getNodes() {
    return _cycleDetector.getOrderedArtifacts();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public HGAggregatedDependency getDependency(int x, int y) {

    //
    if (x == -1 || y == -1) {
      return null;
    }

    // return null if dependency does not exist
    if (x >= _dependencies.length || y >= _dependencies[x].length) {
      return null;
    }

    // return dependency
    return _dependencies[x][y];
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isInCycle(int i) {
    return _cycleDetector.isInCycle(i);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isInCycle(int i, int j) {
    return _cycleDetector.isInCycle(i, j);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int[][] getCycles() {
    return _cycleDetector.getCycles();
  }

  /**
   * <p>
   * </p>
   * 
   * @param unorderedNodes
   */
  private void initialize(Collection<HGNode> unorderedNodes) {

    // IArtifact[] headers, IDependency[][] dependencies
    Assert.isNotNull(unorderedNodes);

    _cycleDetector = new CycleDetector(unorderedNodes);

    _dependencies = new HGAggregatedDependency[_cycleDetector.getOrderedArtifacts().length][_cycleDetector
        .getOrderedArtifacts().length];
    for (int i = 0; i < _cycleDetector.getOrderedArtifacts().length; i++) {
      for (int j = 0; j < _cycleDetector.getOrderedArtifacts().length; j++) {
        HGAggregatedDependency dependency = _cycleDetector.getOrderedArtifacts()[i]
            .getOutgoingDependenciesTo(_cycleDetector.getOrderedArtifacts()[j]);
        _dependencies[j][i] = dependency != null && dependency.getAggregatedWeight() != 0 ? dependency : null;
      }
    }
  }
}
