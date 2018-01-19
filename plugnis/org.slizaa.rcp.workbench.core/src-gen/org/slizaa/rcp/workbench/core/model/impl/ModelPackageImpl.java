/**
 */
package org.slizaa.rcp.workbench.core.model.impl;

import org.eclipse.core.resources.IProject;

import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.slizaa.hierarchicalgraph.HierarchicalgraphPackage;

import org.slizaa.neo4j.dbadapter.DbAdapterPackage;

import org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType;
import org.slizaa.rcp.workbench.core.model.ModelFactory;
import org.slizaa.rcp.workbench.core.model.ModelPackage;
import org.slizaa.rcp.workbench.core.model.SlizaaProject;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationItemModel;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationProblem;
import org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension;
import org.slizaa.scanner.core.api.graphdb.IGraphDb;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelPackageImpl extends EPackageImpl implements ModelPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass slizaaProjectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass slizaaProjectConfigurationModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass slizaaProjectConfigurationItemModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass slizaaProjectConfigurationProblemEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass slizaaProjectExtensionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractUserDefinedTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType iProgressMonitorEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType iProjectEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType iGraphDbEDataType = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.slizaa.rcp.workbench.core.model.ModelPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ModelPackageImpl() {
    super(eNS_URI, ModelFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link ModelPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ModelPackage init() {
    if (isInited) return (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

    // Obtain or create and register package
    ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModelPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    HierarchicalgraphPackage.eINSTANCE.eClass();
    DbAdapterPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theModelPackage.createPackageContents();

    // Initialize created meta-data
    theModelPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theModelPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, theModelPackage);
    return theModelPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSlizaaProject() {
    return slizaaProjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSlizaaProject_Project() {
    return (EAttribute)slizaaProjectEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSlizaaProject_Configuration() {
    return (EReference)slizaaProjectEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSlizaaProject_ProjectExtensions() {
    return (EReference)slizaaProjectEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSlizaaProject_GraphDatabaseInstance() {
    return (EAttribute)slizaaProjectEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSlizaaProject_BoltClient() {
    return (EReference)slizaaProjectEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSlizaaProject_HierachicalGraph() {
    return (EReference)slizaaProjectEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getSlizaaProject__CleanBuild() {
    return slizaaProjectEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getSlizaaProject__Parse__IProgressMonitor() {
    return slizaaProjectEClass.getEOperations().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getSlizaaProject__StartAndConnectDatabase__IProgressMonitor() {
    return slizaaProjectEClass.getEOperations().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getSlizaaProject__Dispose() {
    return slizaaProjectEClass.getEOperations().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSlizaaProjectConfigurationModel() {
    return slizaaProjectConfigurationModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSlizaaProjectConfigurationModel_Problems() {
    return (EReference)slizaaProjectConfigurationModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSlizaaProjectConfigurationModel_ConfigurationItems() {
    return (EReference)slizaaProjectConfigurationModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getSlizaaProjectConfigurationModel__CreateNewConfigurationItemInstance__Class() {
    return slizaaProjectConfigurationModelEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSlizaaProjectConfigurationItemModel() {
    return slizaaProjectConfigurationItemModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSlizaaProjectConfigurationItemModel_Type() {
    return (EAttribute)slizaaProjectConfigurationItemModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSlizaaProjectConfigurationItemModel_MethodName() {
    return (EAttribute)slizaaProjectConfigurationItemModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSlizaaProjectConfigurationProblem() {
    return slizaaProjectConfigurationProblemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSlizaaProjectConfigurationProblem_Message() {
    return (EAttribute)slizaaProjectConfigurationProblemEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSlizaaProjectConfigurationProblem_CharStart() {
    return (EAttribute)slizaaProjectConfigurationProblemEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSlizaaProjectConfigurationProblem_CharEnd() {
    return (EAttribute)slizaaProjectConfigurationProblemEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSlizaaProjectExtension() {
    return slizaaProjectExtensionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSlizaaProjectExtension_ExtensionType() {
    return (EAttribute)slizaaProjectExtensionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getSlizaaProjectExtension__CreateNewInstance__Class() {
    return slizaaProjectExtensionEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractUserDefinedType() {
    return abstractUserDefinedTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractUserDefinedType_Project() {
    return (EAttribute)abstractUserDefinedTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractUserDefinedType_ResourcePath() {
    return (EAttribute)abstractUserDefinedTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractUserDefinedType_TypeName() {
    return (EAttribute)abstractUserDefinedTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getIProgressMonitor() {
    return iProgressMonitorEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getIProject() {
    return iProjectEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getIGraphDb() {
    return iGraphDbEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelFactory getModelFactory() {
    return (ModelFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents() {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    slizaaProjectEClass = createEClass(SLIZAA_PROJECT);
    createEAttribute(slizaaProjectEClass, SLIZAA_PROJECT__PROJECT);
    createEReference(slizaaProjectEClass, SLIZAA_PROJECT__CONFIGURATION);
    createEReference(slizaaProjectEClass, SLIZAA_PROJECT__PROJECT_EXTENSIONS);
    createEAttribute(slizaaProjectEClass, SLIZAA_PROJECT__GRAPH_DATABASE_INSTANCE);
    createEReference(slizaaProjectEClass, SLIZAA_PROJECT__BOLT_CLIENT);
    createEReference(slizaaProjectEClass, SLIZAA_PROJECT__HIERACHICAL_GRAPH);
    createEOperation(slizaaProjectEClass, SLIZAA_PROJECT___CLEAN_BUILD);
    createEOperation(slizaaProjectEClass, SLIZAA_PROJECT___PARSE__IPROGRESSMONITOR);
    createEOperation(slizaaProjectEClass, SLIZAA_PROJECT___START_AND_CONNECT_DATABASE__IPROGRESSMONITOR);
    createEOperation(slizaaProjectEClass, SLIZAA_PROJECT___DISPOSE);

    slizaaProjectConfigurationModelEClass = createEClass(SLIZAA_PROJECT_CONFIGURATION_MODEL);
    createEReference(slizaaProjectConfigurationModelEClass, SLIZAA_PROJECT_CONFIGURATION_MODEL__PROBLEMS);
    createEReference(slizaaProjectConfigurationModelEClass, SLIZAA_PROJECT_CONFIGURATION_MODEL__CONFIGURATION_ITEMS);
    createEOperation(slizaaProjectConfigurationModelEClass, SLIZAA_PROJECT_CONFIGURATION_MODEL___CREATE_NEW_CONFIGURATION_ITEM_INSTANCE__CLASS);

    slizaaProjectConfigurationItemModelEClass = createEClass(SLIZAA_PROJECT_CONFIGURATION_ITEM_MODEL);
    createEAttribute(slizaaProjectConfigurationItemModelEClass, SLIZAA_PROJECT_CONFIGURATION_ITEM_MODEL__TYPE);
    createEAttribute(slizaaProjectConfigurationItemModelEClass, SLIZAA_PROJECT_CONFIGURATION_ITEM_MODEL__METHOD_NAME);

    slizaaProjectConfigurationProblemEClass = createEClass(SLIZAA_PROJECT_CONFIGURATION_PROBLEM);
    createEAttribute(slizaaProjectConfigurationProblemEClass, SLIZAA_PROJECT_CONFIGURATION_PROBLEM__MESSAGE);
    createEAttribute(slizaaProjectConfigurationProblemEClass, SLIZAA_PROJECT_CONFIGURATION_PROBLEM__CHAR_START);
    createEAttribute(slizaaProjectConfigurationProblemEClass, SLIZAA_PROJECT_CONFIGURATION_PROBLEM__CHAR_END);

    slizaaProjectExtensionEClass = createEClass(SLIZAA_PROJECT_EXTENSION);
    createEAttribute(slizaaProjectExtensionEClass, SLIZAA_PROJECT_EXTENSION__EXTENSION_TYPE);
    createEOperation(slizaaProjectExtensionEClass, SLIZAA_PROJECT_EXTENSION___CREATE_NEW_INSTANCE__CLASS);

    abstractUserDefinedTypeEClass = createEClass(ABSTRACT_USER_DEFINED_TYPE);
    createEAttribute(abstractUserDefinedTypeEClass, ABSTRACT_USER_DEFINED_TYPE__PROJECT);
    createEAttribute(abstractUserDefinedTypeEClass, ABSTRACT_USER_DEFINED_TYPE__RESOURCE_PATH);
    createEAttribute(abstractUserDefinedTypeEClass, ABSTRACT_USER_DEFINED_TYPE__TYPE_NAME);

    // Create data types
    iProgressMonitorEDataType = createEDataType(IPROGRESS_MONITOR);
    iProjectEDataType = createEDataType(IPROJECT);
    iGraphDbEDataType = createEDataType(IGRAPH_DB);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents() {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    DbAdapterPackage theDbAdapterPackage = (DbAdapterPackage)EPackage.Registry.INSTANCE.getEPackage(DbAdapterPackage.eNS_URI);
    HierarchicalgraphPackage theHierarchicalgraphPackage = (HierarchicalgraphPackage)EPackage.Registry.INSTANCE.getEPackage(HierarchicalgraphPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    slizaaProjectConfigurationModelEClass.getESuperTypes().add(this.getAbstractUserDefinedType());
    slizaaProjectExtensionEClass.getESuperTypes().add(this.getAbstractUserDefinedType());

    // Initialize classes, features, and operations; add parameters
    initEClass(slizaaProjectEClass, SlizaaProject.class, "SlizaaProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSlizaaProject_Project(), this.getIProject(), "project", null, 0, 1, SlizaaProject.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSlizaaProject_Configuration(), this.getSlizaaProjectConfigurationModel(), null, "configuration", null, 0, 1, SlizaaProject.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSlizaaProject_ProjectExtensions(), this.getSlizaaProjectExtension(), null, "projectExtensions", null, 0, -1, SlizaaProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSlizaaProject_GraphDatabaseInstance(), this.getIGraphDb(), "graphDatabaseInstance", null, 0, 1, SlizaaProject.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSlizaaProject_BoltClient(), theDbAdapterPackage.getNeo4jClient(), null, "boltClient", null, 0, 1, SlizaaProject.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSlizaaProject_HierachicalGraph(), theHierarchicalgraphPackage.getHGRootNode(), null, "hierachicalGraph", null, 0, 1, SlizaaProject.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEOperation(getSlizaaProject__CleanBuild(), null, "cleanBuild", 0, 1, IS_UNIQUE, IS_ORDERED);

    EOperation op = initEOperation(getSlizaaProject__Parse__IProgressMonitor(), null, "parse", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getIProgressMonitor(), "monitor", 0, 1, IS_UNIQUE, IS_ORDERED);

    op = initEOperation(getSlizaaProject__StartAndConnectDatabase__IProgressMonitor(), null, "startAndConnectDatabase", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getIProgressMonitor(), "monitor", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getSlizaaProject__Dispose(), null, "dispose", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(slizaaProjectConfigurationModelEClass, SlizaaProjectConfigurationModel.class, "SlizaaProjectConfigurationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSlizaaProjectConfigurationModel_Problems(), this.getSlizaaProjectConfigurationProblem(), null, "problems", null, 0, -1, SlizaaProjectConfigurationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSlizaaProjectConfigurationModel_ConfigurationItems(), this.getSlizaaProjectConfigurationItemModel(), null, "configurationItems", null, 0, -1, SlizaaProjectConfigurationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    op = initEOperation(getSlizaaProjectConfigurationModel__CreateNewConfigurationItemInstance__Class(), null, "createNewConfigurationItemInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
    ETypeParameter t1 = addETypeParameter(op, "T");
    EGenericType g1 = createEGenericType(ecorePackage.getEJavaClass());
    EGenericType g2 = createEGenericType(t1);
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "type", 0, 1, IS_UNIQUE, IS_ORDERED);
    g1 = createEGenericType(t1);
    initEOperation(op, g1);

    initEClass(slizaaProjectConfigurationItemModelEClass, SlizaaProjectConfigurationItemModel.class, "SlizaaProjectConfigurationItemModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSlizaaProjectConfigurationItemModel_Type(), ecorePackage.getEString(), "type", null, 0, 1, SlizaaProjectConfigurationItemModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSlizaaProjectConfigurationItemModel_MethodName(), ecorePackage.getEString(), "methodName", null, 0, 1, SlizaaProjectConfigurationItemModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(slizaaProjectConfigurationProblemEClass, SlizaaProjectConfigurationProblem.class, "SlizaaProjectConfigurationProblem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSlizaaProjectConfigurationProblem_Message(), ecorePackage.getEString(), "message", null, 0, 1, SlizaaProjectConfigurationProblem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSlizaaProjectConfigurationProblem_CharStart(), ecorePackage.getEInt(), "charStart", null, 0, 1, SlizaaProjectConfigurationProblem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSlizaaProjectConfigurationProblem_CharEnd(), ecorePackage.getEInt(), "charEnd", null, 0, 1, SlizaaProjectConfigurationProblem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(slizaaProjectExtensionEClass, SlizaaProjectExtension.class, "SlizaaProjectExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSlizaaProjectExtension_ExtensionType(), ecorePackage.getEString(), "extensionType", null, 0, 1, SlizaaProjectExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    op = initEOperation(getSlizaaProjectExtension__CreateNewInstance__Class(), null, "createNewInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
    t1 = addETypeParameter(op, "T");
    g1 = createEGenericType(ecorePackage.getEJavaClass());
    g2 = createEGenericType(t1);
    g1.getETypeArguments().add(g2);
    addEParameter(op, g1, "type", 0, 1, IS_UNIQUE, IS_ORDERED);
    g1 = createEGenericType(t1);
    initEOperation(op, g1);

    initEClass(abstractUserDefinedTypeEClass, AbstractUserDefinedType.class, "AbstractUserDefinedType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAbstractUserDefinedType_Project(), this.getIProject(), "project", null, 0, 1, AbstractUserDefinedType.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAbstractUserDefinedType_ResourcePath(), ecorePackage.getEString(), "resourcePath", null, 0, 1, AbstractUserDefinedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAbstractUserDefinedType_TypeName(), ecorePackage.getEString(), "typeName", null, 0, 1, AbstractUserDefinedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize data types
    initEDataType(iProgressMonitorEDataType, IProgressMonitor.class, "IProgressMonitor", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(iProjectEDataType, IProject.class, "IProject", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(iGraphDbEDataType, IGraphDb.class, "IGraphDb", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //ModelPackageImpl
