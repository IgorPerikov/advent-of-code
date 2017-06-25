package com.github.igorperikov.probable.octo.producer.repository;

import com.github.igorperikov.probable.octo.producer.domain.ChannelEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelsRepository extends CrudRepository<ChannelEntity, Integer> {

}
