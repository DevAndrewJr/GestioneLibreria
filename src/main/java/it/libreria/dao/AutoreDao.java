package it.libreria.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.libreria.model.Autore;

@Repository
public interface AutoreDao extends CrudRepository<Autore, Integer>{
	
}
