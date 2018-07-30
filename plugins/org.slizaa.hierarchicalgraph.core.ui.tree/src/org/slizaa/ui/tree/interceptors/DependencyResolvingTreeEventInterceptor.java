package org.slizaa.ui.tree.interceptors;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slizaa.hierarchicalgraph.core.model.HGCoreDependency;
import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.hierarchicalgraph.core.model.HGProxyDependency;
import org.slizaa.hierarchicalgraph.core.model.impl.Utilities;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class DependencyResolvingTreeEventInterceptor implements ISlizaaTreeEventInterceptor {

  /** - */
  private Function<HGNode, Collection<HGCoreDependency>> _coreDependencySupplier;

  /**
   * <p>
   * Creates a new instance of type {@link DependencyResolvingTreeEventInterceptor}.
   * </p>
   *
   * @param coreDependencySupplier
   */
  public DependencyResolvingTreeEventInterceptor(
      Function<HGNode, Collection<HGCoreDependency>> coreDependencySupplier) {
    _coreDependencySupplier = checkNotNull(coreDependencySupplier);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void handleSelect(HGNode node) {
    resolveDependencies(node);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void handleTreeExpand(HGNode node) {
    resolveDependencies(node);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void handleTreeCollapse(HGNode node) {
    // nothing
  }

  /**
   * <p>
   * </p>
   *
   * @param node
   */
  private void resolveDependencies(HGNode node) {
    Collection<HGCoreDependency> dependencies = _coreDependencySupplier.apply(node);
    if (dependencies != null) {
      List<HGProxyDependency> proxyDependencies = dependencies.stream().filter(dep -> dep instanceof HGProxyDependency)
          .map(dep -> (HGProxyDependency) dep).collect(Collectors.toList());
      Utilities.resolveProxyDependencies(proxyDependencies, null);
    }
  }
}
