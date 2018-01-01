package org.slizaa.rcp.workbench.core.internal;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IAccessRule;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;

public class BuildPathSupport {

  public static IClasspathEntry getSlizaaApiSpiLibraryEntry() {

    //
    IPath jarLocationPath = new Path(
        "C:\\Users\\wuetherich\\.m2\\repository\\org\\slizaa\\scanner\\core\\org.slizaa.scanner.core.spi-api\\1.0.0-SNAPSHOT\\org.slizaa.scanner.core.spi-api-1.0.0-SNAPSHOT.jar");

    IAccessRule[] accessRules = {};

    if (jarLocationPath.toFile().exists()) {
      return JavaCore.newLibraryEntry(jarLocationPath, jarLocationPath, new Path("OSGI-OPT\\src"), accessRules, null,
          false);
    }

    //
    return null;
  }
}