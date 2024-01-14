package com.solvd.hospitaldb.dao.impl.jdbc;

import com.solvd.hospitaldb.bin.Admission;
import com.solvd.hospitaldb.bin.InsurancePolicy;
import com.solvd.hospitaldb.dao.InsurancePolicyDAO;
import com.solvd.hospitaldb.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class InsurancePolicyDAOImpl implements InsurancePolicyDAO {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER= LogManager.getLogger(com.solvd.hospitaldb.dao.impl.jdbc.InsurancePolicyDAOImpl.class);

    @Override
    public void create(InsurancePolicy policy) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "INSERT INTO insurance_policies (policy_id, policy_name, patient_id, provider_id, coverage_details) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, policy.getPolicyID());
            ps.setString(2, policy.getPolicyName());
            ps.setInt(3, policy.getPatientID());
            ps.setInt(4, policy.getProviderID());
            ps.setString(5, policy.getCoverageDetails());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error creating insurance policy", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public Optional<InsurancePolicy> findByID(int id) {
        Connection connection = connectionPool.getConnection(1000);
        InsurancePolicy policy = null;
        String sql = "SELECT id, policy_id, policy_name, patient_id, provider_id, coverage_details FROM insurance_policies WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id1 = rs.getInt("id");
                int policyID = rs.getInt("policy_id");
                String policyName = rs.getString("policy_name");
                int patientID = rs.getInt("patient_id");
                int providerID = rs.getInt("provider_id");
                String coverageDetails = rs.getString("coverage_details");

                policy = new InsurancePolicy(id1, policyID, policyName, patientID, providerID, coverageDetails);
            }
        } catch (SQLException e) {
            LOGGER.error("Error finding insurance policy by ID", e);
        } finally {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        }
        return Optional.ofNullable(policy);
    }

    @Override
    public void updateByID(InsurancePolicy policy, int id) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "UPDATE insurance_policies SET policy_id = ?, policy_name = ?, patient_id = ?, provider_id = ?, coverage_details = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, policy.getPolicyID());
            ps.setString(2, policy.getPolicyName());
            ps.setInt(3, policy.getPatientID());
            ps.setInt(4, policy.getProviderID());
            ps.setString(5, policy.getCoverageDetails());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error updating insurance policy", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void deleteByID(InsurancePolicy policy) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "DELETE FROM insurance_policies WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, policy.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error deleting insurance policy", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
