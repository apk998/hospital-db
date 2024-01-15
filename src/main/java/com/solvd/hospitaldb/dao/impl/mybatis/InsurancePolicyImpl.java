package com.solvd.hospitaldb.dao.impl.mybatis;

import com.solvd.hospitaldb.bin.InsurancePolicy;
import com.solvd.hospitaldb.dao.InsurancePolicyDAO;
import com.solvd.hospitaldb.util.Config;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class InsurancePolicyImpl implements InsurancePolicyDAO {

    private static final Logger LOGGER= LogManager.getLogger(com.solvd.hospitaldb.dao.impl.mybatis.InsurancePolicyImpl.class);

    @Override
    public void create(InsurancePolicy policy) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            InsurancePolicyDAO policyDAO = sqlSession.getMapper(InsurancePolicyDAO.class);
            policyDAO.create(policy);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error creating insurance policy", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public Optional<InsurancePolicy> findByID(int id) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        Optional<InsurancePolicy> optionalPolicy = Optional.empty();
        try {
            InsurancePolicyDAO policyDAO = sqlSession.getMapper(InsurancePolicyDAO.class);
            policyDAO.findByID(id);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error finding insurance policy by ID", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        return optionalPolicy;
    }

    @Override
    public void updateByID(InsurancePolicy policy, int id) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            InsurancePolicyDAO policyDAO = sqlSession.getMapper(InsurancePolicyDAO.class);
            policyDAO.updateByID(policy, id);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error updating insurance policy", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void deleteByID(InsurancePolicy policy) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            InsurancePolicyDAO policyDAO = sqlSession.getMapper(InsurancePolicyDAO.class);
            policyDAO.deleteByID(policy);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error deleting insurance policy", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
}
