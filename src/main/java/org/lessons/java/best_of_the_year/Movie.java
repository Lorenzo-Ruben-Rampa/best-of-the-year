package org.lessons.java.best_of_the_year;
import java.io.Serializable;

public class Movie implements Serializable {
    private int id;
    private String titolo;
    private String regista;

    public Movie() {}

    public Movie(int id, String titolo, String regista) {
        this.id = id;
        this.titolo = titolo;
        this.regista = regista;
	}

	 public int getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getRegista() {
        return regista;
    }

    public void setRegista(String regista) {
        this.regista = regista;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
}
