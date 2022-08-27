package com.midnightsun.films.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class Character {
    private String id;
    private String name;
    private Actor playedBy;
}
