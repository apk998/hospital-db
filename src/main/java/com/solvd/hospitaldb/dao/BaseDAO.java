package com.solvd.hospitaldb.dao;

import java.util.Optional;

public interface BaseDAO<T> {
    void create(T t);
    Optional<T> findByID(int id);
    void updateByID(T t, int id);
    void deleteByID(T t);
}