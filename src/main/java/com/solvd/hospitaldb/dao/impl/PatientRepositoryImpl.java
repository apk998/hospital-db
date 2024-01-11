package com.solvd.hospitaldb.dao.impl;

import com.solvd.hospitaldb.bin.Patient;
import com.solvd.hospitaldb.dao.Config;
import com.solvd.hospitaldb.dao.PatientRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.Optional;

public class PatientRepositoryImpl implements PatientRepository {

    @Override
    public void create(Patient patient) {
        try (SqlSession sqlSession = Config.getSessionFactory().openSession(true)) {
            PatientRepository patientRepository = sqlSession.getMapper(PatientRepository.class);
            patientRepository.create(patient);
        }
    }

    @Override
    public Optional<Patient> findByID(int patientID) {
        try (SqlSession sqlSession = Config.getSessionFactory().openSession(true)) {
            PatientRepository patientRepository = sqlSession.getMapper(PatientRepository.class);
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
