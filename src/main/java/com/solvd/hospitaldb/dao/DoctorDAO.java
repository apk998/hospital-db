package com.solvd.hospitaldb.dao;

import com.solvd.hospitaldb.bin.Doctor;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface DoctorDAO extends BaseDAO<Doctor> {
    int create(Doctor doctor);

    Optional<Doctor> findByID(int id);

    int updateByID(@Param("doctor") Doctor doctor, @Param("id") int id);

    int deleteByID(Doctor doctor);
}