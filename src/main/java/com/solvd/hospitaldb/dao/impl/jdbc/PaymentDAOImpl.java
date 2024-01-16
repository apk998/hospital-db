package com.solvd.hospitaldb.dao.impl.jdbc;

import com.solvd.hospitaldb.bin.Patient;
import com.solvd.hospitaldb.bin.Payment;
import com.solvd.hospitaldb.dao.PaymentDAO;
import com.solvd.hospitaldb.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PaymentDAOImpl implements PaymentDAO {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(com.solvd.hospitaldb.dao.impl.jdbc.PaymentDAOImpl.class);

    @Override
    public void create(Payment payment) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "INSERT INTO payments (payment_id, patient_id, amount, payment_date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, payment.getPaymentID());
            ps.setInt(2, payment.getPatientID().getID());
            ps.setBigDecimal(3, payment.getAmount());
            ps.setString(4, payment.getPaymentDate());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error creating payment", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public Optional<Payment> findByID(int id) {
        Connection connection = connectionPool.getConnection(1000);
        Payment payment = null;
        ResultSet rs = null;
        String sql = "SELECT id, payment_id, patient_id, amount, payment_date FROM payments WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            rs = ps.executeQuery;

            if (rs.next()) {
                int id1 = rs.getInt("id");
                int paymentID = rs.getInt("payment_id");
                Patient patientID = (Patient) rs.getObject("patient_id");
                BigDecimal amount = rs.getBigDecimal("amount");
                String paymentDate = rs.getString("payment_date");

                payment = new Payment(id1, paymentID, patientID, amount, paymentDate);
            }
        } catch (SQLException e) {
            LOGGER.error("Error finding payment by ID", e);
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
        return Optional.ofNullable(payment);
    }

    @Override
    public void updateByID(Payment payment, int id) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "UPDATE payments SET payment_id = ?, patient_id = ?, amount = ?, payment_date = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, payment.getPaymentID());
            ps.setInt(2, payment.getPatientID().getID());
            ps.setBigDecimal(3, payment.getAmount());
            ps.setString(4, payment.getPaymentDate());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error updating payment", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void deleteByID(Payment payment) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "DELETE from payments WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, payment.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error deleting payment", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<Payment> getPaymentsForPatient(Integer patientID) {
        List<Payment> payments = new ArrayList<>();
        Connection connection = connectionPool.getConnection(1000);
        ResultSet rs = null;
        String sql = "SELECT * from payments WHERE patient_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, patientID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int paymentID = rs.getInt("payment_id");
                Patient patientId = (Patient) rs.getObject("patient_id");
                BigDecimal amount = rs.getBigDecimal("amount");
                String paymentDate = rs.getString("payment_date");
                payments.add(new Payment(id, paymentID, patientId, amount, paymentDate));
            }
        } catch (SQLException e) {
            LOGGER.error("Error getting payments for patient", e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e); {
                    LOGGER.error("Error closing the result set", e);
                }
            }
            connectionPool.releaseConnection(connection);
        }
        return payments;
    }

    @Override
    public double calculateBalance(Patient patient) {
        return 0;
    }
}
