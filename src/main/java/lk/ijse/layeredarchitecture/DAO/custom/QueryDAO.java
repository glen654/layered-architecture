package lk.ijse.layeredarchitecture.DAO.custom;

import lk.ijse.layeredarchitecture.DAO.SuperDAO;
import lk.ijse.layeredarchitecture.dto.SearchDTO;
import lk.ijse.layeredarchitecture.entity.Search;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    ArrayList<Search> search(String id) throws SQLException, ClassNotFoundException;
}
