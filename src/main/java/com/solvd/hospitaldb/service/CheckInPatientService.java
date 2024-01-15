package com.solvd.hospitaldb.service;

import com.solvd.hospitaldb.bin.Admission;

public interface CheckInPatientService<T> {

    Admission checkInPatientEmergency(String firstName, String lastName, String dateOfBirth, String gender, String contactNumber,
                                      int bedID, String admitDate, String dischargeDate);

    Admission checkInPatientAppointment(String firstName, String lastName, String dateOfBirth, String gender, String contactNumber,
                                        int doctorID, String apptDate);

    void registerInsuranceInformation(int patientID, String policyName, int providerID, String coverageDetails);

    void registerInsuranceProvider(String providerName, String contactNumber, String address);
}