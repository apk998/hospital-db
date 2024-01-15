package com.solvd.hospitaldb.service;

public interface EmergencyAdmitService {
    void admitPatientEmergency(int patientID, int bedID, String reason, String admitDate);
    void dischargePatient(int id, String dischargeDate);
}
