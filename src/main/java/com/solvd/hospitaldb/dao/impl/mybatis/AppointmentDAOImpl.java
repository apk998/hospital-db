package com.solvd.hospitaldb.dao.impl.mybatis;

import com.solvd.hospitaldb.bin.Appointment;
import com.solvd.hospitaldb.dao.AppointmentDAO;
import com.solvd.hospitaldb.util.Config;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class AppointmentDAOImpl implements AppointmentDAO {

    private static final Logger LOGGER= LogManager.getLogger(com.solvd.hospitaldb.dao.impl.mybatis.AppointmentDAOImpl.class);

    @Override
    public void create(Appointment appointment) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            AppointmentDAO appointmentDAO = sqlSession.getMapper(AppointmentDAO.class);
            appointmentDAO.create(appointment);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error creating appointment", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public Optional<Appointment> findByID(int id) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        Optional<Appointment> optionalAppointment = Optional.empty();
        try {
            AppointmentDAO appointmentDAO = sqlSession.getMapper(AppointmentDAO.class);
            appointmentDAO.findByID(id);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error finding appointment by ID", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        return optionalAppointment;
    }

    @Override
    public void updateByID(Appointment appointment, int id) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            AppointmentDAO appointmentDAO = sqlSession.getMapper(AppointmentDAO.class);
            appointmentDAO.updateByID(appointment, id);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error updating appointment", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void deleteByID(Appointment appointment) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            AppointmentDAO appointmentDAO = sqlSession.getMapper(AppointmentDAO.class);
            appointmentDAO.deleteByID(appointment);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error deleting appointment", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Appointment> getApptsForPatient(Integer patientID) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        List<Appointment> appointments = null;
        try {
            appointments = sqlSession.selectList("com.solvd.hospitaldb.dao.AppointmentDAO.getApptsForPatient", patientID);
        } catch (PersistenceException e) {
            LOGGER.error("Error getting appointments for patient", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        return appointments;
    }
}
