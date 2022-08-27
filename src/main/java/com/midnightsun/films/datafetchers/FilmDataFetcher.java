package com.midnightsun.films.datafetchers;

import com.midnightsun.films.models.Actor;
import com.midnightsun.films.models.Film;
import com.midnightsun.films.services.FilmService;
import com.netflix.graphql.dgs.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

@DgsComponent
public class FilmDataFetcher {
    @Autowired
    FilmService service;

    @DgsQuery(field = "film")
    private Film getFilm(@InputArgument String projectName) {
        return service.getFilm(projectName);
    }

    @DgsQuery(field = "films")
    private List<Film> getFilms() {
        return service.getAllFilms();
    }

    @DgsData(parentType = "Actor", field = "filmography")
    private Set<Film> getFilmography(DgsDataFetchingEnvironment dfe) {
        Actor actor = dfe.getSource();
        return service.getFilmography(actor.getUsername());
    }
}
