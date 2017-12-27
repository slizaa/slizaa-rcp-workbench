package org.slizaa.jqassistant.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.MPlaceholder;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PerspectiveAdapter;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class SlizaaPerspectiveAdapter extends PerspectiveAdapter {

  /** - */
  private EModelService                                      _modelService;

  /** - */
  private MApplication                                       _application;

  /** - */
  private MPerspective                                       _currentPerspective;

  /** - */
  private EPartService                                       _partService;

  /** - */
  private LoadingCache<String, Map<String, PartStateHolder>> _view2Perspective;

  /**
   * <p>
   * Creates a new instance of type {@link SlizaaPerspectiveAdapter}.
   * </p>
   *
   * @param modelService
   * @param application
   */
  public SlizaaPerspectiveAdapter(EModelService modelService, MApplication application, EPartService partService) {
    this._modelService = checkNotNull(modelService);
    this._application = checkNotNull(application);
    this._partService = checkNotNull(partService);

    //
    _view2Perspective = CacheBuilder.newBuilder().build(new CacheLoader<String, Map<String, PartStateHolder>>() {
      @Override
      public Map<String, PartStateHolder> load(String perspectiveId) throws Exception {
        return new HashMap<>();
      }
    });

    // set initial perspective
    for (MWindow mWindow : modelService.findElements(application, null, MWindow.class, null)) {
      _currentPerspective = modelService.getActivePerspective(mWindow);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void perspectiveActivated(IWorkbenchPage page, IPerspectiveDescriptor perspectiveDescriptor) {

    //
    List<MPerspective> mPerspectives = _modelService.findElements(_application, perspectiveDescriptor.getId(),
        MPerspective.class, null);

    //
    MPerspective newPerspective = mPerspectives.get(0);
    onSwitchPerspective(newPerspective, _currentPerspective);
    _currentPerspective = newPerspective;
  }

  /**
   * <p>
   * </p>
   *
   */
  private void onSwitchPerspective(MPerspective newPerspective, MPerspective oldPerspective) {

    // get the editor stack
    // TAGS: [[org.eclipse.e4.primaryDataStack, EditorStack, empty]]
    List<MPartStack> partStacks = _modelService.findElements(newPerspective, null, MPartStack.class,
        Arrays.asList(new String[] { "EditorStack" }));

    Map<String, PartStateHolder> oldPerspectiveViewMap = _view2Perspective.getUnchecked(oldPerspective.getElementId());
    Map<String, PartStateHolder> newPerspectiveViewMap = _view2Perspective.getUnchecked(newPerspective.getElementId());
    oldPerspectiveViewMap.clear();

    //
    MStackElement selectedElement = partStacks.get(0).getSelectedElement();

    MPart selectedPart = null;

    for (MStackElement stackElement : partStacks.get(0).getChildren()) {
      if (stackElement instanceof MPlaceholder) {

        //
        MPlaceholder placeholder = (MPlaceholder) stackElement;

        oldPerspectiveViewMap.put(placeholder.getElementId(),
            new PartStateHolder(placeholder.isToBeRendered(), selectedElement == placeholder));

        PartStateHolder partStateHolder = newPerspectiveViewMap.getOrDefault(placeholder.getElementId(),
            new PartStateHolder(false, false));

        //
        if (partStateHolder.isToBeRendered()) {
          placeholder.setToBeRendered(true);
          if (partStateHolder.isSelected()) {
            selectedPart = (MPart) placeholder.getRef();
          }
        } else {
          _partService.hidePart((MPart) placeholder.getRef());
        }
      }
    }

    //
    if (selectedPart != null) {
      _partService.showPart(selectedPart, PartState.ACTIVATE);
    }

    //
    if ("org.slizaa.jqassistant.CrossReferencerPerspective".equals(newPerspective.getElementId())) {
      _partService.showPart("org.slizaa.ui.xref.XRefPart", PartState.ACTIVATE);
    }
  }
}