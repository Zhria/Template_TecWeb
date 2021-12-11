/*
 * Funzione di callback
 */
function requestRandomIntGeneration_callback(theXhr, callback) {

	// verifica dello stato
	/*if (theXhr.readyState === 2) {
		// non faccio niente
		// theElement.innerHTML = "Richiesta inviata...";
	}// if 2
	else if (theXhr.readyState === 3) {
		// non faccio niente
		// theElement.innerHTML = "Ricezione della risposta...";
	}// if 3
	else*/
	if (theXhr.readyState === 4) {

		// verifica della risposta da parte del server
		if (theXhr.status === 200) {

			// operazione avvenuta con successo

			if (theXhr.responseText && theXhr.responseText !== "") {
				callback(JSON.parse(theXhr.responseText));
				//invoco la callback passandogli il risultato ottenuto dalla servlet
			}
			/*
			else {
				// non faccio niente
			}*/

		}

		/*else {
			// errore di caricamento
			// non faccio niente nemmeno qui
		}*/

	}// if 4

} // categoriaCallback();



/*
 * Imposta il contenuto testuale disponibile presso theUri
 * come src di un iframe all'interno dell'elemento theHolder del DOM
 * Non usa AJAX; per browser legacy
 
function requestRandomIntGenerationIframe(theUri, theHolder) {
	// qui faccio scaricare al browser direttamente il contenuto del feed come src dell'iframe.
	theHolder.innerHTML = '<iframe src="' + theUri + '" width="50%" height="50px">Il tuo browser non supporta gli iframe</iframe>';
	// non riesco tuttavia a intervenire per parsarlo! è il browser che renderizza l'src dell'iframe!
}// requestRandomIntGenerationIframe()
*/


/*
 * Imposta il contenuto testuale disponibile presso theUri
 * all'interno dell'elemento theHolder del DOM
 * Usa tecniche AJAX attrverso la XmlHttpRequest fornita in theXhr
 */
function requestRandomIntGenerationAJAX(theUri, theXhr, callback, operando, ResEspressione) {
	// impostazione controllo e stato della richiesta
	theXhr.onreadystatechange = function () { requestRandomIntGeneration_callback(theXhr, callback); };
	try {
		theXhr.open("Post", theUri, true); //Post necessario per una comunicazione json-json con i parametri in un json e non su uri
		//Se avessi utilizzato get la servlet non sarebbe riuscita a recuperare il json spedito
		theXhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');	
	}
	catch (e) {
		// Exceptions are raised when trying to access cross-domain URIs 
		alert(e);
	}
	// invio richiesta

	//operando sarebbe il valore del tasto premuto e ResEspressione sarebbe il risultato dell'espressione scritta
	theXhr.send(JSON.stringify({ operatore: operando, espressione: ResEspressione }));
} // requestRandomIntGenerationAJAX()

/*
 * Scarica un contenuto testuale dall'uri fornito
 * e lo aggiunge al contenuto dell'elemento e del dom
 * Gestisce sia AJAX che il mancato supporto ad AJAX 
 */
function calcoloScientifico(uri, callback, operando, ResEspressione) {
	// assegnazione oggetto XMLHttpRequest
	var xhr = myGetXmlHttpRequest();
	//if ( xhr ) 
	requestRandomIntGenerationAJAX(uri, xhr, callback, operando, ResEspressione); //solita roba
	//else 
	//	requestRandomIntGenerationIframe(uri,callback); 

}// caricaFeed()


// Example POST method implementation:
async function postData(url, data ,callback) {
  // Default options are marked with *
  const response = await fetch(url, {
    method: 'POST', // *GET, POST, PUT, DELETE, etc.
   // mode: 'cors', // no-cors, *cors, same-origin
    cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
    credentials: 'same-origin', // include, *same-origin, omit
    headers: {
      'Content-Type': 'application/json'
      // 'Content-Type': 'application/x-www-form-urlencoded', 
    },
    redirect: 'follow', // manual, *follow, error
    referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
    body: JSON.stringify(data) // body data type must match "Content-Type" header
  });

  callback(await response.json()); // parses JSON response into native JavaScript objects
}