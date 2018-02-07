package org.slizaa.rcp.workbench.core.internal.propertyTester;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.slizaa.rcp.workbench.core.SlizaaWorkbenchCore;
import org.slizaa.rcp.workbench.core.model.SlizaaProject;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class DatabaseDirectoryPopulatedPropertyTester extends PropertyTester {

  /** - */
  private static final String PROPERTY_IS_DATABASE_DIRECTORY_POPULATED = "isDatabaseDirectoryPopulated"; // $NON-NLS-1

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

    //
    if (PROPERTY_IS_DATABASE_DIRECTORY_POPULATED.equals(property)) {

      IProject project = (IProject) receiver;
      try {
        SlizaaProject slizaaProject = SlizaaWorkbenchCore.getSlizaaProject(project);
        return slizaaProject.isDatabaseDirectoryPopulated();
      } catch (CoreException e) {
        //
      }
    }

    // default: false
    return false;
  }
}