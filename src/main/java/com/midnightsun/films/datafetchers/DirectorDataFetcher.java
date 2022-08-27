package com.midnightsun.films.datafetchers;

import com.midnightsun.films.models.Director;
import com.midnightsun.films.services.DirectorService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

@DgsComponent
public class DirectorDataFetcher {
    @Autowired
    private DirectorService service;

    @DgsQuery(field = "director")
    private Director getDirector(@InputArgument String username) {
        return service.getDirector(username);
    }
}
