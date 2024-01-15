package com.solvd.hospitaldb.bin;

import java.math.BigDecimal;

public class Payment {
    private int id;
    private int paymentID;
    private Patient patientID;
    private BigDecimal amount;
    private String paymentDate;

    public Payment(int id, int paymentID, Patient patientID, BigDecimal amount, String paymentDate) {
        this.id = id;
        this.paymentID = paymentID;
        this.patientID = patientID;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public Patient getPatientID() {
        return patientID;
    }

    public void setPatientID(Patient patientID) {
        this.patientID = patientID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paymentID=" + paymentID +
                ", patientID=" + patientID +
                ", amount=" + amount +
                ", paymentDate='" + paymentDate + '\'' +
                '}';
    }
}
