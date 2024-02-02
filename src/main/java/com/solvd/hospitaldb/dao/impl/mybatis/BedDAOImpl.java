package com.solvd.hospitaldb.dao.impl.mybatis;

import com.solvd.hospitaldb.bin.Bed;
import com.solvd.hospitaldb.dao.BedDAO;
import com.solvd.hospitaldb.util.Config;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class BedDAOImpl implements BedDAO {

    private static final Logger LOGGER= LogManager.getLogger(com.solvd.hospitaldb.dao.impl.mybatis.BedDAOImpl.class);

    @Override
    public void create(Bed bed) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            BedDAO bedDAO = sqlSession.getMapper(BedDAO.class);
            bedDAO.create(bed);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error creating bed", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public Optional<Bed> findByID(int id) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        Optional<Bed> optionalBed = Optional.empty();
        try {
            BedDAO bedDAO = sqlSession.getMapper(BedDAO.class);
            optionalBed = bedDAO.findByID(id);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error finding bed by ID", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        return optionalBed;
    }

    @Override
    public void updateByID(Bed bed, int id) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            BedDAO bedDAO = sqlSession.getMapper(BedDAO.class);
            bedDAO.updateByID(bed, id);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error updating bed", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void deleteByID(Bed bed) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            BedDAO bedDAO = sqlSession.getMapper(BedDAO.class);
            bedDAO.deleteByID(bed);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error deleting bed", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
}
