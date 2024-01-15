package com.solvd.hospitaldb.service;

public interface CheckInPatientService {

    void checkInPatient(String firstName, String lastName, String gender, String reason, String admitDate);

    void registerInsurance(int patientID, String policyName, int providerID, String coverageDetails);
}