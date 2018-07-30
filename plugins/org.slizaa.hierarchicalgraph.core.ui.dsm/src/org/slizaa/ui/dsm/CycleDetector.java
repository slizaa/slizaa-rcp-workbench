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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.slizaa.hierarchicalgraph.core.algorithms.FastFasSorter;
import org.slizaa.hierarchicalgraph.core.algorithms.INodeSorter;
import org.slizaa.hierarchicalgraph.core.algorithms.Tarjan;
import org.slizaa.hierarchicalgraph.core.model.HGNode;

/**
 * <p>
 * </p>
 * 
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class CycleDetector {

  /** - */
  private List<List<HGNode>> _cycles;

  /** - */
  private int[][]            _cycleArray;

  /** - */
  private HGNode[]           _artifacts;

  /**
   * <p>
   * Creates a new instance of type {@link CycleDetector}.
   * </p>
   * 
   * @param unorderedArtifacts
   */
  public CycleDetector(Collection<HGNode> unorderedArtifacts) {
    this();
    initialize(unorderedArtifacts);
  }

  /**
   * <p>
   * Creates a new instance of type {@link CycleDetector}.
   * </p>
   */
  public CycleDetector() {
    _cycleArray = new int[0][0];
    _artifacts = new HGNode[0];
  }

  public HGNode[] getOrderedArtifacts() {
    return _artifacts;
  }

  /**
   * {@inheritDoc}
   */
  public boolean isInCycle(int i) {
    return isInCycle(i, i);
  }

  public boolean isInCycle(int i, int j) {

    //
    if (i < 0 || i >= _artifacts.length || j < 0 || j >= _artifacts.length) {
      return false;
    }

    //
    for (List<HGNode> artifacts : _cycles) {
      if (artifacts.size() > 1 && artifacts.contains(_artifacts[i]) && artifacts.contains(_artifacts[j])) {
        return true;
      }
    }

    //
    return false;
  }

  /**
   * {@inheritDoc}
   */
  public int[][] getCycles() {
    return _cycleArray;
  }

  private void initialize(Collection<? extends HGNode> unorderedArtifacts) {

    // IArtifact[] headers, IDependency[][] dependencies
    Assert.isNotNull(unorderedArtifacts);

    _cycles = new Tarjan<HGNode>().executeTarjan(unorderedArtifacts);
    INodeSorter artifactSorter = new FastFasSorter();
    for (List<HGNode> cycle : _cycles) {
      if (cycle.size() > 1) {
        artifactSorter.sort(cycle);
      }
    }

    // Map<IArtifact, Integer> artifactColumnMap = new HashMap<IArtifact,
    // Integer>();
    List<HGNode> orderedArtifacts = new ArrayList<HGNode>();

    // hack: un-cycled artifacts without dependencies first
    for (List<HGNode> artifactList : _cycles) {
      if (artifactList.size() == 1 && artifactList.get(0).getAccumulatedOutgoingCoreDependencies().size() == 0) {
        orderedArtifacts.add(artifactList.get(0));
      }
    }

    //
    for (List<HGNode> cycle : _cycles) {
      for (HGNode iArtifact : cycle) {
        if (!orderedArtifacts.contains(iArtifact)) {
          orderedArtifacts.add(iArtifact);
        }
      }
    }
    Collections.reverse(orderedArtifacts);
    _artifacts = orderedArtifacts.toArray(new HGNode[0]);

    //
    List<int[]> cycles = new LinkedList<int[]>();
    for (List<HGNode> artifactList : _cycles) {
      if (artifactList.size() > 1) {
        int[] cycle = new int[artifactList.size()];
        for (int i = 0; i < cycle.length; i++) {
          cycle[cycle.length - (i + 1)] = orderedArtifacts.indexOf(artifactList.get(i));
        }
        cycles.add(cycle);
      }
    }

    _cycleArray = cycles.toArray(new int[0][0]);
  }
}
