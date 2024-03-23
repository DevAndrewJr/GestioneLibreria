	
/***************************************************************************************/	
/* INIZIO CODICE CAMPI OBBLIGATORI MODULI DI INSERIMENTO E AGGIORNAMENTO LIBRI         */
/***************************************************************************************/
		
document.getElementById("btnBook").addEventListener('click', function(event) {
    // Ottenere i valori dei campi
    let titolo = document.forms["libroForm"].elements["titolo"].value.trim();
    let prezzo = document.forms["libroForm"].elements["prezzo"].value.trim();
    let codiceIsbn = document.forms["libroForm"].elements["codiceIsbn"].value.trim();
    let autore = document.forms["libroForm"].elements["autore"].value;
    let categoria = document.forms["libroForm"].elements["categoria"].value;
    
    // Effettua la validazione
    let isValid = true;

    if (titolo === '') {
        document.forms["libroForm"].elements["titolo"].style.border = "2px solid orange";
        isValid = false;
    }
    if (prezzo === '') {
        document.forms["libroForm"].elements["prezzo"].style.border = "2px solid orange";
        isValid = false;
    }
    if (codiceIsbn === '') {
        document.forms["libroForm"].elements["codiceIsbn"].style.border = "2px solid orange";
        isValid = false;
    }
    
    if (autore === '') {
        document.forms["libroForm"].elements["autore"].style.border = "2px solid orange";
        isValid = false;
    }

    if (categoria === '') {
        document.forms["libroForm"].elements["categoria"].style.border = "2px solid orange";
        isValid = false;
    }
    

    if (!isValid) {
        // Impedire l'invio del modulo se ci sono campi vuoti o select non selezionate
        event.preventDefault();
        event.stopPropagation();
    }
});
	
	// Rimuovi il bordo arancio quando si inizia a digitare o selezionare un'opzione
	document.forms["libroForm"].addEventListener('input', function(event) {
	    if (event.target.tagName === 'INPUT' || event.target.tagName === 'SELECT') {
	        event.target.style.border = '';
	    }
	});
	
	// Aggiungi controlli per il blur (rimozione del focus) delle caselle di testo
	let textLibroInputs = document.forms["libroForm"].querySelectorAll('input[type="text"], input[type="number"]');
	textLibroInputs.forEach(function(input) {
	    input.addEventListener('blur', function(event) {
	        if (input.value.trim() === '') {
	            input.style.border = '2px solid orange';
	        }
	    });
	});


// Aggiungi controlli per il blur (rimozione del focus) sul cambio delle select

let selectLibroInputs = document.forms["libroForm"].querySelectorAll('select');
selectLibroInputs.forEach(function(select) {
    select.addEventListener('change', function(event) {
        if (select.value === '') {
            select.style.border = '2px solid orange';
        } else {
            select.style.border = '';
        }
    });
    
    
        select.addEventListener('focus', function(event) {
        // Aggiungi bordo solo se l'opzione attuale è "Inserisci autore" o "Inserisci categoria"
        if (select.value === '' || select.value === '') {
            select.style.border = '2px solid orange';
        }
    });
    
    
    
});


/***************************************************************************************/	
/* FINE CODICE CAMPI OBBLIGATORI MODULI DI INSERIMENTO E AGGIORNAMENTO LIBRI           */
/***************************************************************************************/	
