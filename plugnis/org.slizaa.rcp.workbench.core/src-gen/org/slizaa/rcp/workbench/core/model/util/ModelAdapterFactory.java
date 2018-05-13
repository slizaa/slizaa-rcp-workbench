/**
 */
package org.slizaa.rcp.workbench.core.model.util;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import org.slizaa.rcp.workbench.core.model.*;

import org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.slizaa.rcp.workbench.core.model.impl.ModelPackageImpl
 * @generated
 */
public class ModelAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ModelPackageImpl modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = ModelPackageImpl.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object) {
    if (object == modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelSwitch<Adapter> modelSwitch =
    new ModelSwitch<Adapter>() {
      @Override
      public Adapter caseSlizaaProject(SlizaaProject object) {
        return createSlizaaProjectAdapter();
      }
      @Override
      public Adapter caseAbstractUserDefinedType(AbstractUserDefinedType object) {
        return createAbstractUserDefinedTypeAdapter();
      }
      @Override
      public Adapter caseSlizaaProjectConfigurationModel(SlizaaProjectConfigurationModel object) {
        return createSlizaaProjectConfigurationModelAdapter();
      }
      @Override
      public Adapter caseProblem(Problem object) {
        return createProblemAdapter();
      }
      @Override
      public Adapter caseSlizaaProjectExtension(SlizaaProjectExtension object) {
        return createSlizaaProjectExtensionAdapter();
      }
      @Override
      public Adapter caseAnnotationTypeToSlizaaProjectExtensionMap(Map.Entry<Class<?>, List<SlizaaProjectExtension>> object) {
        return createAnnotationTypeToSlizaaProjectExtensionMapAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object) {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target) {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.slizaa.rcp.workbench.core.model.SlizaaProject <em>Slizaa Project</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProject
   * @generated
   */
  public Adapter createSlizaaProjectAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType <em>Abstract User Defined Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.slizaa.rcp.workbench.core.model.AbstractUserDefinedType
   * @generated
   */
  public Adapter createAbstractUserDefinedTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel <em>Slizaa Project Configuration Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectConfigurationModel
   * @generated
   */
  public Adapter createSlizaaProjectConfigurationModelAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.slizaa.rcp.workbench.core.model.Problem <em>Problem</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.slizaa.rcp.workbench.core.model.Problem
   * @generated
   */
  public Adapter createProblemAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension <em>Slizaa Project Extension</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.slizaa.rcp.workbench.core.model.SlizaaProjectExtension
   * @generated
   */
  public Adapter createSlizaaProjectExtensionAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Annotation Type To Slizaa Project Extension Map</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see java.util.Map.Entry
   * @generated
   */
  public Adapter createAnnotationTypeToSlizaaProjectExtensionMapAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} //ModelAdapterFactory
