import * as React from "react";
import * as ReactDOM from "react-dom";
import { QueryResultComponent } from "./components/QueryResultComponent";

declare function getColumnNamesAsJson(): string;
declare function getRecordsAsJson(): string;

ReactDOM.render(
    <QueryResultComponent columnNames={JSON.parse(getColumnNamesAsJson())}  records={JSON.parse(getRecordsAsJson())} />,
    document.getElementById("root")
);