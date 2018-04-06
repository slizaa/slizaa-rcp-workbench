package org.slizaa.rcp.workbench.mappings;

import java.util.function.Function;

import org.slizaa.hierarchicalgraph.HGNode;
import org.slizaa.hierarchicalgraph.graphdb.mapping.spi.ILabelDefinitionProvider;
import org.slizaa.hierarchicalgraph.graphdb.mapping.spi.labelprovider.AbstractLabelDefinitionProvider;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class JType_LabelProvider extends AbstractLabelDefinitionProvider implements ILabelDefinitionProvider {

  /** - */
  private boolean                     _showFullyQualifiedName;

  /** - */
  private final MethodSignatureParser _methodSignatureParser;

  /**
   * <p>
   * </p>
   *
   * @param showFullyQualifiedName
   */
  public JType_LabelProvider(boolean showFullyQualifiedName) {
    this._showFullyQualifiedName = showFullyQualifiedName;

    //
    _methodSignatureParser = new MethodSignatureParser();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected LabelDefinitionProcessor createLabelDefinitionProcessor() {

    // @formatter:off
		return exclusiveChoice().
		    
        // Group
        when(nodeHasLabel("Group")).then(handleGroup()).

		    // Module
				when(nodeHasLabel("Module")).then(handleModule()).

				// Package
				when(nodeHasLabel("Directory")).then(handleDirectory()).

				// Resource
				when(nodeHasLabel("Resource")).then(handleResource()).

				// Type
				when(nodeHasLabel("Type")).then(handleType()).

        // Method
        when(nodeHasLabel("Method")).then(handleMethod()).

        // Field
        when(nodeHasLabel("Field")).then(handleField()).
				
				// all other nodes
				otherwise(setBaseImage(fromClasspath("icons/jar_obj.png")).and(setLabelText(propertyValue("name"))));

		// @formatter:on
  }

  private LabelDefinitionProcessor handleGroup() {
    return setBaseImage(fromClasspath("icons/fldr_obj.png")).and(setLabelText(propertyValue("name")));
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  protected LabelDefinitionProcessor handleModule() {
    return setBaseImage(fromClasspath("icons/jar_obj.png")).and(setLabelText(propertyValue("name")));
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  protected LabelDefinitionProcessor handleDirectory() {

    // @formatter:off
		return exclusiveChoice().

		// Packages
		when(nodeHasLabel("Package")).then(setBaseImage(fromClasspath("icons/package_obj.png"))
				.and(setLabelText(propertyValue(this._showFullyQualifiedName ? "fqn" : "name", str -> str.replace('/', '.'))))).

		// Directories
		otherwise(setBaseImage(fromClasspath("icons/fldr_obj.png")).and(setLabelText(propertyValue(this._showFullyQualifiedName ? "fqn" : "name"))));
		// @formatter:on
  }

  private LabelDefinitionProcessor handleResource() {

    // @formatter:off
		return executeAll(

				exclusiveChoice().when(nodeHasLabel("ClassFile"))
						.then(setBaseImage(fromClasspath("icons/classf_obj.png")))
						.otherwise(setBaseImage(fromClasspath("icons/file_obj.png"))),

				setLabelText(propertyValue("name")));
		// @formatter:on
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  protected LabelDefinitionProcessor handleType() {

    // @formatter:off
		return executeAll(

				setLabelText(propertyValue("name")),

				when(nodeHasProperty("final"))
						.then(setOverlayImage(fromClasspath("icons/class_obj.png"), OverlayPosition.TOP_RIGHT)),

				when(nodeHasLabel("Class")).then(setBaseImage(fromClasspath("icons/class_obj.png"))),

				when(nodeHasLabel("Annotation")).then(setBaseImage(fromClasspath("icons/annotation_obj.png"))),

				when(nodeHasLabel("Enum")).then(setBaseImage(fromClasspath("icons/enum_obj.png"))),

				when(nodeHasLabel("Interface")).then(setBaseImage(fromClasspath("icons/int_obj.png"))));
		// @formatter:on
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  protected LabelDefinitionProcessor handleMethod() {

    // @formatter:off
    return executeAll(

        setLabelText(convertMethodSignature(propertyValue("fqn"))),

        when(nodeHasPropertyWithValue("visibility", "public")).then(setBaseImage(fromClasspath("icons/methpub_obj.png"))),

        when(nodeHasPropertyWithValue("visibility", "private")).then(setBaseImage(fromClasspath("icons/methpri_obj.png"))),

        when(nodeHasPropertyWithValue("visibility", "protected")).then(setBaseImage(fromClasspath("icons/methpri_obj.png"))),

        when(nodeHasPropertyWithValue("visibility", "default")).then(setBaseImage(fromClasspath("icons/methdef_obj.png"))));
    // @formatter:on
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  protected LabelDefinitionProcessor handleField() {

    // @formatter:off
    return executeAll(

        setLabelText(propertyValue("fqn")),

        when(nodeHasPropertyWithValue("visibility", "public")).then(setBaseImage(fromClasspath("icons/field_public_obj.png"))),

        when(nodeHasPropertyWithValue("visibility", "private")).then(setBaseImage(fromClasspath("icons/field_private_obj.png"))),

        when(nodeHasPropertyWithValue("visibility", "protected")).then(setBaseImage(fromClasspath("icons/field_protected_obj.png"))),

        when(nodeHasPropertyWithValue("visibility", "default")).then(setBaseImage(fromClasspath("icons/field_default_obj.png"))));
    // @formatter:on
  }
  
  /**
   * <p>
   * </p>
   *
   * @param key
   * @return
   */
  protected Function<HGNode, String> convertMethodSignature(Function<HGNode, String> function) {
    return (node) -> _methodSignatureParser.parse(function.apply(node));
  }
}
