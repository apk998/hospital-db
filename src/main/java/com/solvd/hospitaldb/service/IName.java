package com.solvd.hospitaldb.service;

import java.sql.SQLException;

public interface IName<T> {

    public T getByName(T t) throws SQLException;
}
