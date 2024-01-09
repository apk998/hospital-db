package com.solvd.hospitaldb.dao.impl;

import com.solvd.hospitaldb.bin.Patient;
import com.solvd.hospitaldb.dao.IMapper;

public class PatientMapper implements IMapper<Patient> {

    @Override
    public Patient getByID(int id) {
        Patient patient1 = new Patient();
        // get connection
        // Map info from SQL table to Java class
        return patient1;
    }

    @Override
    public Patient updateTable(Patient patient) {
        // find record in table and perform update query
        return null;
    }
}