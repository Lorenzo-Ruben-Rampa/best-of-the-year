package org.lessons.java.best_of_the_year.controller;
import org.lessons.java.best_of_the_year.Movie;
import org.lessons.java.best_of_the_year.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/")
public class MediaController {

    @GetMapping ("/")
    public String home(Model model) {
        model.addAttribute("name", "Lorenzo");
        return "home";
    }

    // @GetMapping("/root")
    // //Metodo rotta root che ritorna il mio nome
    // public String root(Model model) {
    //     model.addAttribute("name", "Lorenzo");
    //     return "root"; 
    // }

        // Endpoint pubblico per i film
    @GetMapping("/movies")
    public String showMovies(Model model) {
        model.addAttribute("movies", getBestMovies());
        return "movies";
    }

    // Endpoint pubblico per le canzoni
    @GetMapping("/songs")
    public String showSongs(Model model) {
        model.addAttribute("songs", getBestSongs());
        return "songs";
    }

        // Metodo privato per la lista di film
    private List<Movie> getBestMovies() {
        List<Movie> bestMovies = new ArrayList<>();
        bestMovies.add(new Movie(1, "Inception", "Christopher Nolan"));
        bestMovies.add(new Movie(2, "The Shawshank Redemption", "Frank Darabont"));
        bestMovies.add(new Movie(3, "Pulp Fiction", "Quentin Tarantino"));
        return bestMovies;
    }

    // Metodo privato per la lista di canzoni
    private List<Song> getBestSongs() {
        List<Song> bestSongs = new ArrayList<>();
        bestSongs.add(new Song(1, "Bohemian Rhapsody", "Queen"));
        bestSongs.add(new Song(2, "Imagine", "John Lennon"));
        bestSongs.add(new Song(3, "Like a Rolling Stone", "Bob Dylan"));
        return bestSongs;
    }

    //METODI PER ACCEDERE ALL'URL
    @GetMapping("/movies/{id}/{titolo}")
    public String movies(Model model, @PathVariable("id") int id, @PathVariable("titolo") String titolo) {
    // Cerca il film per ID e titolo 
    Movie movieFound = null;
    List<Movie> movies = getBestMovies(); // Ottieni la lista di film
    
    for (Movie m : movies) {
        if (m.getId() == id) {
            movieFound = m;
            break; // Esci dal ciclo appena trovato
        }
    }

    if (movieFound == null) {
        return "movieNotFound"; // Pagina di errore personalizzata
    }

    model.addAttribute("movie", movieFound);
    return "movieById"; 
    }

        @GetMapping("/songs/{id}/{titolo}")
    public String songs(Model model, @PathVariable("id") int id, @PathVariable("titolo") String titolo) {
    // Cerca il film per ID e titolo
    Song songFound = null;
    List<Song> songs = getBestSongs(); // Ottieni la lista di film
    
    for (Song s : songs) {
        if (s.getId() == id) {
            songFound = s;
            break; // Esci dal ciclo appena trovato
        }
    }

    if (songFound == null) {
        return "movieNotFound"; // Pagina di errore personalizzata
    }

    model.addAttribute("song", songFound);
    return "songById"; 
    }

    //METODI PER ACCEDERE SOLO CON L'ID NELL'URL

    @GetMapping("/songs/{id}")
        public String redirectSongById(Model model, @PathVariable("id") int id) {
        // Ciclo la mia lista di canzoni dal getter
        Song songFound = null;
        for (Song s : getBestSongs()) {
            if (s.getId() == id) {
                songFound = s;
                break; 
            }
        }
        // Se la canzone esiste, reindirizza all'URL con ID e titolo
        if (songFound != null) {
            return "redirect:/songs/" + id + "/" + songFound.getTitolo();
        } else {
            return "songNotFound";
        }
    }    
    

    @GetMapping("/movies/{id}")
    public String redirectMovieById(@PathVariable("id") int id) {
        // Trova il film corrispondente all'ID
        Movie movieFound = null;
        for (Movie m : getBestMovies()) {
            if (m.getId() == id) {
            movieFound = m;
            break;
            }
        } 
        // Se il film esiste, reindirizza all'URL con ID e titolo
        if (movieFound != null) {
            return "redirect:/movies/" + id + "/" + movieFound.getTitolo();
        } else {
            return "movieNotFound";
        }
    }
}