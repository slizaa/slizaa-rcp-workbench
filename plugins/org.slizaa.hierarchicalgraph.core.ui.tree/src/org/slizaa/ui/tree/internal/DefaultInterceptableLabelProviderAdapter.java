/**
 *
 */
package org.slizaa.ui.tree.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.function.Supplier;

import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.slizaa.hierarchicalgraph.core.model.HGRootNode;
import org.slizaa.hierarchicalgraph.core.model.spi.INodeLabelProvider;
import org.slizaa.ui.tree.interceptors.ISlizaaLabelProviderInterceptor;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class DefaultInterceptableLabelProviderAdapter extends BaseLabelProvider
    implements ILabelProvider, IStyledLabelProvider, IColorProvider, IFontProvider, IInterceptableLabelProvider {

  /** - */
  private Supplier<INodeLabelProvider>    _nodeLabelProviderSupplier;

  /** - */
  private ISlizaaLabelProviderInterceptor _labelProviderInterceptor;

  /**
   * <p>
   * Creates a new instance of type {@link DefaultInterceptableLabelProviderAdapter}.
   * </p>
   *
   * @param nodeLabelProviderSupplier
   */
  public DefaultInterceptableLabelProviderAdapter(Supplier<INodeLabelProvider> _nodeLabelProviderSupplier) {
    this._nodeLabelProviderSupplier = checkNotNull(_nodeLabelProviderSupplier);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ISlizaaLabelProviderInterceptor getLabelProviderInterceptor() {
    return this._labelProviderInterceptor;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setLabelProviderInterceptor(ISlizaaLabelProviderInterceptor labelProviderInterceptor) {
    this._labelProviderInterceptor = labelProviderInterceptor;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean hasLabelProviderInterceptor() {
    return this._labelProviderInterceptor != null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Font getFont(Object element) {

    //
    if (hasLabelProviderInterceptor()) {
      return this._labelProviderInterceptor.alterFont(element);
    }

    //
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Color getForeground(Object element) {

    //
    if (hasLabelProviderInterceptor()) {
      return this._labelProviderInterceptor.alterForeground(element);
    }

    //
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Color getBackground(Object element) {

    //
    if (hasLabelProviderInterceptor()) {
      return this._labelProviderInterceptor.alterBackground(element);
    }

    //
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public StyledString getStyledText(Object element) {

    //
    if (element instanceof HGRootNode) {
      return new StyledString(((HGRootNode) element).getName());
    }

    //
    StyledString styledString = new StyledString(
        this._nodeLabelProviderSupplier.get().getStyledText(element).toString());

    //
    if (this._labelProviderInterceptor != null) {
      StyledString alteredStyledString = this._labelProviderInterceptor.alterStyledText(element, styledString);
      return alteredStyledString != null ? alteredStyledString : styledString;
    }

    //
    return styledString;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Image getImage(Object element) {

    //
    if (element instanceof HGRootNode) {
      return UiTreeImages.HG_ROOT_NODE.getImage();
    }

    //
    return (Image) this._nodeLabelProviderSupplier.get().getImage(element);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getText(Object element) {

    //
    if (element instanceof HGRootNode) {
      return ((HGRootNode) element).getName();
    }

    //
    String text = this._nodeLabelProviderSupplier.get().getText(element);

    //
    if (this._labelProviderInterceptor != null) {
      String alteredText = this._labelProviderInterceptor.alterText(text, text);
      return alteredText != null ? alteredText : text;
    }

    //
    return text;
  }
}
