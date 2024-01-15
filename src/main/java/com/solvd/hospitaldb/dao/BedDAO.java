package com.solvd.hospitaldb.dao;

import com.solvd.hospitaldb.bin.Bed;
import java.util.Optional;

public interface BedDAO extends BaseDAO<Bed> {
    void create(Bed bed);
    Optional<Bed> findByID(int id);
    void updateByID(Bed bed, int id);
    void deleteByID(Bed bed);
}
