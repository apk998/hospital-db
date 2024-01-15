package com.solvd.hospitaldb.service.impl;

import com.solvd.hospitaldb.bin.Admission;
import com.solvd.hospitaldb.bin.Doctor;
import com.solvd.hospitaldb.dao.PatientDAO;
import com.solvd.hospitaldb.service.CheckInPatientService;

public class CheckInPatientServiceImpl implements CheckInPatientService<Doctor> {

    private final PatientDAO patientDAO;
    private AdmissionDAO admissionDAO;
    private InsurancePolicyDAO insurancePolicyDAO;
    private InsuranceProviderDAO insuranceProviderDAO;
    private AppointmentDAO appointmentDAO;

    public CheckInPatientServiceImpl(PatientDAO patientDAO, AdmissionDAO admissionDAO,
                                     InsurancePolicyDAO insurancePolicyDAO, InsuranceProviderDAO insuranceProviderDAO,
                                     AppointmentDAO appointmentDAO) {
        this.patientDAO = patientDAO;
        this.admissionDAO = admissionDAO;
        this.insurancePolicyDAO = insurancePolicyDAO;
        this.insuranceProviderDAO = insuranceProviderDAO;
        this.appointmentDAO = appointmentDAO;
    }

    @Override
    public Admission checkInPatientEmergency(String firstName, String lastName, String dateOfBirth, String gender, String contactNumber,
                                             int bedID, String admitDate, String dischargeDate) {
        // Implement the logic to check in a patient for emergency admission.
        // Create patient, make entry through AdmissionDAO, and return the Admission object.
    }

    @Override
    public Admission checkInPatientAppointment(String firstName, String lastName, String dateOfBirth, String gender, String contactNumber,
                                               int doctorID, String apptDate) {
        // Implement the logic to check in a patient with an appointment (checkup or sick visit).
        // Create patient, check appointment status, make entry through AdmissionDAO, and return the Admission object.
    }

    @Override
    public void registerInsuranceInformation(int patientID, String policyName, int providerID, String coverageDetails) {
        // Implement the logic to register insurance information for a patient.
        // Invoke InsurancePolicyDAO to save data.
    }

    @Override
    public void registerInsuranceProvider(String providerName, String contactNumber, String address) {
        // Implement the logic to register an insurance provider.
        // Invoke InsuranceProviderDAO to save data.
    }
}
