package com.solvd.hospitaldb.service.impl;

import com.solvd.hospitaldb.bin.Appointment;
import com.solvd.hospitaldb.dao.AppointmentDAO;
import com.solvd.hospitaldb.service.CheckupService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckupServiceImpl implements CheckupService {

    private static final Logger LOGGER= LogManager.getLogger(CheckupServiceImpl.class);
    private final AppointmentDAO appointmentDAO;

    public CheckupServiceImpl(AppointmentDAO appointmentDAO) {
        this.appointmentDAO = appointmentDAO;
    }

    @Override
    public void scheduleCheckup(int patientID, int doctorID, String apptDate) {
        // Create a new appointment for the annual checkup
        Appointment annualCheckup = new Appointment(0, 0, patientID, doctorID, apptDate);
        appointmentDAO.create(annualCheckup);
    }

    @Override
    public void cancelCheckup(int id) {
        // Retrieve the annual checkup appointment details by ID
        Appointment annualCheckup = appointmentDAO.findByID(id).orElse(null);

        if (annualCheckup != null) {
            appointmentDAO.deleteByID(annualCheckup);
        } else {
            LOGGER.info("Annual checkup appointment not found for cancellation.");
        }
    }
}
