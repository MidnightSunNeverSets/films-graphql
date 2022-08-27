package com.midnightsun.films.services;

import com.midnightsun.films.Utils;
import com.midnightsun.films.models.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CharacterService {
    @Autowired
    private Utils repo;

    public Set<Character> getCharactersInFilm(String projectName) {
        return repo.getCharactersByFilm().get(projectName);
    }
}
