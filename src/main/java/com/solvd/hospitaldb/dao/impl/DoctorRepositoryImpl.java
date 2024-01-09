package com.solvd.hospitaldb.dao.impl;

import com.solvd.hospitaldb.bin.Department;
import com.solvd.hospitaldb.bin.Doctor;
import com.solvd.hospitaldb.dao.Config;
import com.solvd.hospitaldb.dao.DoctorRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.Optional;

public class DoctorRepositoryImpl implements DoctorRepository {

    @Override
    public void create(Doctor doctor, Department department) {
        try (SqlSession sqlSession = Config.getSessionFactory().openSession(true)) {
            DoctorRepository doctorRepository = sqlSession.getMapper(DoctorRepository.class);
            doctorRepository.create(doctor, department);
        }
    }

    @Override
    public Optional<Doctor> findByID(int doctorID) {
        try (SqlSession sqlSession = Config.getSessionFactory().openSession(true)) {
            DoctorRepository doctorRepository = sqlSession.getMapper(DoctorRepository.class);
            return doctorRepository.findByID(2); // for example
        }
    }

    @Override
    public void updateByID(Doctor doctor, int doctorID) {

    }

    @Override
    public void deleteByID(int doctorID) {

    }
}