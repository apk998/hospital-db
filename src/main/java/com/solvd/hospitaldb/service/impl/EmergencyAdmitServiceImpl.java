package com.solvd.hospitaldb.service.impl;

import com.solvd.hospitaldb.bin.Admission;
import com.solvd.hospitaldb.dao.AdmissionDAO;
import com.solvd.hospitaldb.dao.BedDAO;
import com.solvd.hospitaldb.service.EmergencyAdmitService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmergencyAdmitServiceImpl implements EmergencyAdmitService {

    private static final Logger LOGGER= LogManager.getLogger(EmergencyAdmitServiceImpl.class);

    private final AdmissionDAO admissionDAO;
    private final BedDAO bedDAO;

    public EmergencyAdmitServiceImpl(AdmissionDAO admissionDAO, BedDAO bedDAO) {
        this.admissionDAO = admissionDAO;
        this.bedDAO = bedDAO;
    }

    @Override
    public void admitPatientEmergency(int patientID, int bedID, String reason, String admitDate) {
        // Create an emergency admission for the patient
        Admission admission = new Admission(0, 0, patientID, admitDate, null, bedID);

        // Insert the emergency admission into the database
        admissionDAO.create(admission);
    }

    @Override
    public void dischargePatient(int id, String dischargeDate) {
        // Retrieve the admission details by ID
        Admission admission = admissionDAO.findByID(id).orElse(null);

        if (admission != null) {
            // Set the discharge date in the admission
            admission.setDischargeDate(dischargeDate);

            // Update the admission with the discharge date
            admissionDAO.updateByID(admission, id);
        } else {
            LOGGER.info("Admission not found for discharge.");
        }
    }
}
