package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

//import javax.swing.table.TableColumn;

public class CategoryViewTable {
    @FXML
    private TableView<Category> categoryTable;
    public TableColumn<Category, Integer> categoryTableID;
    public TableColumn<Category, String> categoryTableName;
    public TableColumn<Category, String > categoryTableDescription;
    public TableColumn<Category, String > categoryTableDate;

    ObservableList<Category> list = FXCollections.observableArrayList(
            new Category(1001, "Busicits"),
            new Category(1002, "Cake"),
            new Category(1001, "Busicits"),
            new Category(1002, "Cake"),
            new Category(1001, "Busicits"),
            new Category(1002, "Cake"),
            new Category(1001, "Busicits"),
            new Category(1002, "Cake")
    );

    public void initialize() {
        categoryTableID.setCellValueFactory(new PropertyValueFactory<Category, Integer>("categoryId"));
        categoryTableName.setCellValueFactory(new PropertyValueFactory<Category, String>("name"));


        categoryTable.setItems(list);
    }
}
