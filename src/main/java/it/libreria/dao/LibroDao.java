package it.libreria.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.libreria.model.Libro;

@Repository
public interface LibroDao extends CrudRepository<Libro, Integer> {

}