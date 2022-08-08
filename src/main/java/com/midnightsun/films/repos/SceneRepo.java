package com.midnightsun.films.repos;

import com.midnightsun.films.models.Scene;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SceneRepo extends CrudRepository<Scene, String> {
    List<Scene> findAll();
}
