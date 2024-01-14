package com.solvd.hospitaldb.dao.impl.jdbc;

import com.solvd.hospitaldb.bin.Department;
import com.solvd.hospitaldb.dao.DepartmentDAO;
import com.solvd.hospitaldb.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class DepartmentDAOImpl implements DepartmentDAO {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER= LogManager.getLogger(com.solvd.hospitaldb.dao.impl.jdbc.DepartmentDAOImpl.class);

    @Override
    public void create(Department department) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "INSERT INTO departments (department_id, department_name, department_wing) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, department.getDeptID());
            ps.setString(2, department.getDeptName());
            ps.setString(3, department.getDeptWing());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error creating department", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public Optional<Department> findByID(int id) {
        Connection connection = connectionPool.getConnection(1000);
        Department department = null;
        String sql = "SELECT id, department_id, department_name, department_wing FROM departments WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id1 = rs.getInt("id");
                int deptID = rs.getInt("department_id");
                String deptName = rs.getString("department_name");
                String deptWing = rs.getString("department_wing");

                department = new Department(id1, deptID, deptName, deptWing);
            }
        } catch (SQLException e) {
            LOGGER.error("Error finding department by ID", e);
        } finally {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        }
        return Optional.ofNullable(department);
    }

    @Override
    public void updateByID(Department department, int id) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "UPDATE departments SET department_id = ?, department_name = ?, department_wing = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, department.getDeptID());
            ps.setString(2, department.getDeptName());
            ps.setString(3, department.getDeptWing());
            ps.setInt(4, department.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error updating department", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void deleteByID(Department department) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "DELETE FROM departments WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, department.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error deleting department", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
