package com.solvd.hospitaldb.dao.impl.mybatis;

import com.solvd.hospitaldb.bin.Patient;
import com.solvd.hospitaldb.util.Config;
import com.solvd.hospitaldb.dao.PatientDAO;
import org.apache.ibatis.session.SqlSession;
import java.sql.SQLException;

import java.util.Optional;

public class PatientDAOImpl implements PatientDAO {

    @Override
    public int create(Patient patient) throws SQLException {
        try (SqlSession sqlSession = Config.getSessionFactory().openSession(true)) {
            PatientDAO patientDAO = sqlSession.getMapper(PatientDAO.class);
            patientDAO.create(patient);
        }
    }

    @Override
    public Optional<Patient> findByID(int id) throws SQLException {
        try (SqlSession sqlSession = Config.getSessionFactory().openSession(true)) {
            PatientDAO patientDAO = sqlSession.getMapper(PatientDAO.class);
            return patientDAO.findByID(0);
        }
    }

    @Override
    public int updateByID(Patient patient, int id) throws SQLException {

    }

    @Override
    public int deleteByID(Patient patient) throws SQLException {

    }
}
