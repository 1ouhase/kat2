package net.iouhase.kat2.adapters;

import java.util.List;

public interface RepositoryItf<T> {
    void save(T entity);
    T findById(T entity);
    List<T> findAll();
    void update(T entity);
    void delete(T entity);
}
