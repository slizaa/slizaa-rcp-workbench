import * as React from "react";
import * as ReactDOM from "react-dom";
import { IGraphNode } from "./QueryResultModel";
import {renderCell} from './GraphComponentRenderer'
import * as styles from "./QueryResultComponents.scss";

interface GraphListComponentProperties {
  map: object;
}

export class GraphMapComponent extends React.Component<GraphListComponentProperties, {}> {

  constructor(props: GraphListComponentProperties) {
    super(props);
  }

  render() {

    const mapObject = this.props.map;
    const hasProperties = Object.keys(mapObject).length != 0;

    let rows = [];
    if (hasProperties) {

      for (let entry of Object.keys(mapObject)) {

        let value = (mapObject as any)[entry];

        rows.push(
          <tr>
            <td className={styles.graphNode_propkey}>{entry}</td>
            <td className={styles.graphNode}>{renderCell(value)}</td>
          </tr>);
      }

    } else {
      rows.push(
        <tr>
          <td className={styles.graphNode}> (empty) </td>
        </tr>);
    }


     <tr>
      <td className={styles.graphNode}> (empty) </td>
    </tr>

    // https://jsfiddle.net/phlschmdt/y0wncx8y/
    return (
      <table className={styles.graphNode}>
        <colgroup>
          <col width="120px" />
          <col />
        </colgroup>
        <tbody>
          {rows}
        </tbody>
      </table>);
  }
}