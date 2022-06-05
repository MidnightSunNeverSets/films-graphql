package com.midnightsun.films.models;

import lombok.Getter;

import javax.persistence.*;
import java.util.LinkedHashSet;

@Getter
@Entity
@Table(name = "t_scenes")
public class Scene {
    @Id
    @Column
    private String id;
    @Column
    private String description;
    @ManyToOne
    @JoinColumn(name = "film_project_name")
    private Film parentFilm;

}
