package com.solvd.pharmacyservice.sql.mybatis;

import com.solvd.pharmacyservice.models.*;
import com.solvd.pharmacyservice.sql.*;
import com.solvd.pharmacyservice.utils.MyBatisSqlFactory;
import org.apache.ibatis.session.*;

import java.util.List;

public class EmployeeDAO implements IEmployeeDAO {
    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public Employee getEntityById(int id) {
        Employee employee;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employee = employeeDAO.getEntityById(id);
        }
        return employee;
    }

    @Override
    public void updateEntity(Employee employee) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employeeDAO.updateEntity(employee);
            sqlSession.commit();
        }
    }

    @Override
    public void createEntity(Employee employee) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employeeDAO.createEntity(employee);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employeeDAO.removeEntity(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees;

        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employees = employeeDAO.getAll();
        }
        return employees;
    }

    @Override
    public void updateEmployeeTypeIDWithLastName(Employee employee) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employeeDAO.updateEmployeeTypeIDWithLastName(employee);
            sqlSession.commit();
        }
    }
}
