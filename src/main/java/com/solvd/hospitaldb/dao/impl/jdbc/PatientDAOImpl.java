package com.solvd.hospitaldb.dao.impl.jdbc;

import com.solvd.hospitaldb.bin.Patient;
import com.solvd.hospitaldb.dao.PatientDAO;
import com.solvd.hospitaldb.util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class PatientDAOImpl implements PatientDAO {

    @Override
    public int create(Patient patient) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "INSERT INTO patients (patient_id, first_name, last_name, date_of_birth, gender, contact_number) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setInt(1, patient.getPatientId());
        ps.setString(2, patient.getFirstName());
        ps.setString(3, patient.getLastName());
        ps.setString(4, patient.getDateOfBirth());
        ps.setString(5, patient.getGender());
        ps.setString(6, patient.getContactNumber());

        int result = ps.executeUpdate();

        Database.closePreparedStatement(ps);
        Database.closeConnection(connection);

        return result;
    }

    @Override
    public Optional<Patient> findByID(int id) throws SQLException {
        Connection connection = Database.getConnection();
        Patient patient = null;
        String sql = "SELECT id, patient_id, first_name, last_name, date_of_birth, gender, contact_number FROM patients WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int id1 = rs.getInt("id");
            int patientID = rs.getInt("patientID");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String dateOfBirth = rs.getString("date_of_birth");
            String gender = rs.getString("gender");
            String contactNumber = rs.getString("contact_number");

            patient = new Patient(id1, patientID, firstName, lastName, dateOfBirth, gender, contactNumber);
        }
        return patient;
    }

    @Override
    public int updateByID(Patient patient, int id) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "UPDATE patients SET patient_id = ?, first_name = ?, last_name = ?, date_of_birth = ?, gender = ?, contact_number = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setInt(1, patient.getPatientId());
        ps.setString(2, patient.getFirstName());
        ps.setString(3, patient.getLastName());
        ps.setString(4, patient.getDateOfBirth());
        ps.setString(5, patient.getGender());
        ps.setString(6, patient.getContactNumber());
        ps.setString(7, patient.getId());

        int result = ps.executeUpdate();

        Database.closePreparedStatement(ps);
        Database.closeConnection(connection);

        return result;
    }

    @Override
    public int deleteByID(Patient patient) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "DELETE FROM patients WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setInt(1, patient.getId());
        int result = ps.executeUpdate();

        Database.closePreparedStatement(ps);
        Database.closeConnection(connection);

        return result;
    }
}
