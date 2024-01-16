package com.solvd.hospitaldb.dao;

import com.solvd.hospitaldb.bin.Department;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface DepartmentDAO extends BaseDAO<Department> {
    void create(Department department);

    Optional<Department> findByID(int id);

    void updateByID(@Param("bed") Department department, @Param("id") int id);

    void deleteByID(Department department);
}
