package com.github.igorperikov.probable.octo.producer.domain;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "movies")
public class MovieEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String movieName;

    @ManyToMany
    private Set<ActorEntity> actors;

    @OneToMany
    private Set<EventEntity> events;
}
