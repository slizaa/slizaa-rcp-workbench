import * as React from "react";
import * as ReactDOM from "react-dom";
import ReactTable, { Column } from 'react-table';
import {renderCell} from './GraphComponentRenderer'


export interface QueryResultComponentProps { columnNames: string[]; records: string[]; }

/**
 * 
 */
export class QueryResultComponent extends React.Component<QueryResultComponentProps, {}> {

  // the constructor
  constructor(props: QueryResultComponentProps) {
    super(props);
  }

  // 
  render() {

    //
    const { columnNames, records } = this.props;

    return (<div>
      <ReactTable
        showPaginationTop={true}
        showPaginationBottom={false}
        sortable={false}
        defaultPageSize={20}
        data={records}
        columns={this.computeColumns(columnNames)}
      // className="-striped -highlight"
      />
    </div>);
  }

  //
  computeColumns(columnNames: string[]) {

    //
    let columns: Column[] = [];

    //
    for (let i = 0; i < columnNames.length; i++) {
      let headerName: string = columnNames[i];
      let newColumn = {
        Header: headerName,
        id: headerName,
        accessor: (d: any) => d[headerName],
        Cell: (cellValue: any) => renderCell(cellValue.value)
      };
      columns.push(newColumn);
    }

    //
    return columns;
  }
}
