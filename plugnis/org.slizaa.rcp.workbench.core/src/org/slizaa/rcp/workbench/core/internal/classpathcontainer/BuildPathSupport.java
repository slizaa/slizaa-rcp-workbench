package org.slizaa.rcp.workbench.core.internal.classpathcontainer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IAccessRule;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.slizaa.rcp.workbench.core.internal.Activator;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class BuildPathSupport {

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public static IClasspathEntry[] getSlizaaApiSpiLibraryEntries() {

    List<IClasspathEntry> entries = new ArrayList<>();

    Map<Bundle, Set<Bundle>> spiApiBundles = Activator.instance().getTrackedSpiApiBundles();
    Set<Bundle> mergedResult = new HashSet<Bundle>();

    //
    List<Bundle> googleGuiceBundles = Arrays
        .asList(FrameworkUtil.getBundle(BuildPathSupport.class).getBundleContext().getBundles()).stream()
        .filter(b -> "com.google.inject".equals(b.getSymbolicName()) || "javax.inject".equals(b.getSymbolicName()))
        .collect(Collectors.toList());

    //
    mergedResult.addAll(googleGuiceBundles);

    spiApiBundles.values().forEach(bundles -> mergedResult.addAll(bundles));

    //
    for (Bundle bundle : mergedResult) {

      try {
        File bundleFile = FileLocator.getBundleFile(bundle).getCanonicalFile();

        IPath jarLocationPath = new Path(bundleFile.getAbsolutePath());

        // TODO: handle projects
        if (new File(bundleFile, ".classpath").isFile()) {

          IAccessRule[] accessRules = getAccessRules();

          if (jarLocationPath.toFile().exists()) {
            // TODO: resolve .classpath!
            entries.add(JavaCore.newLibraryEntry(jarLocationPath.append("bin"), jarLocationPath.append("src"), null,
                accessRules, null, false));
          }

        }
        //
        else {

          IAccessRule[] accessRules = getAccessRules();

          if (jarLocationPath.toFile().exists()) {
            entries.add(JavaCore.newLibraryEntry(jarLocationPath, jarLocationPath, new Path("OSGI-OPT\\src"),
                accessRules, null, false));
          }
        }

      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    //
    return entries.toArray(new IClasspathEntry[0]);
  }

  public static IAccessRule[] getAccessRules() {
    return new IAccessRule[] {
        // JavaCore.newAccessRule(new Path("junit/"), IAccessRule.K_ACCESSIBLE), //$NON-NLS-1$
        JavaCore.newAccessRule(new Path("**/*"), IAccessRule.K_ACCESSIBLE) //$NON-NLS-1$
    };
  }
}