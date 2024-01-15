package com.solvd.hospitaldb.service.impl;

import com.solvd.hospitaldb.bin.Admission;
import com.solvd.hospitaldb.bin.InsurancePolicy;
import com.solvd.hospitaldb.bin.Patient;
import com.solvd.hospitaldb.dao.AdmissionDAO;
import com.solvd.hospitaldb.bin.InsurancePolicy;
import com.solvd.hospitaldb.dao.InsurancePolicyDAO;
import com.solvd.hospitaldb.dao.PatientDAO;
import com.solvd.hospitaldb.service.CheckInPatientService;

public class CheckInPatientServiceImpl implements CheckInPatientService {

    private final AdmissionDAO admissionDAO;
    private final InsurancePolicyDAO insurancePolicyDAO;
    private final PatientDAO patientDAO;

    public CheckInPatientServiceImpl(AdmissionDAO admissionDAO, InsurancePolicyDAO insurancePolicyDAO, PatientDAO patientDAO) {
        this.admissionDAO = admissionDAO;
        this.insurancePolicyDAO = insurancePolicyDAO;
        this.patientDAO = patientDAO;
    }

    @Override
    public void checkInPatient(String firstName, String lastName, String gender, String reason, String admitDate) {
        // Create a new patient
        Patient patient = new Patient(0, 0, firstName, lastName, dateOfBirth, gender, contactNumber);

        // Insert the patient into the database (must fix return type issue)
        patientDAO.create(patient);

        // Create a new admission for the patient
        Admission admission = new Admission(0, 0, patientId, admitDate, null, 0);

        // Insert the admission into the database
        admissionDAO.create(admission);
    }

    @Override
    public void registerInsurance(int patientID, String policyName, int providerID, String coverageDetails) {
        // Register the insurance policy
        InsurancePolicy insurancePolicy = new InsurancePolicy(0, policyName, patientID, providerID, coverageDetails);

        // Insert the insurance policy into the database
        insurancePolicyDAO.create(insurancePolicy);
    }
}
