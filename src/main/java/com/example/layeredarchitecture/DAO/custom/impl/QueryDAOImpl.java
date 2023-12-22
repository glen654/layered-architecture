package com.example.layeredarchitecture.DAO.custom.impl;

import com.example.layeredarchitecture.DAO.SQLUtil;
import com.example.layeredarchitecture.DAO.custom.QueryDAO;
import com.example.layeredarchitecture.model.SearchDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public ArrayList<SearchDTO> search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT od.oid, o.date, od.itemCode, i.description, od.qty, od.unitPrice FROM OrderDetails od  JOIN Orders o on od.oid = o.oid WHERE o.oid = ?",id);

        ArrayList<SearchDTO> getDetails = new ArrayList<>();

        while (rst.next()) {
            SearchDTO dto = new SearchDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5));
            getDetails.add(dto);
        }

        return getDetails;
    }

}
