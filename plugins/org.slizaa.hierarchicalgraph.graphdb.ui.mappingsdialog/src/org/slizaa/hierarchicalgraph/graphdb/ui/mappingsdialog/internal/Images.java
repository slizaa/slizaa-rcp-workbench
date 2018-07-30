package org.slizaa.hierarchicalgraph.graphdb.ui.mappingsdialog.internal;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

/**
 * This enumeration provides a number of images for the plugin.
 */
public enum Images {

  SLIZAA_16("icons/slizaa_16.png");

  /**
   * The bundle-relative path to the icon
   */
  private final String         _path;

  /** - */
  private static ImageRegistry _defaultImageRegistry;

  private Images(final String path) {
    this._path = path;
  }

  /**
   * Returns an image. Clients do not need to dispose the image, it will be disposed automatically.
   * 
   * @return an {@link Image}
   */
  public Image getImage() {

    // try to get the image from the registry
    Image image = imageRegistry().get(this._path);

    // create if it not already exists
    if (image == null) {
      addImageDescriptor();
      image = imageRegistry().get(this._path);
    }

    // return the result
    return image;
  }

  /**
   * Returns an image descriptor.
   * 
   * @return an {@link ImageDescriptor}
   */
  public ImageDescriptor getImageDescriptor() {
    ImageDescriptor imageDescriptor = imageRegistry().getDescriptor(this._path);
    if (imageDescriptor == null) {
      addImageDescriptor();
      imageDescriptor = imageRegistry().getDescriptor(this._path);
    }

    return imageDescriptor;
  }

  private void addImageDescriptor() {
    final ImageDescriptor id = ImageDescriptor.createFromURL(imageUrl());
    imageRegistry().put(this._path, id);
  }

  public static void disposeDefaultImageRegistry() {
    if (_defaultImageRegistry != null) {
      _defaultImageRegistry.dispose();
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param defaultImageRegistry
   */
  public static void setDefaultImageRegistry(ImageRegistry defaultImageRegistry) {
    _defaultImageRegistry = defaultImageRegistry;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  private ImageRegistry imageRegistry() {

    // in OSGi land?
    if (Activator.getDefault() != null) {
      return Activator.getDefault().getImageRegistry();
    }

    // use the build-in-default-registry
    if (_defaultImageRegistry == null) {
      _defaultImageRegistry = new ImageRegistry(Display.getDefault());
    }

    return _defaultImageRegistry;
  }

  /**
   * <p>
   * </p>
   *
   * @param path
   * @return
   */
  private URL imageUrl() {

    // in OSGi land?
    if (Activator.getDefault() != null) {
      return Activator.getDefault().getBundle().getEntry(_path);
    }

    // try to load from class path
    URL url = this.getClass().getClassLoader().getResource(_path);
    if (url != null) {
      return url;
    }

    //
    File classesDir = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().getFile());
    File parentFile = classesDir.getParentFile();
    try {
      return new File(parentFile, _path).toURI().toURL();
    } catch (MalformedURLException e) {
    }

    //
    return null;
  }
}
