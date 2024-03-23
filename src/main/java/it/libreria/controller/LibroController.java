package it.libreria.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import it.libreria.model.Autore;
import it.libreria.model.Categoria;
import it.libreria.model.Libro;
import it.libreria.service.AutoreService;
import it.libreria.service.CategoriaService;
import it.libreria.service.LibroService;


@Controller
@RequestMapping("/libri")
public class LibroController {
	
	@Autowired
	private LibroService libroService;
	
	@Autowired
	private AutoreService autoreService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	
	@GetMapping
	public String getPage(Model model) {		
		List<Libro> libri = libroService.getLibri();
		model.addAttribute("libri", libri);
		return "libri";	
	}	
	
	/*
	@GetMapping
	public String getPage(Model model, @RequestParam(name = "id", required = false) Integer id ) {
		Libro libro = id == null ? new Libro() : libroService.getLibroById(id);
		List<Libro> libri = libroService.getLibri();
		model.addAttribute("libri", libri);
		return "libri";	
	}	
	*/

	@GetMapping ("/inserisciLibro")
	public String inserisciLibro(@ModelAttribute ("libro") Libro libro, Model model){
			
		List<Autore> autori = autoreService.getAutori();
		model.addAttribute("autori", autori);
			
		List<Categoria> categorie = categoriaService.getCategorie();
		model.addAttribute("categorie", categorie);
		
		return "inserisciLibroForm";
	}
	
	@GetMapping("/cancella")
	public String cancellaLibro(@RequestParam("id") int id) {
		libroService.cancellaLibro(id);
		return "redirect:/libri";
	}
	
	
	@GetMapping("/paginaAggiornaLibro")
	public String getDettagliLibro(@RequestParam("id") int id, Model model) {
		Libro libro = libroService.getLibroById(id);
		model.addAttribute("libro", libro);
		
		List<Autore> autori = autoreService.getAutori();
		model.addAttribute("autori", autori);
			
		List<Categoria> categorie = categoriaService.getCategorie();
		model.addAttribute("categorie", categorie);
		
		return "aggiornaLibroForm";
	}
		
	@PostMapping("/save")
	public String registraLibro(@ModelAttribute("libro") Libro libro, BindingResult result) {
		
		libroService.salvaLibro(libro);
		return "redirect:/libri";
	}
	
	@PostMapping("/aggiornaLibro")
    public String aggiornaLibro(@ModelAttribute("libro") Libro libro, int id, BindingResult result) {
        libroService.aggiornaLibro(libro, id);
        return "redirect:/libri";
    }
	
	
}