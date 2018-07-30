package org.slizaa.ui.tree;

import org.eclipse.jface.viewers.TreeViewer;
import org.slizaa.ui.tree.interceptors.ISlizaaLabelProviderInterceptor;
import org.slizaa.ui.tree.interceptors.ISlizaaTreeEventInterceptor;

public interface ISlizaaTreeViewerBuilder {

  ISlizaaTreeViewerBuilder withStyle(int style);

  ISlizaaTreeViewerBuilder withAutoExpandLevel(int autoExpandLevel);

  ISlizaaTreeViewerBuilder withTreeEventInterceptor(ISlizaaTreeEventInterceptor treeEventInterceptor);

  ISlizaaTreeViewerBuilder withLabelProviderInterceptor(ISlizaaLabelProviderInterceptor labelProviderInterceptor);

  TreeViewer create();
}
