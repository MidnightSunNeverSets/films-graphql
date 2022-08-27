package com.midnightsun.films.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Shot {
    private String id;
    private String description;
}
