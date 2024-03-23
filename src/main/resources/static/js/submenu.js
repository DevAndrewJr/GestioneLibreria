document.addEventListener("DOMContentLoaded", function() {
    // Ottieni il percorso della pagina corrente
    let currentPage = window.location.pathname.split("/").pop();
	console.log(currentPage);

	// Seleziona l'elemento della barra di navigazione in base alla pagina corrente
    let navLinks = document.querySelectorAll("ul#submenu li a");
    console.log(navLinks[0]);
    
    let insertData = document.querySelector("#openSubmenu");
    
    let firstNavLink = document.querySelector("ul#submenu li:first-child a")
    
	firstNavLink.addEventListener("mouseover", function() {
    	firstNavLink.style.backgroundColor = "#333";
    	firstNavLink.style.cursor = "default";
    });

    
    // Imposta un colore fisso per il link della pagina corrente
    for (let i = 0; i < navLinks.length; i++) {
        let link = navLinks[i];
     	// Ottieni il percorso href dell'elemento link
        let linkHref = link.getAttribute("href").split("/").pop(); 

        if (linkHref === currentPage) {
            link.style.backgroundColor = "#111";
            link.style.color = "orange";
            
            insertData.style.backgroundColor = "grey";
			insertData.style.color = "#111";	
			insertData.style.fontWeight = "bold";	
        }        		
    }
});