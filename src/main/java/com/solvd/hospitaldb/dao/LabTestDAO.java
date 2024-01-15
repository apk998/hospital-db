package com.solvd.hospitaldb.dao;

import com.solvd.hospitaldb.bin.LabTest;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface LabTestDAO extends BaseDAO<LabTest> {
    void create(LabTest test);
    Optional<LabTest> findByID(int id);
    void updateByID(@Param("test") LabTest test, @Param("id") int id);
    void deleteByID(LabTest test);
}
