package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Squad extends Session {

    private int id;
    private String name;
    private int size;
    private String cause;
    private int countHeroes;
    private ArrayList<Hero> squadHeroes;

    public Squad(String name, int size, String cause) {
        this.name = name;
        this.size = size;
        this.cause = cause;
        this.squadHeroes = new ArrayList<>();
        this.setCountHeroes(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public int getCountHeroes() {
        return countHeroes;
    }

    public void setCountHeroes(int countHeroes) {
        this.countHeroes = countHeroes;
    }

    public void addHeroToSquad(Hero hero) {
        this.squadHeroes.add(hero);
        hero.setSquad(this);
    }

    public ArrayList<Hero> getSquadHeroes() { return this.squadHeroes; }

    public ArrayList<Squad> getAll() {
        return this.squads;
    }
}
