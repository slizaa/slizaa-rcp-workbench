package org.slizaa.ui.tree;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public interface ISlizaaActionGroupContribution {

  /**
   * <p>
   * </p>
   * 
   * @return the id of the action group
   */
  String getId();

  /**
   * <p>
   * </p>
   *
   * @return
   */
  boolean isSubMenu();
  
  /**
   * <p>
   * </p>
   * 
   * @return the label of the action group
   */
  String getLabel();

  /**
   * <p>
   * </p>
   * 
   * @return the imagePath of the action group
   */
  String getImagePath();

  /**
   * <p>
   * </p>
   *
   * @return
   */
  int getRanking();
  
  /**
   * <p>
   * </p>
   * 
   * @param eObject
   *          the {@link EObject} on which to test if the action can be executed
   * @return <b>true</b> if the action can be executed on the parameter {@code eObject}
   */
  boolean shouldShow(List<?> selectedObjects);

  /**
   * <p>
   * </p>
   *
   * @param eSelectedObject
   * @return
   */
  boolean isEnabled(List<?> selectedObjects);

  /**
   * <p>
   * </p>
   *
   * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
   */
  public static abstract class DefaultActionGroupContribution implements ISlizaaActionGroupContribution {

    /**
     * {@inheritDoc}
     */
    @Override
    public String getImagePath() {
      return null;
    }
    

    @Override
    public boolean isSubMenu() {
      return false;
    }

    @Override
    public String getLabel() {
      return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getRanking() {
      return 0;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean shouldShow(List<?> selectedObjects) {
      return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEnabled(List<?> selectedObjects) {
      return true;
    }
  }
}
