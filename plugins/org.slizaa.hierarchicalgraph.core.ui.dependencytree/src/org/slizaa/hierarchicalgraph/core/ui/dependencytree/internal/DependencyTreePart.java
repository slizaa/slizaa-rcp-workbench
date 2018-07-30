/*******************************************************************************
 * Copyright (c) Gerd W�therich 2012-2016. All rights reserved. This program and the accompanying materials are made
 * available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors: Gerd W�therich (gerd@gerd-wuetherich.de) - initial API and implementation
 ******************************************************************************/
package org.slizaa.hierarchicalgraph.core.ui.dependencytree.internal;

import java.util.Collections;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.widgets.Composite;
import org.slizaa.hierarchicalgraph.core.model.HGCoreDependency;
import org.slizaa.hierarchicalgraph.core.selections.DependencySelection;
import org.slizaa.hierarchicalgraph.core.selections.DependencySelections;
import org.slizaa.ui.shared.ILifecycleParticipator;

import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class DependencyTreePart {

  /** - */
  public static final String      INJECTOR_KEY = "org.slizaa.hierarchicalgraph.core.ui.dependencytree.Injector";

  /** - */
  public static final String      ID           = DependencyTreePart.class.getName();

  /** - */
  private DependencyTreeComposite _composite;

  /**
   * <p>
   * </p>
   *
   * @param parent
   * @param injector
   */
  @PostConstruct
  public void createComposite(Composite parent, @Named(INJECTOR_KEY) Injector injector) {

    // set GridLayout with no margins and default dialog spacing.
    GridLayoutFactory.fillDefaults().applyTo(parent);

    //
    this._composite = new DependencyTreeComposite(parent);
    injector.injectMembers(this._composite);
    this._composite.init();
    GridDataFactory.fillDefaults().grab(true, true).applyTo(this._composite);

    // @formatter:off
    injector.getInstance(Key.get(new TypeLiteral<ILifecycleParticipator<DependencyTreePart>>() {})).postCreate(this);
    // @formatter:on
  }

  /**
   * <p>
   * </p>
   *
   * @param injector
   */
  @PreDestroy
  public final void disposePart(@Named(INJECTOR_KEY) Injector injector) {

    // @formatter:off
    injector.getInstance(Key.get(new TypeLiteral<ILifecycleParticipator<DependencyTreePart>>() {})).preDestroy(this);
    // @formatter:on
  }

  /**
   * <p>
   * </p>
   *
   * @param oldValue
   * @param newValue
   */
  public void handleMainDependencySelectionChanged(DependencySelection oldValue, DependencySelection newValue) {

    // get the core dependencies
    Set<HGCoreDependency> coreDependencies = newValue != null
        ? DependencySelections.getCoreDependencies(newValue.getDependencies())
        : Collections.emptySet();

    //
    if (this._composite != null && !this._composite.isDisposed()) {
      this._composite.setDependencies(coreDependencies);
    }
  }
}
