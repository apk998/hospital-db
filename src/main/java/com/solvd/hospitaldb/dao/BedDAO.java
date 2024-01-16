package com.solvd.hospitaldb.dao;

import com.solvd.hospitaldb.bin.Bed;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface BedDAO extends BaseDAO<Bed> {
    void create(Bed bed);
    Optional<Bed> findByID(int id);
    void updateByID(@Param("bed") Bed bed, @Param("id") int id);
    void deleteByID(Bed bed);
}
