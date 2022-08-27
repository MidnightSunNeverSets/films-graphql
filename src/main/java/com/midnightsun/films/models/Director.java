package com.midnightsun.films.models;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@AllArgsConstructor
public class Director {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "name")
    private String name;
}
