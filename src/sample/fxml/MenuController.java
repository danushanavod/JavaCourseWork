package sample.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuController {
    public BorderPane menuBorderPane;
    public AnchorPane menuAnchorPane;
    public Button menuCloseBtn;

    public void editProduct(ActionEvent event) {

    }

    public void home(MouseEvent mouseEvent) {
        menuBorderPane.setCenter(menuAnchorPane);
    }

    public void categories(MouseEvent mouseEvent) throws IOException {
        loadPage("sample");
    }

    public void products(MouseEvent mouseEvent) {
        loadPage("addProductPopup");
    }

    public void stock(MouseEvent mouseEvent) {
    }

    private void loadPage(String page){
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

        menuBorderPane.setCenter(root);
    }

    public void closeMenu(ActionEvent event) {
        Stage currentStage = (Stage) menuCloseBtn.getScene().getWindow();
        currentStage.close();
    }
}
