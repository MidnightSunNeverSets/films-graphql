package com.midnightsun.films.services;

import com.midnightsun.films.Utils;
import com.midnightsun.films.models.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class FilmService {
    @Autowired
    private Utils repo;

    public Film getFilm(String projectName) {
        return repo.getFilms().get(projectName);
    }

    public List<Film> getAllFilms() {
        return new ArrayList<>(repo.getFilms().values());
    }

    public Set<Film> getFilmography(String username) {
        return repo.getFilmsByActor().get(username);
    }
}
