package com.solvd.hospitaldb.dao;

import com.solvd.hospitaldb.bin.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

public interface PaymentDAO extends BaseDAO<Payment> {
    void create(Payment payment);
    Optional<Payment> findByID(int id);
    void updateByID(@Param("payment") Payment payment, @Param("id") int id);
    void deleteByID(Payment payment);
    List<Payment> getPaymentsForPatient(Integer patientID);
}
