package org.lessons.java.best_of_the_year;
import java.io.Serializable;

public class Song implements Serializable {
    private int id;
    private String titolo;
    private String autore;

    public Song() {}

    public Song(int id, String titolo, String autore) {
        this.id = id;
        this.titolo = titolo;
        this.autore = autore;
	}

	 public int getId() {
        return this.id;
    }

    public String getTitolo() {
        return this.titolo;
    }

       public String getAutore() {
        return this.autore;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }
}
