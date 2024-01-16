package com.solvd.hospitaldb.service;

import com.solvd.hospitaldb.bin.InsurancePolicy;
import com.solvd.hospitaldb.bin.Payment;
import java.util.List;

public interface BillingService {
    void processPayment(Payment payment);
    void refundPayment(int id);
    List<Payment> getPaymentsForPatient(Integer patientID);
    void registerInsurance(InsurancePolicy policy);
}
