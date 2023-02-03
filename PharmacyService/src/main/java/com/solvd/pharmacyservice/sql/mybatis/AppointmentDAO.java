package com.solvd.pharmacyservice.sql.mybatis;

import com.solvd.pharmacyservice.models.Appointment;
import com.solvd.pharmacyservice.sql.IAppointmentDAO;
import com.solvd.pharmacyservice.utils.MyBatisSqlFactory;
import org.apache.ibatis.session.*;

import java.util.List;

public class AppointmentDAO implements IAppointmentDAO {
    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public Appointment getAppointmentByCustomerID(int customerId) {
        Appointment appointment;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IAppointmentDAO appointmentDAO = sqlSession.getMapper(IAppointmentDAO.class);
            appointment = appointmentDAO.getAppointmentByCustomerID(customerId);
        }
        return appointment;
    }

    @Override
    public Appointment getEntityById(int id) {
        Appointment appointment;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IAppointmentDAO appointmentDAO = sqlSession.getMapper(IAppointmentDAO.class);
            appointment = appointmentDAO.getEntityById(id);
        }
        return appointment;
    }

    @Override
    public void updateEntity(Appointment appointment) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IAppointmentDAO appointmentDAO = sqlSession.getMapper(IAppointmentDAO.class);
            appointmentDAO.updateEntity(appointment);
            sqlSession.commit();
        }
    }

    @Override
    public void createEntity(Appointment appointment) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IAppointmentDAO appointmentDAO = sqlSession.getMapper(IAppointmentDAO.class);
            appointmentDAO.createEntity(appointment);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IAppointmentDAO appointmentDAO = sqlSession.getMapper(IAppointmentDAO.class);
            appointmentDAO.removeEntity(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Appointment> getAll() {
        List<Appointment> appointments;

        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IAppointmentDAO appointmentDAO = sqlSession.getMapper(IAppointmentDAO.class);
            appointments = appointmentDAO.getAll();
        }
        return appointments;
    }
}
