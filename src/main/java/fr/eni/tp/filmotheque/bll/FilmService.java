package fr.eni.tp.filmotheque.bll;

import java.util.List;

import fr.eni.tp.filmotheque.bo.Film;
import fr.eni.tp.filmotheque.bo.Genre;
import fr.eni.tp.filmotheque.bo.Participant;

public interface FilmService {

	List<Film> consulterFilms();

	/**
	 * @return film si id correspond
	 * @return null si inconnu
	 */
	Film consulterFilmParId(long id);

	List<Genre> consulterGenres();

	List<Participant> consulterParticipants();

	Genre consulterGenreParId(long id);

	/**
	 * @return participant si id correspond
	 * @return null si inconnu
	 */
	Participant consulterParticipantParId(long id);

	void creerFilm(Film film);

}
