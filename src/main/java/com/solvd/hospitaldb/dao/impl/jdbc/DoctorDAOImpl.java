package com.solvd.hospitaldb.dao.impl.jdbc;

import com.solvd.hospitaldb.bin.Department;
import com.solvd.hospitaldb.bin.Doctor;
import com.solvd.hospitaldb.util.Database;
import com.solvd.hospitaldb.dao.DoctorDAO;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class DoctorDAOImpl implements DoctorDAO {

    @Override
    public int create(Doctor doctor) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "INSERT INTO doctors (doctor_id, first_name, last_name, department_id, contact_number) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setInt(1, doctor.getDoctorID());
        ps.setString(2, doctor.getFirstName());
        ps.setString(3, doctor.getLastName());
        ps.setString(4, String.valueOf(doctor.getDepartment()));
        ps.setString(5, doctor.getContactNumber());

        int result = ps.executeUpdate();

        Database.closePreparedStatement(ps);
        Database.closeConnection(connection);

        return result;
    }

    @Override
    public Optional<Doctor> findByID(int id) throws SQLException {
        Connection connection = Database.getConnection();
        Doctor doctor = null;
        String sql = "SELECT id, doctor_id, first_name, last_name, department_id, contact_number FROM doctors WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int id1 = rs.getInt("id");
            int doctorID = rs.getInt("doctor_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");

            int departmentId = rs.getInt("department_id");
            Department department = getDepartmentById(departmentId);

            String contactNumber = rs.getString("contact_number");

            doctor = new Doctor(id1, doctorID, firstName, lastName, department, contactNumber);
        }
        return Optional.ofNullable(doctor);
    }

    @Override
    public int updateByID(Doctor doctor, int id) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "UPDATE doctors SET doctor_id = ?, first_name = ?, last_name = ?, department_id = ?, contact_number = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setInt(1, doctor.getDoctorID());
        ps.setString(2, doctor.getFirstName());
        ps.setString(3, doctor.getLastName());
        ps.setString(5, String.valueOf(doctor.getDepartment()));
        ps.setString(6, doctor.getContactNumber());
        ps.setInt(7, doctor.getId());

        int result = ps.executeUpdate();

        Database.closePreparedStatement(ps);
        Database.closeConnection(connection);

        return result;
    }

    @Override
    public int deleteByID(Doctor doctor) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "DELETE FROM doctors WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setInt(1, doctor.getId());
        int result = ps.executeUpdate();

        Database.closePreparedStatement(ps);
        Database.closeConnection(connection);

        return result;
    }
}
