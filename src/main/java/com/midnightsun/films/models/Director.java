package com.midnightsun.films.models;

import jdk.jfr.Name;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "t_directors")
public class Director {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "directors")
    private List<Film> works;


}
