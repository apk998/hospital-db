package com.solvd.hospitaldb.dao.impl.jdbc;

import com.solvd.hospitaldb.bin.LabTest;
import com.solvd.hospitaldb.dao.LabTestDAO;
import com.solvd.hospitaldb.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class LabTestDAOImpl implements LabTestDAO {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER= LogManager.getLogger(com.solvd.hospitaldb.dao.impl.jdbc.LabTestDAOImpl.class);

    @Override
    public void create(LabTest test) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "INSERT INTO lab_tests (test_id, test_name, test_description) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, test.getTestID());
            ps.setString(2, test.getTestName());
            ps.setString(3, test.getTestDescription());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error creating lab test", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public Optional<LabTest> findByID(int id) {
        Connection connection = connectionPool.getConnection(1000);
        LabTest test = null;
        String sql = "SELECT id, test_id, test_name, test_description FROM beds WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id1 = rs.getInt("id");
                Integer testID = rs.getInt("test_id");
                String testName = rs.getString("test_name");
                String testDescription = rs.getString("test_description");

                test = new LabTest(id1, testID, testName, testDescription);
            }
        } catch (SQLException e) {
            LOGGER.error("Error finding lab test by ID", e);
        } finally {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        }
        return Optional.ofNullable(bed);
    }

    @Override
    public void updateByID(LabTest test, int id) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "UPDATE lab_tests SET test_id = ?, test_name = ?, test_description = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, test.getTestID());
            ps.setString(2, test.getTestName());
            ps.setString(3, test.getTestDescription());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error updating lab test", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void deleteByID(LabTest test) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "DELETE FROM lab_tests WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, test.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error deleting lab test", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
