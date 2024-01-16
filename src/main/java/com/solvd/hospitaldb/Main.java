package com.solvd.hospitaldb;

import com.solvd.hospitaldb.bin.*;
import com.solvd.hospitaldb.dao.AppointmentDAO;
import com.solvd.hospitaldb.dao.InsurancePolicyDAO;
import com.solvd.hospitaldb.dao.PatientDAO;
import com.solvd.hospitaldb.dao.PaymentDAO;
import com.solvd.hospitaldb.dao.impl.jdbc.AppointmentDAOImpl;
import com.solvd.hospitaldb.dao.impl.jdbc.InsurancePolicyDAOImpl;
import com.solvd.hospitaldb.dao.impl.jdbc.PatientDAOImpl;
import com.solvd.hospitaldb.dao.impl.jdbc.PaymentDAOImpl;
import com.solvd.hospitaldb.service.AppointmentService;
import com.solvd.hospitaldb.service.BillingService;
import com.solvd.hospitaldb.service.PatientService;
import com.solvd.hospitaldb.service.impl.AppointmentServiceImpl;
import com.solvd.hospitaldb.service.impl.BillingServiceImpl;
import com.solvd.hospitaldb.service.impl.PatientServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.math.BigDecimal;

public class Main {

    private static final Logger LOGGER= LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
        PaymentDAO paymentDAO = new PaymentDAOImpl();
        InsurancePolicyDAO insurancePolicyDAO = new InsurancePolicyDAOImpl();
        PatientDAO patientDAO = new PatientDAOImpl();

        AppointmentService appointmentService = new AppointmentServiceImpl(appointmentDAO);
        BillingService billingService = new BillingServiceImpl(paymentDAO, insurancePolicyDAO);
        PatientService patientService = new PatientServiceImpl(patientDAO);


        // Simulate a patient's journey
        Patient newPatient = new Patient(1, 302, "Max", "Stirner",
                "1990-08-10", "Male", "215-386-7171");
        Department internal = new Department(1, 1, "Internal medicine", "South");
        Doctor gp = new Doctor(1, 67, "Orestes", "Brownson", internal, "267-312-8973");
        Appointment newAppointment = new Appointment(1, 9738,
                newPatient, gp, "2024-01-11");
        appointmentService.scheduleAppt(newAppointment);

        // Patient check-in and insurance registration
        patientService.admitPatient(newPatient);
        int patientId = newPatient.getId();
        InsuranceProvider newProvider = new InsuranceProvider(1, 7, "Sample Healthcare",
                "888-123-4567", "123 Debt Ave");
        InsurancePolicy newPolicy = new InsurancePolicy(1, 531256, "Gold policy",
                newPatient, newProvider, "High premium, low deductible");
        billingService.registerInsurance(newPolicy);
        List<Appointment> appointmentsForPatient = appointmentService.getApptsForPatient(patientId);

        if (!appointmentsForPatient.isEmpty()) {
            Appointment scheduledAppointment = appointmentsForPatient.get(0);
            // Patient finishes the appointment
            appointmentService.cancelAppt(scheduledAppointment.getId());
        }

        // Billing
        BigDecimal amount = new BigDecimal(105.00);
        Payment newPayment = new Payment(1, 10383, newPatient, amount, "2024-01-11");
        billingService.processPayment(newPayment);

        // Patient leaves
        patientService.dischargePatient(patientId);
        }
    }