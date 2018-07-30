package org.slizaa.hierarchicalgraph.core.testfwk.ui.rules;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.junit.rules.ExternalResource;

public class ImageRegistryRule extends ExternalResource {

  /** - */
  private Map<String, Image> _imageCache;

  /** - */
  private Supplier<Display>  _displaySupplier;

  /**
   * <p>
   * Creates a new instance of type {@link ImageRegistryRule}.
   * </p>
   *
   * @param displaySupplier
   */
  public ImageRegistryRule(Supplier<Display> displaySupplier) {
    _displaySupplier = checkNotNull(displaySupplier);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void before() throws Throwable {

    //
    _imageCache = new HashMap<>();
  };

  /**
   * {@inheritDoc}
   */
  @Override
  protected void after() {

    // dispose images
    if (_imageCache != null) {
      _imageCache.values().forEach(image -> image.dispose());
      _imageCache = null;
    }
  };

  /**
   * <p>
   * </p>
   *
   * @param path
   * @return
   */
  public Image getImage(String path) {

    return _imageCache.computeIfAbsent(checkNotNull(path), p -> {

      //
      try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(p)) {
        if (inputStream != null) {
          return new Image(_displaySupplier.get(), inputStream);
        } else {
          throw new RuntimeException(String.format("No image for path '%s'.", p));
        }
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    });

  }
}
