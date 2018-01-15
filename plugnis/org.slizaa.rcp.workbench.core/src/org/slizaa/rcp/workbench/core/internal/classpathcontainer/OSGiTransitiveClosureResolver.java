package org.slizaa.rcp.workbench.core.internal.classpathcontainer;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
  private Bundle       _bundle;

  /** - */
  private List<String> _whiteList;

  /** - */
  private Set<Bundle>  _result;

  /**
   * <p>
   * Creates a new instance of type {@link OSGiTransitiveClosureResolver}.
   * </p>
   *
   * @param bundle
   * @param whiteList
   */
  public OSGiTransitiveClosureResolver(Bundle bundle, String whiteList) {
    this._bundle = checkNotNull(bundle);

    if (!Boolean.parseBoolean(whiteList)) {
      this._whiteList = Arrays.asList(checkNotNull(whiteList).split(","));
    }
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
    return this._result.stream()
        .filter(b -> this._bundle.equals(b) || this._whiteList == null || this._whiteList.contains(b.getSymbolicName()))
        .collect(Collectors.toSet());
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
