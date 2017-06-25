package com.github.igorperikov.probable.octo.producer.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "events")
public class EventEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @ManyToOne
    private MovieEntity movie;

    @ManyToOne
    private ChannelEntity channel;

    public Integer getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public EventEntity setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public EventEntity setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    public MovieEntity getMovie() {
        return movie;
    }

    public EventEntity setMovie(MovieEntity movie) {
        this.movie = movie;
        return this;
    }

    public ChannelEntity getChannel() {
        return channel;
    }

    public EventEntity setChannel(ChannelEntity channel) {
        this.channel = channel;
        return this;
    }
}
