package org.slizaa.rcp.workbench.core.model.impl;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectEList;

public class EObjectEListWithoutUniqueCheck<T> extends EObjectEList<T> {

  private static final long serialVersionUID = 1L;

  public EObjectEListWithoutUniqueCheck(Class<?> dataClass, InternalEObject owner, int featureID) {
    super(dataClass, owner, featureID);
  }

  @Override
  protected boolean isUnique() {
    return false;
  }
}