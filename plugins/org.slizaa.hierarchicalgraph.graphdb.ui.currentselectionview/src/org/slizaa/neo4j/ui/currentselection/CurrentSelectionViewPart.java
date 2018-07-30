/*******************************************************************************
 * Copyright (c) Gerd W�therich 2012-2016. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors: Gerd W�therich (gerd@gerd-wuetherich.de) - initial API and implementation
 ******************************************************************************/
package org.slizaa.neo4j.ui.currentselection;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.slizaa.hierarchicalgraph.core.selections.NodeSelection;
import org.slizaa.hierarchicalgraph.graphdb.model.GraphDbNodeSource;
import org.slizaa.ui.shared.AbstractSlizaaWorkbenchModelComponent;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class CurrentSelectionViewPart extends AbstractSlizaaWorkbenchModelComponent {

  /** - */
  public static final String PART_ID = CurrentSelectionViewPart.class.getName();

  /** - */
  private Browser            _browser;

  /** - */
  private NodeSelection      _currenNodeSelection;

  /**
   * <p>
   * </p>
   *
   * @param parent
   */
  @Override
  @PostConstruct
  public void createComposite(Composite parent) {

    //
    GridLayout layout = new GridLayout(1, false);
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    parent.setLayout(layout);

    this._browser = new Browser(parent, SWT.NONE);
    this._browser.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_CYAN));
    GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
    this._browser.setLayoutData(gridData);
    this._browser.setUrl(Activator.getDefault().getMainUrl());

    //
    new CustomFunction(this._browser, "currentNodeSelection");
  }

  @Override
  protected void handleNodeSelectionChanged(NodeSelection oldValue, NodeSelection newValue) {
    this._currenNodeSelection = newValue;
    this._browser.setUrl(Activator.getDefault().getMainUrl());
    this._browser.refresh();
  }

  /**
   * <p>
   * </p>
   *
   * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
   */
  class CustomFunction extends BrowserFunction {
    CustomFunction(Browser browser, String name) {
      super(browser, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object function(Object[] arguments) {

      //
      JsonArray jsonArray = new JsonArray();

      //
      if (CurrentSelectionViewPart.this._currenNodeSelection != null) {

        //
        CurrentSelectionViewPart.this._currenNodeSelection.getNodes().forEach(node -> {

          // get the node source
          GraphDbNodeSource nodeSource = node.getNodeSource(GraphDbNodeSource.class).get();

          // create the result
          JsonObject nodeAsJsonObject = new JsonObject();

          // add id
          nodeAsJsonObject.addProperty("id", node.getIdentifier().toString());

          // add labels
          JsonArray labelsAsJsonArray = new JsonArray();
          nodeSource.getLabels().forEach(l -> labelsAsJsonArray.add(l));
          nodeAsJsonObject.add("labels", labelsAsJsonArray);

          // add properties
          JsonObject propertiesAsJsonObject = new JsonObject();
          nodeSource.getProperties().entrySet()
              .forEach(e -> propertiesAsJsonObject.addProperty(e.getKey(), e.getValue()));
          nodeAsJsonObject.add("properties", propertiesAsJsonObject);

          // add json object
          jsonArray.add(nodeAsJsonObject);
        });
      }

      //
      String result = new GsonBuilder().disableHtmlEscaping().create().toJson(jsonArray);
      return result;
    }
  }
}
