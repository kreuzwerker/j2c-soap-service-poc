package com.springboot.soap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.soap.entities.*;

@Repository
public interface MovieEntityRepository extends CrudRepository<MovieEntity,Long>{
    public MovieEntity findByTitle(String title);
}

