package com.solvd.hospitaldb.dao;

import com.solvd.hospitaldb.bin.Medication;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface MedicationDAO extends BaseDAO<Medication> {
    void create(Medication medication);
    Optional<Medication> findByID(int id);
    void updateByID(@Param("medication") Medication medication, @Param("id") int id);
    void deleteByID(Medication medication);
}
