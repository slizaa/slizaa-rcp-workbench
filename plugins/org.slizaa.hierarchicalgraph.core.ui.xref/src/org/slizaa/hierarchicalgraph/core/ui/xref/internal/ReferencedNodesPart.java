package org.slizaa.hierarchicalgraph.core.ui.xref.internal;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.hierarchicalgraph.core.model.ProxyDependencyFunctions;
import org.slizaa.hierarchicalgraph.core.selections.NodeSelections;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class ReferencedNodesPart extends AbstractRefNodesPart {

  /**
   * {@inheritDoc}
   */
  @Override
  protected Set<HGNode> getNodesToShow(Collection<HGNode> selectedNodes) {

    //
    ProxyDependencyFunctions.resolveProxyDependencies(selectedNodes, false, true, null);

    //
    return NodeSelections.getAccumulatedOutgoingCoreDependencies(selectedNodes).stream().map(dep -> dep.getTo())
        .collect(Collectors.toSet());
  }
}
