package org.slizaa.rcp.workbench.core.internal.classpathcontainer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ClasspathContainerInitializer;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.slizaa.rcp.workbench.core.SlizaaWorkbenchCore;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class SlizaaApiSpiClasspathContainerInitializer extends ClasspathContainerInitializer {

  /**
   * <p>
   * </p>
   *
   * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
   */
  private static class SlizaaApiSpiContainer implements IClasspathContainer {

    /** - */
    private final IClasspathEntry[] _entries;

    /** - */
    private final IPath             _path;

    /**
     * <p>
     * Creates a new instance of type {@link SlizaaApiSpiContainer}.
     * </p>
     *
     * @param path
     * @param entries
     */
    public SlizaaApiSpiContainer(IPath path, IClasspathEntry[] entries) {
      this._path = path;
      this._entries = entries;
    }

    @Override
    public IClasspathEntry[] getClasspathEntries() {
      return this._entries;
    }

    @Override
    public String getDescription() {
      return "Slizaa API/SPI";
    }

    @Override
    public int getKind() {
      return IClasspathContainer.K_DEFAULT_SYSTEM;
    }

    @Override
    public IPath getPath() {
      return this._path;
    }

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void initialize(IPath containerPath, IJavaProject project) throws CoreException {
    if (isValidSContainerPath(containerPath)) {
      SlizaaApiSpiContainer container = getNewContainer(containerPath);
      JavaCore.setClasspathContainer(containerPath, new IJavaProject[] { project },
          new IClasspathContainer[] { container }, null);
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param containerPath
   * @return
   */
  private static SlizaaApiSpiContainer getNewContainer(IPath containerPath) {

    //
    return new SlizaaApiSpiContainer(containerPath, BuildPathSupport.getSlizaaApiSpiLibraryEntries());
  }

  /**
   * <p>
   * </p>
   *
   * @param path
   * @return
   */
  private static boolean isValidSContainerPath(IPath path) {
    return path != null && SlizaaWorkbenchCore.SLIZAA_CONTAINER_ID.equals(path.segment(0));
  }
}