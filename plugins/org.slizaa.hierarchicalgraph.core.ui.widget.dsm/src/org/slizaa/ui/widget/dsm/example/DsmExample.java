/*******************************************************************************
 * Copyright (c) Gerd Wütherich 2012-2016.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *    Gerd Wütherich (gerd@gerd-wuetherich.de) - initial API and implementation
 ******************************************************************************/
package org.slizaa.ui.widget.dsm.example;

import java.util.Observable;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.slizaa.ui.widget.dsm.DsmViewWidget;
import org.slizaa.ui.widget.dsm.IDsmContentProvider;

public class DsmExample {

  /**
   * <p>
   * </p>
   * 
   * @param args
   */
  public static void main(String[] args) {

    Display display = new Display();

    final Shell myShell = new Shell(display);
    myShell.setText("This is a label");
    myShell.setBounds(100, 100, 400, 450);
    myShell.setLayout(new FillLayout());

    new DsmViewWidget(new ContentProvider(), new LabelProvider(), new LabelProvider(), myShell);

    myShell.open();

    while (!myShell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }

    display.dispose();
  }

  public static class ContentProvider extends Observable implements IDsmContentProvider {

    private String[]   _name = new String[] { "/guice-grapher-4.0.jar", "/commons-math-2.2.jar", "/joda-time-2.9.2.jar",
        "/httpclient-4.3.4.jar", "/httpcore-4.3.2.jar", "/asm-5.0.4.jar", "/governator-1.12.5.jar",
        "/commons-configuration-1.8.jar", "/hibernate-validator-4.1.0.Final.jar", "/aopalliance-1.0.jar",
        "/jackson-dataformat-xml-2.5.4.jar", "/guice-4.0.jar", "/netflix-infix-0.3.0.jar", "/slf4j-api-1.6.4.jar",
        "/antlr-2.7.7.jar", "/jersey-client-1.19.jar", "/stringtemplate-3.2.1.jar", "/guice-grapher-4.0.jar",
        "/eureka-client-1.4.2.jar", "/xmlpull-1.1.3.1.jar", "/aws-java-sdk-core-1.9.3.jar",
        "/governator-annotations-1.12.5.jar", "/aws-java-sdk-autoscaling-1.9.3.jar", "/jsr305-3.0.1.jar",
        "/woodstox-core-asl-4.4.1.jar", "/jackson-annotations-2.5.4.jar", "/commons-jxpath-1.3.jar",
        "/servo-core-0.12.3.jar", "/guava-16.0.jar", "/commons-codec-1.6.jar", "/jackson-databind-2.5.4.jar",
        "/guice-assistedinject-4.0.jar", "/governator-api-1.12.5.jar", "/guice-multibindings-4.0.jar",
        "/aws-java-sdk-route53-1.9.3.jar", "/gson-2.1.jar", "/jersey-core-1.19.jar", "/jackson-core-2.5.4.jar",
        "/eureka-core-1.4.2.jar", "/jersey-apache-client4-1.19.jar", "/aws-java-sdk-sts-1.9.3.jar",
        "/commons-lang-2.6.jar", "/xpp3_min-1.1.4c.jar", "/governator-core-1.12.5.jar", "/jsr311-api-1.1.1.jar",
        "/jettison-1.3.7.jar", "/javax.inject-1.jar", "/validation-api-1.0.0.GA.jar", "/stax2-api-3.1.4.jar",
        "/stax-api-1.0-2.jar", "/xstream-1.4.2.jar", "/netflix-eventbus-0.3.0.jar", "/commons-logging-1.1.3.jar",
        "/servlet-api-2.5.jar", "/archaius-core-0.7.3.jar", "/aws-java-sdk-ec2-1.9.3.jar", "/stax-api-1.0.1.jar",
        "/antlr-runtime-3.4.jar" };

    /** - */
    private String[][] _items;

    public ContentProvider() {
      _items = new String[_name.length][_name.length];

      for (int i = 0; i < _items.length; i++) {
        for (int j = 0; j < _items.length; j++) {
          _items[i][j] = j+j + "";
        }
      }
    }

    @Override
    public int getItemCount() {
      return _name.length;
    }

    @Override
    public Object getDependency(int j, int i) {
      return _items[j][i];
    }

    @Override
    public Object[][] getDependencies() {
      return _items;
    }

    @Override
    public Object[] getNodes() {
      return _name;
    }

    @Override
    public int[][] getCycles() {
      return new int[][] { { 3, 4 } };
    }

    @Override
    public boolean isInCycle(int x, int y) {
      return isInCycle(x) && isInCycle(y);
    }

    @Override
    public boolean isInCycle(int i) {
      return i == 3 | i == 4;
    }
  }

  public static class LabelProvider implements ILabelProvider {

    /** - */
    private Image _image;

    public LabelProvider() {
      _image = new Image(getDisplay(), getClass().getResourceAsStream("example.png"));
    }

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
      return _image;
    }

    @Override
    public String getText(Object element) {
      return element.toString().replace("/", "").replace(".jar", "");
    }

    private static Display getDisplay() {
      Display display = Display.getCurrent();
      // may be null if outside the UI thread
      if (display == null)
        display = Display.getDefault();
      return display;
    }
  }
}
