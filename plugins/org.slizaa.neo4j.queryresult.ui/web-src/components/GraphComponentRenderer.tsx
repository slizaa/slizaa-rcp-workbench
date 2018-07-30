import * as React from "react";
import * as ReactDOM from "react-dom";

import * as QueryResultModel from "./QueryResultModel";
import { GraphNodeComponent } from "./GraphNodeComponent";
import { GraphRelationshipComponent } from "./GraphRelationshipComponent";
import { GraphPathComponent } from "./GraphPathComponent";
import { GraphListComponent } from "./GraphListComponent";
import { GraphMapComponent } from "./GraphMapComponent";
import * as styles from "./QueryResultComponents.scss";

/**
 * 
 * @export
 * @param  {*} value 
 * @return boolean 
 */
export function isComplexType(value: any): boolean {
  return Array.isArray(value) || typeof value == 'object';
}

/**
 * 
 * @export
 * @param  {*} value 
 * @return boolean 
 */
export function isSimpleType(value: any): boolean {
  return !isComplexType(value);
}

/**
 * 
 * @export
 * @param  {*} value 
 * @return JSX.Element 
 */
export function renderCell(value: any): JSX.Element {

  // handle QueryResultModel.ResultElementType.LIST: {
  if (Array.isArray(value)) {
    return <GraphListComponent items={value} />
  }

  //
  else if (typeof value === 'object') {

    let elementType = QueryResultModel.checkObject(value);

    switch (elementType) {
      case QueryResultModel.ResultElementType.NODE: {
        let graphNode = value as QueryResultModel.IGraphNode;
        return <GraphNodeComponent {...graphNode} />
      }
      case QueryResultModel.ResultElementType.RELATIONSHIP: {
        let graphRelationship = value as QueryResultModel.IGraphRelationship;
        return <GraphRelationshipComponent {...graphRelationship} />
      }
      case QueryResultModel.ResultElementType.PATH: {
        let graphPath = value as QueryResultModel.IGraphPath;
        return <GraphPathComponent {...graphPath} />
      }
      case QueryResultModel.ResultElementType.MAP: {
        return <GraphMapComponent map={value} />
      }
      default: {
        //statements; 
        break;
      }
    }
  }

  // handle anything else
  else {
    return <div className={styles.attributeValue}>{value == null ? 'null' : value.toString()}</div>
  }
}