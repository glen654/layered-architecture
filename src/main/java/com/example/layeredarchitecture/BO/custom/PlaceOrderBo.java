package com.example.layeredarchitecture.BO.custom;

import com.example.layeredarchitecture.BO.SuperBo;
import com.example.layeredarchitecture.DAO.SuperDAO;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PlaceOrderBo extends SuperBo {
     boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;

     ItemDTO findItem(String code);

    CustomerDTO searchCustomer(String newValue) throws SQLException, ClassNotFoundException;
    ItemDTO searchItem(String newValue) throws SQLException, ClassNotFoundException;

    boolean itemExist(String id) throws SQLException, ClassNotFoundException;

    boolean customerExist(String id) throws SQLException, ClassNotFoundException;

    String generateOrderId() throws SQLException, ClassNotFoundException;

    ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;

    ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;

}
