package com.solvd.hospitaldb.dao.impl.jdbc;

import com.solvd.hospitaldb.bin.Medication;
import com.solvd.hospitaldb.dao.MedicationDAO;
import com.solvd.hospitaldb.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class MedicationDAOImpl implements MedicationDAO {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER= LogManager.getLogger(com.solvd.hospitaldb.dao.impl.jdbc.MedicationDAOImpl.class);

    @Override
    public void create(Medication medication) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "INSERT INTO medications (medication_id, medication_name, dosage, usage_instructions) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, medication.getMedicationID());
            ps.setString(2, medication.getMedicationName());
            ps.setString(3, medication.getDosage());
            ps.setString(4, medication.getUsageInstructions());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error creating medication", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public Optional<Medication> findByID(int id) {
        Connection connection = connectionPool.getConnection(1000);
        Medication medication = null;
        String sql = "SELECT id, medication_id, medication_name, dosage, usage_instructions FROM medications WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id1 = rs.getInt("id");
                Integer medicationID = rs.getInt("medication_id");
                String medicationName = rs.getString("medication_name");
                String dosage = rs.getString("dosage");
                String usageInstructions = rs.getString("usage_instructions");

                medication = new Medication(id1, medicationID, medicationName, dosage, usageInstructions);
            }
        } catch (SQLException e) {
            LOGGER.error("Error finding medication by ID", e);
        } finally {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        }
        return Optional.ofNullable(medication);
    }

    @Override
    public void updateByID(Medication medication, int id) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "UPDATE medications SET medication_id = ?, medication_name = ?, dosage = ?, usage_instructions = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, medication.getMedicationID());
            ps.setString(2, medication.getMedicationName());
            ps.setString(3, medication.getDosage());
            ps.setString(4, medication.getUsageInstructions());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error updating medication", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void deleteByID(Medication medication) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "DELETE FROM medications WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, medication.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error deleting medication", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
