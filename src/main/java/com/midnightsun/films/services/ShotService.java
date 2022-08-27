package com.midnightsun.films.services;

import com.midnightsun.films.Utils;
import com.midnightsun.films.models.Shot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ShotService {
    @Autowired
    private Utils repo;

    public Set<Shot> getShotsInScene(String id) {
        return repo.getShotsByScene().get(id);
    }
}
