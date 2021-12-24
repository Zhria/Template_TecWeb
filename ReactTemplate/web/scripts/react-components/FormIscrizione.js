/*ZAKARIA TRAKA MATRICOLA 0000921074*/
'use strict';

class FormIscrizione extends React.Component {

    render() {
        return (
            <div className="iscrizione"><br/>
            Email:<input type="email" name="email" onChange={this.props.onChange}></input><br/>
            Password:<input type="password" name="password"  onChange={this.props.onChange}></input><br/>
            Nazione:<select name="nazione" onChange={this.props.onChange}>
                <option name="empty" value="empty" ></option>
                <option name="italia" value="italia" >Italia</option>
                <option name="francia" value="francia" >Francia</option>
                <option name="spagna" value="spagna" >Spagna</option>
                <option name="germania" value="germania" >Germania</option>
            </select><br/>
            <button name="iscrivimi" onClick={this.props.onClick}>iscrivimi</button><br/>
            </div>
        );
    }
}
