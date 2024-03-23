package it.libreria.service;

import it.libreria.model.Libro;

import java.util.List;


public interface LibroService {
	
	void salvaLibro(Libro libro);
	
	Libro getLibroById(int id);
	
	List<Libro> getLibri();
	
	void cancellaLibro(int id);
	
	void aggiornaLibro(Libro libro, int id);
}