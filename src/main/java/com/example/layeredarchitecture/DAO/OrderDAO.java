package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;
import java.time.LocalDate;

public interface OrderDAO {
     String generateOrderId() throws SQLException, ClassNotFoundException;

     boolean orderExist(String orderId) throws SQLException, ClassNotFoundException;

     boolean saveOrder(String orderId, LocalDate orderDate,String customerId) throws SQLException, ClassNotFoundException;
}
