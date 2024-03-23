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
@RequestMapping("/api/autori")
public class RestAutoreController {

    @Autowired
    private AutoreService autoreService;

    @GetMapping(value = "/list", produces="application/json")
    @ResponseBody
    public List<Autore> getAllAutori() {
        return autoreService.getAutori();
    }
    
    
    @GetMapping(value = "/get/{id}", produces="application/json")
    @ResponseBody
    public Autore getAutoreById (@PathVariable ("id") int id) {
    	try {
    	autoreService.getAutoreById(id);    	
    	return autoreService.getAutoreById(id);
    	}catch(Exception e) {
    		return null;
    	}
    }
    
    
    @DeleteMapping(value = "/delete/{id}", produces="application/json")
    @ResponseBody
    public List<Autore> deleteAutoreByID(@PathVariable ("id") int id) {
    	try {
    	 autoreService.cancellaAutoreById(id);
    	 return autoreService.getAutori();
    	}catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
    
    @PostMapping(value = "/save", produces="application/json")
    @ResponseBody
    public List<Autore> registraAutore(@RequestBody Autore autore, BindingResult result) {
    	try {
			autoreService.salvaAutore(autore);
			return autoreService.getAutori();
    	}catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
    @PutMapping(value = "/update/{id}", produces="application/json")
    @ResponseBody
    public List<Autore> aggiornaAutore(@PathVariable int id, 
    								   @RequestBody Autore autoreAggiornato) {
        try {
            autoreService.aggiornaAutore(autoreAggiornato, id);
            return autoreService.getAutori();
        } catch (Exception e) {
        	e.printStackTrace();
    		return null;
        }
    }
    
    
}