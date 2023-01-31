package com.solvd.pharmacyservice.sql.mybatis;

import com.solvd.pharmacyservice.models.Prescription;
import com.solvd.pharmacyservice.sql.IPrescriptionDAO;
import com.solvd.pharmacyservice.utils.MyBatisSqlFactory;
import org.apache.ibatis.session.*;

import java.util.List;

public class PrescriptionDAO implements IPrescriptionDAO {
    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public Prescription getEntityById(int id) {
        Prescription prescription;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IPrescriptionDAO prescriptionDAO = sqlSession.getMapper(IPrescriptionDAO.class);
            prescription = prescriptionDAO.getEntityById(id);
        }
        return prescription;
    }

    @Override
    public void updateEntity(Prescription prescription) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPrescriptionDAO prescriptionDAO = sqlSession.getMapper(IPrescriptionDAO.class);
            prescriptionDAO.updateEntity(prescription);
            sqlSession.commit();
        }
    }

    @Override
    public void createEntity(Prescription prescription) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPrescriptionDAO prescriptionDAO = sqlSession.getMapper(IPrescriptionDAO.class);
            prescriptionDAO.createEntity(prescription);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPrescriptionDAO prescriptionDAO = sqlSession.getMapper(IPrescriptionDAO.class);
            prescriptionDAO.removeEntity(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Prescription> getAll() {
        List<Prescription> prescriptions;

        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IPrescriptionDAO prescriptionDAO = sqlSession.getMapper(IPrescriptionDAO.class);
            prescriptions = prescriptionDAO.getAll();
        }
        return prescriptions;
    }

    @Override
    public Prescription getPrescriptionByRxNumber(String rxNumber) {
        Prescription prescription;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IPrescriptionDAO prescriptionDAO = sqlSession.getMapper(IPrescriptionDAO.class);
            prescription = prescriptionDAO.getPrescriptionByRxNumber(rxNumber);
        }
        return prescription;
    }

    @Override
    public Prescription getPrescriptionByCustomerID(int customerId) {
        Prescription prescription;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IPrescriptionDAO prescriptionDAO = sqlSession.getMapper(IPrescriptionDAO.class);
            prescription = prescriptionDAO.getPrescriptionByCustomerID(customerId);
        }
        return prescription;
    }
}
