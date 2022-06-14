package com.midnightsun.films.services;

import com.midnightsun.films.models.Actor;
import com.midnightsun.films.repos.ActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService {
    @Autowired
    private ActorRepo repo;

    public Actor getActorFromUsername(String username) {
        return repo.findActorByUsername(username);
    }
}
