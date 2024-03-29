package com.solvd.hospitaldb.dao.impl.jdbc;

import com.solvd.hospitaldb.bin.Department;
import com.solvd.hospitaldb.bin.Doctor;
import com.solvd.hospitaldb.dao.DoctorDAO;
import com.solvd.hospitaldb.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DoctorDAOImpl implements DoctorDAO {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER= LogManager.getLogger(com.solvd.hospitaldb.dao.impl.jdbc.DoctorDAOImpl.class);

    @Override
    public void create(Doctor doctor) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "INSERT INTO doctors (doctor_id, first_name, last_name, department_id, contact_number) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, doctor.getDoctorID());
            ps.setString(2, doctor.getFirstName());
            ps.setString(3, doctor.getLastName());
            ps.setString(4, String.valueOf(doctor.getDepartment()));
            ps.setString(5, doctor.getContactNumber());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error creating doctor", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public Optional<Doctor> findByID(int id) {
        Connection connection = connectionPool.getConnection(1000);
        Doctor doctor = null;
        ResultSet rs = null;
        String sql = "SELECT id, doctor_id, first_name, last_name, department_id, contact_number FROM doctors WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                int id1 = rs.getInt("id");
                Integer doctorID = rs.getInt("doctor_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                Department department = (Department) rs.getObject("department_id");
                String contactNumber = rs.getString("contact_number");

                doctor = new Doctor(id1, doctorID, firstName, lastName, department, contactNumber);
            }
        } catch (SQLException e) {
            LOGGER.error("Error finding doctor by ID", e);
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
        return Optional.ofNullable(doctor);
    }

    @Override
    public void updateByID(Doctor doctor, int id) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "UPDATE doctors SET doctor_id = ?, first_name = ?, last_name = ?, department_id = ?, contact_number = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, doctor.getDoctorID());
            ps.setString(2, doctor.getFirstName());
            ps.setString(3, doctor.getLastName());
            ps.setString(4, String.valueOf(doctor.getDepartment()));
            ps.setString(5, doctor.getContactNumber());
            ps.setInt(6, doctor.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error updating doctor", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void deleteByID(Doctor doctor) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "DELETE FROM doctors WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, doctor.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error deleting doctor", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
