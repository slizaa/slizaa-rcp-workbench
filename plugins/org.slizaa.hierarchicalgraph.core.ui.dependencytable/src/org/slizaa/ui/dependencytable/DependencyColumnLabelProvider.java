/*******************************************************************************
 * Copyright (c) Gerd W�therich 2012-2016.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *    Gerd W�therich (gerd@gerd-wuetherich.de) - initial API and implementation
 ******************************************************************************/
package org.slizaa.ui.dependencytable;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.slizaa.hierarchicalgraph.core.model.AbstractHGDependency;
import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.hierarchicalgraph.core.model.HGRootNode;
import org.slizaa.hierarchicalgraph.core.model.spi.INodeLabelProvider;

/**
 * @author Nils Hartmann (nils@nilshartmann.net)
 * 
 */
public abstract class DependencyColumnLabelProvider extends ColumnLabelProvider {


	private final ArtifactPathLabelGenerator _labelGenerator;

	/**
	 * @param labelGenerator
	 */
	public DependencyColumnLabelProvider(ArtifactPathLabelGenerator labelGenerator) {
		super();
		_labelGenerator = labelGenerator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ColumnLabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {

		//
		if (element instanceof AbstractHGDependency) {
			element = getNode((AbstractHGDependency) element);
		}

		//
		if (element instanceof HGNode) {

			//
			HGRootNode rootNode = ((HGNode) element).getRootNode();
			return (Image) rootNode.getExtension(INodeLabelProvider.class).getImage(element);
		}

		//
		return null;
	}

	/**
	 * Sets the 'base artifact' that is the IArtifact from the HGDependency
	 * (either from- or to-side)
	 * 
	 * @param baseArtifact
	 *            the baseArtifact to set
	 */
	public void setBaseArtifact(HGNode baseArtifact) {
		getLabelGenerator().setBaseArtifact(baseArtifact);
	}

	/**
	 * @return
	 */
	protected ArtifactPathLabelGenerator getLabelGenerator() {
		return _labelGenerator;
	}

	/**
	 * @param dependency
	 * @return
	 */
	protected abstract HGNode getNode(AbstractHGDependency dependency);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ColumnLabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {

		//
		if (element instanceof AbstractHGDependency) {
			element = getNode((AbstractHGDependency) element);
		}

		//
		if (element instanceof HGNode) {

			//
			HGRootNode rootNode = ((HGNode) element).getRootNode();
			return rootNode.getExtension(INodeLabelProvider.class).getText(element);
		}

		//
		return null;
	}

	protected String getArtifactLabel(HGNode artifact) {
		return _labelGenerator.getLabel(artifact);
	}

}
