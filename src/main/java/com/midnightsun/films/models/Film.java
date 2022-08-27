package com.midnightsun.films.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
public class Film {
    private String projectName;

    private String title;

    private int releaseYear;
}
