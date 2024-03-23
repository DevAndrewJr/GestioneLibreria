/***************************************************************************************/	
/*  CAMPI OBBLIGATORI MODULI DI INSERIMENTO E AGGIORNAMENTO AUTORI                     */
/***************************************************************************************/


document.getElementById("btnAutore").addEventListener('click', function(event){
    // Ottenere i valori dei campi
    let nomeAutore = document.forms["autoreForm"].elements["nome"].value.trim();
    let cognomeAutore = document.forms["autoreForm"].elements["cognome"].value.trim();


    // Effettua la validazione    
    let isValid = true;
    
    if (nomeAutore === ''){
		document.forms["autoreForm"].elements["nome"].style.border = "2px solid orange";
		isValid = false;
	}

   if (cognomeAutore === ''){
	   document.forms["autoreForm"].elements["cognome"].style.border = "2px solid orange";
	   isValid = false;
   }

   if (!isValid){
	   // Impedire l'invio del modulo se ci sono campi vuoti o select non selezionate
	   event.preventDefault();
   }

});



// Rimuovi il bordo arancio quando si inizia a digitare o selezionare un'opzione
document.forms["autoreForm"].addEventListener('input', function (event){
	if (event.target.tagName === 'INPUT' || event.target.tagName === 'SELECT'){
		event.target.style.border = '';
	}
});

// Aggiungi controlli per il blur delle caselle di testo e il cambio delle select

// Blur delle caselle di testo
let textAutoreInputs = document.forms["autoreForm"].querySelectorAll('input[type="text"]');
textAutoreInputs.forEach(function(input) {
    input.addEventListener('blur', function(event) {
        if (input.value.trim() === '') {
            input.style.border = '2px solid orange';
        }
    });
});



/***************************************************************************************/	
/* FINE CODICE CAMPI OBBLIGATORI MODULI DI INSERIMENTO E AGGIORNAMENTO AUTORI          */
/***************************************************************************************/

