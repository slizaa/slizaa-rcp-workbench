import * as React from "react";
import * as ReactDOM from "react-dom";
import { IGraphRelationship } from "./QueryResultModel";
import * as styles from "./QueryResultComponents.scss";

/**
 * 
 * @export
 * @class GraphRelationshipComponent
 * @extends React.Component<IGraphRelationship, {}>
 */
export class GraphRelationshipComponent extends React.Component<IGraphRelationship, {}> {

  /**
   * Creates an instance of GraphRelationshipComponent.
   * @param  {IGraphRelationship} props 
   * @memberof GraphRelationshipComponent
   */
  constructor(props: IGraphRelationship) {
    super(props);
  }

  /**
   * 
   * @return 
   * @memberof GraphRelationshipComponent
   */
  render() {

    const graphRelationship = this.props;
    const hasProperties = Object.keys(graphRelationship.properties).length != 0;

    // https://jsfiddle.net/phlschmdt/y0wncx8y/
    return (
      <table className={styles.graphNode}>
        <colgroup>
          <col width="120px" />
          <col />
        </colgroup>
        <tbody>
          <tr>
            <td className={styles.graphNode} colSpan={2}>{graphRelationship.id}</td>
          </tr>
          <tr>
            <td className={styles.graphNode_labels} colSpan={2}>{ "(" + graphRelationship.start + ") -[:" + graphRelationship.type + "]-> (" + graphRelationship.end + ")"}</td>
          </tr>
          {
            hasProperties ?
              Object.keys(graphRelationship.properties).map(key => <tr><td className={styles.graphNode_propkey}>{key}</td><td className={styles.graphNode}>{"" + graphRelationship.properties[key]}</td></tr>) :
              <tr>
                <td className={styles.graphNode}> (empty) </td>
              </tr>
          }
        </tbody>
      </table>);
  }
}