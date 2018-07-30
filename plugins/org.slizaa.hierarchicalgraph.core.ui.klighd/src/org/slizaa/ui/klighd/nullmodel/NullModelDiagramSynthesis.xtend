package org.slizaa.ui.klighd.nullmodel

import de.cau.cs.kieler.klighd.kgraph.KNode
import de.cau.cs.kieler.klighd.krendering.extensions.KNodeExtensions
import de.cau.cs.kieler.klighd.krendering.extensions.KRenderingExtensions
import de.cau.cs.kieler.klighd.syntheses.AbstractDiagramSynthesis
import javax.inject.Inject

class NullModelDiagramSynthesis extends AbstractDiagramSynthesis<NullModel> {

	@Inject extension KNodeExtensions
	@Inject extension KRenderingExtensions

	override KNode transform(NullModel model) {
		val root = model.createNode().associateWith(model);

		val node = createNode();
		root.children.add(node);
		val figure = node.addRectangle();
		figure.invisible = true;
		return root;
	}

}
