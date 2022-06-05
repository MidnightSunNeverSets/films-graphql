package com.midnightsun.films.datafetchers;

import com.midnightsun.films.models.Film;
import com.midnightsun.films.services.FilmService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
        return service.getFilms();
    }
}
