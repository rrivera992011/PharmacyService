package com.solvd.pharmacyservice.sql.mybatis;

import com.solvd.pharmacyservice.models.AppointmentType;
import com.solvd.pharmacyservice.sql.IAppointmentTypeDAO;
import com.solvd.pharmacyservice.utils.MyBatisSqlFactory;
import org.apache.ibatis.session.*;

import java.util.List;

public class AppointmentTypeDAO implements IAppointmentTypeDAO {
    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public AppointmentType getAppointmentTypeByName(String appointmentTypeName) {
        AppointmentType appointmentType;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IAppointmentTypeDAO appointmentTypeDAO = sqlSession.getMapper(IAppointmentTypeDAO.class);
            appointmentType = appointmentTypeDAO.getAppointmentTypeByName(appointmentTypeName);
        }
        return appointmentType;
    }

    @Override
    public AppointmentType getEntityById(int id) {
        AppointmentType appointmentType;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IAppointmentTypeDAO appointmentTypeDAO = sqlSession.getMapper(IAppointmentTypeDAO.class);
            appointmentType = appointmentTypeDAO.getEntityById(id);
        }
        return appointmentType;
    }

    @Override
    public void updateEntity(AppointmentType appointmentType) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IAppointmentTypeDAO appointmentTypeDAO = sqlSession.getMapper(IAppointmentTypeDAO.class);
            appointmentTypeDAO.updateEntity(appointmentType);
            sqlSession.commit();
        }
    }

    @Override
    public void createEntity(AppointmentType appointmentType) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IAppointmentTypeDAO appointmentTypeDAO = sqlSession.getMapper(IAppointmentTypeDAO.class);
            appointmentTypeDAO.createEntity(appointmentType);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IAppointmentTypeDAO appointmentTypeDAO = sqlSession.getMapper(IAppointmentTypeDAO.class);
            appointmentTypeDAO.removeEntity(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<AppointmentType> getAll() {
        List<AppointmentType> appointmentTypes;

        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IAppointmentTypeDAO appointmentTypeDAO = sqlSession.getMapper(IAppointmentTypeDAO.class);
            appointmentTypes = appointmentTypeDAO.getAll();
        }
        return appointmentTypes;
    }
}
