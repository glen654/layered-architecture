package lk.ijse.layeredarchitecture.DAO.custom;

import lk.ijse.layeredarchitecture.DAO.CrudDAO;
import lk.ijse.layeredarchitecture.entity.OrderDetail;

import java.sql.SQLException;

public interface OrderDetailsDAO extends CrudDAO<OrderDetail> {
     boolean saveOrderDetails(String orderId, OrderDetail entity) throws SQLException, ClassNotFoundException;

}
