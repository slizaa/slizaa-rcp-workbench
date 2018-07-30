package org.slizaa.ui.tree.internal.menu;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.osgi.framework.FrameworkUtil;
import org.slizaa.ui.tree.ISlizaaActionContribution;
import org.slizaa.ui.tree.ISlizaaActionContributionProvider;
import org.slizaa.ui.tree.ISlizaaActionGroupContribution;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * <p>
 * https://wiki.eclipse.org/FAQ_How_do_I_build_menus_and_toolbars_programmatically%3F
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class SlizaaTreeMenuBuilder {

  /** - */
  private TreeViewer                        _treeViewer;

  /** - */
  private MenuManager                       _menuManager;

  /** - */
  private ISlizaaActionContributionProvider _slizaaActionContributionProvider;

  /** - */
  private Supplier<IEclipseContext>         _contextSupplier;

  /** - */
  private List<?>                           _currentObjectSelection;

  /**
   * <p>
   * Creates a new instance of type {@link SlizaaTreeMenuBuilder}.
   * </p>
   *
   * @param treeViewer
   */
  public SlizaaTreeMenuBuilder(TreeViewer treeViewer, ISlizaaActionContributionProvider contributionProvider,
      Supplier<IEclipseContext> contextSupplier) {
    this._treeViewer = checkNotNull(treeViewer);
    this._slizaaActionContributionProvider = checkNotNull(contributionProvider);
    this._contextSupplier = checkNotNull(contextSupplier);
  }

  /**
   * <p>
   * </p>
   *
   * @param menuManager
   */
  public void populateMenu() {

    this._menuManager = new MenuManager();
    this._menuManager.setRemoveAllWhenShown(true);

    // the menu listener creates the menu on demand
    this._menuManager.addMenuListener(menuManager -> {

      if (SlizaaTreeMenuBuilder.this._treeViewer.getSelection().isEmpty()) {
        return;
      }
      if (SlizaaTreeMenuBuilder.this._treeViewer.getSelection() instanceof IStructuredSelection) {

        SlizaaTreeMenuBuilder.this._currentObjectSelection = ((IStructuredSelection) SlizaaTreeMenuBuilder.this._treeViewer
            .getSelection()).toList();

        SlizaaTreeMenuGroup rootMenuGroup = computeInternalSlizaaMenuModel();

        populateMenuManager(SlizaaTreeMenuBuilder.this._menuManager, rootMenuGroup, null);
      }
    });

    // return the result
    this._treeViewer.getControl().setMenu(this._menuManager.createContextMenu(this._treeViewer.getControl()));
  }

  /**
   * <p>
   * </p>
   *
   * @param menuManager
   * @param menuGroup
   * @param eSelectedObject
   */
  private void populateMenuManager(MenuManager menuManager, SlizaaTreeMenuGroup menuGroup, String currentGroup) {

    //
    Collections.sort(menuGroup.getMenuEntries(), (a, b) -> a.ranking() - b.ranking());

    //
    for (ISlizaaTreeMenuPart menuPart : menuGroup.getMenuEntries()) {

      if (menuPart instanceof SlizaaTreeMenuEntry) {
        SlizaaTreeMenuEntry menuEntry = (SlizaaTreeMenuEntry) menuPart;
        //
        if (currentGroup == null) {
          menuManager.add(wrapActionContribution(menuEntry.getActionContribution()));
        }
        //
        else {
          menuManager.appendToGroup(currentGroup, wrapActionContribution(menuEntry.getActionContribution()));
        }
      }
      //
      else if (menuPart instanceof SlizaaTreeMenuGroup) {

        SlizaaTreeMenuGroup group = (SlizaaTreeMenuGroup) menuPart;

        //
        if (group.isSubMenu()) {

          MenuManager subMenuManager = new MenuManager(group.getActionGroupContribution().getLabel(),
              group.getActionGroupContribution().getId());
          //
          if (currentGroup == null) {
            menuManager.add(subMenuManager);
          }
          //
          else {
            menuManager.appendToGroup(currentGroup, subMenuManager);
          }
          populateMenuManager(subMenuManager, group, null);
        }

        //
        else {

          //
          if (currentGroup == null) {
            menuManager.add(new GroupMarker(group.getId()));
          }
          //
          else {
            menuManager.appendToGroup(currentGroup, new GroupMarker(group.getId()));
          }

          //
          populateMenuManager(menuManager, group, group.getId());
        }
      }
    }
  }

  /**
   * <p>
   * </p>
   *
   * @param menuManager
   */
  private SlizaaTreeMenuGroup computeInternalSlizaaMenuModel() {

    //
    SlizaaTreeMenuGroup menuGroup = new SlizaaTreeMenuGroup(SlizaaTreeMenuBuilder.class.getName() + "#DEFAULT");

    //
    LoadingCache<String, SlizaaTreeMenuGroup> menuGroupMap = CacheBuilder.newBuilder()
        .build(new CacheLoader<String, SlizaaTreeMenuGroup>() {
          @Override
          public SlizaaTreeMenuGroup load(String id) {
            return new SlizaaTreeMenuGroup(id);
          }
        });

    // TODO: HIERARCHIES
    for (ISlizaaActionGroupContribution actionGroupContribution : this._slizaaActionContributionProvider
        .getActionGroupContributions()) {

      if (actionGroupContribution.shouldShow(this._currentObjectSelection)) {
        SlizaaTreeMenuGroup group = menuGroupMap.getUnchecked(actionGroupContribution.getId());
        group.setActionGroupContribution(actionGroupContribution);
        menuGroup.getMenuEntries().add(group);
      }
    }

    //
    for (ISlizaaActionContribution slizaaActionContribution : this._slizaaActionContributionProvider
        .getActionContributions()) {
      if (slizaaActionContribution.shouldShow(this._currentObjectSelection, this._treeViewer)) {
        if (slizaaActionContribution.getParentGroupId() != null) {
          SlizaaTreeMenuGroup group = menuGroupMap.getIfPresent(slizaaActionContribution.getParentGroupId());
          if (group != null) {
            group.getMenuEntries().add(new SlizaaTreeMenuEntry(slizaaActionContribution));
          }
        } else {
          menuGroup.getMenuEntries().add(new SlizaaTreeMenuEntry(slizaaActionContribution));
        }
      }
    }

    //
    return menuGroup;
  }

  /**
   * <p>
   * </p>
   *
   * @param eSelectedObject
   * @param slizaaTreeAction
   *
   * @return
   */
  private Action wrapActionContribution(final ISlizaaActionContribution slizaaTreeAction) {

    // set enabled
    ContextInjectionFactory.inject(slizaaTreeAction, this._contextSupplier.get());

    //
    final Action newAction = new Action() {
      @Override
      public void run() {
        ContextInjectionFactory.inject(slizaaTreeAction, SlizaaTreeMenuBuilder.this._contextSupplier.get());
        slizaaTreeAction.execute(SlizaaTreeMenuBuilder.this._currentObjectSelection,
            SlizaaTreeMenuBuilder.this._treeViewer);
      }
    };

    // set action image
    if (slizaaTreeAction.getImagePath(this._currentObjectSelection) != null) {
      newAction.setImageDescriptor(ImageDescriptor.createFromURL(FrameworkUtil.getBundle(slizaaTreeAction.getClass())
          .getResource(slizaaTreeAction.getImagePath(this._currentObjectSelection))));

    }

    //
    newAction.setEnabled(slizaaTreeAction.isEnabled(this._currentObjectSelection, this._treeViewer));

    // set action text
    newAction.setText(slizaaTreeAction.getLabel(this._currentObjectSelection));

    // return the result
    return newAction;
  }
}
