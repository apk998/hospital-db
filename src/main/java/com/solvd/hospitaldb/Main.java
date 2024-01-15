package com.solvd.hospitaldb;

import com.solvd.hospitaldb.dao.*;
import com.solvd.hospitaldb.dao.impl.jdbc.*;
import com.solvd.hospitaldb.service.CheckInPatientService;
import com.solvd.hospitaldb.service.CheckupService;
import com.solvd.hospitaldb.service.EmergencyAdmitService;
import com.solvd.hospitaldb.service.impl.CheckInPatientServiceImpl;
import com.solvd.hospitaldb.service.impl.CheckupServiceImpl;
import com.solvd.hospitaldb.service.impl.EmergencyAdmitServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER= LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        // Initialize DAOs
        AdmissionDAO admissionDAO = new AdmissionDAOImpl();
        InsurancePolicyDAO insurancePolicyDAO = new InsurancePolicyDAOImpl();
        PatientDAO patientDAO = new PatientDAOImpl();
        BedDAO bedDAO = new BedDAOImpl();
        AppointmentDAO appointmentDAO = new AppointmentDAOImpl();

        // Initialize Services
        CheckInPatientService checkin = new CheckInPatientServiceImpl(admissionDAO, insurancePolicyDAO, patientDAO);
        EmergencyAdmitService emergency = new EmergencyAdmitServiceImpl(admissionDAO, bedDAO);
        CheckupService checkup = new CheckupServiceImpl(appointmentDAO);


        emergency.admitPatientEmergency(2, 2, "Car accident", "2024-01-13");
        checkin.checkInPatient("Max", "Stirner", "Male", "Emergency", "2024-01-13");
        checkin.registerInsurance(2, "Policy A", 6, "Full Coverage");
        checkup.scheduleCheckup(2, 4, "2024-01-30");
        emergency.dischargePatient(2, "2024-01-14");
        }
    }