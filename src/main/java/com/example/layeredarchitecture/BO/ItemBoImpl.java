package com.example.layeredarchitecture.BO;

import com.example.layeredarchitecture.DAO.custom.ItemDAO;
import com.example.layeredarchitecture.DAO.impl.ItemDAOImpl;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBoImpl implements ItemBo{
    ItemDAO itemDAO = new ItemDAOImpl();
    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException{
        return itemDAO.getAll();
    }
    @Override
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException{
        return itemDAO.delete(id);
    }
    @Override
    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException{
        return itemDAO.save(dto);
    }
    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException{
        return itemDAO.update(dto);
    }
    @Override
    public boolean existItem(String id) throws SQLException, ClassNotFoundException{
        return itemDAO.exist(id);
    }
    @Override
    public String generateItemId() throws SQLException, ClassNotFoundException{
        return itemDAO.generateId();
    }
}
