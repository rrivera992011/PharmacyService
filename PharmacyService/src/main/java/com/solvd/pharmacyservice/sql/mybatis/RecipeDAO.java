package com.solvd.pharmacyservice.sql.mybatis;

import com.solvd.pharmacyservice.models.Prescription;
import com.solvd.pharmacyservice.models.Recipe;
import com.solvd.pharmacyservice.sql.IPrescriptionDAO;
import com.solvd.pharmacyservice.sql.IRecipeDAO;
import com.solvd.pharmacyservice.utils.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class RecipeDAO implements IRecipeDAO {
    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public Recipe getEntityById(int id) {
        Recipe recipe;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IRecipeDAO recipeDAO = sqlSession.getMapper(IRecipeDAO.class);
            recipe = recipeDAO.getEntityById(id);
        }
        return recipe;
    }

    @Override
    public void updateEntity(Recipe recipe) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IRecipeDAO recipeDAO = sqlSession.getMapper(IRecipeDAO.class);
            recipeDAO.updateEntity(recipe);
            sqlSession.commit();
        }
    }

    @Override
    public void createEntity(Recipe recipe) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IRecipeDAO recipeDAO = sqlSession.getMapper(IRecipeDAO.class);
            recipeDAO.createEntity(recipe);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IRecipeDAO recipeDAO = sqlSession.getMapper(IRecipeDAO.class);
            recipeDAO.removeEntity(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Recipe> getAll() {
        List<Recipe> recipes;

        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IRecipeDAO recipeDAO = sqlSession.getMapper(IRecipeDAO.class);
            recipes = recipeDAO.getAll();
        }
        return recipes;
    }

    @Override
    public Recipe getRecipeFromRecipeSize(double recipeSize) {
        Recipe recipe;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IRecipeDAO recipeDAO = sqlSession.getMapper(IRecipeDAO.class);
            recipe = recipeDAO.getRecipeFromRecipeSize(recipeSize);
        }
        return recipe;
    }
}
