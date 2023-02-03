package com.solvd.pharmacyservice.sql.mybatis;

import com.solvd.pharmacyservice.models.Examination;
import com.solvd.pharmacyservice.models.ExaminationType;
import com.solvd.pharmacyservice.sql.IExaminationDAO;
import com.solvd.pharmacyservice.sql.IExaminationTypeDAO;
import com.solvd.pharmacyservice.utils.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ExaminationTypeDAO implements IExaminationTypeDAO {
    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public ExaminationType getEntityById(int id) {
        ExaminationType examinationType;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IExaminationTypeDAO examinationTypeDAO = sqlSession.getMapper(IExaminationTypeDAO.class);
            examinationType = examinationTypeDAO.getEntityById(id);
        }
        return examinationType;
    }


    @Override
    public void updateEntity(ExaminationType examinationType) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IExaminationTypeDAO examinationTypeDAO = sqlSession.getMapper(IExaminationTypeDAO.class);
            examinationTypeDAO.updateEntity(examinationType);
            sqlSession.commit();
        }
    }

    @Override
    public void createEntity(ExaminationType examinationType) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IExaminationTypeDAO examinationTypeDAO = sqlSession.getMapper(IExaminationTypeDAO.class);
            examinationTypeDAO.createEntity(examinationType);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IExaminationTypeDAO examinationTypeDAO = sqlSession.getMapper(IExaminationTypeDAO.class);
            examinationTypeDAO.removeEntity(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<ExaminationType> getAll() {
        List<ExaminationType> examinationTypes;

        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IExaminationTypeDAO examinationTypeDAO = sqlSession.getMapper(IExaminationTypeDAO.class);
            examinationTypes = examinationTypeDAO.getAll();
        }
        return examinationTypes;
    }

    @Override
    public ExaminationType getExaminationTypeByName(String examinationTypeName) {
        ExaminationType examinationType;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IExaminationTypeDAO examinationTypeDAO = sqlSession.getMapper(IExaminationTypeDAO.class);
            examinationType = examinationTypeDAO.getExaminationTypeByName(examinationTypeName);
        }
        return examinationType;
    }
}
