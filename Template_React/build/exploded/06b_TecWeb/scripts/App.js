'use strict';



class App extends React.Component {
  constructor(){
        super();
        this.state = {
        result: "",
        expr: "",
        }
        this.onClick = this.onClick.bind(this); 
  }

onClick(e) {
  
    let button = e.target.name
     if(button === "="){

         this.calculate()
     }

     else if(button === "C"){
        this.reset()
      }
    else if(button === "CE"){
        this.backspace()
      }

     else if(button==="log" || button==="e" || button==="1/x") //Aggiunto per vedere se il tasto premuto è uno di questi, nel caso invoco metodo
     {
      this.effettuaCalcoloScientifico(button)
     }


    else {
         this.setState({
        expr: this.state.expr + button,
        //result: this.state.result+button,
       })
     }
};

  effettuaCalcoloScientifico (button) {
         // calcoloScientifico("calcolo", (res) => {this.setState({result: res})} ,button,eval(this.state.expr) ); 
         postData("calcolo", { operatore: button, espressione: eval(this.state.expr) }, (res) => {this.setState({result: res})} ); 
         
          //gli do come uri il nome della servlet (mappata così sul file web), la funzione da chiamare (callback), il valore del tasto
          //premuto ed il risultato dell'espressione scritta (perchè a fargli fare eval da servlet è un casino quindi mando direttamente
          //il risultato e passa la paura)

          //La callback fa in modo che il risultato ottenuto sia il valore della variabile result all'interno dello state
  }

  calculate() {
        try {
              this.setState({result: (eval(this.state.expr) || "" ) })
        } catch (e) {
            this.setState({result: "error"})
        }
  };

  reset(){
      this.setState({result: "", expr:"" })
        };

  backspace(){
      this.setState({
          expr: this.state.expr.slice(0, -1)
      })
  };

  render() {
      return (
        <div className="calculator-body">
            <h1>Calcolatrice</h1>
            <Display result={this.state.result}/>
            <Display result={this.state.expr}/>
            <KeyBoard onClick={this.onClick}/>
        </div>
      );
  }
}
