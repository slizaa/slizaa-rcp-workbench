package org.slizaa.hierarchicalgraph.core.ui.dependencytree.internal;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.slizaa.hierarchicalgraph.core.model.HGNode;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class SelectionUtil {

  /**
   * <p>
   * </p>
   *
   * @param selection
   * @return
   */
  public static List<HGNode> toArtifactList(ISelection selection) {

    if (!(selection instanceof IStructuredSelection)) {
      return Collections.emptyList();
    }

    //
    else {

      List<?> objects = ((IStructuredSelection) selection).toList();

      //
      Assert.isNotNull(objects);

      //
      List<HGNode> result = new LinkedList<HGNode>();

      //
      for (Object object : objects) {
        if (object instanceof HGNode) {
          result.add((HGNode) object);
        }
      }

      //
      return result;
    }
  }
}
