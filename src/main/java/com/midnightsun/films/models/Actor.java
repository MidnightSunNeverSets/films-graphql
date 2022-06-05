package com.midnightsun.films.models;

import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Entity
@Table(name = "t_actors")
public class Actor {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "cast")
    private Set<Film> films;
}
