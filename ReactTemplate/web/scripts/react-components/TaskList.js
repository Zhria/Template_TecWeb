/*ZAKARIA TRAKA MATRICOLA 0000921074*/
'use strict';
class TaskList extends React.Component {
    render() {
    let result = this.props.result;

    return (
    <div className="result">
        <div id="list">
            
        </div>
        <button name="cancella" onClick={this.props.onClick}>Cancella tutto</button>
    </div>
    
        );
        
    }
}

