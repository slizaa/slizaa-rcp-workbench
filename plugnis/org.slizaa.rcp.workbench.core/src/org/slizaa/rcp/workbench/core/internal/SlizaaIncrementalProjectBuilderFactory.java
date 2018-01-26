package org.slizaa.rcp.workbench.core.internal;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.slizaa.rcp.workbench.core.internal.builder.AstBasedResourceHandler;
import org.slizaa.rcp.workbench.core.internal.builder.SlizaaIncrementalProjectBuilder;
import org.slizaa.rcp.workbench.core.internal.extensions.SlizaaExtensionsJavaSourceHandler;
import org.slizaa.rcp.workbench.core.internal.projectconfig.SlizaaProjectConfigurationJavaSourceHandler;

public class SlizaaIncrementalProjectBuilderFactory implements IExecutableExtensionFactory {

  @Override
  public Object create() throws CoreException {

    return new SlizaaIncrementalProjectBuilder(new AstBasedResourceHandler(
        new SlizaaExtensionsJavaSourceHandler(), new SlizaaProjectConfigurationJavaSourceHandler()));
  }
}
