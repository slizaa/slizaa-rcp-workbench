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

import org.slizaa.hierarchicalgraph.core.model.HGNode;

/**
 * 
 */
public class ArtifactPathLabelGenerator {

	/**
	 * The common base artifact that is used to calculate the labels
	 */
	private HGNode _baseArtifact;

	private HGNode _titleArtifact;

	/**
	 * @return the baseArtifact
	 */
	public HGNode getBaseArtifact() {
		return _baseArtifact;
	}

	/**
	 * @param baseArtifact
	 *            the baseArtifact to set
	 */
	public void setBaseArtifact(HGNode baseArtifact) {
		_baseArtifact = baseArtifact;
		_titleArtifact = null;
	}

	/**
	 * returns the last segment of the path of IArtifacts that is used to build
	 * the title
	 * 
	 * @return
	 */
	protected HGNode getTitleArtifact() {
		if (_titleArtifact != null) {
			return _titleArtifact;
		}

		HGNode artifact = _baseArtifact;
		if (artifact == null) {
			return null;
		}
		// TODO
		// if (artifact.isInstanceOf(IRootArtifact.class)) {
		// _titleArtifact = artifact;
		// return artifact;
		// }
		//
		// while (artifact != null && artifact.getParent(IModuleArtifact.class)
		// != null) {
		// artifact = artifact.getParent();
		// }

		_titleArtifact = artifact;

		return _titleArtifact;

	}

	public String getTitle() {

		HGNode artifact = getTitleArtifact();

		return "UNKNOWN";

		// if (artifact == null) {
		// return "";
		// }
		//
		// // TODO
		// if (artifact instanceof HGRootNode) {
		// return "Default Model";
		// }
		//
		// String path = "";
		//
		// // while (artifact != null && artifact.getType().ordinal() >
		// // ArtifactType.Root.ordinal()) {
		// // path = artifact.getName() + "/" + path;
		// // artifact = artifact.getParent();
		// // }
		//
		// if (!(((HGNode) artifact).getNodeSource() instanceof
		// AbstractJqaNode)) {
		// return "UNKOWN";
		// }
		//
		// path = ((AbstractJqaNode) ((HGNode) artifact).getNodeSource()).fqn();
		// // path = ((HGNode) artifact).getFullPath().toPortableString();
		//
		// if (path.endsWith("/")) {
		// path = path.substring(0, path.length() - 1);
		// }
		// return path;
	}

	/**
	 * @return
	 */
	public String getLabel(HGNode typeArtifact) {
		// return getFullLabel(typeArtifact);
		return "unknown";
	}

	// protected String getTypeLabel(HGNode typeArtifact, boolean
	// useQualifiedTypeName) {
	// String name = ((AbstractJqaNode) (typeArtifact).getNodeSource()).fqn();
	//
	// if (!useQualifiedTypeName) {
	// return name;
	// }
	//
	// // TODO:
	// // if (!(typeArtifact instanceof ITypeArtifact)) {
	// // // why would this happen?
	// // return name;
	// // }
	// //
	// // HGNode parent = typeArtifact.getParent(IPackageArtifact.class);
	// //
	// // if (parent == null) {
	// // return name;
	// // }
	// //
	// // if (parent instanceof IPackageArtifact) {
	// // name = parent.getQualifiedName() + "." + name;
	// // }
	//
	// return name;
	// }
	//
	// protected String getFullLabel(HGNode typeArtifact) {
	// HGNode titleArtifact = getTitleArtifact();
	// if (titleArtifact == null) {
	// return "";
	// }
	//
	// HGNode artifact = typeArtifact;
	//
	// String path = "";
	// boolean inPackage = false;
	// while (artifact != null && !artifact.equals(titleArtifact)) {
	// // if (artifact.isInstanceOf(IPackageArtifact.class)) {
	// // if (!inPackage) {
	// // inPackage = true;
	// // path = artifact.getQualifiedName() + "." + path;
	// // }
	// // } else {
	// path = ((AbstractJqaNode) typeArtifact.getNodeSource()).name() + "/" +
	// path;
	// inPackage = false;
	// // }
	// artifact = artifact.getParent();
	// }
	//
	// //
	// return _labelProvider.getText(path);
	// }
}
