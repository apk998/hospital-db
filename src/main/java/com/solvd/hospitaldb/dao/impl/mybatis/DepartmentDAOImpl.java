package com.solvd.hospitaldb.dao.impl.mybatis;

import com.solvd.hospitaldb.bin.Department;
import com.solvd.hospitaldb.dao.DepartmentDAO;
import com.solvd.hospitaldb.util.Config;
import org.apache.ibatis.session.SqlSession;

import java.util.Optional;

public class DepartmentDAOImpl implements DepartmentDAO {

    @Override
    public void create(Department department) {
        try (SqlSession sqlSession = Config.getSessionFactory().openSession(true)) {
            DepartmentDAO departmentRepository = sqlSession.getMapper(DepartmentDAO.class);
            departmentRepository.create(department);
        }
    }

    @Override
    public Optional<Department> findByName(String deptName) {
        try (SqlSession sqlSession = Config.getSessionFactory().openSession(true)) {
            DepartmentDAO departmentRepository = sqlSession.getMapper(DepartmentDAO.class);
            return departmentRepository.findByName("Cardiology"); // for example
        }
    }

    @Override
    public void updateByName(String deptName) {

    }

    @Override
    public void deleteByName(String deptName) {

    }
}
