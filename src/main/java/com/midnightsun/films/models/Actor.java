package com.midnightsun.films.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Actor {
    private String username;
    private String name;
}
