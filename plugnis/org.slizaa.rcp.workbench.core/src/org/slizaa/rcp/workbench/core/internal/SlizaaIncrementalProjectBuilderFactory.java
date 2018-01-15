package org.slizaa.rcp.workbench.core.internal;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.slizaa.rcp.workbench.core.internal.builder.SlizaaIncrementalProjectBuilder;

public class SlizaaIncrementalProjectBuilderFactory implements IExecutableExtensionFactory {

  @Override
  public Object create() throws CoreException {
    // TODO
    return new SlizaaIncrementalProjectBuilder();
  }
}
