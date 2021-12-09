package sample;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    public static ArrayList<Category> categoryArrayList = new ArrayList<>();
    public Category selectedCategory;
    public ImageView loginImageView;

    private TableView table = new TableView();

    @FXML
    String defaultUsername = "Danusha";
    String defaultPassword = "12345";
    @FXML
    Label topLabel;
    @FXML
    Label categorySelectID;
    @FXML
    Label categorySelectName;
    @FXML
    Label categoryTopLabel;
    @FXML
    Label categoryFound;
    @FXML
    Label categoryNameExist;
    @FXML
    Label categoryIdExist;
    Label deleteCategoryIndoLabel;
    @FXML
    Label deleteCategorySelectedName;
    @FXML
    Label deleteCategorySelectedID;
    @FXML
    Label deleteCategoryHeading;
    @FXML
    Label deleteCategoryInfoLabel;

    @FXML
    TextField username;
    @FXML
    TextField password;
    @FXML
    TextField categorySearchInput;
    @FXML
    TextField categoryEditName;
    @FXML
    TextField categoryEditID;
    @FXML
    TextField deleteCategoryTextField;
    @FXML
    TextField categoryName;
    @FXML
    TextField categoryID;
    TextField addProductName;
    TextField addProductID;

    @FXML
    Button loginBtn;
    @FXML
    Button addCategoryBtn;
    @FXML
    Button categoryEditBtn;
    @FXML
    Button deleteCategoryBtn;

    SplitMenuButton addProductSelectCategory;

    ChoiceBox<String> addProductChoiceBox;

    public static ArrayList<Category> getCategoryArrayList() {
        return categoryArrayList;
    }

    public Category getSelectedCategory() {
        return selectedCategory;
    }

    @FXML
    public void logInPressed(ActionEvent event) throws IOException {
        if (username.getText().equals(defaultUsername) && password.getText().equals(defaultPassword)) {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menuWindow.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            currentStage.setScene(scene);
        } else {
            topLabel.setText("Invalid username or password");
        }
    }

    //ADD CATEGORY

    @FXML
    public void addCategory(ActionEvent event) throws IOException {
        Stage addCategoryStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("addCategoryPopup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        addCategoryStage.setTitle("Add new category");
        addCategoryStage.setScene(scene);
        addCategoryStage.show();
    }

    @FXML
    public void addCategoryBtn(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        String currentCategoryName = categoryName.getText();
        try {
            int currentCategoryID = Integer.parseInt(categoryID.getText());
            Category currentCategory = new Category( currentCategoryID, currentCategoryName);
            categoryArrayList.add(currentCategory);
            currentStage.close();
        } catch (NumberFormatException e) {
            System.out.println("Check category ID and try again");
        }
    }

    // VIEW CATEGORY

    @FXML
    public void viewCategories(ActionEvent event) throws IOException {
        Stage categoryTableStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("viewCategoriesTable.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        categoryTableStage.setTitle("Category list");
        categoryTableStage.setScene(scene);
        categoryTableStage.show();

        table.setEditable(true);
    }

    @FXML
    public void printCategories(ActionEvent event) {
        for (Category category : categoryArrayList) {
            System.out.println(category.getName() + ", ID = " + category.getCategoryId());
        }
    }

    // EDIT CATEGORY

    @FXML
    public void editCategory(ActionEvent event) throws IOException {
        Stage editCategoryStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("editCategory.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        editCategoryStage.setTitle("Edit Category");
        editCategoryStage.setScene(scene);
        editCategoryStage.show();
    }

    @FXML
    public void searchCategory(ActionEvent event) throws IOException {
        for (Category category : categoryArrayList) {
            boolean isNameEqual = category.getName().equalsIgnoreCase(categorySearchInput.getText());
            boolean isIdEqual = ("" + category.getCategoryId()).equals(categorySearchInput.getText());
            if (isNameEqual || isIdEqual) {
                selectedCategory = category;
                categorySelectName.setText(category.getName());
                categorySelectID.setText("" + (category.getCategoryId()));
                categoryFound.setText("Category Found");
                categoryEditName.setText("");
                categoryEditID.setText("");
                categoryEditName.setDisable(false);
                categoryEditID.setDisable(false);
                categoryEditBtn.setDisable(false);
                break;
            } else {
                categoryFound.setText("Category Not Found");
                categorySelectName.setText("");
                categorySelectID.setText("");
                categoryEditName.setText("");
                categoryEditID.setText("");
                categoryEditName.setDisable(true);
                categoryEditID.setDisable(true);
                categoryEditBtn.setDisable(true);
            }
        }
    }

    @FXML
    public void editCategoryBtn(ActionEvent event) {
//        String newName = categoryEditName.getText();
//        String newId = categoryEditID.getText();
//        boolean canEditName = false;
//        boolean canEditId = false;
//
//        if (isCategoryNameExist(newName) == null) {
//            canEditName = true;
//        } else {
//            categoryName.setText(isCategoryNameExist(newName).getName() + " category name already stored in the system.");
//        }
//
//        if (isCategoryIdExist(newId) == null) {
//            canEditId = true;
//        } else {
//            categoryIdExist.setText(isCategoryIdExist(newId).getCategoryId() + " category ID already stored in the system.");
//        }
//        if (canEditName && canEditId) {
//            selectedCategory.setName(newName);
//            selectedCategory.setCategoryId(Integer.parseInt(newId));
//            categoryFound.setText("Category Edited Successfully");
//            categoryEditName.setText("");
//            categoryEditID.setText("");
//        }

        selectedCategory.setName(categoryEditName.getText());
        selectedCategory.setCategoryId(Integer.parseInt(categoryEditID.getText()));
        categoryFound.setText("Category Edited Successfully");
        categorySelectName.setText("");
        categorySelectID.setText("");
        categoryEditName.setText("");
        categoryEditID.setText("");
        categorySearchInput.setText("");
        categoryEditName.setDisable(true);
        categoryEditID.setDisable(true);
        categoryEditBtn.setDisable(true);
    }

    // DELETE CATEGORY

    @FXML
    public void deleteCategory(ActionEvent event) throws IOException {
        Stage deleteCategoryStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("deleteCategoryPopup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        deleteCategoryStage.setTitle("Delete Category");
        deleteCategoryStage.setScene(scene);
        deleteCategoryStage.show();
    }

    @FXML
    public void searchDeleteCategory(ActionEvent event) {
        for (Category category : categoryArrayList) {
            boolean isNameEqual = category.getName().equalsIgnoreCase(deleteCategoryTextField.getText());
            boolean isIdEqual = ("" + category.getCategoryId()).equals(deleteCategoryTextField.getText());
            if (isNameEqual || isIdEqual) {
                deleteCategorySelectedName.setText(category.getName());
                deleteCategorySelectedID.setText("" + (category.getCategoryId()));
                deleteCategoryInfoLabel.setText("Category found. Click 'Delete' button to delete");
                selectedCategory = category;
                deleteCategoryBtn.setDisable(false);
                break;
            } else {
                deleteCategorySelectedName.setText("");
                deleteCategorySelectedID.setText("");
                deleteCategoryInfoLabel.setText("Category not found. Please try again.");
                deleteCategoryBtn.setDisable(true);
            }
        }
    }

    @FXML
    public void deleteCategoryBtn(ActionEvent event) {
        categoryArrayList.remove(selectedCategory);
        deleteCategoryInfoLabel.setText("Category deleted successfully");
        deleteCategorySelectedName.setText("");
        deleteCategorySelectedID.setText("");
        deleteCategoryBtn.setDisable(true);
    }

    // ADD PRODUCT - OPEN NEW STAGE

    @FXML
    public void addProduct(ActionEvent event) throws IOException {
        Stage addProductStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("addProductPopup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        addProductStage.setTitle("Add Product");
        addProductStage.setScene(scene);
        addProductStage.show();
    }

    public void searchProduct(ActionEvent event) throws IOException {
        Stage searchProductStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("searchProduct.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        searchProductStage.setTitle("Delete Category");
        searchProductStage.setScene(scene);
        searchProductStage.show();
    }

    public void editProduct(ActionEvent event) {
    }
}