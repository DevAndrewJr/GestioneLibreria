package it.libreria.controller;

import it.libreria.model.*;
import it.libreria.service.*;
import it.libreria.helper.*;
import it.libreria.dao.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;


import java.util.List;

@RestController
@RequestMapping("/api/categorie")
public class RestCategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/list", produces = "application/json")
    @ResponseBody
    public List<Categoria> getAllCategorie() {
        return categoriaService.getCategorie();
    }
    
    @GetMapping(value="/get/{id}", produces = "application/json")
    public ResponseEntity<?> getCategoriaById(@PathVariable int id) {
        try {
            Categoria categoria = categoriaService.getCategoriaById(id);
            return ResponseEntity.ok(categoria);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Categoria non trovata per l'id: " + id);
        }
    }    
    
    
    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    public ResponseEntity<?> deleteCategoria(@PathVariable int id) {
        try {
            categoriaService.cancellaCategoria(id);
            return ResponseEntity.ok("Categoria con ID " + id + " cancellata con successo");
        } catch (Exception e) {
            // Aggiungi log per vedere l'errore nella console
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Errore durante la cancellazione della categoria con ID " + id);
        }
    }
    
    @PostMapping(value = "/save", produces = "application/json")
    public ResponseEntity<?> aggiungiCategoria(@RequestBody Categoria nuovaCategoria) {
        try {
            categoriaService.salvaCategoria(nuovaCategoria);
            return ResponseEntity.ok("Categoria aggiunta con successo");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Errore durante l'aggiunta della nuova categoria");
        }
    }
    
    @PutMapping(value = "/update/{id}", produces = "application/json")
    public ResponseEntity<?> aggiornaCategoria(@PathVariable int id,    										   
    										   @RequestBody Categoria categoriaAggiornata) {
        try {
            categoriaService.aggiornaCategoria(categoriaAggiornata, id);
            return ResponseEntity.ok("Categoria con ID " + id + " aggiornata con successo");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Errore durante l'aggiornamento della categoria con ID " + id);
        }
    }

}