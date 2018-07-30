package org.slizaa.ui.shared.context;

import static com.google.common.base.Preconditions.checkNotNull;

import org.eclipse.emf.ecore.EObject;

public class RootObject {

  private final EObject modelElement;

  /**
   * Default constructor.
   * 
   * @param modelElement
   *          the wrapped root object
   */
  public RootObject(EObject modelElement) {
    this.modelElement = checkNotNull(modelElement);
  }

  /**
   * @return the root object
   */
  public EObject getRoot() {
    return modelElement;
  }

}