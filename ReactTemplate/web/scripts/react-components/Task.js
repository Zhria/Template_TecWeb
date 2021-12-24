/*ZAKARIA TRAKA MATRICOLA 0000921074*/
'use strict';

class Task extends React.Component {

    render() {
        return (
            <div className="new-task"><br/>
            New Task:<input type="text" name="task" onChange={this.props.onChange}></input>
            <button name="add" onClick={this.props.onClick}>add</button><br/>
            </div>
        );
    }
}
