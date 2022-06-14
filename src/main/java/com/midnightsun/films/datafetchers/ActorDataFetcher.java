package com.midnightsun.films.datafetchers;

import com.midnightsun.films.models.Actor;
import com.midnightsun.films.services.ActorService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

@DgsComponent
public class ActorDataFetcher {
    @Autowired
    ActorService actorService;

    @DgsQuery(field = "actor")
    private Actor getActor(@InputArgument String username) {
        return actorService.getActorFromUsername(username);
    }
}
