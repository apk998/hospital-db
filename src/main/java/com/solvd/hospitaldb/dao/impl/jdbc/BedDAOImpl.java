package com.solvd.hospitaldb.dao.impl.jdbc;

import com.solvd.hospitaldb.bin.Bed;
import com.solvd.hospitaldb.dao.BedDAO;
import com.solvd.hospitaldb.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class BedDAOImpl implements BedDAO {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER= LogManager.getLogger(com.solvd.hospitaldb.dao.impl.jdbc.BedDAOImpl.class);

    @Override
    public void create(Bed bed) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "INSERT INTO beds (bed_id, ward_number, availability) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, bed.getBedID());
            ps.setInt(2, bed.getWardNumber());
            ps.setBoolean(3, bed.isAvailability());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error creating bed", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public Optional<Bed> findByID(int id) {
        Connection connection = connectionPool.getConnection(1000);
        Bed bed = null;
        String sql = "SELECT id, bed_id, ward_number, availability FROM beds WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id1 = rs.getInt("id");
                Integer bedID = rs.getInt("bed_id");
                int wardNumber = rs.getInt("ward_number");
                boolean availability = rs.getBoolean("availability");

                bed = new Bed(id1, bedID, wardNumber, availability);
            }
        } catch (SQLException e) {
            LOGGER.error("Error finding bed by ID", e);
        } finally {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        }
        return Optional.ofNullable(bed);
    }

    @Override
    public void updateByID(Bed bed, int id) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "UPDATE beds SET bed_id = ?, ward_number = ?, availability = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, bed.getBedID());
            ps.setInt(2, bed.getWardNumber());
            ps.setBoolean(3, bed.isAvailability());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error updating bed", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void deleteByID(Bed bed) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "DELETE FROM beds WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, bed.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error deleting bed", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}