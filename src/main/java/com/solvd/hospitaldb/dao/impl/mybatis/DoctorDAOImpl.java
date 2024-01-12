package com.solvd.hospitaldb.dao.impl.mybatis;

import com.solvd.hospitaldb.bin.Doctor;
import com.solvd.hospitaldb.dao.DoctorDAO;
import com.solvd.hospitaldb.util.Config;
import org.apache.ibatis.session.SqlSession;
import java.sql.SQLException;

import java.util.Optional;

public class DoctorDAOImpl implements DoctorDAO {

    @Override
    public int create(Doctor doctor) throws SQLException {
        try (SqlSession sqlSession = Config.getSessionFactory().openSession(true)) {
            DoctorDAO doctorRepository = sqlSession.getMapper(DoctorDAO.class);
            doctorRepository.create(doctor);
    }

    public Optional<Doctor> findByID(int doctorID) {
        try (SqlSession sqlSession = Config.getSessionFactory().openSession(true)) {
            DoctorDAO doctorRepository = sqlSession.getMapper(DoctorDAO.class);
            return doctorDAO.findByID(2); // for example
        }
    }

    public int updateByID(Doctor doctor, int id) {

        }

    public int deleteByID(Doctor doctor) {

        }
}