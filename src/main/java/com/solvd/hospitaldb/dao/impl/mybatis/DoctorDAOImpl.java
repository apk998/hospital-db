package com.solvd.hospitaldb.dao.impl.mybatis;

import com.solvd.hospitaldb.bin.Doctor;
import com.solvd.hospitaldb.dao.DoctorDAO;
import com.solvd.hospitaldb.util.Config;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class DoctorDAOImpl implements DoctorDAO {


    private static final Logger LOGGER= LogManager.getLogger(com.solvd.hospitaldb.dao.impl.mybatis.DoctorDAOImpl.class);

    @Override
    public void create(Doctor doctor) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            DoctorDAO doctorRepository = sqlSession.getMapper(DoctorDAO.class);
            doctorRepository.create(doctor);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error creating doctor", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public Optional<Doctor> findByID(int id) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        Optional<Doctor> optionalDoctor = Optional.empty();
        try {
            DoctorDAO doctorDAO = sqlSession.getMapper(DoctorDAO.class);
            doctorDAO.findByID(id);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error finding doctor by ID", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        return optionalDoctor;
    }

    @Override
    public void updateByID(Doctor doctor, int id) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(true);
        try {
            DoctorDAO doctorDAO = sqlSession.getMapper(DoctorDAO.class);
            doctorDAO.updateByID(doctor, id);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error updating doctor", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void deleteByID(Doctor doctor) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(true);
        try {
            DoctorDAO doctorDAO = sqlSession.getMapper(DoctorDAO.class);
            doctorDAO.deleteByID(doctor);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error deleting doctor", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
}