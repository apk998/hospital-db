package com.solvd.hospitaldb.service.impl;

import com.solvd.hospitaldb.bin.Appointment;
import com.solvd.hospitaldb.dao.AppointmentDAO;
import com.solvd.hospitaldb.service.AppointmentService;

import java.util.List;

public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentDAO appointmentDAO;

    public AppointmentServiceImpl(AppointmentDAO appointmentDAO) {
        this.appointmentDAO = appointmentDAO;
    }

    @Override
    public void scheduleAppt(Appointment appointment) {
        appointmentDAO.create(appointment);
    }

    @Override
    public void cancelAppt(int id) {
        appointmentDAO.findByID(id).ifPresent(appointmentDAO::deleteByID);
    }

    @Override
    public List<Appointment> getApptsForPatient(Integer patientID) {
        return appointmentDAO.getApptsForPatient(patientID);
    }
}