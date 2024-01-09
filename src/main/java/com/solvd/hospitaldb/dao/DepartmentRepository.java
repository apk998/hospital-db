package com.solvd.hospitaldb.dao;

import com.solvd.hospitaldb.bin.Department;

import java.util.Optional;

public interface DepartmentRepository {
    void create(Department department);

    Optional<Department> findByName(String deptName);

    void updateByName(String deptName);

    void deleteByName(String deptName);
}
