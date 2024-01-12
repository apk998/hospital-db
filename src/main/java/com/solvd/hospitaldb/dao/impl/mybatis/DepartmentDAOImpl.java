package com.solvd.hospitaldb.dao.impl.mybatis;

import com.solvd.hospitaldb.bin.Department;
import com.solvd.hospitaldb.dao.DepartmentDAO;
import com.solvd.hospitaldb.util.Config;
import org.apache.ibatis.session.SqlSession;
import java.sql.SQLException;

import java.util.Optional;

public class DepartmentDAOImpl implements DepartmentDAO {

    @Override
    public int create(Department department) throws SQLException {
        try (SqlSession sqlSession = Config.getSessionFactory().openSession(true)) {
            DepartmentDAO departmentDAO = sqlSession.getMapper(DepartmentDAO.class);
            return departmentDAO.create(department);
        }
    }

    @Override
    public Optional<Department> findByID(int id) throws SQLException {
        try (SqlSession sqlSession = Config.getSessionFactory().openSession(true)) {
            DepartmentDAO departmentDAO = sqlSession.getMapper(DepartmentDAO.class);
            return departmentDAO.findByID(id);
        }
    }

    @Override
    public int updateByID(Department department, int id) throws SQLException {
        try (SqlSession sqlSession = Config.getSessionFactory().openSession(true)) {
            DepartmentDAO departmentDAO = sqlSession.getMapper(DepartmentDAO.class);
            return departmentDAO.updateByID(department, id);
        }
    }

    @Override
    public int deleteByID(Department department) throws SQLException {
        try (SqlSession sqlSession = Config.getSessionFactory().openSession(true)) {
            DepartmentDAO departmentDAO = sqlSession.getMapper(DepartmentDAO.class);
            return departmentDAO.deleteByID(department);
        }
    }
}
