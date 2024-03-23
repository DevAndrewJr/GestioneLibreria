package it.libreria.controller;

import it.libreria.model.*;
import it.libreria.service.*;
import it.libreria.helper.*;
import it.libreria.dao.*;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;


@RestController
@RequestMapping("/api/libri")
public class RestLibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping(value = "/list", produces = "application/json")
    @ResponseBody
    public List<Libro> getAllLibri() {
        return libroService.getLibri ();
    }
    
  
    @GetMapping(value = "/get/{id}", produces = "application/json")
    @ResponseBody
    public Libro getAutoreById (@PathVariable ("id") int id) {
    	libroService.getLibroById(id);
    	return libroService.getLibroById(id);
    }
    
   
    
    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    @ResponseBody
    public List<Libro> deleteLibroByID(@PathVariable ("id") int id) {
    	try {
    	 libroService.cancellaLibro(id);
    	 return libroService.getLibri();
    	}catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    

    @PostMapping(value = "/save", produces = "application/json")
    @ResponseBody
    public List<Libro> registraLibro(@RequestBody Libro libro, BindingResult result) {
    	try {
			libroService.salvaLibro(libro);
			return libroService.getLibri();
    	}catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
    
    @PutMapping(value = "/update/{id}", produces = "application/json")
    @ResponseBody
    public List<Libro> aggiornaAutore(@PathVariable int id, 
    								  @RequestBody Libro libroAggiornato) {
        try {
            libroService.aggiornaLibro(libroAggiornato, id);
            return libroService.getLibri();
        } catch (Exception e) {
        	e.printStackTrace();
    		return null;
        }
    }
    
    
    
}