package com.example.layeredarchitecture.DAO.custom;

import com.example.layeredarchitecture.model.SearchDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO {
    ArrayList<SearchDTO> search(String id) throws SQLException, ClassNotFoundException;
}
