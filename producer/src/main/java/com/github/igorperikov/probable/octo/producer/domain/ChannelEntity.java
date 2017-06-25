package com.github.igorperikov.probable.octo.producer.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "channels")
public class ChannelEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String channelName;

    @OneToMany
    private Set<EventEntity> events = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public String getChannelName() {
        return channelName;
    }

    public ChannelEntity setChannelName(String channelName) {
        this.channelName = channelName;
        return this;
    }

    public Set<EventEntity> getEvents() {
        return events;
    }

    public ChannelEntity setEvents(Set<EventEntity> events) {
        this.events = events;
        return this;
    }
}
