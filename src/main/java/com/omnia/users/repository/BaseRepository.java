package com.omnia.users.repository;

import com.omnia.users.model.entities.BaseEntity;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.Collection;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity<T>, K extends Serializable> extends Repository<T, K> {

    T save(T entity);

    Collection<T> findAll();

    T findById(K entityId);

    void delete(T entity);

    void deleteById(K entityId);

}
