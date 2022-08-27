package com.midnightsun.films;

import com.midnightsun.films.models.*;
import com.midnightsun.films.models.Character;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

/*
Was too lazy to set up a DB, so this class is meant to simulate one.
*Note: None of this is actually good coding practices.
 */

@Component
public class Utils {
    private Map<String, Film> films;
    private Map<String, Director> directors;
    private Map<String, Actor> actors;
    private Map<String, Character> characters;

    private Map<String, Set<Actor>> actorsByFilm;
    private Map<String, Set<Director>> directorsByFilm;
    private Map<String, Set<Shot>> shotsByScene;
    private Map<String, Set<Character>> charactersByShot;
    private Map<String, Set<Character>> charactersByActor;
    private Map<String, Set<Scene>> scenesByFilm;
    private Map<String, Set<Character>> charactersByFilm;
    private Map<String, Set<Film>> filmsByActor;
    private Map<String, Set<Film>> filmsByDirector;
    private Map<String, Film> filmCharacterIn;

    public Utils() {
        initialize();
        film1();
        film2();
        film3();
    }

    public Map<String, Film> getFilmCharacterIn() {
        return filmCharacterIn;
    }

    public void initialize() {
        // initialize
        films = new HashMap<>();
        directors = new HashMap<>();
        actors = new HashMap<>();
        characters = new HashMap<>();

        actorsByFilm = new HashMap<>();
        directorsByFilm = new HashMap<>();
        shotsByScene = new HashMap<>();
        charactersByShot = new HashMap<>();
        charactersByActor = new HashMap<>();
        scenesByFilm = new HashMap<>();
        charactersByFilm = new HashMap<>();
        filmsByActor = new HashMap<>();
        filmsByDirector = new HashMap<>();
        filmCharacterIn = new HashMap<>();


    }

    public void film1() {
        // films
        Film matrixFilm = Film.builder()
                .title("The Matrix")
                .projectName("matrix")
                .releaseYear(2000)
                .build();

        // actors
        Actor keanur = Actor.builder().
                username("keanur")
                .name("Keanu Reeves")
                .build();

        Actor hugow = Actor.builder().
                username("hugow")
                .name("Hugo Weaving")
                .build();

        addActorToFilm(matrixFilm, keanur);
        addActorToFilm(matrixFilm, hugow);

        // characters
        Character matrix_neo = Character.builder()
                .id("matrix_neo")
                .name("Neo")
                .playedBy(keanur)
                .build();

        Character matrix_one = Character.builder()
                .id("matrix_one")
                .name("The One")
                .playedBy(keanur)
                .build();
        Character matrix_smith = new Character("matrix_smith", "Agent Smith", hugow);

        addCharacterToFilm(matrixFilm, matrix_neo);
        addCharacterToFilm(matrixFilm, matrix_one);
        addCharacterToFilm(matrixFilm, matrix_smith);

        addCharacterToActor(keanur, matrix_neo);
        addCharacterToActor(keanur, matrix_one);
        addCharacterToActor(hugow, matrix_smith);

        // directors
        Director lanaw = new Director("lanaw", "Lana Wachowski");
        Director lillyw = new Director("lillyw", "Lilly Wachowski");

        addDirectorToFilm(matrixFilm, lanaw);
        addDirectorToFilm(matrixFilm, lillyw);

        // scenes and shots
        for (int i = 1; i <=7; i++) {
            String sceneName = "matrix_scene0" + i;
            Scene scene = new Scene(sceneName, "something happens lol");
            addSceneToFilm(matrixFilm, scene);
            for (int k = 1; k <=2; k++) {
                addShotToScene(scene, new Shot(sceneName + "_0" + k, "Image of something"));
            }

        }

    }

    public void film2() {
        Film lotr = Film.builder()
                .projectName("lotr")
                .title("Lord of the Rings")
                .releaseYear(2001).build();

        // directors
        addDirectorToFilm(lotr, new Director("peterj", "Peter Jackson"));

        // actors
        List<Actor> lotrActors = new ArrayList<>();

        lotrActors.add(new Actor("elijaw", "Elijah Wood"));
        lotrActors.add(new Actor("ianm", "Ian McKellen"));
        lotrActors.add(new Actor("viggom", "Viggo Mortensen"));
        lotrActors.add(new Actor("seana", "Sean Astin"));
        lotrActors.add(new Actor("seanb", "Sean Bean"));
        lotrActors.add(new Actor("orlandob", "Orlando Bloom"));
        lotrActors.add(new Actor("johnr", "John Rhys-Davies"));

        addActorToFilm(lotr, actors.get("hugow"));
        for (Actor actor: lotrActors) {
            addActorToFilm(lotr, actor);
        }

        // characters
        List<Character> lotrCharacters = new ArrayList<>();
        lotrCharacters.add(new Character("lotr_frodo", "Frodo Baggins", lotrActors.get(0)));
        lotrCharacters.add(new Character("lotr_gandalf", "Gandalf the Grey", lotrActors.get(1)));
        lotrCharacters.add(new Character("lotr_aragorn", "Aragorn", lotrActors.get(2)));
        lotrCharacters.add(new Character("lotr_sam", "Samwise Gamgee", lotrActors.get(3)));
        lotrCharacters.add(new Character("lotr_boromir", "Boromir", lotrActors.get(4)));
        lotrCharacters.add(new Character("lotr_legolas", "Legolas Greenleaf", lotrActors.get(5)));
        lotrCharacters.add(new Character("lotr_gimli", "Gimli", lotrActors.get(6)));

        Character elrond = new Character("lotr_elrond", "Elrond", actors.get("hugow"));
        addCharacterToFilm(lotr, elrond);
        addCharacterToActor(actors.get("hugow"), elrond);

        for (int i = 0; i < lotrCharacters.size(); i++) {
            addCharacterToFilm(lotr, lotrCharacters.get(i));
            addCharacterToActor(lotrActors.get(i), lotrCharacters.get(i));
        }

        // scenes and shots
        for (int i = 1; i <=4; i++) {
            String sceneName = "lotr_scene0" + i;
            Scene scene = new Scene(sceneName, "something happens in lotr lol");
            addSceneToFilm(lotr, scene);
            for (int k = 1; k <=4; k++) {
                addShotToScene(scene, new Shot(sceneName + "_0" + k, "Image of something in lotr"));
            }

        }

    }

    public void film3() {
        Film shibe = Film.builder()
                .projectName("shibe")
                .title("Mr. Shibe's Big Adventure")
                .releaseYear(2021)
                .build();

        // director
        addDirectorToFilm(shibe, new Director("doggo", "Doggo McDog"));

        // actor
        addActorToFilm(shibe, actors.get("seanb"));

        //characters
        List<Character> shibeCharacters = new ArrayList<>();
        shibeCharacters.add(new Character("mrshibe", "Mr. Shibe", actors.get("seanb")));
        shibeCharacters.add(new Character("chonk", "The Chonk", actors.get("seanb")));
        shibeCharacters.add(new Character("doge", "Le Doge", actors.get("seanb")));
        shibeCharacters.add(new Character("trashp", "Trash Panda", actors.get("seanb")));

        for (Character c: shibeCharacters) {
            addCharacterToFilm(shibe, c);
            addCharacterToActor(c.getPlayedBy(), c);
        }

        Scene scene = new Scene("shibe_scene01", "Something happens in Shibe movie");
        addSceneToFilm(shibe, scene);

        String shot = "_0";
        for (int i = 1; i <= 24; i++) {
            if (i > 9) {
                shot = "_";
            }
            addShotToScene(scene, new Shot(scene.getId() + shot + String.valueOf(i), "image of shibe"));
        }

    }



    // getters
    public Map<String, Film> getFilms() {
        return films;
    }

    public Map<String, Director> getDirectors() {
        return directors;
    }

    public Map<String, Actor> getActors() {
        return actors;
    }

    public Map<String, Character> getCharacters() {
        return characters;
    }

    public Map<String, Set<Actor>> getActorsByFilm() {
        return actorsByFilm;
    }

    public Map<String, Set<Director>> getDirectorsByFilm() {
        return directorsByFilm;
    }

    public Map<String, Set<Shot>> getShotsByScene() {
        return shotsByScene;
    }

    public Map<String, Set<Character>> getCharactersByShot() {
        return charactersByShot;
    }

    public Map<String, Set<Character>> getCharactersByActor() {
        return charactersByActor;
    }

    public Map<String, Set<Scene>> getScenesByFilm() {
        return scenesByFilm;
    }

    public Map<String, Set<Character>> getCharactersByFilm() {
        return charactersByFilm;
    }

    public Map<String, Set<Film>> getFilmsByActor() {
        return filmsByActor;
    }

    public Map<String, Set<Film>> getFilmsByDirector() {
        return filmsByDirector;
    }

    // adders
    public boolean addFilm(Film film) {
        if (!films.containsKey(film.getProjectName())) {
            films.put(film.getProjectName(), film);

            actorsByFilm.put(film.getProjectName(), new HashSet<>());
            directorsByFilm.put(film.getProjectName(), new HashSet<>());
            scenesByFilm.put(film.getProjectName(), new LinkedHashSet<>());
            charactersByFilm.put(film.getProjectName(), new HashSet<>());
            return true;
        }
        return false;
    }

    public boolean addDirector(Director director) {
        if (!directors.containsKey(director.getUsername())) {
            directors.put(director.getUsername(), director);

            filmsByDirector.put(director.getUsername(), new HashSet<>());
            return true;
        }

        return false;
    }

    public boolean addActor(Actor actor) {
        if (!actors.containsKey(actor.getUsername())) {
            actors.put(actor.getUsername(), actor);

            charactersByActor.put(actor.getUsername(), new HashSet<>());
            filmsByActor.put(actor.getUsername(), new HashSet<>());
            return true;
        }
        return false;
    }

    public boolean addCharacter(Character character) {
        if (!characters.containsKey(character.getId())) {
            characters.put(character.getId(), character);
            return true;
        }
        return false;
    }

    public void addSceneToFilm(Film film, Scene scene) {
        String project_name = film.getProjectName();

        if (!scenesByFilm.containsKey(project_name)) {
            addFilm(film);
        }

        scenesByFilm.get(film.getProjectName()).add(scene);
    }

    public void addShotToScene(Scene scene, Shot shot) {
        if (!shotsByScene.containsKey(scene.getId())) {
            shotsByScene.put(scene.getId(), new LinkedHashSet<>());
        }
        shotsByScene.get(scene.getId()).add(shot);
    }

    public void addCharacterToShot(Shot shot, Character character) {
        if (!charactersByShot.containsKey(shot.getId())) {
            charactersByShot.put(shot.getId(), new HashSet<>());
        }
        addCharacter(character);
        charactersByShot.get(shot.getId()).add(character);
    }

    public void addCharacterToActor(Actor actor, Character character) {
        if (!charactersByActor.containsKey(actor.getUsername())) {
            addActor(actor);
        }
        character.setPlayedBy(actor);
        charactersByActor.get(actor.getUsername()).add(character);
        addCharacter(character);
    }

    public void addActorToFilm(Film film, Actor actor) {
        String project_name = film.getProjectName();
        String username = actor.getUsername();

        if (!actorsByFilm.containsKey(project_name)) {
            addFilm(film);
        }

        if (!filmsByActor.containsKey(username)) {
            addActor(actor);
        }

        actorsByFilm.get(project_name).add(actor);
        filmsByActor.get(username).add(film);
    }

    public void addCharacterToFilm(Film film, Character character) {
        if (!charactersByFilm.containsKey(film.getProjectName())) {
            addFilm(film);
        }

        addCharacter(character);
        charactersByFilm.get(film.getProjectName()).add(character);
        filmCharacterIn.put(character.getId(), film);
    }

    public void addDirectorToFilm(Film film, Director director) {
        if (!directorsByFilm.containsKey(film.getProjectName())) {
            addFilm(film);
        }

        if (!filmsByDirector.containsKey(director.getUsername())) {
            addDirector(director);
        }

        directorsByFilm.get(film.getProjectName()).add(director);
        filmsByDirector.get(director.getUsername()).add(film);
    }
}
