package it.libreria.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.libreria.model.Categoria;

@Repository
public interface CategoriaDao extends CrudRepository<Categoria, Integer> {

}