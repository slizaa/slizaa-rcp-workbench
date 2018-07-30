package org.slizaa.ui.shared.context;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Set;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.swt.widgets.Display;
import org.slizaa.hierarchicalgraph.core.model.AbstractHGDependency;
import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.hierarchicalgraph.core.model.HGRootNode;

public class ContextHelper {

  public static void setDependenciesInContext(IEclipseContext eclipseContext, String name,
      Set<? extends AbstractHGDependency> value) {
    checkNotNull(eclipseContext).declareModifiable(checkNotNull(name));
    Display.getDefault().syncExec(() -> eclipseContext.modify(name, value));
  }

  public static void setNodesInContext(IEclipseContext eclipseContext, String name, Set<? extends HGNode> value) {
    checkNotNull(eclipseContext).declareModifiable(checkNotNull(name));
    Display.getDefault().syncExec(() -> eclipseContext.modify(name, value));
  }

  public static void setRootNodeInContext(IEclipseContext eclipseContext, String name, HGRootNode rootNode) {
    checkNotNull(eclipseContext).declareModifiable(checkNotNull(name));
    Display.getDefault().syncExec(() -> eclipseContext.modify(name, rootNode));
  }
}
