package com.midnightsun.films.datafetchers;

import com.midnightsun.films.models.Film;
import com.midnightsun.films.models.Scene;
import com.midnightsun.films.services.SceneService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Set;

@DgsComponent
public class SceneDataFetcher {
    @Autowired
    private SceneService sceneService;

    @DgsData(parentType = "Film", field = "scenes")
    private Set<Scene> getScenesInFilm(DgsDataFetchingEnvironment env) {
        Film film = env.getSource();
        return sceneService.getScenesInFilm(film.getProjectName());
    }
}
