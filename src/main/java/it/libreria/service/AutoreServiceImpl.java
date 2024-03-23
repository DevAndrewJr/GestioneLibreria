package it.libreria.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import it.libreria.controller.AutoreController;
import it.libreria.dao.AutoreDao;
import it.libreria.helper.ResponseManager;
import it.libreria.model.Autore;
import it.libreria.model.Categoria;
import it.libreria.service.AutoreService;


@Service
public class AutoreServiceImpl implements AutoreService{
		
	@Autowired
	private AutoreDao autoreDao;
	
	
	@Override
	public void salvaAutore(Autore autore) {
		autoreDao.save(autore);
	}
	
	
	@Override
	public Autore getAutoreById(int id) {
		Optional<Autore> autoreOptional = autoreDao.findById(id);
		if(autoreOptional.isPresent()) {
			return autoreOptional.get();
		}
			throw new EntityNotFoundException("Autore avetnte id=" + id +  " non presente");
	}
	
	
	@Override
	public List<Autore> getAutori(){
		return (List<Autore>) autoreDao.findAll();
	}
	
	
	@Override
	public void cancellaAutore(int id) {
		Autore autore = autoreDao.findById(id).get();
		autoreDao.delete(autore);
	}
	
	
	// Cancella autore tramite id (Servizio usato per il REST Controller, json)
	@Override
	public ObjectNode cancellaAutoreById(int id) {
		Optional<Autore> autore = autoreDao.findById(id);
		if(!autore.isPresent()) {
			return new ResponseManager(new ObjectMapper(), 404, "Autore non trovato").getResponse();		
		}
		autoreDao.delete(autore.get());
		return new ResponseManager(new ObjectMapper(), 202, "Autore eliminato ").getResponse();		
	}
	
		
	@Override
	public void aggiornaAutore(Autore autore, int id) {
	    Optional<Autore> autoreEsistenteOptional = autoreDao.findById(id);
	    if (autoreEsistenteOptional.isPresent()) {
	        Autore autoreEsistente = autoreEsistenteOptional.get();
	        // Aggiorna solo i campi necessari dell'autore esistente
	        autoreEsistente.setNome(autore.getNome());
	        autoreEsistente.setCognome(autore.getCognome());

	        autoreDao.save(autoreEsistente);
	    }
	}
		
}
