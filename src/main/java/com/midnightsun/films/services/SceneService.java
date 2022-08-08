package com.midnightsun.films.services;

import com.midnightsun.films.models.Scene;
import com.midnightsun.films.repos.SceneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SceneService {
    @Autowired
    private SceneRepo repo;

    public List<Scene> getScenesInFilm(String parentFilm) {
        return repo.findAll();
    }
}
