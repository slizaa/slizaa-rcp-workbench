package org.slizaa.hierarchicalgraph.core.ui.xref.internal;

import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.junit.Test;
import org.slizaa.hierarchicalgraph.core.model.HGAggregatedDependency;
import org.slizaa.hierarchicalgraph.core.model.HGNode;

/**
 * <p>
 * </p>
 */
public class XRefPart_SingleCenterSelect_Test extends AbstractXRefPartTest {

	/**
	 * <p>
	 * </p>
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void test() throws InterruptedException {

		//
		for (int i = 0; i < modules().size(); i++) {

			//
			HGNode centerModule = (HGNode) modules().get(i);

			//
			centerTree().select(centerRootItem().getNode(getLabel(centerModule)));
			fromRootItem().expand();
			toRootItem().expand();

			//
			for (HGAggregatedDependency dependency : centerModule.getIncomingDependenciesFrom(modules())) {
				swtbot().waitUntil(Conditions.treeItemHasNode(fromRootItem(), getLabel(dependency.getFrom())));
			}

			//
			for (HGAggregatedDependency dependency : centerModule.getOutgoingDependenciesTo(modules())) {
				swtbot().waitUntil(Conditions.treeItemHasNode(toRootItem(), getLabel(dependency.getTo())));
			}
		}
	}
}