package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;

public interface OrderDAO {
     String generateOrderId() throws SQLException, ClassNotFoundException;

     boolean orderExist(String orderId) throws SQLException, ClassNotFoundException;

     boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;
}
