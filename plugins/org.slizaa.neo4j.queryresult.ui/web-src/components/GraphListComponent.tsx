import * as React from "react";
import * as ReactDOM from "react-dom";
import * as styles from "./QueryResultComponents.scss";
import { isComplexType, isSimpleType, renderCell } from './GraphComponentRenderer'

/**
 * 
 * @interface GraphListComponentState
 */
interface GraphListComponentState {
  items: any[];
}

/**
 * 
 * @export
 * @class GraphListComponent
 * @extends React.Component<GraphListComponentState, {}>
 */
export class GraphListComponent extends React.Component<GraphListComponentState, {}> {


  constructor(props: GraphListComponentState) {
    super(props);
  }

  render() {

    //
    const anyArray = this.props.items;

    let rows = [];
    let containsComplexType = false;
    for (let i = 0; i < anyArray.length; i++) {

      containsComplexType = containsComplexType || isComplexType(anyArray[i]);

      rows.push(
        <tr>
          <td className={styles.graphNode_listItem}>{renderCell(anyArray[i])}</td>
        </tr>);
    }

    return <table className={containsComplexType ? styles.graphList : styles.graphListSimple}>
      <tbody>{rows}</tbody>
    </table>
  }
}