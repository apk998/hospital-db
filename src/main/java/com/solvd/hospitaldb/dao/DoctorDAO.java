package com.solvd.hospitaldb.dao;

import com.solvd.hospitaldb.bin.Doctor;
import org.apache.ibatis.annotations.Param;
import java.sql.SQLException;

import java.util.Optional;

public interface DoctorDAO extends BaseDAO<Doctor> {
    void create(Doctor doctor);

    Optional<Doctor> findByID(int id);

    void updateByID(@Param("doctor") Doctor doctor, @Param("id") int id);

    void deleteByID(Doctor doctor);
}