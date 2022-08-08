package com.midnightsun.films.datafetchers;

import com.midnightsun.films.models.Actor;
import com.midnightsun.films.models.Film;
import com.midnightsun.films.services.ActorService;
import com.netflix.graphql.dgs.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@DgsComponent
public class ActorDataFetcher {
    @Autowired
    ActorService actorService;

    @DgsQuery(field = "actor")
    private Actor getActor(@InputArgument String username) {
        return actorService.getActorFromUsername(username);
    }

    @DgsQuery(field = "actors")
    private List<Actor> getAllActors() {
        return actorService.getActors();
    }

    @DgsData(parentType = "Film", field = "cast")
    private Set<Actor> getCastFromFilm(DgsDataFetchingEnvironment dfe) {
        Film film = dfe.getSource();
        /*
        Note, in this case since I'm building the DB at runtime using H2 and inserting them using Spring JPA,
        "foreign keys" are already part of a class, and thus DB technically does not need to be called
         */
        return film.getCast();
    }
}
