package com.github.igorperikov.probable.octo.producer.repository;

import com.github.igorperikov.probable.octo.producer.domain.ActorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorsRepository extends CrudRepository<ActorEntity, Integer> {

}
