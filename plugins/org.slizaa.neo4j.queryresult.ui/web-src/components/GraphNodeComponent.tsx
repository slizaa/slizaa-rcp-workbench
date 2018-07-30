import * as React from "react";
import * as ReactDOM from "react-dom";
import { IGraphNode } from "./QueryResultModel";
import * as styles from "./QueryResultComponents.scss";


/**
 * 
 * @export
 * @class GraphNodeComponent
 * @extends React.Component<IGraphNode, {}>
 */
export class GraphNodeComponent extends React.Component<IGraphNode, {}> {

  /**
   * Creates an instance of GraphNodeComponent.
   * 
   * @param  {IGraphNode} props 
   * @memberof GraphNodeComponent
   */
  constructor(props: IGraphNode) {
    super(props);
  }

  /**
   * 
   * @return 
   * @memberof GraphNodeComponent
   */
  render() {

    const graphNode = this.props;
    const hasProperties = Object.keys(graphNode.properties).length != 0;

    // https://jsfiddle.net/phlschmdt/y0wncx8y/
    return (
      <table className={styles.graphNode}>
        <colgroup>
          <col width="120px" />
          <col />
        </colgroup>
        <tbody>
          <tr>
            <td className={styles.graphNode} colSpan={2}>{graphNode.id}</td>
          </tr>
          <tr>
            <td className={styles.graphNode_labels} colSpan={2}>{"[" + graphNode.labels + "]"}</td>
          </tr>
          {
            hasProperties ?
            Object.keys(graphNode.properties).map(key => <tr><td className={styles.graphNode_propkey}>{key}</td><td className={styles.graphNode}>{"" + graphNode.properties[key]}</td></tr>) :
            <tr>
              <td className={styles.graphNode}> (empty) </td>
            </tr>
          }
        </tbody>
      </table>);
  }
}