package com.midnightsun.films;

import com.midnightsun.films.models.Actor;
import com.midnightsun.films.models.Film;
import com.midnightsun.films.repos.ActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FilmsApplication {
	public static void main(String[] args) {
		SpringApplication.run(FilmsApplication.class, args);
	}
}
