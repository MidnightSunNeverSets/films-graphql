package com.midnightsun.films.datafetchers;

import com.midnightsun.films.models.Scene;
import com.midnightsun.films.models.Shot;
import com.midnightsun.films.services.ShotService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

@DgsComponent
public class ShotDataFetcher {
    @Autowired
    private ShotService service;

    @DgsData(parentType = "Scene", field = "shots")
    private Set<Shot> shotsInScene(DgsDataFetchingEnvironment dfe) {
        Scene scene = dfe.getSource();
        return service.getShotsInScene(scene.getId());
    }
}
