package com.solvd.pharmacyservice.sql.mybatis;

import com.solvd.pharmacyservice.models.PaymentType;
import com.solvd.pharmacyservice.sql.IPaymentTypeDAO;
import com.solvd.pharmacyservice.utils.MyBatisSqlFactory;
import org.apache.ibatis.session.*;

import java.util.List;

public class PaymentTypeDAO implements IPaymentTypeDAO {
    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public PaymentType getEntityById(int id) {
        PaymentType paymentType;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IPaymentTypeDAO paymentTypeDAO = sqlSession.getMapper(IPaymentTypeDAO.class);
            paymentType = paymentTypeDAO.getEntityById(id);
        }
        return paymentType;
    }

    @Override
    public void updateEntity(PaymentType paymentType) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPaymentTypeDAO paymentTypeDAO = sqlSession.getMapper(IPaymentTypeDAO.class);
            paymentTypeDAO.updateEntity(paymentType);
            sqlSession.commit();
        }
    }

    @Override
    public void createEntity(PaymentType paymentType) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPaymentTypeDAO paymentTypeDAO = sqlSession.getMapper(IPaymentTypeDAO.class);
            paymentTypeDAO.createEntity(paymentType);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPaymentTypeDAO paymentTypeDAO = sqlSession.getMapper(IPaymentTypeDAO.class);
            paymentTypeDAO.removeEntity(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<PaymentType> getAll() {
        List<PaymentType> paymentTypes;

        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IPaymentTypeDAO paymentTypeDAO = sqlSession.getMapper(IPaymentTypeDAO.class);
            paymentTypes = paymentTypeDAO.getAll();
        }
        return paymentTypes;
    }

    @Override
    public PaymentType getPaymentTypeByName(String paymentTypeName) {
        PaymentType paymentType;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IPaymentTypeDAO paymentTypeDAO = sqlSession.getMapper(IPaymentTypeDAO.class);
            paymentType = paymentTypeDAO.getPaymentTypeByName(paymentTypeName);
        }
        return paymentType;
    }
}
