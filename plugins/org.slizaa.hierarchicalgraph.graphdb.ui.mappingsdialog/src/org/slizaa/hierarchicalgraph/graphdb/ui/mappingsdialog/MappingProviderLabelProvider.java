package org.slizaa.hierarchicalgraph.graphdb.ui.mappingsdialog;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.slizaa.hierarchicalgraph.graphdb.mapping.spi.IMappingProvider;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 *
 */
class MappingProviderLabelProvider implements ILabelProvider {

  @Override
  public void addListener(ILabelProviderListener listener) {

  }

  @Override
  public void dispose() {

  }

  @Override
  public boolean isLabelProperty(Object element, String property) {
    return false;
  }

  @Override
  public void removeListener(ILabelProviderListener listener) {

  }

  @Override
  public Image getImage(Object element) {
    return null;
  }

  @Override
  public String getText(Object element) {

    if (element instanceof IMappingProvider) {
      IMappingProvider mappingProvider = (IMappingProvider) element;
      return mappingProvider.getMappingProviderMetadata().getName();
    }

    return element.toString();
  }
}