package com.midnightsun.films.datafetchers;

import com.midnightsun.films.models.Actor;
import com.midnightsun.films.models.Film;
import com.midnightsun.films.services.FilmService;
import com.netflix.graphql.dgs.*;
import graphql.relay.Connection;
import graphql.relay.SimpleListConnection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@DgsComponent
public class FilmDataFetcher {
    @Autowired
    FilmService service;

    @DgsQuery(field = "film")
    private Film getFilm(@InputArgument String projectName) {
        return service.getFilm(projectName);
    }

    // useful link for DGS pagination:
    @DgsQuery(field = "films")
    private Connection<Film> getFilms(
        DgsDataFetchingEnvironment dfe,
        // The implementation for enacting upon these parameters is provided by DGS
        @InputArgument int first, // refers to the first # of items
        @InputArgument String after // the cursor, it is based on the cursor from the pageInfo provided from DGS
    ) {
        return new SimpleListConnection<>(service.getFilms()).get(dfe);
    }

    @DgsData(parentType = "Actor", field = "filmography")
    private Set<Film> getFilmography(DgsDataFetchingEnvironment dfe) {
        Actor actor = dfe.getSource();
        return service.getFilmography(actor.getUsername());
    }
}
