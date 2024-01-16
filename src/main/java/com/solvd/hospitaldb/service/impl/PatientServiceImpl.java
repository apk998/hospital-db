package com.solvd.hospitaldb.service.impl;

import com.solvd.hospitaldb.bin.Patient;
import com.solvd.hospitaldb.dao.PatientDAO;
import com.solvd.hospitaldb.service.PatientService;

import java.util.List;

public class PatientServiceImpl implements PatientService {
    private final PatientDAO patientDAO;

    public PatientServiceImpl(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @Override
    public void admitPatient(Patient patient) {
        patientDAO.create(patient);
    }

    @Override
    public void dischargePatient(int id) {
        patientDAO.findByID(id).ifPresent(patientDAO::deleteByID);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientDAO.getAll();
    }

    @Override
    public Patient getPatientById(int id) {
        return patientDAO.findByID(id).orElse(null);
    }

    @Override
    public void updatePatient(Patient patient) {
        patientDAO.updateByID(patient, patient.getId());
    }
}
