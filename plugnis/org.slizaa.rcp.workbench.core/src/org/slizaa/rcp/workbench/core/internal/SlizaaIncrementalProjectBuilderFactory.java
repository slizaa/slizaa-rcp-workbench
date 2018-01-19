package org.slizaa.rcp.workbench.core.internal;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.slizaa.rcp.workbench.core.SlizaaWorkbenchCore;
import org.slizaa.rcp.workbench.core.internal.builder.AstBasedResourceHandler;
import org.slizaa.rcp.workbench.core.internal.builder.SlizaaIncrementalProjectBuilder;
import org.slizaa.rcp.workbench.core.internal.extensions.SlizaaExtensionsJavaSourceHandler;
import org.slizaa.rcp.workbench.core.internal.projectconfig.SlizaaProjectConfigurationJavaSourceHandler;

public class SlizaaIncrementalProjectBuilderFactory implements IExecutableExtensionFactory {

  /** - */
  private final static String[] MARKERTYPES_TO_DELETE_ON_CLEAN = {
      SlizaaWorkbenchCore.SLIZAA_CONFIGURATION_PROBLEM_MARKER };

  @Override
  public Object create() throws CoreException {

    return new SlizaaIncrementalProjectBuilder(MARKERTYPES_TO_DELETE_ON_CLEAN, new AstBasedResourceHandler(
        new SlizaaExtensionsJavaSourceHandler(), new SlizaaProjectConfigurationJavaSourceHandler()));
  }
}
