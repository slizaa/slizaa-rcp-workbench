package org.slizaa.rcp.workbench.core.internal.classpathcontainer;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.HashSet;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.namespace.BundleNamespace;
import org.osgi.framework.namespace.PackageNamespace;
import org.osgi.framework.wiring.BundleWiring;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class OSGiTransitiveClosureResolver {

  /** - */
  private Bundle      _bundle;

  /** - */
  private Set<Bundle> _result;

  /**
   * <p>
   * Creates a new instance of type {@link OSGiTransitiveClosureResolver}.
   * </p>
   *
   * @param bundle
   */
  public OSGiTransitiveClosureResolver(Bundle bundle) {
    this._bundle = checkNotNull(bundle);
  }

  /**
   * <p>
   * </p>
   *
   * @param bundle
   * @return
   */

  public Set<Bundle> computeTransitiveClosure() {

    //
    this._result = new HashSet<>();

    //
    this._result.add(this._bundle);

    //
    BundleWiring bundleWiring = this._bundle.adapt(BundleWiring.class);

    //
    bundleWiring.getRequiredWires(PackageNamespace.PACKAGE_NAMESPACE)
        .forEach(bw -> this._result.add(bw.getProvider().getBundle()));

    //
    bundleWiring.getRequiredWires(BundleNamespace.BUNDLE_NAMESPACE)
        .forEach(bw -> this._result.add(bw.getProvider().getBundle()));

    //
    return this._result;
  }
}
