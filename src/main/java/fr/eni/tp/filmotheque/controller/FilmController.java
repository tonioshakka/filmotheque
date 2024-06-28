package fr.eni.tp.filmotheque.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.Film;


@Controller
@RequestMapping("/films")
public class FilmController {
	
	private FilmService filmService;
	
	public FilmController(FilmService filmService) {
		this.filmService = filmService;
	}

	@GetMapping("/detail")
	public String afficherUnFilm(@RequestParam("idFilm") long id, Model model) {
		Film f = this.filmService.consulterFilmParId(id);
		System.out.println(f);
		
		model.addAttribute("film", f);
		
		
		return "view-film-detail";
	}

	/**
	 * La méthode réagit à l'url /films et la méthode Get du protocole HTTP
	 * 
	 * @param model -- pour injecter des données à la vue
	 * @return l'alias de la page à afficher
	 */
	@GetMapping
	public String afficherFilms(Model model) {
		System.out.println("\nTous les films : ");
		List<Film> films = filmService.consulterFilms();
		// Ajout des films dans le modèle
		model.addAttribute("films", films);
		return "view-films";
	}

}
