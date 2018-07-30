package org.slizaa.hierarchicalgraph.core.ui.xref.internal;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.hierarchicalgraph.core.model.ProxyDependencyFunctions;
import org.slizaa.hierarchicalgraph.core.selections.NodeSelections;

public class ReferencingNodesPart extends AbstractRefNodesPart {

  protected Set<HGNode> getNodesToShow(Collection<HGNode> selectedNodes) {

    //
    ProxyDependencyFunctions.resolveProxyDependencies(selectedNodes, true, false, null);

    //
    return NodeSelections.getAccumulatedIncomingCoreDependencies(selectedNodes).stream().map(dep -> dep.getFrom())
        .collect(Collectors.toSet());
  }
}
