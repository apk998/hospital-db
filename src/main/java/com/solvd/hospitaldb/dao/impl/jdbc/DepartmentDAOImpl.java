package com.solvd.hospitaldb.dao.impl.jdbc;

import com.solvd.hospitaldb.bin.Department;
import com.solvd.hospitaldb.bin.Doctor;
import com.solvd.hospitaldb.bin.Patient;
import com.solvd.hospitaldb.dao.DepartmentDAO;
import com.solvd.hospitaldb.util.Database;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class DepartmentDAOImpl implements DepartmentDAO {

    @Override
    public int create(Department department) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "INSERT INTO departments (department_id, department_name, department_wing) VALUES (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setInt(1, department.getDeptID());
        ps.setString(2, department.getDeptName());
        ps.setString(3, department.getDeptWing());

        int result = ps.executeUpdate();

        Database.closePreparedStatement(ps);
        Database.closeConnection(connection);

        return result;
    }

    @Override
    public Optional<Department> findByID(int id) throws SQLException {
        Connection connection = Database.getConnection();
        Department department = null;
        String sql = "SELECT id, department_id, department_name, department_wing FROM departments WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int id1 = rs.getInt("id");
            int deptID = rs.getInt("department_id");
            String deptName = rs.getString("department_name");
            String deptWing = rs.getString("department_wing");

            department = new Department(id1, deptID, deptName, deptWing);
        }
        return Optional.ofNullable(department);
    }

    @Override
    public int updateByID(Department department, int id) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "UPDATE departments SET department_id = ?, department_name = ?, department_wing = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setInt(1, department.getDeptID());
        ps.setString(2, department.getDeptName());
        ps.setString(3, department.getDeptWing());
        ps.setInt(7, department.getId());

        int result = ps.executeUpdate();

        Database.closePreparedStatement(ps);
        Database.closeConnection(connection);

        return result;
    }

    @Override
    public int deleteByID(Department department) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "DELETE FROM departments WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setInt(1, department.getId());
        int result = ps.executeUpdate();

        Database.closePreparedStatement(ps);
        Database.closeConnection(connection);

        return result;
    }
}
