package com.midnightsun.films.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.util.LinkedHashSet;

@Getter
@AllArgsConstructor
public class Scene {
    private String id;

    private String description;

}
