package com.midnightsun.films.datafetchers;

import com.midnightsun.films.models.Character;
import com.midnightsun.films.models.Film;
import com.midnightsun.films.services.CharacterService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@DgsComponent
public class CharacterDataFetcher {
    @Autowired
    private CharacterService service;

    @DgsData(parentType = "Film", field = "characters")
    private Set<Character> charactersInFilm(DgsDataFetchingEnvironment dfe) {
        Film film = dfe.getSource();
        return service.getCharactersInFilm(film.getProjectName());
    }
}
