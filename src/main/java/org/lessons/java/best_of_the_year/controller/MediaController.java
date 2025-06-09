package org.lessons.java.best_of_the_year.controller;
import org.lessons.java.best_of_the_year.Movie;
import org.lessons.java.best_of_the_year.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MediaController {

    @GetMapping ("/")
    public String home() {
        return "home";
    }

    @GetMapping("/root")
    //Metodo rotta root
    public String root(Model model) {
        model.addAttribute("name", "Lorenzo");
        return "root"; 
    }

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
}