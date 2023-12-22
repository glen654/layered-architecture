package com.example.layeredarchitecture.BO.impl;

import com.example.layeredarchitecture.BO.custom.CustomerBo;
import com.example.layeredarchitecture.DAO.custom.CustomerDAO;
import com.example.layeredarchitecture.DAO.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBoImpl implements CustomerBo {

    CustomerDAO customerDAO = new CustomerDAOImpl();
    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException{
        return customerDAO.getAll();
    }
    @Override
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException{
        return customerDAO.save(dto);
    }
    @Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException{
        return customerDAO.update(dto);
    }
    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException{
        return customerDAO.exist(id);
    }
    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException{
        return customerDAO.delete(id);
    }
    @Override
    public String generateCustomerId() throws SQLException, ClassNotFoundException{
        return customerDAO.generateId();
    }
}
