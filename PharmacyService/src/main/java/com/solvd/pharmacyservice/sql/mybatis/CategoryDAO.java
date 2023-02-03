package com.solvd.pharmacyservice.sql.mybatis;

import com.solvd.pharmacyservice.models.Category;
import com.solvd.pharmacyservice.sql.ICategoryDAO;
import com.solvd.pharmacyservice.utils.MyBatisSqlFactory;
import org.apache.ibatis.session.*;

import java.util.List;

public class CategoryDAO implements ICategoryDAO {
    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public Category getEntityById(int id) {
        Category category;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            ICategoryDAO categoryDAO = sqlSession.getMapper(ICategoryDAO.class);
            category = categoryDAO.getEntityById(id);
        }
        return category;
    }

    @Override
    public void updateEntity(Category category) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICategoryDAO categoryDAO = sqlSession.getMapper(ICategoryDAO.class);
            categoryDAO.updateEntity(category);
            sqlSession.commit();
        }
    }

    @Override
    public void createEntity(Category category) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICategoryDAO categoryDAO = sqlSession.getMapper(ICategoryDAO.class);
            categoryDAO.createEntity(category);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICategoryDAO categoryDAO = sqlSession.getMapper(ICategoryDAO.class);
            categoryDAO.removeEntity(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories;

        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            ICategoryDAO categoryDAO = sqlSession.getMapper(ICategoryDAO.class);
            categories = categoryDAO.getAll();
        }
        return categories;
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        Category category;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            ICategoryDAO categoryDAO = sqlSession.getMapper(ICategoryDAO.class);
            category = categoryDAO.getCategoryByName(categoryName);
        }
        return category;
    }
}
