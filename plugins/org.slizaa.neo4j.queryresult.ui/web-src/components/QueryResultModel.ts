/**
 * 
 * @export
 * @interface IGraphNode
 */
export interface IGraphNode {

    id: number;
    labels: string[];
    properties: any;
}

/**
 * 
 * @export
 * @interface IGraphRelationship
 */
export interface IGraphRelationship {

    id: number;
    start: number;
    end: number;
    type: string;
    properties: any;
}

/**
 * 
 * @export
 * @interface IGraphPath
 */
export interface IGraphPath {

    nodes: IGraphNode[];
    relationships: IGraphRelationship[];
    segments: IGraphPathSegment[];
}

/**
 * 
 * @export
 * @interface IGraphPathSegment
 */
export interface IGraphPathSegment {

    /** 
     * The relationship underlying this path segment 
     */
    relationship: IGraphRelationship;

    /**
     * The node that this segment starts at.
     */
    start: IGraphNode;

    /**
     * The node that this segment ends at.
     */
    end: IGraphNode;
}

/**
 * 
 * @enum {number}
 */
export enum ResultElementType {
    LIST,
    MAP,
    NODE,
    PATH,
    RELATIONSHIP,
    UNKNOWN
}
/**
 * Returns the type of the query result element (NODE, RELATIONSHIP, PATH, MAP).
 * 
 * @export
 * @param  {object} value 
 * @return ResultElementType 
 */
export function checkObject(value: object): ResultElementType {

    //
    if (value.hasOwnProperty('__type')) {

        //
        switch((<any>value)['__type']) { 

            case 'NODE': { 
                return ResultElementType.NODE
            } 
            case 'RELATIONSHIP': { 
                return ResultElementType.RELATIONSHIP
            } 
            case 'PATH': { 
                return ResultElementType.PATH
            } 
            default: { 
                return ResultElementType.MAP
            } 
         } 
    }

    //
    else {
        return ResultElementType.MAP
    }
}