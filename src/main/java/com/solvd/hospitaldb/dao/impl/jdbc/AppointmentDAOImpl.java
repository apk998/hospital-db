package com.solvd.hospitaldb.dao.impl.jdbc;

import com.solvd.hospitaldb.bin.Admission;
import com.solvd.hospitaldb.bin.Appointment;
import com.solvd.hospitaldb.dao.AppointmentDAO;
import com.solvd.hospitaldb.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class AppointmentDAOImpl implements AppointmentDAO {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER= LogManager.getLogger(com.solvd.hospitaldb.dao.impl.jdbc.AppointmentDAOImpl.class);

    @Override
    public void create(Appointment appointment) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "INSERT INTO appointments (appt_id, patient_id, doctor_id, appt_date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, appointment.getApptID());
            ps.setInt(2, appointment.getPatientID());
            ps.setInt(3, appointment.getDoctorID());
            ps.setString(4, appointment.getApptDate());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error creating appointment", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public Optional<Appointment> findByID(int id) {
        Connection connection = connectionPool.getConnection(1000);
        Appointment appointment = null;
        String sql = "SELECT id, appt_id, patient_id, doctor_id, appt_date FROM appointments WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id1 = rs.getInt("id");
                int apptID = rs.getInt("appt_id");
                int patientID = rs.getInt("patient_id");
                int doctorID = rs.getInt("doctor_id");
                String apptDate = rs.getString("appt_date");

                appointment = new Appointment(id1, apptID, patientID, doctorID, apptDate);
            }
        } catch (SQLException e) {
            LOGGER.error("Error finding appointment by ID", e);
        } finally {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        }
        return Optional.ofNullable(appointment);
    }

    @Override
    public void updateByID(Appointment appointment, int id) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "UPDATE appointments SET appt_id = ?, patient_id = ?, doctor_id = ?, appt_date = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, appointment.getApptID());
            ps.setInt(2, appointment.getPatientID());
            ps.setInt(3, appointment.getDoctorID());
            ps.setString(4, appointment.getApptDate());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error updating appointment", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void deleteByID(Appointment appointment) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "DELETE FROM appointments WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, appointment.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error deleting appointment", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
