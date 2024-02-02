package com.solvd.hospitaldb;

import com.solvd.hospitaldb.bin.Patient;
import com.solvd.hospitaldb.dao.PatientDAO;
import com.solvd.hospitaldb.service.PatientService;
import com.solvd.hospitaldb.service.impl.PatientServiceImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientTest {

    private PatientService patientService;
    private final Patient stirner =
            new Patient(1, 302, "Max", "Stirner", "1990-08-10", "Male", "215-386-7171");

    @BeforeClass
    public void setUp() {
        PatientDAO patientDAO = new PatientDAO() {
            @Override
            public void create(Patient patient) {
            }
            @Override
            public Optional<Patient> findByID(int id) {
                return Optional.empty();
            }
            @Override
            public void updateByID(Patient patient, int id) {
            }
            @Override
            public void deleteByID(Patient patient) {
            }
            @Override
            public List<Patient> getAll() {
                return new ArrayList<>();
            }
        };
        patientService = new PatientServiceImpl(patientDAO);
    }

    @Test(description = "Verify patient admission with valid inputs")
    public void verifyAdmitPatientWithValidInputTest() {
        patientService.admitPatient(stirner);
        List<Patient> patients = patientService.getAllPatients();
        Assert.assertEquals(patients.size(), 1);
    }

    @Test
    public void verifyAdmitPatientWithInvalidInputTest() {
        Patient goldman =
                new Patient(2, -1, "Emma", "Goldman", "1992-03-18", "Female", "856-246-2321");
        List<Patient> intialPatients = patientService.getAllPatients();
        patientService.admitPatient(goldman);
        List<Patient> finalPatients = patientService.getAllPatients();
        Assert.assertEquals(intialPatients, finalPatients);
    }

    @Test(description = "Verify patient discharge with valid inputs")
    public void verifyDischargePatientWithValidInputTest() {
        patientService.dischargePatient(1);
        List<Patient> patients = patientService.getAllPatients();
        Assert.assertEquals(patients.size(), 0);
    }

    @Test(description = "Verify returning a list of all patients")
    // Assumes the database is initially empty
    public void verifyGetAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        Assert.assertEquals(patients.size(), 0);
    }
}
