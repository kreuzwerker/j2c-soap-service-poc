package com.springboot.soap.services;

import java.util.List;
import com.springboot.soap.entities.*;

public interface MovieEntityService {
    public MovieEntity getEntityById(long id);
    public MovieEntity getEntityByTitle(String title);
    public List<MovieEntity> getAllEntities();
    public MovieEntity addEntity(MovieEntity movieEntity);
    public boolean updateEntity(MovieEntity movieEntity);
    public boolean deleteEntityById(long id);
}