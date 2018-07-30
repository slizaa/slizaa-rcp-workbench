package org.slizaa.ui.tree.actions;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;
import org.slizaa.hierarchicalgraph.core.model.HGNode;
import org.slizaa.ui.tree.ISlizaaActionContribution;

public abstract class AbstractCopyAction implements ISlizaaActionContribution {

  @Override
  public String getParentGroupId() {
    return CopyActionGroup.ID;
  }

  @Override
  public int getRanking() {
    return 10;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean shouldShow(List<?> selection, Viewer viewer) {
    return checkNotNull(selection).stream().allMatch(o -> o instanceof HGNode);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isEnabled(List<?> selection, Viewer viewer) {
    return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final void execute(List<?> selection, Viewer viewer) {

    //
    StringBuilder stringBuilder = new StringBuilder();

    //
    for (int i = 0; i < selection.size(); i++) {
      if (selection.get(i) instanceof HGNode) {
        HGNode node = (HGNode) selection.get(i);
        String value = mapNode(node);
        stringBuilder.append(value);
        if (i + 1 < selection.size()) {
          stringBuilder.append("\n");
        }
      }
    }

    //
    copyToClipboard(stringBuilder.toString());
  }

  protected abstract String mapNode(HGNode node);

  public final void copyToClipboard(String content) {

    checkNotNull(content);

    //
    final Clipboard clipboard = new Clipboard(Display.getCurrent());
    TextTransfer textTransfer = TextTransfer.getInstance();
    clipboard.setContents(new Object[] { content }, new Transfer[] { textTransfer });
  }
}
