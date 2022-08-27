package com.midnightsun.films.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
public class Actor {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "name")
    private String name;
}
