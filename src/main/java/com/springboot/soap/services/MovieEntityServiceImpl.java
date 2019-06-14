package com.springboot.soap.services;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.soap.entities.*;
import com.springboot.soap.repository.*;

@Service
@Transactional
public class MovieEntityServiceImpl implements MovieEntityService{

    private MovieEntityRepository _repository;

    @Autowired
    public MovieEntityServiceImpl(MovieEntityRepository repository) {
        this._repository = repository;
    }

    @Override
    public MovieEntity getEntityById(long id) {
        return this._repository.findById(id).get();
    }

    @Override
    public MovieEntity getEntityByTitle(String title) {
        return this._repository.findByTitle(title);
    }

    @Override
    public List<MovieEntity> getAllEntities() {
        List<MovieEntity> list = new ArrayList<>();
        _repository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public MovieEntity addEntity(MovieEntity movieEntity) {
        try {
            return this._repository.save(movieEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateEntity(MovieEntity movieEntity) {
        try {
            this._repository.save(movieEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteEntityById(long id) {
        try {
            this._repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}