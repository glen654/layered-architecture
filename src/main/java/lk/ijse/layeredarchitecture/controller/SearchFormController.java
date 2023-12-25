package lk.ijse.layeredarchitecture.controller;

import lk.ijse.layeredarchitecture.DAO.custom.OrderDAO;
import lk.ijse.layeredarchitecture.DAO.custom.QueryDAO;
import lk.ijse.layeredarchitecture.DAO.custom.impl.OrderDAOImpl;
import lk.ijse.layeredarchitecture.DAO.custom.impl.QueryDAOImpl;
import lk.ijse.layeredarchitecture.dto.OrderDTO;
import lk.ijse.layeredarchitecture.dto.SearchDTO;
import lk.ijse.layeredarchitecture.entity.Order;
import lk.ijse.layeredarchitecture.entity.Search;
import lk.ijse.layeredarchitecture.view.tdm.SearchTM;
import com.jfoenix.controls.JFXComboBox;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class SearchFormController implements Initializable {
    @FXML
    private JFXComboBox<String> cmbOrderId;

    @FXML
    private TableColumn<?, ?> tblDescription;

    @FXML
    private TableColumn<?, ?> tblOrderDate;

    @FXML
    private TableColumn<?, ?> tblOrderId;

    @FXML
    private TableColumn<?, ?> tblQty;

    @FXML
    private TableView<SearchTM> tblSearch;

    @FXML
    private TableColumn<?, ?> tblUnitPrice;

    @FXML
    private AnchorPane root;

    OrderDAO orderDAO = new OrderDAOImpl();
    QueryDAO queryDAO = new QueryDAOImpl();


    @FXML
    void navigateToHome(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/lk/ijse/layeredarchitecture/main-form.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());
    }

    private void loadAllOrderIds() {
        ObservableList<String> obList = FXCollections.observableArrayList();

        try {
            List<Order> idList = orderDAO.getAll();
            List<OrderDTO> orderDTOS = new ArrayList<>();
            for (Order order : idList) {
                obList.add(order.getOrderId());
            }

            cmbOrderId.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadAllOrderIds();

        tblSearch.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("orderId"));
        tblSearch.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        tblSearch.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblSearch.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblSearch.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
    }

    public void loadSearch(){
        tblSearch.getItems().clear();

        String id = (String) cmbOrderId.getValue();
        try {
            ArrayList<Search> searches = queryDAO.search(id);
            ArrayList<SearchDTO> search = new ArrayList<>();
            for(SearchDTO s : search){
                tblSearch.getItems().add(new SearchTM(s.getOrderId(), s.getOrderDate(), s.getDescription(), s.getQty(), s.getUnitPrice()));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
}
