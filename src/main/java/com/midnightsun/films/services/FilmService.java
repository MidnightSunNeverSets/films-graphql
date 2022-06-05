package com.midnightsun.films.services;

import com.midnightsun.films.models.Film;
import com.midnightsun.films.repos.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    @Autowired
    private FilmRepo filmRepo;

    public Film getFilm(String projectName) {
        return filmRepo.findFilmByProjectName(projectName);
    }

    public List<Film> getFilms() {
        return filmRepo.findAll();
    }
}
