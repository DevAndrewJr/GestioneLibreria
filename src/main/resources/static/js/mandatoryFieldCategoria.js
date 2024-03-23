/***************************************************************************************/	
/*  CAMPI OBBLIGATORI MODULI DI INSERIMENTO E AGGIORNAMENTO CATEGORIE                     */
/***************************************************************************************/



document.getElementById("btnCategoria").addEventListener('click', function(event) {
// Ottenere i valori dei campi
	let nomeCategoria = document.forms["categoriaForm"].elements["nomeCategoria"].value.trim();
		
	// Effettua la validazione    
	let isValid = true;
	    
	if (nomeCategoria === ''){
		document.forms["categoriaForm"].elements["nomeCategoria"].style.border = "2px solid orange";
		isValid = false;
	}	 
	
	if (!isValid){
		// Impedire l'invio del modulo se ci sono campi vuoti
		event.preventDefault();
	}

});



// Rimuovi il bordo arancio quando si inizia a digitare 
document.forms["categoriaForm"].addEventListener('input', function (event){
	if (event.target.tagName === 'INPUT'){
		event.target.style.border = '';
	}
});

// Aggiungi controlli per il blur delle caselle di testo 

// Blur delle caselle di testo
let textCategoriaInputs = document.forms["categoriaForm"].querySelectorAll('input[type="text"]');
textCategoriaInputs.forEach(function(input) {
    input.addEventListener('blur', function(event) {
        if (input.value.trim() === '') {
            input.style.border = '2px solid orange';
        }
    });
});



/***************************************************************************************/	
/* FINE CODICE CAMPI OBBLIGATORI MODULI DI INSERIMENTO E AGGIORNAMENTO CATEGORIE       */
/***************************************************************************************/

