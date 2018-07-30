package org.slizaa.ui.klighd.synthesis.hierarchicalgraph

import de.cau.cs.kieler.klighd.kgraph.KNode
import de.cau.cs.kieler.klighd.krendering.Colors
import de.cau.cs.kieler.klighd.krendering.extensions.KContainerRenderingExtensions
import de.cau.cs.kieler.klighd.krendering.extensions.KEdgeExtensions
import de.cau.cs.kieler.klighd.krendering.extensions.KLabelExtensions
import de.cau.cs.kieler.klighd.krendering.extensions.KNodeExtensions
import de.cau.cs.kieler.klighd.krendering.extensions.KPolylineExtensions
import de.cau.cs.kieler.klighd.krendering.extensions.KRenderingExtensions
import de.cau.cs.kieler.klighd.syntheses.AbstractDiagramSynthesis
import java.util.Set
import javax.inject.Inject
import org.eclipse.elk.alg.layered.p4nodes.NodePlacementStrategy
import org.eclipse.elk.alg.layered.properties.LayeredOptions
import org.eclipse.elk.core.options.CoreOptions
import org.eclipse.elk.core.options.Direction
import org.eclipse.elk.core.options.EdgeRouting
import org.eclipse.emf.edit.provider.IItemLabelProvider
import org.eclipse.swt.graphics.Image
import org.slizaa.hierarchicalgraph.core.model.HGNode
import org.slizaa.hierarchicalgraph.core.model.spi.INodeLabelProvider

class HierarchicalGraphSelectionSynthesis extends AbstractDiagramSynthesis<Set<HGNode>> {

	@Inject extension KNodeExtensions
	@Inject extension KEdgeExtensions
	@Inject extension KLabelExtensions
	@Inject extension KRenderingExtensions
	@Inject extension KContainerRenderingExtensions
	@Inject extension KPolylineExtensions

	val float LINE_WIDTH = 1.5f;

	override KNode transform(Set<HGNode> nodeSelection) {
		val rootNode = nodeSelection.createNode().associateWith(nodeSelection);

		//
		rootNode.addLayoutParam(CoreOptions::ALGORITHM, "org.eclipse.elk.layered");
		rootNode.addLayoutParam(CoreOptions::DIRECTION, Direction.DOWN);
		rootNode.addLayoutParam(CoreOptions::EDGE_ROUTING, EdgeRouting.ORTHOGONAL);
		rootNode.addLayoutParam(LayeredOptions::SPACING_EDGE_LABEL, 4.0);
		// nice one!
		rootNode.addLayoutParam(LayeredOptions::FEEDBACK_EDGES, false);
		rootNode.addLayoutParam(LayeredOptions::NODE_PLACEMENT_STRATEGY, NodePlacementStrategy.BRANDES_KOEPF);
		rootNode.children += nodeSelection.map [
			val child = (it as HGNode).translateNode;
			return child;
		];

		//
		for (sourceElement : nodeSelection) {

			// set the ypos to influence the order: sourceElement.node.getData(KShapeLayout).ypos = virtualY;
			for (targetElement : nodeSelection) {

				if (sourceElement != targetElement) {

					val outgoingDependencies = sourceElement.getOutgoingDependenciesTo(targetElement);

					if (outgoingDependencies != null && outgoingDependencies.aggregatedWeight > 0) {
						createEdge => [
							it.source = sourceElement.node
							it.target = targetElement.node
							it.associateWith(outgoingDependencies)
							it.addPolyline => [
								it.invisible = false
								it.lineWidth = LINE_WIDTH
								it.addHeadArrowDecorator => [
									it.invisible = false
									it.lineWidth = LINE_WIDTH
								]
								it.addSingleOrMultiClickAction(SelectDependenciesAction.ID)
							]
							it.createLabel => [
								it.configureCenterEdgeLabel(Integer.toString(outgoingDependencies.aggregatedWeight), 10)
							]
						]
					}
				}
			}
		}

		return rootNode;
	}

	private def create node : object.createNode translateNode(HGNode object) {

		//
		node.associateWith(object);

		//
		node.createFigure() =>
			[
				it.setGridPlacement(2);

				// SHOW IMAGE
				val IItemLabelProvider itemLabelProvider = object.rootNode.getExtension(INodeLabelProvider);
				val Image original = itemLabelProvider.getImage(object) as Image;

				// upper part is icon
				if (original != null) {

					it.addRectangle =>
						[
							it.invisible = true;
							// set minimal size
							it.setGridPlacementData(original.boundsInPixels.width, original.boundsInPixels.height);
							it.addImage(original.getImageData()).setPointPlacementData(LEFT, 0, 0.5f, TOP, 0, 0.5f, H_CENTRAL, V_CENTRAL,
								10, 10, original.boundsInPixels.width, original.boundsInPixels.height).addRectangularClip;
						]
				}

				it.addText(object.rootNode.getExtension(INodeLabelProvider).getText(object)).associateWith(object) => [
					it.fontSize = 10;
					it.setFontBold(false);
					it.setGridPlacementData().from(LEFT, 0, 0, TOP, 8, 0).to(RIGHT, 16, 0, BOTTOM, 8, 0);
				];
			];
	}

	private def createFigure(KNode node) {
		node.addRectangle() => [

			it.invisible = false
			it.lineWidth = LINE_WIDTH
			it.foreground = Colors.BLACK

			it.shadow = Colors.GRAY_50;
			it.shadow.XOffset = 4;
			it.shadow.YOffset = 4;

		// it.setBackgroundGradient("#FFF3D3".color, "#FFFFFF".color, 90)
		]
	}
}
