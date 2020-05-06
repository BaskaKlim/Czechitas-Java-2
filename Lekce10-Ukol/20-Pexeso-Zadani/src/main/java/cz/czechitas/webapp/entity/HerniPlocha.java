package cz.czechitas.webapp.entity;

import java.util.*;

public class HerniPlocha {

    private Long id;
    private GameState stav;
    private List<Karta> karticky;

    public HerniPlocha() {
    }

    public HerniPlocha(List<Karta> karticky, GameState stav) {
        this.karticky = karticky;
        this.stav = stav;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GameState getStav() {
        return stav;
    }

    public void setStav(GameState stav) {
        this.stav = stav;
    }

    public List<Karta> getKarticky() {
        return karticky;
    }

    public void setKarticky(List<Karta> newValue) {
        karticky = newValue;
    }
}
