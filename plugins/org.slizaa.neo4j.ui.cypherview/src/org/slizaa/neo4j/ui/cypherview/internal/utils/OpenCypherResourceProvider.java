package org.slizaa.neo4j.ui.cypherview.internal.utils;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
@SuppressWarnings("restriction")
public class OpenCypherResourceProvider implements IEditedResourceProvider {

  /** - */
  @Inject
  private IResourceSetProvider  resourceSetProvider;

  /** - */
  @Inject
  private FileExtensionProvider fileExtensionProvider;

  /**
   * {@inheritDoc}
   */
  @Override
  public XtextResource createResource() {
    ResourceSet resourceSet = resourceSetProvider.get(null);
    URI uri = URI.createURI("example/test1." + fileExtensionProvider.getPrimaryFileExtension());
    XtextResource result = (XtextResource) resourceSet.createResource(uri);
    resourceSet.getResources().add(result);
    return result;
  }
}