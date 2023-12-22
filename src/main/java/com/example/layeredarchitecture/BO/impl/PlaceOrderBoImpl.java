package com.example.layeredarchitecture.BO.impl;

import com.example.layeredarchitecture.BO.custom.PlaceOrderBo;
import com.example.layeredarchitecture.DAO.custom.CustomerDAO;
import com.example.layeredarchitecture.DAO.custom.ItemDAO;
import com.example.layeredarchitecture.DAO.custom.OrderDAO;
import com.example.layeredarchitecture.DAO.custom.OrderDetailsDAO;
import com.example.layeredarchitecture.DAO.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.DAO.custom.impl.ItemDAOImpl;
import com.example.layeredarchitecture.DAO.custom.impl.OrderDAOImpl;
import com.example.layeredarchitecture.DAO.custom.impl.OrderDetailsDAOImpl;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderBoImpl implements PlaceOrderBo {
    CustomerDAO customerDAO = new CustomerDAOImpl();
    ItemDAO itemDAO = new ItemDAOImpl();
    OrderDAO orderDAO = new OrderDAOImpl();
    OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAOImpl();
    @Override
    public boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
        Connection connection = null;
            connection = DBConnection.getDbConnection().getConnection();

            boolean isExist = orderDAO.exist(orderId);

            if(isExist){
                return false;
            }
            connection.setAutoCommit(false);

            var dto = new OrderDTO(orderId,orderDate,customerId);
            boolean isSaved = orderDAO.save(dto);

            if(!isSaved){
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }


            for (OrderDetailDTO detail: orderDetails){

                boolean isSave = orderDetailsDAO.saveOrderDetails(orderId,detail);
                if(!isSave){
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
                ItemDTO item =findItem(detail.getItemCode());

                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());


                boolean isUpdated = itemDAO.update(new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand()));
                if(!isUpdated){
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }

            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;

    }
    @Override
    public ItemDTO findItem(String code) {
        try {
            return  itemDAO.search(code);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find the Item " + code, e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public CustomerDTO searchCustomer(String newValue) throws SQLException, ClassNotFoundException{
        return customerDAO.search(newValue);
    }
    @Override
    public ItemDTO searchItem(String newValue) throws SQLException, ClassNotFoundException{
        return itemDAO.search(newValue);
    }
    @Override
    public boolean itemExist(String id) throws SQLException, ClassNotFoundException{
        return itemDAO.exist(id);
    }
    @Override
    public boolean customerExist(String id) throws SQLException, ClassNotFoundException{
        return customerDAO.exist(id);
    }
    @Override
    public String generateOrderId() throws SQLException, ClassNotFoundException{
        return orderDAO.generateId();
    }
    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException{
        return customerDAO.getAll();
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException{
        return itemDAO.getAll();
    }
}
