package it.libreria.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import it.libreria.model.Autore;
import it.libreria.model.Categoria;
import it.libreria.model.Libro;
import it.libreria.service.AutoreService;
import it.libreria.dao.AutoreDao;


@Controller
@RequestMapping("/autori")
public class AutoreController {
	
	@Autowired
	private AutoreService autoreService;
		
	
	@GetMapping
	public String getPage(Model model) {
		List<Autore> autori = autoreService.getAutori();
		model.addAttribute("autori", autori);
		return "autori";	
	}	
	
	@GetMapping("/inserisciAutore")
	public String inserisciAutore(@ModelAttribute ("autore") Autore autore, Model model) {
		return "inserisciAutoreForm";
	}
	
	@GetMapping("/cancella")
	public String cancellaAutore(@RequestParam("id") int id) {
		autoreService.cancellaAutore(id);
		return "redirect:/autori";
	}
	
	@GetMapping("/paginaAggiornaAutore")
	public String getDettagliAutore(@RequestParam("id") int id, Model model) {
		Autore autore = autoreService.getAutoreById(id);
		model.addAttribute("autore", autore);			
		return "aggiornaAutoreForm";
	}
	
	
	@PostMapping("/save")
	public String registraAutore(@ModelAttribute ("autore") Autore autore, BindingResult result) {
		autoreService.salvaAutore(autore);
		return "redirect:/autori";
	}
	
	@PostMapping("/aggiornaAutore")
    public String aggiornaLibro(@ModelAttribute("autore") Autore autore, int id, BindingResult result) {
        autoreService.aggiornaAutore(autore, id);
        return "redirect:/autori";
    }
	
}