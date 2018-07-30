import * as React from "react";
import * as ReactDOM from "react-dom";
import { GraphRelationshipComponent } from "./GraphRelationshipComponent";
import { GraphNodeComponent } from "./GraphNodeComponent";
import * as QueryResultModel from "./QueryResultModel";
import * as styles from "./QueryResultComponents.scss";



export class GraphPathComponent extends React.Component<QueryResultModel.IGraphPath, {}> {


  constructor(props: QueryResultModel.IGraphPath) {
    super(props);
  }


  render() {

    const graphPath = this.props;

    //
    let graphRelationship = graphPath.segments[0].relationship;

    var rows = [];
    for (var i = 0; i < graphPath.segments.length; i++) {

      if (i == 0) {
        rows.push(
          <tr>
            <td><GraphNodeComponent {...graphPath.segments[i].start} /></td>
          </tr>);
      }

      rows.push(
        <tr>
          <td className={styles.graphPath_relationship}><GraphRelationshipComponent {...graphPath.segments[i].relationship} /></td>
        </tr>);

      rows.push(
        <tr>
          <td><GraphNodeComponent {...graphPath.segments[i].end} /></td>
        </tr>);
    }

    return <table className={styles.graphPath}>
      <tbody>{rows}</tbody>
    </table>
  }
}