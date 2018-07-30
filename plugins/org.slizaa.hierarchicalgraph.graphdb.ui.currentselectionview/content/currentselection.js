function renderNodeSelection(nodeSelection) {

    // create the body values
    var createdContent = "";
    
	// render each node
    $.each($.parseJSON(nodeSelection), function (i, val) {
        
        // start row
        createdContent += '<tr><td>';
        
        //
		createdContent += renderNode(val);

		// end row
        createdContent += '</td></tr>';
    });

    //
    $("#currentSelectionTableBody").append(createdContent);
}

function renderNode(node) {

    // create the table
    var html = '<table class="node"><tbody class="node_tbody">';

     // add the node identifier
     html += '<tr class="node_row node_id"><td class="node_id" colspan="2">' + node['id'] + '</td></tr>';

     // add the node label
     html += '<tr class="node_row node_labels"><td class="node_labels" colspan="2"> [' + node['labels'] + '] </td></tr>';
         
    // add the node properties
    var properties = node['properties'];
    if (Object.keys(properties).length === 0) {
        html += '<tr class="node_row">';
        html += '<td class="node_data_empty"> (empty) </td>';
        html += "</tr>";
    } else {
        for (var property in  properties) {
            html += '<tr class="node_row">';
            html += '<td class="node_data node_data_key">' + property + '</td>';
            html += '<td class="node_data node_data_value">' + properties[property].replace('<', '&lt;').replace('>', '&gt;'); + '</td>';
            html += "</tr>";
        }
    }

    // close the table
    html += '</tbody></table>';

    // return the result
    return html;
}