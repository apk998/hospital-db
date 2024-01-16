package com.solvd.hospitaldb.dao.impl.mybatis;

import com.solvd.hospitaldb.bin.Payment;
import com.solvd.hospitaldb.dao.PaymentDAO;
import com.solvd.hospitaldb.util.Config;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class PaymentDAOImpl implements PaymentDAO {

    private static final Logger LOGGER = LogManager.getLogger(com.solvd.hospitaldb.dao.impl.mybatis.PaymentDAOImpl.class);

    @Override
    public void create(Payment payment) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            PaymentDAO paymentDAO = sqlSession.getMapper(PaymentDAO.class);
            paymentDAO.create(payment);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error creating payment", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public Optional<Payment> findByID(int id) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        Optional<Payment> optionalPayment = Optional.empty();
        try {
            PaymentDAO paymentDAO = sqlSession.getMapper(PaymentDAO.class);
            paymentDAO.findByID(id);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error finding payment by ID");
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        return optionalPayment;
    }

    @Override
    public void updateByID(Payment payment, int id) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            PaymentDAO paymentDAO = sqlSession.getMapper(PaymentDAO.class);
            paymentDAO.updateByID(payment, id);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error updating payment", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void deleteByID(Payment payment) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            PaymentDAO paymentDAO = sqlSession.getMapper(PaymentDAO.class);
            paymentDAO.deleteByID(payment);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error deleting payment", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Payment> getPaymentsForPatient(Integer patientID) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        List<Payment> payments = null;
        try {
            payments.sqlSession.selectList("com.solvd.hospitaldb.dao.PaymentDAO.getPaymentsForPatient", patientID);
        } catch (PersistenceException e) {
            LOGGER.error("Error getting payments for patient", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        return payments;
    }
}
