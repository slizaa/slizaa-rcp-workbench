package org.slizaa.hierarchicalgraph.graphdb.ui.hierarchicalgraphview;

import static com.google.common.base.Preconditions.checkNotNull;

import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.swt.graphics.Image;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class OverlayImageRegistry {

  /** - */
  private ImageRegistry _imageRegistry;

  /**
   * <p>
   * Creates a new instance of type {@link OverlayImageRegistry}.
   * </p>
   *
   * @param imageRegistry
   */
  public OverlayImageRegistry(ImageRegistry imageRegistry) {
    this._imageRegistry = checkNotNull(imageRegistry);
  }

  /**
   * <p>
   * Creates a new instance of type {@link OverlayImageRegistry}.
   * </p>
   */
  public OverlayImageRegistry() {
    this._imageRegistry = Activator.getDefault().getImageRegistry();
  }

  /**
   * <p>
   * </p>
   *
   * @param basePath
   * @param overlayPaths
   * @param quadrant
   * @return
   */
  public Image getOverlayImage(URL baseImageUrl, URL[] overlayImageUrls) {

    //
    if (baseImageUrl == null) {
      return null;
    }

    //
    if (overlayImageUrls == null) {
      return getImage(baseImageUrl);
    }

    //
    String combinedKey = key(baseImageUrl, overlayImageUrls);

    //
    ImageDescriptor imageDescriptor = this._imageRegistry.getDescriptor(combinedKey);
    if (imageDescriptor == null) {

      ImageDescriptor[] descriptors = new ImageDescriptor[overlayImageUrls.length];
      for (int i = 0; i < overlayImageUrls.length; i++) {
        descriptors[i] = overlayImageUrls[i] != null ? getImageDescriptor(overlayImageUrls[i]) : null;
      }

      Image baseImage = getImage(baseImageUrl);
      checkNotNull(baseImage, String.format("Image with url %s does not exist.", baseImageUrl.toExternalForm()));
      imageDescriptor = new DecorationOverlayIcon(baseImage, descriptors);
      this._imageRegistry.put(combinedKey, imageDescriptor);
    }

    //
    return this._imageRegistry.get(combinedKey);
  }

  /**
   * Returns an image. Clients do not need to dispose the image, it will be disposed automatically.
   *
   * @return an {@link Image}
   */
  public Image getImage(URL imageUrl) {
    Image image = this._imageRegistry.get(key(imageUrl));
    if (image == null) {
      addImageDescriptor(imageUrl);
      image = this._imageRegistry.get(key(imageUrl));
    }

    return image;
  }

  /**
   * Returns an image descriptor.
   *
   * @return an {@link ImageDescriptor}
   */
  public ImageDescriptor getImageDescriptor(URL imageUrl) {
    ImageDescriptor imageDescriptor = this._imageRegistry.getDescriptor(key(imageUrl));
    if (imageDescriptor == null) {
      addImageDescriptor(imageUrl);
      imageDescriptor = this._imageRegistry.getDescriptor(key(imageUrl));
    }

    return imageDescriptor;
  }

  /**
   * <p>
   * </p>
   */
  private void addImageDescriptor(URL imageUrl) {
    final ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(imageUrl);
    this._imageRegistry.put(key(imageUrl), imageDescriptor);
  }

  /**
   * <p>
   * </p>
   *
   * @param imageUrl
   * @return
   */
  private String key(URL imageUrl) {
    return checkNotNull(imageUrl).toExternalForm();
  }

  /**
   * <p>
   * </p>
   *
   * @param baseImageUrl
   * @param overlayImageUrls
   * @return
   */
  private String key(URL baseImageUrl, URL[] overlayImageUrls) {
    StringBuilder combinedKeyBuilder = new StringBuilder(key(baseImageUrl));
    for (URL overlayImageUrl : overlayImageUrls) {
      combinedKeyBuilder.append(overlayImageUrl != null ? overlayImageUrl.toExternalForm() : "<null>");
      combinedKeyBuilder.append("|");
    }
    String combinedKey = combinedKeyBuilder.toString();
    return combinedKey;
  }
}
