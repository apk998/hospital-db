package com.solvd.hospitaldb.dao.impl.mybatis;

import com.solvd.hospitaldb.bin.Department;
import com.solvd.hospitaldb.dao.DepartmentDAO;
import com.solvd.hospitaldb.util.Config;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class DepartmentDAOImpl implements DepartmentDAO {

    private static final Logger LOGGER= LogManager.getLogger(com.solvd.hospitaldb.dao.impl.mybatis.DepartmentDAOImpl.class);

    @Override
    public void create(Department department) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            DepartmentDAO departmentDAO = sqlSession.getMapper(DepartmentDAO.class);
            departmentDAO.create(department);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error creating department", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public Optional<Department> findByID(int id) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        Optional<Department> optionalDepartment = Optional.empty();
        try {
            DepartmentDAO departmentDAO = sqlSession.getMapper(DepartmentDAO.class);
            departmentDAO.findByID(id);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error finding department by ID", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        return optionalDepartment;
    }

    @Override
    public void updateByID(Department department, int id) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            DepartmentDAO departmentDAO = sqlSession.getMapper(DepartmentDAO.class);
            departmentDAO.updateByID(department, id);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error updating department", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void deleteByID(Department department) {
        SqlSession sqlSession = Config.getSessionFactory().openSession(false);
        try {
            DepartmentDAO departmentDAO = sqlSession.getMapper(DepartmentDAO.class);
            departmentDAO.deleteByID(department);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("Error deleting department", e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
}
