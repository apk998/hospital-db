package com.solvd.hospitaldb.dao;

import com.solvd.hospitaldb.bin.Patient;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

public interface PatientDAO extends BaseDAO<Patient> {
    void create(Patient patient);

    Optional<Patient> findByID(int id);

    void updateByID(@Param("patient") Patient patient, @Param("id") int id);

    void deleteByID(Patient patient);

    List<Patient> getAll();
}
