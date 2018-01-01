/*******************************************************************************
 * Copyright (c) 2011-2015 slizaa project team.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    slizaa project team - initial API and implementation
 ******************************************************************************/
package org.slizaa.rcp.workbench.ui.internal;

import org.eclipse.jface.viewers.OwnerDrawLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.TreeItem;

/**
 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=26045
 * @see http 
 *      ://dev.eclipse.org/viewcvs/index.cgi/org.eclipse.jface.snippets/Eclipse%20JFace%20Snippets/org/eclipse/jface/
 *      snippets/viewers/Snippet051TableCenteredImage.java?view=markup CenterImageLabelProvider --
 * 
 * @author Nils Hartmann (nils@nilshartmann.net)
 */
public abstract class CenterImageLabelProvider extends OwnerDrawLabelProvider {

  @Override
  protected void measure(Event event, Object element) {
  }

  @Override
  protected void paint(Event event, Object element) {

    Image img = getImage(element);

    if (img != null) {
      Rectangle bounds = ((TreeItem) event.item).getBounds(event.index);
      Rectangle imgBounds = img.getBounds();
      bounds.width /= 2;
      bounds.width -= imgBounds.width / 2;
      bounds.height /= 2;
      bounds.height -= imgBounds.height / 2;

      int x = bounds.width > 0 ? bounds.x + bounds.width : bounds.x;
      int y = bounds.height > 0 ? bounds.y + bounds.height : bounds.y;

      event.gc.drawImage(img, x, y);
    }
  }

  protected abstract Image getImage(Object element);
}
