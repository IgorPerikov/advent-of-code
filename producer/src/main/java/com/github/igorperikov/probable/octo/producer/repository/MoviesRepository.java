package com.github.igorperikov.probable.octo.producer.repository;

import com.github.igorperikov.probable.octo.producer.domain.MovieEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends CrudRepository<MovieEntity, Integer> {

}
