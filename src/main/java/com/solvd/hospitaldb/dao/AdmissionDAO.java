package com.solvd.hospitaldb.dao;

import com.solvd.hospitaldb.bin.Admission;
import org.apache.ibatis.annotations.Param;
import java.util.Optional;

public interface AdmissionDAO extends BaseDAO<Admission> {
    void create(Admission admission);

    Optional<Admission> findByID(int id);

    void updateByID(@Param("admission") Admission admission, @Param("id") int id);

    void deleteByID(Admission admission);
}
