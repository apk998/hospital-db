package com.solvd.hospitaldb.dao.impl.mybatis;

import com.solvd.hospitaldb.bin.LabTest;
import com.solvd.hospitaldb.dao.LabTestDAO;
import com.solvd.hospitaldb.util.Config;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class LabTestDAOImpl implements LabTestDAO {

    private static final Logger LOGGER= LogManager.getLogger(com.solvd.hospitaldb.dao.impl.mybatis.LabTestDAOImpl.class);

    @Override
    public void create(LabTest test) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            LabTestDAO labTestDAO = sqlSession.getMapper(LabTestDAO.class);
            labTestDAO.create(test);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error creating lab test", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public Optional<LabTest> findByID(int id) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        Optional<LabTest> optionalTest = Optional.empty();
        try {
            LabTestDAO labTestDAO = sqlSession.getMapper(LabTestDAO.class);
            labTestDAO.findByID(id);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error finding lab test by ID", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        return optionalTest;
    }

    @Override
    public void updateByID(LabTest test, int id) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            LabTestDAO labTestDAO = sqlSession.getMapper(LabTestDAO.class);
            labTestDAO.updateByID(test, id);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error updating lab test", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void deleteByID(LabTest test) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            LabTestDAO labTestDAO = sqlSession.getMapper(LabTestDAO.class);
            labTestDAO.deleteByID(test);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error deleting lab test", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
}
