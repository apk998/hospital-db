package com.solvd.hospitaldb.service;

import com.solvd.hospitaldb.bin.Patient;
import java.util.List;

public interface PatientService {
    void admitPatient(Patient patient);
    void dischargePatient(int id);
    List<Patient> getAllPatients();
    Patient getPatientById(int id);
    void updatePatient(Patient patient);
}
