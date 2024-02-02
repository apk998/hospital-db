package com.solvd.hospitaldb.dao.impl.mybatis;

import com.solvd.hospitaldb.bin.InsuranceProvider;
import com.solvd.hospitaldb.dao.InsuranceProviderDAO;
import com.solvd.hospitaldb.util.Config;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class InsuranceProviderImpl implements InsuranceProviderDAO {

    private static final Logger LOGGER= LogManager.getLogger(com.solvd.hospitaldb.dao.impl.mybatis.InsuranceProviderImpl.class);

    @Override
    public void create(InsuranceProvider provider) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            InsuranceProviderDAO providerDAO = sqlSession.getMapper(InsuranceProviderDAO.class);
            providerDAO.create(provider);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error creating insurance provider", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public Optional<InsuranceProvider> findByID(int id) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        Optional<InsuranceProvider> optionalProvider = Optional.empty();
        try {
            InsuranceProviderDAO providerDAO = sqlSession.getMapper(InsuranceProviderDAO.class);
            optionalProvider = providerDAO.findByID(id);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error finding insurance provider by ID", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        return optionalProvider;
    }

    @Override
    public void updateByID(InsuranceProvider provider, int id) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            InsuranceProviderDAO providerDAO = sqlSession.getMapper(InsuranceProviderDAO.class);
            providerDAO.updateByID(provider, id);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error updating insurance provider", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void deleteByID(InsuranceProvider provider) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            InsuranceProviderDAO providerDAO = sqlSession.getMapper(InsuranceProviderDAO.class);
            providerDAO.deleteByID(provider);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error deleting insurance provider", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
}
