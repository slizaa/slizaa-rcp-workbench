/**
 *
 */
package org.slizaa.ui.dependencytree.internal;

import java.util.function.Consumer;

import org.slizaa.hierarchicalgraph.core.selections.DependencySelection;
import org.slizaa.hierarchicalgraph.core.ui.dependencytree.internal.DependencyTreePart;
import org.slizaa.ui.shared.DefaultLifecycleParticipator;
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
public class DependencyTreeTestModule extends AbstractModule {

  /**
   * {@inheritDoc}
   */
  @Override
  protected void configure() {

    // @formatter:off

    // bind the dependencySelectionCallback
    bind(new TypeLiteral<Consumer<DependencySelection>>() {}).
      annotatedWith(Names.named("dependencySelectionCallback")).
      toInstance(dependencySelection -> System.out.println(dependencySelection));

    // bind the DependencyTreePart ILifecycleParticipator
    bind(new TypeLiteral<ILifecycleParticipator<DependencyTreePart>>() {}).
      toInstance(new DefaultLifecycleParticipator<DependencyTreePart>());

    // @formatter:on
  }

}
