package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SearchProduct {
    @FXML
    Label searchProductInfo;

    @FXML
    TextField searchProductTextBox;

    @FXML
    Label searchProductID;

    @FXML
    Label searchProductName;

    public void searchProductBtn(ActionEvent event) {
        for (Product product : ProductController.productArrayList) {
            boolean isNameEqual = product.getName().equalsIgnoreCase(searchProductTextBox.getText());
            boolean isIdEqual = ("" + product.getProductId()).equals(searchProductTextBox.getText());
            if (isNameEqual || isIdEqual) {
                searchProductName.setText(product.getName());
                searchProductID.setText("" + product.getProductId());
                searchProductInfo.setText("");
                break;
            } else {
                searchProductName.setText("");
                searchProductID.setText("");
                searchProductInfo.setText("Product not found.");
            }
        }
    }
}
