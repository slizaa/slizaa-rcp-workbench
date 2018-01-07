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
   * @param result
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
    computeWiredBundles(this._bundle);

    //
    return this._result;
  }

  /**
   * <p>
   * </p>
   */
  private void computeWiredBundles(Bundle bundle) {

    //
    if (this._result.contains(checkNotNull(bundle))) {
      return;
    }

    //
    this._result.add(bundle);

    //
    BundleWiring bundleWiring = bundle.adapt(BundleWiring.class);

    //
    bundleWiring.getRequiredWires(PackageNamespace.PACKAGE_NAMESPACE)
        .forEach(bw -> computeWiredBundles(bw.getProvider().getBundle()));

    //
    bundleWiring.getRequiredWires(BundleNamespace.BUNDLE_NAMESPACE)
        .forEach(bw -> computeWiredBundles(bw.getProvider().getBundle()));
  }
}
