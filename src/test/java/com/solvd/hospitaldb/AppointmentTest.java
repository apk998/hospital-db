package com.solvd.hospitaldb;

import com.solvd.hospitaldb.bin.Appointment;
import com.solvd.hospitaldb.bin.Department;
import com.solvd.hospitaldb.bin.Doctor;
import com.solvd.hospitaldb.bin.Patient;
import com.solvd.hospitaldb.dao.AppointmentDAO;
import com.solvd.hospitaldb.service.AppointmentService;
import com.solvd.hospitaldb.service.impl.AppointmentServiceImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AppointmentTest {

    private AppointmentService appointmentService;
    private final Patient stirner =
            new Patient(1, 302, "Max", "Stirner", "1990-08-10", "Male", "215-386-7171");
    private final Department internal =
            new Department(1, 1, "Internal medicine", "South");
    private final Doctor brownson =
            new Doctor(1, 67, "Orestes", "Brownson", internal, "267-312-8973");

    @BeforeClass
    public void setUp() {
        AppointmentDAO appointmentDAO = new AppointmentDAO() {
            @Override
            public void create(Appointment appointment) {
            }
            @Override
            public Optional<Appointment> findByID(int id) {
                return Optional.empty();
            }
            @Override
            public void updateByID(Appointment appointment, int id) {
            }
            @Override
            public void deleteByID(Appointment appointment) {
            }
            @Override
            public List<Appointment> getApptsForPatient(Integer patientID) {
                return new ArrayList<>();
            }
        };
        appointmentService = new AppointmentServiceImpl(appointmentDAO);
    }

    @Test(description = "Verify appointment scheduling with valid inputs")
    public void verifyScheduleAppointmentWithValidInputTest() {
        Appointment appointment =
                new Appointment(1, 1, stirner, brownson, "2024-02-01");
        appointmentService.scheduleAppt(appointment);
        List<Appointment> appointments = appointmentService.getApptsForPatient(1);
        Assert.assertEquals(appointments.size(), 1);
    }

    @Test(description = "Verify appointment scheduling with invalid inputs")
    public void verifyScheduleAppointmentWithInvalidInputTest() {
        Appointment appointment = new Appointment(2, -1, null, null, "2024-02-01");
        List<Appointment> initialAppointments = appointmentService.getApptsForPatient(1);
        appointmentService.scheduleAppt(appointment);
        List<Appointment> finalAppointments = appointmentService.getApptsForPatient(1);
        Assert.assertEquals(finalAppointments, initialAppointments);
    }

    @Test(description = "Verify appointment cancellation with valid inputs")
    public void verifyCancelAppointmentWithValidInputTest() {
        appointmentService.cancelAppt(1);
        List<Appointment> appointments = appointmentService.getApptsForPatient(1);
        Assert.assertEquals(appointments.size(), 0);
    }
}