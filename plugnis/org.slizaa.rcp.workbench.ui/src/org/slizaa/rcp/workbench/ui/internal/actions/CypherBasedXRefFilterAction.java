package org.slizaa.rcp.workbench.ui.internal.actions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.osgi.service.component.annotations.Component;
import org.slizaa.hierarchicalgraph.HGNode;
import org.slizaa.neo4j.dbadapter.Neo4jClient;
import org.slizaa.neo4j.opencypher.openCypher.Cypher;
import org.slizaa.neo4j.opencypher.util.CypherNormalizer;
import org.slizaa.ui.tree.ISlizaaActionContribution;

@Component(service = ISlizaaActionContribution.class)
public class CypherBasedXRefFilterAction extends AbstractFilterAction {

  @Override
  public void execute(List<?> selection, Viewer viewer) {

    HGNode node = (HGNode) selection.get(0);

    ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(Display.getDefault().getActiveShell(),
        new WorkbenchLabelProvider(), new BaseWorkbenchContentProvider());

    dialog.setTitle("Tree Selection");
    dialog.setMessage("Select the elements from the tree:");
    dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
    dialog.addFilter(new ViewerFilter() {

      @Override
      public boolean select(Viewer viewer, Object parentElement, Object element) {
        if (element instanceof IFile) {
          IFile file = (IFile) element;
          return "cypher".equals(file.getFileExtension());
        }
        return true;
      }
    });

    //
    if (Dialog.OK == dialog.open()) {

      //
      IFile cypherFile = (IFile) dialog.getFirstResult();

      try {

        final String cypherQuery = CypherNormalizer.normalize(readStream(cypherFile.getContents()));

        //
        Cypher cypher = (Cypher) Platform.getAdapterManager().loadAdapter(cypherQuery, Cypher.class.getName());

        //
        if (!CypherUtils.returnItemsContainOnlyIds(cypher)) {
          MessageDialog.openError(Display.getCurrent().getActiveShell(), "Invalid cyuper statement",
              "A filter statement must return only ids (e.g. RETURNS id(a), id(b)).");
          return;
        }

        Neo4jClient neo4jClient = node.getRootNode().getExtension(Neo4jClient.class);

//        BusyCursor.execute(Display.getCurrent().getActiveShell(), () -> {
//
//          Future<JsonObject> future = neo4jClient.executeCypherQuery(cypherQuery);
//          JsonObject jsonObject;
//          try {
//            jsonObject = future.get();
//
//            // System.out.println(jsonObject);
//            // TODO :ERROR CHECK!!
//
//            //
//            List<Long> filteredNodeIds = new LinkedList<>();
//            List<Void> rows = QueryResultConverter.convertRows(jsonObject, row -> {
//              for (JsonElement jsonElement : row) {
//                filteredNodeIds.add(jsonElement.getAsLong());
//              }
//              return null;
//            });
//
//            //
//            FilterSelections.setFilteredNodeIds(node.getRootNode(), filteredNodeIds);
//
//          } catch (InterruptedException | ExecutionException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//          }
//        });

      } catch (IOException | CoreException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  @Override
  public String getLabel(List<?> selection) {
    return "Filter... ";
  }

  /**
   * Reads the stream into a string
   * 
   * @param iStream
   *          the input stream
   * @return the string read from the stream
   * @throws IOException
   *           when an IO error occurs
   */
  private String readStream(InputStream iStream) throws IOException {

    // Buffered reader allows us to read line by line
    try (BufferedReader bReader = new BufferedReader(new InputStreamReader(iStream))) {
      StringBuilder builder = new StringBuilder();
      String line;
      while ((line = bReader.readLine()) != null) { // Read till end
        builder.append(line);
        builder.append("\n"); // append new line to preserve lines
      }
      return builder.toString();
    }
  }
}
