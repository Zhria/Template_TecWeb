/*ZAKARIA TRAKA MATRICOLA 0000921074*/
'use strict';

    class App extends React.Component {
    constructor(){
            super();
            this.state = {
            email:"",
            password: "",
            nazione: "",
            result:""
            }
            this.onClick = this.onClick.bind(this); 
            this.onChange = this.onChange.bind(this); 
    }

    onClick(e) {
            let button = e.target.name
            var err="";
            if(button === "iscrivimi"){
                //valuto che i campi non siano vuoti
                if(this.state.email==undefined||this.state.email==""||this.state.email==null){
                    //controllo email ben formattata
                    err="errore, non hai inserito la email"
                }
                if(!(this.state.email.includes("@"))||!(this.state.email.includes(".com"))){
                    err="errore, l'email non è formata bene"
                }
                if(this.state.password==undefined||this.state.password==""||this.state.password==null){
                    err="errore, non hai inserito la password"
                }
                if(this.state.nazione==undefined||this.state.nazione==""||this.state.nazione==null){
                    err="errore, non hai inserito la nazione"
                }
            this.setState({
                result: this.state.result+ err+"\n"+this.state.email+", "+this.state.password+", "+this.state.nazione+"\n"
            })
            }

        else if(button === "cancella"){
            this.setState({
                result: ""       
            })
        }
    };

    onChange(e) {
    if(e.target.name=="email"){
    this.setState({
      email: e.target.value
        });
    }
    if(e.target.name=="password"){
            this.setState({
      password: e.target.value
         });
    }
        if(e.target.name=="nazione"){
            this.setState({
      nazione: e.target.value
         });
    }
  }

    render() {
        return (

            <div className="iscrizione-body">
                <h1>Iscrizione:</h1>
                <FormIscrizione onClick={this.onClick} onChange={this.onChange}/>
                <Lavagna onClick={this.onClick} result={this.state.result}/>
            </div>

        );
    }
    }
