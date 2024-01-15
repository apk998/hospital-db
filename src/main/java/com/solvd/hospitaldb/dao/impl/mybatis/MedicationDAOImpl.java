package com.solvd.hospitaldb.dao.impl.mybatis;

import com.solvd.hospitaldb.bin.Medication;
import com.solvd.hospitaldb.dao.MedicationDAO;
import com.solvd.hospitaldb.util.Config;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class MedicationDAOImpl implements MedicationDAO {

    private static final Logger LOGGER= LogManager.getLogger(com.solvd.hospitaldb.dao.impl.mybatis.MedicationDAOImpl.class);

    @Override
    public void create(Medication medication) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            MedicationDAO medicationDAO = sqlSession.getMapper(MedicationDAO.class);
            medicationDAO.create(medication);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error creating medication", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public Optional<Medication> findByID(int id) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        Optional<Medication> optionalMedication = Optional.empty();
        try {
            MedicationDAO medicationDAO = sqlSession.getMapper(MedicationDAO.class);
            medicationDAO.findByID(id);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error finding medication by ID", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        return optionalMedication;
    }

    @Override
    public void updateByID(Medication medication, int id) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            MedicationDAO medicationDAO = sqlSession.getMapper(MedicationDAO.class);
            medicationDAO.updateByID(medication, id);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error updating medication", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void deleteByID(Medication medication) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            MedicationDAO medicationDAO = sqlSession.getMapper(MedicationDAO.class);
            medicationDAO.deleteByID(medication);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error deleting medication", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
}
