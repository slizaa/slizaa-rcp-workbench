package org.slizaa.hierarchicalgraph.graphdb.ui.mappingsdialog;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;
import java.util.function.Supplier;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.slizaa.hierarchicalgraph.graphdb.mapping.spi.IMappingProvider;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
class MappingProviderTreeContentProvider implements ITreeContentProvider {

  /** - */
  private Supplier<List<IMappingProvider>> _mappingProviderSupplier;

  /**
   * <p>
   * Creates a new instance of type {@link MappingProviderTreeContentProvider}.
   * </p>
   *
   * @param mappingProviderSupplier
   */
  public MappingProviderTreeContentProvider(Supplier<List<IMappingProvider>> mappingProviderSupplier) {

    //
    checkNotNull(mappingProviderSupplier);

    //
    this._mappingProviderSupplier = mappingProviderSupplier;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object[] getChildren(Object element) {
    return new Object[0];
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object getParent(Object element) {
    // TODO
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean hasChildren(Object element) {
    return getChildren(element).length > 0;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object[] getElements(Object element) {
    return this._mappingProviderSupplier.get().toArray();
  }

  @Override
  public void dispose() {
    // TODO
  }

  @Override
  public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
    // TODO
  }
}