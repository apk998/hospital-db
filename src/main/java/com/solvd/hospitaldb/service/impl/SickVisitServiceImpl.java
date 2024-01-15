package com.solvd.hospitaldb.service.impl;

import com.solvd.hospitaldb.bin.Appointment;
import com.solvd.hospitaldb.dao.AppointmentDAO;
import com.solvd.hospitaldb.service.SickVisitService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SickVisitServiceImpl implements SickVisitService {

    private static final Logger LOGGER= LogManager.getLogger(SickVisitServiceImpl.class);
    private final AppointmentDAO appointmentDAO;

    public SickVisitServiceImpl(AppointmentDAO appointmentDAO) {
        this.appointmentDAO = appointmentDAO;
    }

    @Override
    public void scheduleSickVisit(int patientID, int doctorID, String reason, String apptDate) {
        // Create a new appointment for the sick visit
        Appointment sickVisit = new Appointment(0, 0, patientID, doctorID, apptDate);
        appointmentDAO.create(sickVisit);
    }

    @Override
    public void cancelSickVisit(int id) {
        Appointment sickVisit = appointmentDAO.findByID(id).orElse(null);
        if (sickVisit != null) {
            appointmentDAO.deleteByID(sickVisit);
        } else {
            LOGGER.info("Sick visit appointment not found for cancellation.");
        }
    }
}
