/*******************************************************************************
 * Copyright (c) 2011-2015 slizaa project team.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    slizaa project team - initial API and implementation
 ******************************************************************************/
package org.slizaa.rcp.workbench.ui.internal;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonNavigator;
import org.slizaa.rcp.workbench.core.ISlizaaProject;

/**
 * Parses and opens a specified BundleMaker Project and executes all required
 * pre- and post-actions for the UI (like fireing events, switching perspective
 * etc)
 * 
 * <p>
 * After opening the project the appropriate events are fired, the perspective
 * will be switched etc.
 * 
 * @author Nils Hartmann (nils@nilshartmann.net)
 * 
 */
public class SlizaaProjectOpener {

	public static void openProject(final ISlizaaProject bundleMakerProject, boolean parse) {

		if (bundleMakerProject == null) {
			return;
		}

		final long start = System.currentTimeMillis();

		openProjectInternal(bundleMakerProject, parse);

		final long duration = System.currentTimeMillis() - start;

		Activator
				.getDefault()
				.getLog()
				.log(new Status(Status.INFO, Activator.PLUGIN_ID,
						"Opening slizaa Project '" + bundleMakerProject.getName()
								+ "' took " + duration + "ms ("
								+ (duration / 1000) + "s)"));

	}

	private static void openProjectInternal(
			final ISlizaaProject bundleMakerProject, boolean parse) {

		// ask user if the perspective should be opened
		// if (!BundleMakerPerspectiveHelper
		// .openBundleMakerPerspectiveIfWanted(BundleMakerPreferenceInitializer.PREF_SWITCH_TO_PERSPECTIVE_ON_PROJECT_OPEN))
		// {
		// // BundleMaker perspective not open; make sure that at least the
		// Project Explorer is visible
		// CommonNavigatorUtils.activateCommonNavigator(CommonNavigatorUtils.PROJECT_EXPLORER_VIEW_ID);
		// }

		// TODO: As an exception?
		// Activator.getDefault().initFilters();

		final long start = System.currentTimeMillis();

		ParseSlizaaProjectRunnable
				.parseProject(bundleMakerProject, parse);
		
		final long duration = System.currentTimeMillis() - start;

		// Activator
		// .getDefault()
		// .getLog()
		// .log(
		// new Status(Status.INFO, Activator.PLUGIN_ID,
		// "Setup and parsing took " + duration + "ms ("
		// + (duration / 1000) + "s)"));
		//
		// List<IProblem> problems =
		// bundleMakerProject.adaptAs(IParserAwareBundleMakerProject.class).getProblems();
		// for (IProblem iProblem : problems) {
		// System.out.println("Problem: " + iProblem);
		// }
		//
		// if (defaultModularizedSystem == null) {
		// return;
		// }

		// Select default modularized system in common navigator
		IWorkbench wb = PlatformUI.getWorkbench();

//		try {
//
//			selectDefaultModularizedSystemArtifact(bundleMakerProject,
//					bundleMakerProject.getAnalysisModel());

			final long fireProjectOpenedStart = System.currentTimeMillis();
			//
			// Events.instance().fireProjectOpened(bundleMakerProject);

			final long fireProjectOpenedStartDuration = System
					.currentTimeMillis() - fireProjectOpenedStart;

			Activator
					.getDefault()
					.getLog()
					.log(new Status(Status.INFO, Activator.PLUGIN_ID,
							"Fire Project open took "
									+ fireProjectOpenedStartDuration + "ms ("
									+ (fireProjectOpenedStartDuration / 1000)
									+ "s)"));

			// Re-activate common navigator make selections via context menu
			// work
			CommonNavigatorUtils
					.activateCommonNavigator(CommonNavigatorUtils.PROJECT_EXPLORER_VIEW_ID);
			// CommonNavigatorUtils.refreshProject(CommonNavigatorUtils.PROJECT_EXPLORER_VIEW_ID,
			// bundleMakerProject);
//		} catch (CoreException ex) {
//			// BundleMakerUiUtils.logError("Error while creating BundleMaker model:"
//			// + ex, ex);
//		}
	}
//
//	private static IAnalysisModelElement selectDefaultModularizedSystemArtifact(
//			ISlizaaProject bundleMakerProject,
//			IAnalysisModelElement defaultModularizedSystemArtifact)
//			throws CoreException {
//
//		IProject eclipseProject = bundleMakerProject.getProject();
//
//		// get the common navigator
//		CommonNavigator commonNavigator = CommonNavigatorUtils
//				.findCommonNavigator(CommonNavigatorUtils.PROJECT_EXPLORER_VIEW_ID);
//		if (commonNavigator == null) {
//			return null;
//		}
//
//		// Expand Eclipse Project project in tree (i.e. make Artifacts node
//		// visible)
//		commonNavigator.getCommonViewer().expandToLevel(eclipseProject, 1);
//
//		// Expand Tree to BundleMaker artifact (no idea why two steps are
//		// neccessary)
//		commonNavigator.getCommonViewer().expandToLevel(
//				defaultModularizedSystemArtifact, 1);
//
//		// Select root artifact in tree
//		StructuredSelection newSelection = new StructuredSelection(
//				defaultModularizedSystemArtifact);
//		commonNavigator.selectReveal(newSelection);
//
//		return defaultModularizedSystemArtifact;
//	}

}
