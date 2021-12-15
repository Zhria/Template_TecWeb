var socket = new WebSocket("ws://localhost:8080/08_TecWeb/actions2");
console.log("ws://localhost:8080/08_TecWeb/actions2")

function send( data) {
    var json = JSON.stringify(data);

    socket.send(json);
}




socket.onmessage =  function (event){
    console.log(event)

    


    //passo a oggetto js
    
//event.data è il "dato" che ricevo????
     var message = JSON.parse(event.data);
     if(message.update != undefined || message.update != null || message.update != ""){

        //ho una update request, quindi setto solo il campo di op "update"!
        document.getElementById(message.update).value=message.valore;

     }else{

        //è una operationRes!!!

        
	 //mi aspetto che il server abbia riempito il campo valid del messaggio!
	 if(message.valid)
		 {
			 /*Il server usa la variabile booleana valid per dire al client che ha superato il num massimo!
			 Quindi nel server se è la 100esima richiesta non devo mettere contenuto nel mess ma devo valorizzare campo valid!*/
		 	var log = document.getElementById("risultato");
			log.value = "";
		    console.log(event.data);
		   
		    log.value = message.risultato;
		 }else{
			 alert("hai superato il limite massimo di richieste per sessione");
		 }



     }



}

//debug client:
/*

Metti i break point dopo il messaggio (es. dopo il parse!)


*/


//scatta con click su button
function myFunction()
{
	//preleva i dati interessanti dalla calcolatrice
	var op1 = document.getElementById("op1").value;
	var op2 = document.getElementById("op2").value;
		//alert("uno dei due operandi non è un numero");

	//controlla che entrambi siano numeri:
	if(isNaN(op1) || isNaN(op2))
		{
			alert("uno dei due operandi non è un numero");
			return;
		}

		//crea var operazione a partire da elemento del dom che si chiama op
		//poi, se op l'ho realizzata con una checkbox

	var operazione = document.getElementsByName("op");
	//mi restituisce il vettore con tutti gli elementi che si chiaamano così
	var op;
	for (var i=0; i< operazione.length;i++)
		{
			if(operazione[i].checked)
			//cerco tra tutti gli elem del vettore quale è stato checked!
				{
					op = operazione[i].value;
					break;
				}
		}

		//costruisco larichiesta di operazione:
		//dopo aver ottenuto l'operatore premuto:
	//creo oggetto con le tre info necessarie
	var operationReq = {};
	operationReq.op1 = op1;
	operationReq.op2 = op2;
	operationReq.operazione = op;
	
	//questa non è la send della socket, è la send che ho definito qua in sto file
	// (che farà il passaggio a JSON)
	send(operationReq);
	
}






//scatta sull'onkeyUp del campo di input!
function functionUpdate(id){

	//devo fare una send al server di un oggetto jsonato di updateRequest!

    var updateReq={}
    updateReq.update= id
    updateReq.valore=document.getElementById(id).value

    //questa non è la send della socket, è la send che ho definito qua in sto file
	// (che farà il passaggio a JSON)
	send(updateReq);

}