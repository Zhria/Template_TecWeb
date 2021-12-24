/*ZAKARIA TRAKA MATRICOLA 0000921074*/
'use strict';

class Lavagna extends React.Component {
    render() {
    let result = this.props.result;
    return (
    <div className="result">
        <textarea id="dati" rows="8" cols="30" value={result}></textarea>
        <button name="cancella" onClick={this.props.onClick}>Cancella tutto</button>
    </div>
        );
    }
}
