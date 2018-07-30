/*******************************************************************************
 * Copyright (c) Gerd W�therich 2012-2016. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors: Gerd W�therich (gerd@gerd-wuetherich.de) - initial API and implementation
 ******************************************************************************/
package org.slizaa.hierarchicalgraph.graphdb.ui.hierarchicalgraphview;

import static com.google.common.base.Preconditions.checkNotNull;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.jface.resource.ImageRegistry;
import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.hierarchicalgraph.core.model.spi.INodeLabelProvider;
import org.slizaa.hierarchicalgraph.graphdb.mapping.spi.ILabelDefinitionProvider;
import org.slizaa.hierarchicalgraph.graphdb.mapping.spi.ILabelDefinitionProvider.ILabelDefinition;
import org.slizaa.hierarchicalgraph.graphdb.mapping.spi.ILabelDefinitionProvider.OverlayPosition;
import org.slizaa.hierarchicalgraph.graphdb.mapping.spi.labelprovider.DefaultLabelDefinition;

public class LabelDefinitionProvider2NoteLabelProviderAdapter implements INodeLabelProvider {

  /** - */
  private OverlayImageRegistry     _imageRegistry;

  /** - */
  private ILabelDefinitionProvider _labelDefinitionProvider;

  /**
   * <p>
   * Creates a new instance of type {@link LabelDefinitionProvider2NoteLabelProviderAdapter}.
   * </p>
   *
   * @param labelDefinitionProvider
   * @param imageRegistry
   */
  public LabelDefinitionProvider2NoteLabelProviderAdapter(ILabelDefinitionProvider labelDefinitionProvider,
      ImageRegistry imageRegistry) {
    this._labelDefinitionProvider = checkNotNull(labelDefinitionProvider);
    this._imageRegistry = new OverlayImageRegistry(checkNotNull(imageRegistry));
  }

  /**
   * <p>
   * Creates a new instance of type {@link LabelDefinitionProvider2NoteLabelProviderAdapter}.
   * </p>
   *
   * @param labelDefinitionProvider
   */
  public LabelDefinitionProvider2NoteLabelProviderAdapter(ILabelDefinitionProvider labelDefinitionProvider) {
    this._labelDefinitionProvider = checkNotNull(labelDefinitionProvider);
    this._imageRegistry = new OverlayImageRegistry();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object getStyledText(Object object) {
    return new StyledString(getText(object));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getText(Object object) {
    return getLabelDefinition(object).getText();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object getImage(Object object) {

    ILabelDefinition labelDefinition = getLabelDefinition(object);

    //
    if (labelDefinition.hasBaseImage()) {
      return this._imageRegistry.getOverlayImage(labelDefinition.getBaseImage(),
          new URL[] { labelDefinition.getOverlayImage(OverlayPosition.TOP_LEFT),
              labelDefinition.getOverlayImage(OverlayPosition.TOP_RIGHT),
              labelDefinition.getOverlayImage(OverlayPosition.BOTTOM_LEFT),
              labelDefinition.getOverlayImage(OverlayPosition.BOTTOM_RIGHT) });
    }

    //
    try {
      // TODO
      return this._imageRegistry.getImage(
          new URL("platform:/plugin/org.slizaa.hierarchicalgraph.graphdb.ui.hierarchicalgraphview/icons/HGNode.png"));
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param object
   * @return
   */
  private ILabelDefinition getLabelDefinition(Object object) {

    //
    if (object instanceof HGNode) {
      return this._labelDefinitionProvider.getLabelDefinition((HGNode) object);
    }

    //
    return new DefaultLabelDefinition();
  }

}
