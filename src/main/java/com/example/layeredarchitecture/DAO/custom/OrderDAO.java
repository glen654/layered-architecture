package com.example.layeredarchitecture.DAO.custom;

import com.example.layeredarchitecture.DAO.CrudDAO;
import com.example.layeredarchitecture.model.OrderDTO;

public interface OrderDAO extends CrudDAO<OrderDTO> {
    /* String generateOrderId() throws SQLException, ClassNotFoundException;

     boolean orderExist(String orderId) throws SQLException, ClassNotFoundException;

     boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;*/
}
