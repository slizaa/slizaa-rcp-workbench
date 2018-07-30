package org.slizaa.hierarchicalgraph.core.ui.xref.internal;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.slizaa.hierarchicalgraph.core.model.HGAggregatedDependency;
import org.slizaa.hierarchicalgraph.core.model.HGNode;

/**
 * <p>
 * </p>
 */
public class XRefPart_SingleCrop_Test extends AbstractXRefPartTest {

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
			cropSelectionButton().click();

			assertThat(centerRootItem().getItems()).hasSize(1);

			//
			for (HGAggregatedDependency dependency : centerModule.getIncomingDependenciesFrom(modules())) {
				fromRootItem().getNode(getLabel(dependency.getFrom()));
			}

			//
			for (HGAggregatedDependency dependency : centerModule.getOutgoingDependenciesTo(modules())) {
				toRootItem().getNode(getLabel(dependency.getTo()));
			}

			uncropButton().click();
			assertThat(centerRootItem().getItems()).hasSameSizeAs(modules());
		}
	}
}