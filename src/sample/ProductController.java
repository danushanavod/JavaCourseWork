package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class ProductController {
    public static ArrayList<Product> productArrayList = new ArrayList<>();

    @FXML
    SplitMenuButton addProductSelectCategory;

    @FXML
    TextField addProductName;

    @FXML
    TextField addProductID;

    @FXML
    ChoiceBox<String> addProductChoiceBox;

    public void initialize() {
        for (Category category: Controller.categoryArrayList) {
            addProductChoiceBox.getItems().add(category.getName());
        }
    }

    public void addProductBtn(ActionEvent event) {
        for (Category category: Controller.categoryArrayList) {
            String selectedCategoryName = addProductChoiceBox.getValue();
            if (category.getName().equals(selectedCategoryName) && !selectedCategoryName.equals("")) {
                try {
                    int currentProductId = Integer.parseInt(addProductID.getText());
                    Product currentProduct = new Product(category, addProductName.getText(), currentProductId);
                    productArrayList.add(currentProduct);
                    System.out.println("New product added: " + "Name: " + addProductName.getText() + ", ID: " + currentProductId + ", Category: " + category.getName());
                } catch (NumberFormatException e) {
                    System.out.println("Number format exception");
                }
            }
        }
    }

    public void showAllProducts(ActionEvent event) {
        for (Product product: productArrayList) {
            System.out.println(product.getName() + " ID = " + product.getProductId() + " category= " + product.getCategory().getName());
        }
    }
}
