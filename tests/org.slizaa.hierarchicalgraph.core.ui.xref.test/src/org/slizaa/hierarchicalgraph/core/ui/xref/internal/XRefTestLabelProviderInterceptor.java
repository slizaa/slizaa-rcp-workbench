package org.slizaa.hierarchicalgraph.core.ui.xref.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.slizaa.hierarchicalgraph.core.model.HGRootNode;
import org.slizaa.ui.tree.interceptors.ISlizaaLabelProviderInterceptor;
import org.slizaa.ui.tree.interceptors.SelectedNodesLabelProviderInterceptor;

public class XRefTestLabelProviderInterceptor implements ISlizaaLabelProviderInterceptor {

  /** - */
  private SelectedNodesLabelProviderInterceptor _delegate;

  /**
   * <p>
   * Creates a new instance of type {@link XRefTestLabelProviderInterceptor}.
   * </p>
   *
   * @param delegate
   */
  public XRefTestLabelProviderInterceptor(SelectedNodesLabelProviderInterceptor delegate) {
    _delegate = checkNotNull(delegate);
  }

  /**
   * {@inheritDoc}
   */
  public String alterText(Object object, String text) {

    //
    if (_delegate.selectedNodes() != null) {
      if (_delegate.selectedNodes().contains(object) && !(object instanceof HGRootNode)) {
        return "*" + text + "*";
      }
    }
    return _delegate.alterText(object, text);
  }

  /**
   * {@inheritDoc}
   */
  public Font alterFont(Object object) {
    return _delegate.alterFont(object);
  }

  /**
   * {@inheritDoc}
   */
  public StyledString alterStyledText(Object object, StyledString styledString) {
    return _delegate.alterStyledText(object, styledString);
  }

  /**
   * {@inheritDoc}
   */
  public Color alterForeground(Object object) {
    return _delegate.alterForeground(object);
  }

  /**
   * {@inheritDoc}
   */
  public Color alterBackground(Object object) {
    return _delegate.alterBackground(object);
  }
}
