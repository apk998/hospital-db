package com.solvd.hospitaldb.dao.impl.mybatis;

import com.solvd.hospitaldb.bin.Patient;
import com.solvd.hospitaldb.util.Config;
import com.solvd.hospitaldb.dao.PatientDAO;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class PatientDAOImpl implements PatientDAO {

    private static final Logger LOGGER= LogManager.getLogger(com.solvd.hospitaldb.dao.impl.mybatis.PatientDAOImpl.class);

    @Override
    public void create(Patient patient) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            PatientDAO patientDAO = sqlSession.getMapper(PatientDAO.class);
            patientDAO.create(patient);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error creating patient", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public Optional<Patient> findByID(int id) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        Optional<Patient> optionalPatient = Optional.empty();
        try {
            PatientDAO patientDAO = sqlSession.getMapper(PatientDAO.class);
            patientDAO.findByID(id);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error finding patient by ID", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        return optionalPatient;
    }

    @Override
    public void updateByID(Patient patient, int id) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            PatientDAO patientDAO = sqlSession.getMapper(PatientDAO.class);
            patientDAO.updateByID(patient, id);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error updating patient", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void deleteByID(Patient patient) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            PatientDAO patientDAO = sqlSession.getMapper(PatientDAO.class);
            patientDAO.deleteByID(patient);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error deleting patient", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
}
