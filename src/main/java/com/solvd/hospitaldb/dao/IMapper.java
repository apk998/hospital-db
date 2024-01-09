package com.solvd.hospitaldb.dao;

public interface IMapper<T> {
    T getByID(int id);

    T updateTable(T t);
}