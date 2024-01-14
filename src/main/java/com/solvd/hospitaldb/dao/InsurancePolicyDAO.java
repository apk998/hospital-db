package com.solvd.hospitaldb.dao;

import com.solvd.hospitaldb.bin.InsurancePolicy;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface InsurancePolicyDAO extends BaseDAO<InsurancePolicy> {
    void create(InsurancePolicy policy);

    Optional<InsurancePolicy> findByID(int id);

    void updateByID(@Param("policy") InsurancePolicy policy, @Param("id") int id);

    void deleteByID(InsurancePolicy policy);
}
