package com.solvd.hospitaldb.dao.impl.jdbc;

import com.solvd.hospitaldb.bin.Patient;
import com.solvd.hospitaldb.dao.PatientDAO;
import com.solvd.hospitaldb.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientDAOImpl implements PatientDAO {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER= LogManager.getLogger(com.solvd.hospitaldb.dao.impl.jdbc.PatientDAOImpl.class);

    @Override
    public void create(Patient patient) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "INSERT INTO patients (patient_id, first_name, last_name, date_of_birth, gender, contact_number) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, patient.getPatientId());
            ps.setString(2, patient.getFirstName());
            ps.setString(3, patient.getLastName());
            ps.setString(4, patient.getDateOfBirth());
            ps.setString(5, patient.getGender());
            ps.setString(6, patient.getContactNumber());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error creating patient", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public Optional<Patient> findByID(int id) {
        Connection connection = connectionPool.getConnection(1000);
        Patient patient = null;
        ResultSet rs = null;
        String sql = "SELECT id, patient_id, first_name, last_name, date_of_birth, gender, contact_number FROM patients WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                int id1 = rs.getInt("id");
                Integer patientID = rs.getInt("patient_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String dateOfBirth = rs.getString("date_of_birth");
                String gender = rs.getString("gender");
                String contactNumber = rs.getString("contact_number");

                patient = new Patient(id1, patientID, firstName, lastName, dateOfBirth, gender, contactNumber);
            }
        } catch (SQLException e) {
            LOGGER.error("Error finding patient by ID", e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    LOGGER.error("Error closing the result set", e);
                }
            }
            connectionPool.releaseConnection(connection);
        }
        return Optional.ofNullable(patient);
    }

    @Override
    public void updateByID(Patient patient, int id) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "UPDATE patients SET patient_id = ?, first_name = ?, last_name = ?, date_of_birth = ?, gender = ?, contact_number = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, patient.getPatientId());
            ps.setString(2, patient.getFirstName());
            ps.setString(3, patient.getLastName());
            ps.setString(4, patient.getDateOfBirth());
            ps.setString(5, patient.getGender());
            ps.setString(6, patient.getContactNumber());
            ps.setInt(7, patient.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error updating patient", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void deleteByID(Patient patient) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "DELETE FROM patients WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, patient.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error deleting patient", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    public List<Patient> getAll() {
        List<Patient> patients = new ArrayList<>();
        Connection connection = connectionPool.getConnection(1000);
        ResultSet rs = null;
        String sql = "SELECT id, patient_id, first_name, last_name, date_of_birth, gender, contact_number FROM patients";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                Integer patientId = rs.getInt("patient_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String dateOfBirth = rs.getString("date_of_birth");
                String gender = rs.getString("gender");
                String contactNumber = rs.getString("contact_number");
                patients.add(new Patient(id, patientId, firstName, lastName, dateOfBirth, gender, contactNumber));
            }
        } catch (SQLException e) {
            LOGGER.error("Error getting all patients", e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    LOGGER.error("Error closing the result set", e);
                }
            }
            connectionPool.releaseConnection(connection);
        }
        return patients;
    }
}