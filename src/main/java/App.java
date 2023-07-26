import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import static spark.Spark.*;

import model.Hero;
import model.Session;
import model.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class App {
    public static Session session;

    public static void main(String[] args) {

        // new session
        if (session == null) {
            session = new Session();
        }

        // static files
        staticFileLocation("/public");

        // home page
        get("/", (request, response) -> {
            return new ModelAndView(new HashMap(), "index.hbs");
        }, new HandlebarsTemplateEngine());

        // credits page
        get("/credits", (request, response) -> {
            return new ModelAndView(new HashMap(), "credits.hbs");
        }, new HandlebarsTemplateEngine());

        // seed data
        get("/seed", (request, response) -> {
            Hero newHero1 = new Hero("Batman", 40, "I am rich", "Human");
            session.addHero(newHero1);
            Hero newHero2 = new Hero("Superman", 40, "Super strength, laser eyes, alien", "Kryptonite");
            session.addHero(newHero2);
            Hero newHero3 = new Hero("Spiderman", 16, "Spidey sense, climbing walls, super strength, agility", "Still human");
            session.addHero(newHero3);
            Hero newHero4 = new Hero("Captain America", 60, "Super strength, agility, shield", "Still human");
            session.addHero(newHero4);
            Hero newHero5 = new Hero("Hulk", 60, "Extremely strong, angry, hulk smash", "Puny Banner");
            session.addHero(newHero5);

            Squad squad1 = new Squad("Avengers", 10, "Fighting evil");
            squad1.addHeroToSquad(newHero4);
            squad1.addHeroToSquad(newHero5);
            squad1.addHeroToSquad(newHero3);
            session.addSquad(squad1);
            Squad squad2 = new Squad("Justice League", 10, "Fighting evil");
            squad2.addHeroToSquad(newHero1);
            squad2.addHeroToSquad(newHero2);
            session.addSquad(squad2);
            Squad squad3 = new Squad("Avatar TLA", 5, "Overthrowing the firelord");
            session.addSquad(squad3);

            response.redirect("/heroes");
            return null;
        });

        // hero pages
        get("/heroes", (request, response) -> {
            Map<String, Object> data = new HashMap<>();
            ArrayList<Hero> heroes = session.getHeroes();
            data.put("heroes", heroes);
            return new ModelAndView(data, "heroes.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/new", (request, response) -> {
            return new ModelAndView(new HashMap(), "hero-new.hbs");
        }, new HandlebarsTemplateEngine());

        post("/heroes/new", (request, response)-> {

            // params
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Hero newHero = new Hero(name, age, power, weakness);
            session.addHero(newHero);

            // data
            response.redirect("/heroes");
            return null;
        });

        get("/heroes/:id", (request, response) -> {
            Hero hero = session.findHeroById(Integer.parseInt(request.params(":id")));
            Map<String, Object> data = new HashMap<>();
            data.put("hero", hero);
            return new ModelAndView(data, "hero-single.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero/:id/squad", (request, response) -> {
            Hero hero = session.findHeroById(Integer.parseInt(request.params(":heroId")));
            if(hero.getSquad() != null) {
                // alert - hero already added to squad.
            }

            Map<String, Object> data = new HashMap<>();
            data.put("hero", hero);
            return new ModelAndView(data, "hero-single.hbs");
        }, new HandlebarsTemplateEngine());

        post("/hero/:id/squad", (request, response) -> {
            Hero hero = session.findHeroById(Integer.parseInt(request.params(":heroId")));
            if(hero.getSquad() != null) {
                // alert - hero already added to squad.
            }

            int squadId = Integer.parseInt(request.queryParams("squadId"));
            Squad squad = session.findSquadById(squadId);
            squad.addHeroToSquad(hero);

            Map<String, Object> data = new HashMap<>();
            data.put("hero", hero);
            return new ModelAndView(data, "hero-single.hbs");
        }, new HandlebarsTemplateEngine());

        // squad pages
        get("/squads", (request, response) -> {
            Map<String, Object> data = new HashMap<>();
            ArrayList<Squad> squads = session.getSquads();
            data.put("squads", squads);
            return new ModelAndView(data, "squads.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/new", (request, response) -> {
            return new ModelAndView(new HashMap(), "squad-new.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squads/new", (request, response)-> {

            // params
            String name = request.queryParams("name");
            int size = Integer.parseInt(request.queryParams("size"));
            String cause = request.queryParams("cause");
            Squad newSquad = new Squad(name, size, cause);
            session.addSquad(newSquad);

            // data
            response.redirect("/squads");
            return null;
        });

        get("/squads/:id", (request, response) -> {
            Squad squad = session.findSquadById(Integer.parseInt(request.params(":id")));
            Map<String, Object> data = new HashMap<>();
            data.put("squad", squad);
            data.put("heroes", squad.getSquadHeroes());
            return new ModelAndView(data, "squad-single.hbs");
        }, new HandlebarsTemplateEngine());

    }
}