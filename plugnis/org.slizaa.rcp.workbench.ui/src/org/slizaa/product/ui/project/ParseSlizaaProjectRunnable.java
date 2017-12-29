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
package org.slizaa.product.ui.project;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.PlatformUI;
import org.slizaa.rcp.workbench.core.ISlizaaProject;

/**
 * A {@link IRunnableWithProgress} that initializes and (re-parses) a
 * bundlemaker project
 * 
 * @see SlizaaProjectOpener for a convienence class that not only parses
 *      the project but also runs all required actions for the UI handling
 * 
 * @author Nils Hartmann (nils@nilshartmann.net)
 * 
 */
public class ParseSlizaaProjectRunnable implements IRunnableWithProgress {

	private final ISlizaaProject _bundleMakerProject;
	
	private final boolean _parse;

	/**
	 * @param bundleMakerProject
	 */
	public ParseSlizaaProjectRunnable(
			ISlizaaProject bundleMakerProject, boolean parse) {
		_bundleMakerProject = bundleMakerProject;
		_parse = parse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core
	 * .runtime.IProgressMonitor)
	 */
	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException,
			InterruptedException {
		try {
			_bundleMakerProject.initialize(monitor);

//			// Check if initializing was successful
//			SlizaaProjectState state = _bundleMakerProject.getState();
//			if (state == SlizaaProjectState.INITIALIZED
//					| state == SlizaaProjectState.READY) {

				// parse the project
				if (_parse) {
					_bundleMakerProject.parseAndOpen(monitor);
				} else {
					_bundleMakerProject.startAndConnectGraphDatabase(monitor);
				}

//			} else {
//				return;
//			}

			// _defaultModularizedSystem =
			// getDefaultModularizedSystemArtifact(_bundleMakerProject,
			// monitor);

		} catch (Exception ex) {
			// Forward exception
			throw new InvocationTargetException(ex);
		}
	}

	/**
	 * Initialize and parse the specified project
	 * 
	 * <p>
	 * Errors happening during the operation are reported via Error Log and an
	 * Error Dialog
	 * 
	 * @param bundleMakerProject
	 * @return true if the project has been successfully opened
	 */
	public static void parseProject(ISlizaaProject bundleMakerProject,
			boolean parse) {
		// Create runnable
		ParseSlizaaProjectRunnable runnable = new ParseSlizaaProjectRunnable(
				bundleMakerProject, parse);

		// Execute runnable via IProgressService
		try {
			PlatformUI.getWorkbench().getProgressService()
					.busyCursorWhile(runnable);
		} catch (InvocationTargetException ex) {
			// Report Error to error log
			Throwable cause = ex.getCause();

			cause.printStackTrace();

			// BundleMakerUiUtils.logError("Error while parsing project: " +
			// cause, cause);
			//
			// // Report error to user
			// Throwable throwable =
			// ErrorDialogUtil.getNestedNonCoreThrowable(cause);
			// ErrorDialogUtil.errorDialogWithStackTrace("Error while parsing project",
			// throwable.getMessage(),
			// Activator.PLUGIN_ID, throwable);

		} catch (InterruptedException ex) {
			// ignore. User has canceled the operation
		}

		// // Refresh navigator tree
		// BundleMakerUiUtils.refreshProjectExplorer();
		//
		// return runnable._defaultModularizedSystem;
	}

	// /**
	// * <p>
	// * </p>
	// *
	// * @param bundleMakerProject
	// * @param monitor
	// * @return
	// * @throws CoreException
	// */
	// protected static IBundleMakerArtifact
	// getDefaultModularizedSystemArtifact(
	// IParserAwareBundleMakerProject bundleMakerProject, IProgressMonitor
	// monitor) throws CoreException {
	//
	// if (monitor != null) {
	// monitor.subTask("Creating default Analysis Model");
	// }
	//
	// IArtifactModelConfigurationProvider artifactModelConfigurationProvider =
	// Activator.getDefault()
	// .getArtifactModelConfigurationProvider();
	//
	// IModularizedSystem modularizedSystem =
	// bundleMakerProject.getModularizedSystemWorkingCopy();
	//
	// //
	// return AnalysisCore.getAnalysisModel(modularizedSystem,
	// artifactModelConfigurationProvider.getArtifactModelConfiguration(),
	// monitor);
	// }

}
