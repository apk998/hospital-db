package com.solvd.hospitaldb.dao;

import java.util.Optional;
import java.sql.SQLException;

public interface BaseDAO<T> {
    int create(T t) throws SQLException;
    Optional<T> findByID(int id) throws SQLException;
    int updateByID(T t, int id) throws SQLException;
    int deleteByID(T t) throws SQLException;
}
