package model;

import java.util.ArrayList;

public class Session {

    // sessions
    protected ArrayList<Squad> squads = new ArrayList<>();
    protected ArrayList<Hero> heroes = new ArrayList<>();

    public ArrayList<Squad> getSquads() {
        return squads;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void addHero(Hero hero) {
        if(this.findHeroById(hero.getId()) != null) {
            this.heroes.remove(hero.getId());
            this.heroes.add(hero.getId(), hero);
        } else {
            hero.setId(this.heroes.size() + 1);
            this.heroes.add(hero);
        }
    }

    public void addSquad(Squad squad) {
        if(this.findSquadById(squad.getId()) != null) {
            this.squads.remove(squad.getId());
            squad.setCountHeroes(squad.getSquadHeroes().size());
            this.squads.add(squad.getId(), squad);
        } else {
            squad.setId(this.squads.size() + 1);
            squad.setCountHeroes(squad.getSquadHeroes().size());
            this.squads.add(squad);
        }
    }

    public Hero findHeroById(int id) {
        for (Hero hero: heroes) {
            if(hero.getId() == id) {
                return hero;
            }
        }
        return null;
    }

    public Squad findSquadById(int id) {
        for (Squad squad: squads) {
            if(squad.getId() == id) {
                squad.setCountHeroes(squad.getSquadHeroes().size());
                return squad;
            }
        }
        return null;
    }
}
