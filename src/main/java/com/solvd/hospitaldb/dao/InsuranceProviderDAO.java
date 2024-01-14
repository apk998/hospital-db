package com.solvd.hospitaldb.dao;

import com.solvd.hospitaldb.bin.InsuranceProvider;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface InsuranceProviderDAO extends BaseDAO<InsuranceProvider> {
    void create(InsuranceProvider provider);

    Optional<InsuranceProvider> findByID(int id);

    void updateByID(@Param("provider") InsuranceProvider provider, @Param("id") int id);

    void deleteByID(InsuranceProvider provider);
}
