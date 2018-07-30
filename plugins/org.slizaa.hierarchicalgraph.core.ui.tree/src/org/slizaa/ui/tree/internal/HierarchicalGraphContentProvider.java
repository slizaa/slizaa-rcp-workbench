/**
 *
 */
package org.slizaa.ui.tree.internal;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.ui.shared.context.RootObject;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 */
public class HierarchicalGraphContentProvider implements ITreeContentProvider {

  @Override
  public void dispose() {
    ITreeContentProvider.super.dispose();
  }

  @Override
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    ITreeContentProvider.super.inputChanged(viewer, oldInput, newInput);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object[] getElements(Object inputElement) {

    //
    if (RootObject.class.isInstance(inputElement)) {
      return new Object[] { RootObject.class.cast(inputElement).getRoot() };
    }

    //
    else if (inputElement instanceof HGNode) {
      return ((HGNode) inputElement).getChildren().toArray();
    }

    //
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object[] getChildren(Object parentElement) {

    //
    if (parentElement instanceof HGNode) {
      return ((HGNode) parentElement).getChildren().toArray();
    }

    //
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object getParent(Object element) {

    //
    if (element instanceof HGNode) {
      return ((HGNode) element).getParent();
    }

    //
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean hasChildren(Object element) {
    return ((HGNode) element).getChildren().size() > 0;
  }
}
