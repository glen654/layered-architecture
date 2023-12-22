package com.example.layeredarchitecture.controller;

import com.example.layeredarchitecture.DAO.custom.OrderDAO;
import com.example.layeredarchitecture.DAO.custom.QueryDAO;
import com.example.layeredarchitecture.DAO.custom.impl.OrderDAOImpl;
import com.example.layeredarchitecture.DAO.custom.impl.QueryDAOImpl;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.SearchDTO;
import com.example.layeredarchitecture.view.tdm.SearchTM;
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
        URL resource = this.getClass().getResource("/com/example/layeredarchitecture/main-form.fxml");
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
            List<OrderDTO> idList = orderDAO.getAll();

            for (OrderDTO dto : idList) {
                obList.add(dto.getOrderId());
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
            ArrayList<SearchDTO> search = queryDAO.search(id);
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
