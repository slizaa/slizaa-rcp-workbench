package org.slizaa.hierarchicalgraph.core.ui.dependencytree.internal.osgi;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.function.Consumer;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.slizaa.hierarchicalgraph.core.selections.DependencySelection;
import org.slizaa.hierarchicalgraph.core.ui.dependencytree.internal.DependencyTreePart;
import org.slizaa.hierarchicalgraph.core.workbench.model.SlizaaWorkbenchModel;
import org.slizaa.ui.shared.ILifecycleParticipator;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class DependencyTreeModule extends AbstractModule {

  /** - */
  private IEclipseContext _eclipseContext;

  /**
   * <p>
   * Creates a new instance of type {@link DependencyTreeModule}.
   * </p>
   *
   * @param eclipseContext
   */
  public DependencyTreeModule(IEclipseContext eclipseContext) {
    this._eclipseContext = checkNotNull(eclipseContext);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void configure() {

    // @formatter:off

    // bind the workbench model
    SlizaaWorkbenchModel workbenchModel = this._eclipseContext.get(SlizaaWorkbenchModel.class);
    bind(SlizaaWorkbenchModel.class).toInstance(workbenchModel);

    // bind the dependencySelectionCallback
    bind(new TypeLiteral<Consumer<DependencySelection>>() {}).
      annotatedWith(Names.named("dependencySelectionCallback")).
      toInstance(dependencySelection -> workbenchModel.setDetailDependencySelection(dependencySelection));

    // bind the DependencyTreePart ILifecycleParticipator
    bind(new TypeLiteral<ILifecycleParticipator<DependencyTreePart>>() {}).
      to(DependencyTreePartLifecycleParticipator.class);

    // @formatter:on
  }

}