package org.slizaa.rcp.workbench.ui.internal.actions.tools;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.slizaa.hierarchicalgraph.HGNode;
import org.slizaa.ui.tree.ISlizaaActionGroupContribution;
import org.slizaa.ui.tree.ISlizaaActionGroupContribution.DefaultActionGroupContribution;

@Component(service = ISlizaaActionGroupContribution.class)
public class SlizaaToolsActionGroup extends DefaultActionGroupContribution implements ISlizaaActionGroupContribution {

  public static final String ID = "org.slizaa.rcp.workbench.ui.actions.ToolsActionGroup";

  @Override
  public String getId() {
    return ID;
  }

  @Override
  public boolean isSubMenu() {
    return true;
  }

  @Override
  public String getLabel() {
    return "Tools";
  }

  @Override
  public boolean shouldShow(List<?> selectedObjects) {
    return checkNotNull(selectedObjects).stream().allMatch(o -> o instanceof HGNode);
  }

  @Override
  public boolean isEnabled(List<?> selectedObjects) {
    return true;
  }
}
