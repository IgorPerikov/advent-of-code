package com.github.igorperikov.probable.octo.producer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ChannelEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String channelName;
}
