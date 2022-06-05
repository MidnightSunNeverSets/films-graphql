package com.midnightsun.films.repos;

import com.midnightsun.films.models.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmRepo extends CrudRepository<Film, String> {
    Film findFilmByProjectName(String projectName);
    List<Film> findAll();
}
