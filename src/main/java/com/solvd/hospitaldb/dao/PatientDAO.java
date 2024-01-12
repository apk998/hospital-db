package com.solvd.hospitaldb.dao;

import com.solvd.hospitaldb.bin.Patient;
import org.apache.ibatis.annotations.Param;
import java.sql.SQLException;

import java.util.Optional;

public interface PatientDAO extends BaseDAO<Patient> {
    int create(Patient patient) throws SQLException;

    Optional<Patient> findByID(int id) throws SQLException;

    int updateByID(@Param("patient") Patient patient, @Param("id") int id) throws SQLException;

    int deleteByID(Patient patient) throws SQLException;
}
