package com.solvd.hospitaldb.dao;

import com.solvd.hospitaldb.bin.Department;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

import java.util.Optional;

public interface DepartmentDAO extends BaseDAO<Department> {
    int create(Department department) throws SQLException;

    Optional<Department> findById(int id) throws SQLException;

    int updateByID(@Param("department") Department department, @Param("id") int id) throws SQLException;

    int deleteByID(Department department) throws SQLException;
}
