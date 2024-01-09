package com.solvd.hospitaldb.dao;

import com.solvd.hospitaldb.bin.Department;
import com.solvd.hospitaldb.bin.Doctor;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface DoctorRepository {
    void create(Doctor doctor, Department department);

    Optional<Doctor> findByID(int doctorID);

    void updateByID(@Param("doctor") Doctor doctor, @Param("doctorID") int doctorID);

    void deleteByID(int doctorID);
}