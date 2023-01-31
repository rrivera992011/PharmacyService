package com.solvd.pharmacyservice.sql.mybatis;

import com.solvd.pharmacyservice.models.Customer;
import com.solvd.pharmacyservice.sql.ICustomerDAO;
import com.solvd.pharmacyservice.utils.MyBatisSqlFactory;
import org.apache.ibatis.session.*;

import java.util.List;

public class CustomerDAO implements ICustomerDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();
    @Override
    public Customer getEntityById(int id) {
        Customer customer;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            ICustomerDAO customerDAO = sqlSession.getMapper(ICustomerDAO.class);
            customer = customerDAO.getEntityById(id);
        }
        return customer;
    }

    @Override
    public void updateEntity(Customer customer) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            ICustomerDAO customerDAO = sqlSession.getMapper(ICustomerDAO.class);
            customerDAO.updateEntity(customer);
            sqlSession.commit();
        }

    }

    @Override
    public void createEntity(Customer customer) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = sqlSession.getMapper(ICustomerDAO.class);
            customerDAO.createEntity(customer);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = sqlSession.getMapper(ICustomerDAO.class);
            customerDAO.removeEntity(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers;

        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            ICustomerDAO customerDAO = sqlSession.getMapper(ICustomerDAO.class);
            customers = customerDAO.getAll();
        }
        return customers;
    }

    @Override
    public Customer getCustomerByLastName(String lastName) {
        Customer customer;

        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            ICustomerDAO customerDAO = sqlSession.getMapper(ICustomerDAO.class);
            customer = customerDAO.getCustomerByLastName(lastName);
        }
        return customer;
    }
}
