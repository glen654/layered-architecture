package com.example.layeredarchitecture.BO.custom;

import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBo {
    ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;

    boolean deleteItem(String id) throws SQLException, ClassNotFoundException;

    boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    boolean existItem(String id) throws SQLException, ClassNotFoundException;

    String generateItemId() throws SQLException, ClassNotFoundException;

}
