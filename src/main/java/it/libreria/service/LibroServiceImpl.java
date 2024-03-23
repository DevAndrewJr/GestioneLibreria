package it.libreria.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.libreria.controller.LibroController;
import it.libreria.dao.LibroDao;
import it.libreria.model.Libro;


@Service
public class LibroServiceImpl implements LibroService{
	
	@Autowired
	private LibroDao librodao;

	
	@Override
	public void salvaLibro(Libro libro) {
		librodao.save(libro);		
	}

	@Override
	public Libro getLibroById(int id) {
		Optional<Libro> libroOptional = librodao.findById(id);
		if(libroOptional.isPresent()) {
			return libroOptional.get();
		}
		return null;
	}
	

	@Override
	public List<Libro> getLibri() {		
		return (List<Libro>) librodao.findAll();
	}

	
	@Override
	public void cancellaLibro(int id) {
		Libro libro = librodao.findById(id).get();
		librodao.delete(libro);
	}
	
	@Override
	public void aggiornaLibro(Libro libro, int id) {
	    Optional<Libro> libroEsistenteOptional = librodao.findById(id);
	    if (libroEsistenteOptional.isPresent()) {
	        Libro libroEsistente = libroEsistenteOptional.get();
	        // Aggiorna solo i campi necessari del libro esistente
	        libroEsistente.setTitolo(libro.getTitolo());
	        libroEsistente.setCosto(libro.getCosto());
	        libroEsistente.setCodiceIsbn(libro.getCodiceIsbn());
	        libroEsistente.setAutore(libro.getAutore());
	        libroEsistente.setCategoria(libro.getCategoria());
	        librodao.save(libroEsistente);
	    }
	}

} 
