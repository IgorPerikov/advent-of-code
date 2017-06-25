package com.github.igorperikov.probable.octo.producer.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "actors")
public class ActorEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    private Set<MovieEntity> movies = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ActorEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Set<MovieEntity> getMovies() {
        return movies;
    }

    public ActorEntity setMovies(Set<MovieEntity> movies) {
        this.movies = movies;
        return this;
    }
}
