package org.slizaa.rcp.workbench.ui.internal.actions;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;
import org.osgi.service.component.annotations.Component;
import org.slizaa.hierarchicalgraph.HGRootNode;
import org.slizaa.hierarchicalgraph.graphdb.mapping.spi.IMappingProvider;
import org.slizaa.rcp.workbench.core.model.SlizaaProject;
import org.slizaa.rcp.workbench.ui.internal.Activator;
import org.slizaa.ui.tree.ISlizaaActionContribution;

@Component(service = ISlizaaActionContribution.class)
public class ReloadHierarchicalGraphAction implements ISlizaaActionContribution {

  @Override
  public String getParentGroupId() {
    return null;
  }

  @Override
  public int getRanking() {
    return 0;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean shouldShow(List<?> selection, Viewer viewer) {
    return selection.size() > 0 && selection.stream().allMatch(n -> n instanceof HGRootNode);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isEnabled(List<?> selection, Viewer viewer) {
    return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(List<?> selection, Viewer viewer) {

    Display.getDefault().syncExec(() -> {
      try {

        //
        IRunnableWithProgress runnable = new IRunnableWithProgress() {
          public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

            //
            HGRootNode rootNode = (HGRootNode) selection.get(0);

            //
            IMappingProvider mappingProvider = rootNode.getExtension(IMappingProvider.class);
            SlizaaProject slizaaProject = rootNode.getExtension(SlizaaProject.class);

            // set hgRootNode
            HGRootNode hgRootNode = slizaaProject.mapToHierachicalGraph(mappingProvider, null);
            hgRootNode.registerExtension(SlizaaProject.class, slizaaProject);

            // set global
            Activator.getDefault().getWorkbenchModel().setRootNode(hgRootNode);
          }
        };

        try {
          new ProgressMonitorDialog(null).run(true, true, runnable);
        } catch (InvocationTargetException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          //
        }

      } catch (Exception e) {
        // do nothing
      }
    });
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getLabel(List<?> selection) {
    return "Reload Hierarchical Graph";
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getImagePath(List<?> selection) {
    return "icons/actions/DSM.png";
  }
}
