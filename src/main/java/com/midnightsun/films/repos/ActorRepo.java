package com.midnightsun.films.repos;

import com.midnightsun.films.models.Actor;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepo extends CrudRepository<Actor, String> {
}
