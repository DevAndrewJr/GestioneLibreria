package it.libreria.service;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.libreria.model.Categoria;

public interface CategoriaService {
	
	void salvaCategoria(Categoria categoria);
	
	Categoria getCategoriaById (int id);
	
	List<Categoria> getCategorie();
	
	void cancellaCategoria(int id);
		
	void aggiornaCategoria(Categoria categoria, int id);
}