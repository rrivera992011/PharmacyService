package com.solvd.pharmacyservice.sql.mybatis;

import com.solvd.pharmacyservice.models.EmployeeType;
import com.solvd.pharmacyservice.sql.IEmployeeTypeDAO;
import com.solvd.pharmacyservice.utils.MyBatisSqlFactory;
import org.apache.ibatis.session.*;

import java.util.List;

public class EmployeeTypeDAO implements IEmployeeTypeDAO {
    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public EmployeeType getEntityById(int id) {
        EmployeeType employeeType;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IEmployeeTypeDAO employeeTypeDAO = sqlSession.getMapper(IEmployeeTypeDAO.class);
            employeeType = employeeTypeDAO.getEntityById(id);
        }
        return employeeType;
    }

    @Override
    public void updateEntity(EmployeeType employeeType) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IEmployeeTypeDAO employeeTypeDAO = sqlSession.getMapper(IEmployeeTypeDAO.class);
            employeeTypeDAO.updateEntity(employeeType);
            sqlSession.commit();
        }
    }

    @Override
    public void createEntity(EmployeeType employeeType) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IEmployeeTypeDAO employeeTypeDAO = sqlSession.getMapper(IEmployeeTypeDAO.class);
            employeeTypeDAO.createEntity(employeeType);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IEmployeeTypeDAO employeeTypeDAO = sqlSession.getMapper(IEmployeeTypeDAO.class);
            employeeTypeDAO.removeEntity(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<EmployeeType> getAll() {
        List<EmployeeType> employeeTypes;

        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IEmployeeTypeDAO employeeTypeDAO = sqlSession.getMapper(IEmployeeTypeDAO.class);
            employeeTypes = employeeTypeDAO.getAll();
        }
        return employeeTypes;
    }

    @Override
    public EmployeeType getEmployeeTypeByName(String employeeTypeName) {
        EmployeeType employeeType;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IEmployeeTypeDAO employeeTypeDAO = sqlSession.getMapper(IEmployeeTypeDAO.class);
            employeeType = employeeTypeDAO.getEmployeeTypeByName(employeeTypeName);
        }
        return employeeType;
    }
}
