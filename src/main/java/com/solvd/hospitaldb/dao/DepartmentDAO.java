package com.solvd.hospitaldb.dao;

import com.solvd.hospitaldb.bin.Department;

import java.util.Optional;

public interface DepartmentDAO extends BaseDAO<Department> {
    int create(Department department);

    Optional<Department> findById(int id);

    int updateByID(Department department, int id);

    int deleteByID(Department department);
}
