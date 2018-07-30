import * as React from "react";
import * as ReactDOM from "react-dom";

import * as styles from "./errorMessages.scss";

declare function getErrorMessageAsJson(): string;

ReactDOM.render(renderErrorMessage(), document.getElementById("root"));

function renderErrorMessage(): JSX.Element {

    //
    const errorMessage = JSON.parse(getErrorMessageAsJson());


    let rows = [];
    for (let i = 0; i < errorMessage.length; i++) {
        rows.push(<div><pre>{errorMessage[i]}</pre></div>);
    }

    return <div>
        <div className={styles.header}>Error</div>
        <div className={styles.errorMessageBox} >{rows}</div>
    </div>
} 