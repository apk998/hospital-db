package com.solvd.hospitaldb;

import com.solvd.hospitaldb.bin.Patient;
import com.solvd.hospitaldb.dao.PatientDAO;
import com.solvd.hospitaldb.util.Database;
import com.solvd.hospitaldb.dao.impl.jdbc.PatientDAOImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Optional;

public class Main {

    private static final Logger LOGGER= LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {

        // JDBC
        PatientDAO patientDAO = new PatientDAOImpl();
        Patient patient = new Patient(0, 101, "Max", "Stirner", "1990-08-10", "Male", "215-386-7171");
        int result = patientDAO.create(patient);
        LOGGER.info(result);

        Optional<Patient> patient0 = patientDAO.findByID(0);
        LOGGER.info(patient0);

        Patient patient1 = new Patient(0, 101, "Emile", "Durkheim", "1990-08-10", "Male", "215-685-6322");
        patientDAO.updateByID(patient1, 0);
        LOGGER.info(patient1);

        LOGGER.info(patientDAO.deleteByID(patient1));

        //MyBatis

        }
    }