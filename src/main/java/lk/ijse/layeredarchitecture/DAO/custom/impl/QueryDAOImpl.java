package lk.ijse.layeredarchitecture.DAO.custom.impl;

import lk.ijse.layeredarchitecture.DAO.SQLUtil;
import lk.ijse.layeredarchitecture.DAO.custom.QueryDAO;
import lk.ijse.layeredarchitecture.dto.SearchDTO;
import lk.ijse.layeredarchitecture.entity.Search;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public ArrayList<Search> search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT od.oid, o.date, od.itemCode, i.description, od.qty, od.unitPrice FROM OrderDetails od  JOIN Orders o on od.oid = o.oid WHERE o.oid = ?",id);

        ArrayList<Search> getDetails = new ArrayList<>();

        while (rst.next()) {
            Search search = new Search(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5));
            getDetails.add(search);
        }

        return getDetails;
    }

}
