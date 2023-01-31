package com.solvd.pharmacyservice.sql.mybatis;

import com.solvd.pharmacyservice.models.CustomerOrder;
import com.solvd.pharmacyservice.sql.ICustomerOrderDAO;
import com.solvd.pharmacyservice.utils.MyBatisSqlFactory;
import org.apache.ibatis.session.*;

import java.util.List;

public class CustomerOrderDAO implements ICustomerOrderDAO {
    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public CustomerOrder getEntityById(int id) {
        CustomerOrder customerOrder;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            ICustomerOrderDAO customerOrderDAO = sqlSession.getMapper(ICustomerOrderDAO.class);
            customerOrder = customerOrderDAO.getEntityById(id);
        }
        return customerOrder;
    }

    @Override
    public void updateEntity(CustomerOrder customerOrder) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICustomerOrderDAO customerOrderDAO = sqlSession.getMapper(ICustomerOrderDAO.class);
            customerOrderDAO.updateEntity(customerOrder);
            sqlSession.commit();
        }
    }

    @Override
    public void createEntity(CustomerOrder customerOrder) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICustomerOrderDAO customerOrderDAO = sqlSession.getMapper(ICustomerOrderDAO.class);
            customerOrderDAO.createEntity(customerOrder);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICustomerOrderDAO customerOrderDAO = sqlSession.getMapper(ICustomerOrderDAO.class);
            customerOrderDAO.removeEntity(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<CustomerOrder> getAll() {
        List<CustomerOrder> customerOrders;

        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            ICustomerOrderDAO customerOrderDAO = sqlSession.getMapper(ICustomerOrderDAO.class);
            customerOrders = customerOrderDAO.getAll();
        }
        return customerOrders;
    }

    @Override
    public CustomerOrder getCustomerOrderByProductID(int customerOrderId) {
        CustomerOrder customerOrder;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            ICustomerOrderDAO customerOrderDAO = sqlSession.getMapper(ICustomerOrderDAO.class);
            customerOrder = customerOrderDAO.getCustomerOrderByProductID(customerOrderId);
        }
        return customerOrder;
    }
}
