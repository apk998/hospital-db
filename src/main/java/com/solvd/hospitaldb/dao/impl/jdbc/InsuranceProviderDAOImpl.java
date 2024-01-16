package com.solvd.hospitaldb.dao.impl.jdbc;

import com.solvd.hospitaldb.bin.InsuranceProvider;
import com.solvd.hospitaldb.dao.InsuranceProviderDAO;
import com.solvd.hospitaldb.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class InsuranceProviderDAOImpl implements InsuranceProviderDAO {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER= LogManager.getLogger(com.solvd.hospitaldb.dao.impl.jdbc.InsuranceProviderDAOImpl.class);

    @Override
    public void create(InsuranceProvider provider) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "INSERT INTO insurance_providers (provider_id, provider_name, contact_number, address) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, provider.getProviderID());
            ps.setString(2, provider.getProviderName());
            ps.setString(3, provider.getContactNumber());
            ps.setString(4, provider.getAddress());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error creating insurance provider", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public Optional<InsuranceProvider> findByID(int id) {
        Connection connection = connectionPool.getConnection(1000);
        InsuranceProvider provider = null;
        ResultSet rs = null;
        String sql = "SELECT id, provider_id, provider_name, contact_number, address FROM insurance_providers WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                int id1 = rs.getInt("id");
                int providerID = rs.getInt("provider_id");
                String providerName = rs.getString("provider_name");
                String contactNumber = rs.getString("contact_number");
                String address = rs.getString("address");

                provider = new InsuranceProvider(id1, providerID, providerName, contactNumber, address);
            }
        } catch (SQLException e) {
            LOGGER.error("Error finding insurance provider by ID", e);
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
        return Optional.ofNullable(provider);
    }

    @Override
    public void updateByID(InsuranceProvider provider, int id) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "UPDATE insurance_providers SET provider_id = ?, provider_name = ?, contact_number = ?, address = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, provider.getProviderID());
            ps.setString(2, provider.getProviderName());
            ps.setString(3, provider.getContactNumber());
            ps.setString(4, provider.getAddress());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error updating insurance provider", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void deleteByID(InsuranceProvider provider) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "DELETE FROM insurance_providers WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, provider.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error deleting insurance provider", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
