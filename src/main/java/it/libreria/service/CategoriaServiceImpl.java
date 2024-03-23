package it.libreria.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import it.libreria.controller.CategoriaController;
import it.libreria.dao.CategoriaDao;
import it.libreria.model.Categoria;
import it.libreria.service.CategoriaService;
import it.libreria.service.CategoriaServiceImpl;
import jakarta.persistence.EntityNotFoundException;

@Qualifier("categoriaServiceImpl")
@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	private CategoriaDao categoriadao;

	
	@Override
	public void salvaCategoria(Categoria categoria) {
		categoriadao.save(categoria);		
	}

	@Override
	public List<Categoria> getCategorie() {		
		return (List<Categoria>) categoriadao.findAll();
	}
	
	
	@Override
	public Categoria getCategoriaById(int id) {
		Optional<Categoria> categoriaOptional = categoriadao.findById(id);
		if(categoriaOptional.isPresent()) {
			return categoriaOptional.get();
		}
		throw new EntityNotFoundException("Autore avente id=" + id  +"non presente");
	}
	
	
	@Override
	public void cancellaCategoria(int id) {
		Categoria categoria = categoriadao.findById(id).get();
		categoriadao.delete(categoria);
	}
	

	
	@Override
	public void aggiornaCategoria(Categoria categoria, int id) {
	    Optional<Categoria> categoriaEsistenteOptional = categoriadao.findById(id);
	    if (categoriaEsistenteOptional.isPresent()) {
	        Categoria categoriaEsistente = categoriaEsistenteOptional.get();
	        // Aggiorna solo i campi necessari della categoria esistente
	        categoriaEsistente.setNomeCategoria(categoria.getNomeCategoria());
	        categoriadao.save(categoriaEsistente);
	    }
	}
	

} 
