package com.solvd.hospitaldb.dao.impl;

import com.solvd.hospitaldb.bin.Department;
import com.solvd.hospitaldb.dao.Config;
import com.solvd.hospitaldb.dao.DepartmentRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.Optional;

public class DepartmentRepositoryImpl implements DepartmentRepository {

    @Override
    public void create(Department department) {
        try (SqlSession sqlSession = Config.getSessionFactory().openSession(true)) {
            DepartmentRepository departmentRepository = sqlSession.getMapper(DepartmentRepository.class);
            departmentRepository.create(department);
        }
    }

    @Override
    public Optional<Department> findByName(String deptName) {
        try (SqlSession sqlSession = Config.getSessionFactory().openSession(true)) {
            DepartmentRepository departmentRepository = sqlSession.getMapper(DepartmentRepository.class);
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
