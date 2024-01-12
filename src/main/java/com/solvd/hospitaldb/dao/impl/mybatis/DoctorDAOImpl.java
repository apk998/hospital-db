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
            return doctorRepository.create(doctor);
        }
    }

    @Override
    public Optional<Doctor> findByID(int id) throws SQLException {
        try (SqlSession sqlSession = Config.getSessionFactory().openSession(true)) {
            DoctorDAO doctorDAO = sqlSession.getMapper(DoctorDAO.class);
            return doctorDAO.findByID(id);
        }
    }

    @Override
    public int updateByID(Doctor doctor, int id) throws SQLException {
        try (SqlSession sqlSession = Config.getSessionFactory().openSession(true)) {
            DoctorDAO doctorDAO = sqlSession.getMapper(DoctorDAO.class);
            return doctorDAO.updateByID(doctor, id);
        }
    }

    @Override
    public int deleteByID(Doctor doctor) throws SQLException {
        try (SqlSession sqlSession = Config.getSessionFactory().openSession(true)) {
            DoctorDAO doctorDAO = sqlSession.getMapper(DoctorDAO.class);
            return doctorDAO.deleteByID(doctor);
        }
    }
}