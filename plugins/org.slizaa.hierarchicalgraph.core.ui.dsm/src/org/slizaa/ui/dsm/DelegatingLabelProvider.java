package org.slizaa.ui.dsm;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.slizaa.hierarchicalgraph.core.model.spi.INodeLabelProvider;

public class DelegatingLabelProvider extends LabelProvider {

  private INodeLabelProvider _itemLabelProvider;

  public void setItemLabelProvider(INodeLabelProvider itemLabelProvider) {
    _itemLabelProvider = itemLabelProvider;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Image getImage(Object element) {

    //
    if (_itemLabelProvider == null) {
      return super.getImage(element);
    }

    //
    else {
      return (Image) _itemLabelProvider.getImage(element);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getText(Object element) {

    String result = null;
    
    //
    if (_itemLabelProvider == null) {
      result = super.getText(element);
    }

    //
    else {
      result = _itemLabelProvider.getText(element);
    }
    
    //
    return result != null ? result : "";
  }
}
