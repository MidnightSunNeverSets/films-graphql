package com.midnightsun.films.services;

import com.midnightsun.films.Utils;
import com.midnightsun.films.models.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {
    @Autowired
    Utils repo;

    public Director getDirector(String username) {
        return repo.getDirectors().get(username);
    }
}
