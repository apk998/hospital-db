package com.solvd.hospitaldb.service.impl;

import com.solvd.hospitaldb.bin.Doctor;
import com.solvd.hospitaldb.dao.DoctorDAO;
import com.solvd.hospitaldb.dao.impl.jdbc.DoctorDAOImpl;
import com.solvd.hospitaldb.service.IName;

import java.sql.SQLException;

public class DoctorName implements IName<Doctor> {

    public Doctor getByName(Doctor doctor) throws SQLException {
        DoctorDAO doctorDAO = new DoctorDAOImpl();
        return doctorDAO
                .findByID(doctor.getDoctorID())
                .orElseThrow(() -> new RuntimeException("No doctor with provided data found" + doctor.toString()));
    }
}
