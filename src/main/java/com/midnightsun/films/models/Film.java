package com.midnightsun.films.models;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@Table(name = "t_films")
public class Film {
    @Id
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "title")
    private String title;
    @Column(name = "release_year")
    private short releaseYear;
    @ManyToMany
    @JoinTable(
            name = "t_filmsdirectors",
            joinColumns = @JoinColumn(name = "film_project_name"),
            inverseJoinColumns = @JoinColumn(name = "director_username")
    )
    private Set<Director> directors;
    @ManyToMany
    @JoinTable(
            name = "t_filmsactors",
            joinColumns = @JoinColumn(name = "film_project_name"),
            inverseJoinColumns = @JoinColumn(name = "actor_username")
    )
    private Set<Actor> cast;
    @OneToMany(mappedBy = "parentFilm")
    private List<Scene> scenes;
}
