/*ZAKARIA TRAKA MATRICOLA 0000921074*/
'use strict';

class Display extends React.Component {

    render() {
    let result = this.props.result;
    return (
        <div className="result">
        <p>{result}</p>
        </div>
        );
    }
}
