package it.libreria.service;

import it.libreria.model.Autore;

import java.util.List;
import com.fasterxml.jackson.databind.node.ObjectNode;



public interface AutoreService {
	
	void salvaAutore(Autore autore);
	
	Autore getAutoreById(int id);
	
	List<Autore> getAutori();
	
	void cancellaAutore(int id);


	void aggiornaAutore(Autore autore, int id);

	// Cancella autore tramite id (Servizio di REST Controller, json)
	ObjectNode cancellaAutoreById(int id);
	
}