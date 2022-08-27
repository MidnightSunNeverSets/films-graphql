package com.midnightsun.films.services;

import com.midnightsun.films.Utils;
import com.midnightsun.films.models.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ActorService {
    @Autowired
    private Utils repo;

    public Actor getActorFromUsername(String username) {
        return repo.getActors().get(username);
    }

    public List<Actor> getActors() {
        return new ArrayList<>(repo.getActors().values());
    }

    public Set<Actor> getFilmCast(String projectName) {
        return repo.getActorsByFilm().get(projectName);
    }
}
