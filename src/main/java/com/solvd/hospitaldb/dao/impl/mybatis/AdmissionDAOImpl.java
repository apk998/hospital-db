package com.solvd.hospitaldb.dao.impl.mybatis;

import com.solvd.hospitaldb.bin.Admission;
import com.solvd.hospitaldb.dao.AdmissionDAO;
import com.solvd.hospitaldb.util.Config;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class AdmissionDAOImpl implements AdmissionDAO {

    private static final Logger LOGGER= LogManager.getLogger(com.solvd.hospitaldb.dao.impl.mybatis.AdmissionDAOImpl.class);

    @Override
    public void create(Admission admission) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            AdmissionDAO admissionDAO = sqlSession.getMapper(AdmissionDAO.class);
            admissionDAO.create(admission);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error creating admission", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public Optional<Admission> findByID(int id) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        Optional<Admission> optionalAdmission = Optional.empty();
        try {
            AdmissionDAO admissionDAO = sqlSession.getMapper(AdmissionDAO.class);
            admissionDAO.findByID(id);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error finding admission by ID", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        return optionalAdmission;
    }

    @Override
    public void updateByID(Admission admission, int id) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            AdmissionDAO admissionDAO = sqlSession.getMapper(AdmissionDAO.class);
            admissionDAO.updateByID(admission, id);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error updating admission", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void deleteByID(Admission admission) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            AdmissionDAO admissionDAO = sqlSession.getMapper(AdmissionDAO.class);
            admissionDAO.deleteByID(admission);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error deleting admission", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
}
