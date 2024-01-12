package com.solvd.hospitaldb.dao.impl.mybatis;

import com.solvd.hospitaldb.bin.Patient;
import com.solvd.hospitaldb.util.Config;
import com.solvd.hospitaldb.dao.PatientDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.Optional;

public class PatientDAOImpl implements PatientDAO {

    @Override
    public void create(Patient patient) {
        try (SqlSession sqlSession = Config.getSessionFactory().openSession(true)) {
            PatientDAO patientRepository = sqlSession.getMapper(PatientDAO.class);
            patientRepository.create(patient);
        }
    }

    @Override
    public Optional<Patient> findByID(int patientID) {
        try (SqlSession sqlSession = Config.getSessionFactory().openSession(true)) {
            PatientDAO patientRepository = sqlSession.getMapper(PatientDAO.class);
            return patientRepository.findByID(7); // for example
        }
    }

    @Override
    public void updateByID(Patient patient, int patientID) {

    }

    @Override
    public void deleteByID(int patientID) {

    }
}
