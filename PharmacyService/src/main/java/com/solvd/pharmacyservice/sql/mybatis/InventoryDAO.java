package com.solvd.pharmacyservice.sql.mybatis;

import com.solvd.pharmacyservice.models.Examination;
import com.solvd.pharmacyservice.models.Inventory;
import com.solvd.pharmacyservice.sql.IExaminationDAO;
import com.solvd.pharmacyservice.sql.IInventoryDAO;
import com.solvd.pharmacyservice.utils.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class InventoryDAO implements IInventoryDAO {
    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public Inventory getEntityById(int id) {
        Inventory inventory;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IInventoryDAO inventoryDAO = sqlSession.getMapper(IInventoryDAO.class);
            inventory = inventoryDAO.getEntityById(id);
        }
        return inventory;
    }

    @Override
    public void updateEntity(Inventory inventory) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IInventoryDAO inventoryDAO = sqlSession.getMapper(IInventoryDAO.class);
            inventoryDAO.updateEntity(inventory);
            sqlSession.commit();
        }
    }

    @Override
    public void createEntity(Inventory inventory) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IInventoryDAO inventoryDAO = sqlSession.getMapper(IInventoryDAO.class);
            inventoryDAO.createEntity(inventory);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IInventoryDAO inventoryDAO = sqlSession.getMapper(IInventoryDAO.class);
            inventoryDAO.removeEntity(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Inventory> getAll() {
        List<Inventory> inventories;

        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IInventoryDAO inventoryDAO = sqlSession.getMapper(IInventoryDAO.class);
            inventories = inventoryDAO.getAll();
        }
        return inventories;
    }

    @Override
    public Inventory getInventoryByMedicineName(String medicineName) {
        Inventory inventory;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            IInventoryDAO inventoryDAO = sqlSession.getMapper(IInventoryDAO.class);
            inventory = inventoryDAO.getInventoryByMedicineName(medicineName);
        }
        return inventory;
    }

    @Override
    public void removeInventoryWithAmountLeft(int amountLeft) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IInventoryDAO inventoryDAO = sqlSession.getMapper(IInventoryDAO.class);
            inventoryDAO.removeInventoryWithAmountLeft(amountLeft);
            sqlSession.commit();
        }
    }
}
