package cz.czechitas;

import java.time.*;


public class Article {
        Long id;
        String nazev;
        String autor;
        LocalDate datum;

    public Article() {
    }

    public Article(Long id, String nazev, String autor, LocalDate datum) {
        this.id = id;
        this.nazev = nazev;
        this.autor = autor;
        this.datum = datum;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long newValue) {
        id = newValue;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String newValue) {
        nazev = newValue;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String newValue) {
        autor = newValue;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate newValue) {
        datum = newValue;
    }

    @Override
    public String toString() {
        return "Article " +
                "id=" + id + ", " +
                "nazev=\"" + nazev + "\"" + ", " +
                "autor=\"" + autor + "\"" + ", " +
                "datum=" + datum;
    }
}
