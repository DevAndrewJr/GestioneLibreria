package it.libreria.controller;

import java.util.List;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import it.libreria.model.Autore;
import it.libreria.service.AutoreService;
import it.libreria.model.Categoria;
import it.libreria.model.Libro;
import it.libreria.service.CategoriaService;
import it.libreria.dao.CategoriaDao;


@Controller
@RequestMapping("/categorie")
public class CategoriaController {
	
	@Autowired
	@Qualifier("categoriaServiceImpl")
	private CategoriaService categoriaService;
		
	@GetMapping
	public String getPage(Model model) {
		List<Categoria> categorie = categoriaService.getCategorie();
		model.addAttribute("categorie", categorie);
		return "categorie";	
	}	
	
	@GetMapping ("/paginaInserisciCategoria")
	public String inserisciCategoria(@ModelAttribute ("categoria") Categoria categoria, Model model){		
		return "inserisciCategoriaForm";	
	}
			
	@GetMapping("/paginaAggiornaCategoria")
	public String getDettagliCategoria(@RequestParam("id") int id, Model model) {
		Categoria categoria = categoriaService.getCategoriaById(id);
		model.addAttribute("categoria", categoria);		
		return "aggiornaCategoriaForm";
	}
	
	@GetMapping("/cancella")
	public String cancellaCategoria(@RequestParam("id") int id) {
		categoriaService.cancellaCategoria(id);
		return "redirect:/categorie";
	}
	
	@PostMapping("/save")
	public String registraCategoria(@ModelAttribute ("categoria") Categoria categoria, BindingResult result) {
		categoriaService.salvaCategoria(categoria);
		return "redirect:/categorie";
	}
	
	@PostMapping("/aggiornaCategoria")
    public String aggiornaLibro(@ModelAttribute("categoria") Categoria categoria, int id, BindingResult result) {
        categoriaService.aggiornaCategoria(categoria, id);
        return "redirect:/categorie";
    }
	
	
}