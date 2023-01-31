package com.solvd.pharmacyservice.sql.mybatis;

import com.solvd.pharmacyservice.models.Examination;
import com.solvd.pharmacyservice.sql.IExaminationDAO;
import com.solvd.pharmacyservice.utils.MyBatisSqlFactory;
import org.apache.ibatis.session.*;

import java.util.List;

public class ExaminationDAO implements IExaminationDAO {
    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public Examination getEntityById(int id) {
        Examination examination;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IExaminationDAO examinationDAO = sqlSession.getMapper(IExaminationDAO.class);
            examination = examinationDAO.getEntityById(id);
        }
        return examination;
    }

    @Override
    public void updateEntity(Examination examination) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IExaminationDAO examinationDAO = sqlSession.getMapper(IExaminationDAO.class);
            examinationDAO.updateEntity(examination);
            sqlSession.commit();
        }
    }

    @Override
    public void createEntity(Examination examination) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IExaminationDAO examinationDAO = sqlSession.getMapper(IExaminationDAO.class);
            examinationDAO.createEntity(examination);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IExaminationDAO examinationDAO = sqlSession.getMapper(IExaminationDAO.class);
            examinationDAO.removeEntity(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Examination> getAll() {
        List<Examination> examinations;

        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IExaminationDAO examinationDAO = sqlSession.getMapper(IExaminationDAO.class);
            examinations = examinationDAO.getAll();
        }
        return examinations;
    }

    @Override
    public Examination getExaminationByResult(String result) {
        Examination examination;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IExaminationDAO examinationDAO = sqlSession.getMapper(IExaminationDAO.class);
            examination = examinationDAO.getExaminationByResult(result);
        }
        return examination;
    }
}
