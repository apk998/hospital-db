package com.solvd.hospitaldb.dao.impl.jdbc;

import com.solvd.hospitaldb.bin.Admission;
import com.solvd.hospitaldb.bin.Bed;
import com.solvd.hospitaldb.bin.Patient;
import com.solvd.hospitaldb.dao.AdmissionDAO;
import com.solvd.hospitaldb.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class AdmissionDAOImpl implements AdmissionDAO {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER= LogManager.getLogger(com.solvd.hospitaldb.dao.impl.jdbc.AdmissionDAOImpl.class);

    @Override
    public void create(Admission admission) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "INSERT INTO admissions (admission_id, patient_id, admit_date, discharge_date, bed_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, admission.getAdmitID());
            ps.setInt(2, admission.getPatientID().getId());
            ps.setString(3, admission.getAdmitDate());
            ps.setString(4, admission.getDischargeDate());
            ps.setInt(5, admission.getBedID().getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error creating admission", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public Optional<Admission> findByID(int id) {
        Connection connection = connectionPool.getConnection(1000);
        Admission admission = null;
        ResultSet rs = null;
        String sql = "SELECT id, admission_id, patient_id, admit_date, discharge_date, bed_id FROM admissions WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                int id1 = rs.getInt("id");
                int admitID = rs.getInt("admission_id");
                Patient patientID = (Patient) rs.getObject("patient_id");
                String admitDate = rs.getString("admit_date");
                String dischargeDate = rs.getString("discharge_date");
                Bed bedID = (Bed) rs.getObject("bed_id");

                admission = new Admission(id1, admitID, patientID, admitDate, dischargeDate, bedID);
            }
        } catch (SQLException e) {
            LOGGER.error("Error finding admission by ID", e);
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
        return Optional.ofNullable(admission);
    }

    @Override
    public void updateByID(Admission admission, int id) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "UPDATE admissions SET admission_id = ?, patient_id = ?, admit_date = ?, discharge_date = ?, bed_id = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, admission.getAdmitID());
            ps.setInt(2, admission.getPatientID().getId());
            ps.setString(3, admission.getAdmitDate());
            ps.setString(4, admission.getDischargeDate());
            ps.setInt(5, admission.getBedID().getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error updating admission", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void deleteByID(Admission admission) {
        Connection connection = connectionPool.getConnection(1000);
        String sql = "DELETE FROM admissions WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, admission.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Error deleting admission", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
