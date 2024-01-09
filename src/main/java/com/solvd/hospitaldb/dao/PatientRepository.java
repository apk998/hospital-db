package com.solvd.hospitaldb.dao;

import com.solvd.hospitaldb.bin.Patient;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface PatientRepository {
    void create(Patient patient);

    Optional<Patient> findByID(int patientID);

    void updateByID(@Param("patient") Patient patient, @Param("patientID") int patientID);

    void deleteByID(int patientID);
}
