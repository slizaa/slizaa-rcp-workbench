package org.slizaa.neo4j.ui.cypherview.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.EContextService;
import org.eclipse.e4.ui.workbench.modeling.IPartListener;
import org.slizaa.neo4j.ui.cypherview.CypherViewPart;
import org.slizaa.neo4j.ui.cypherview.internal.osgi.CypherViewActivator;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public final class CypherViewPartListener implements IPartListener {

  /** - */
  private final CypherViewPart  _cypherViewPart;

  /** - */
  private final EContextService _contextService;

  /**
   * <p>
   * Creates a new instance of type {@link CypherViewPartListener}.
   * </p>
   *
   * @param cypherViewPart
   * @param contextService
   */
  public CypherViewPartListener(CypherViewPart cypherViewPart, EContextService contextService) {
    this._cypherViewPart = checkNotNull(cypherViewPart);
    this._contextService = checkNotNull(contextService);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void partBroughtToTop(MPart part) {
    CypherViewActivator.getInstance().setCurrentCypherViewPart(this._cypherViewPart);
    this._contextService.activateContext("org.slizaa.neo4j.ui.cypherview.context");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void partHidden(MPart part) {
    this._contextService.deactivateContext("org.slizaa.neo4j.ui.cypherview.context");
    CypherViewActivator.getInstance().setCurrentCypherViewPart(null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void partActivated(MPart part) {
    CypherViewActivator.getInstance().setCurrentCypherViewPart(this._cypherViewPart);
    this._contextService.activateContext("org.slizaa.neo4j.ui.cypherview.context");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void partDeactivated(MPart part) {
    this._contextService.deactivateContext("org.slizaa.neo4j.ui.cypherview.context");
    CypherViewActivator.getInstance().setCurrentCypherViewPart(null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void partVisible(MPart part) {
    //
  }
}