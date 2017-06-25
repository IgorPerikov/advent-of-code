package com.github.igorperikov.probable.octo.producer.repository;

import com.github.igorperikov.probable.octo.producer.domain.EventEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends CrudRepository<EventEntity, Integer> {

}
