package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface OrderDetailsDAO {
     boolean saveOrderDetails(String orderId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;
}
