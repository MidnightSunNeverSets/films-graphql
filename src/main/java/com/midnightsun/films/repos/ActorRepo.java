package com.midnightsun.films.repos;

import com.midnightsun.films.models.Actor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActorRepo extends CrudRepository<Actor, String> {
    Actor findActorByUsername(String username);
    @NotNull
    List<Actor> findAll();
}
