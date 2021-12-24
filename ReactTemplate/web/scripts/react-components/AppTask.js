/*ZAKARIA TRAKA MATRICOLA 0000921074*/
'use strict';

    class App extends React.Component {
    constructor(){
            super();
            var arr=[]
            this.state = {
            result:"",
            list:arr
            }
            this.onClick = this.onClick.bind(this); 
            this.onChange = this.onChange.bind(this); 
    }

    onClick(e) {
            let button = e.target.name
            var err="";
            if(button === "add"){
                //valuto che i campi non siano vuoti
                if(this.state.list==undefined||this.state.list==""||this.state.list==null){
                    //controllo email ben formattata
                    err="errore, non hai inserito neanche un task"
                }
               const html= createHtml(this.state.list)
            this.setState({
                result: html
            })
            }

        else if(button === "cancella"){
            this.setState({
                result: ""       
            })
        }
    };

    onChange(e) {
    if(e.target.name=="task"){
        if(e.target.value!=undefined||e.target.value!=""||e.target.value!=null){
            this.state.list[this.state.list.length]=e.target.value
        }
    this.setState({
      list: this.state.list
        });
    }
  }

    render() {
        return (

            <div className="iscrizione-body">
                <h1>Iscrizione:</h1>
                <Task onClick={this.onClick} onChange={this.onChange}/>
                <TaskList onClick={this.onClick} result={this.state.result}/>
            </div>

        );
    }
    }

 function createHtml(list){
     var res="<ul>"
    list.forEach(element => {
        res+="<li>"+element+"</li><br>"
    });
    res+="</ul>"
    return res;
 }
