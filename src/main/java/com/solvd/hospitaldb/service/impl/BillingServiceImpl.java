package com.solvd.hospitaldb.service.impl;

import com.solvd.hospitaldb.bin.InsurancePolicy;
import com.solvd.hospitaldb.dao.InsurancePolicyDAO;
import com.solvd.hospitaldb.bin.Payment;
import com.solvd.hospitaldb.dao.PaymentDAO;
import com.solvd.hospitaldb.service.BillingService;

import java.util.List;

public class BillingServiceImpl implements BillingService {

    private final PaymentDAO paymentDAO;
    private final InsurancePolicyDAO insurancePolicyDAO;

    public BillingServiceImpl(PaymentDAO paymentDAO, InsurancePolicyDAO insurancePolicyDAO) {
        this.paymentDAO = paymentDAO;
        this.insurancePolicyDAO = insurancePolicyDAO;
    }

    @Override
    public void processPayment(Payment payment) {
        paymentDAO.create(payment);
    }

    @Override
    public void refundPayment(int id) {
        paymentDAO.findByID(id).ifPresent(paymentDAO::deleteByID);
    }

    @Override
    public List<Payment> getPaymentsForPatient(Integer patientID) {
        return paymentDAO.getPaymentsForPatient(patientID);
    }

    @Override
    public void registerInsurance(InsurancePolicy policy){
        insurancePolicyDAO.create(policy);
    }
}
