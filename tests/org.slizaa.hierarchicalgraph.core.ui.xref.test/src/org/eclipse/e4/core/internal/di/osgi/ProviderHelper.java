package org.eclipse.e4.core.internal.di.osgi;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.e4.core.di.suppliers.ExtendedObjectSupplier;
import org.eclipse.e4.core.di.suppliers.PrimaryObjectSupplier;

/**
 * Workaround
 */
public class ProviderHelper {

  static protected Map<String, ExtendedObjectSupplier> extendedSuppliers = new HashMap<>();

  static public ExtendedObjectSupplier findProvider(String qualifier, PrimaryObjectSupplier objectSupplier) {
    return null;
  }
}
