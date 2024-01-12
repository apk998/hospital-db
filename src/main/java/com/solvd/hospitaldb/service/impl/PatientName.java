package com.solvd.hospitaldb.service.impl;

import com.solvd.hospitaldb.bin.Patient;
import com.solvd.hospitaldb.dao.PatientDAO;
import com.solvd.hospitaldb.dao.impl.jdbc.PatientDAOImpl;
import com.solvd.hospitaldb.service.IName;
import java.sql.SQLException;

public class PatientName implements IName<Patient> {

    @Override
    public Patient getByName(Patient patient) throws SQLException {
        PatientDAO patientDAO = new PatientDAOImpl();
        return patientDAO
                .findByID(patient.getPatientId())
                .orElseThrow(() -> new RuntimeException("No patient with provided data found" + patient.toString()));
    }
}