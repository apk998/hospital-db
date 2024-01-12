package com.solvd.hospitaldb.dao;

import com.solvd.hospitaldb.bin.Doctor;
import org.apache.ibatis.annotations.Param;
import java.sql.SQLException;

import java.util.Optional;

public interface DoctorDAO extends BaseDAO<Doctor> {
    int create(Doctor doctor) throws SQLException;

    Optional<Doctor> findByID(int id) throws SQLException;

    int updateByID(@Param("doctor") Doctor doctor, @Param("id") int id) throws SQLException;

    int deleteByID(Doctor doctor) throws SQLException;
}