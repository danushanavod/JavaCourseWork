package sample;

public class Product {
    Category category;
    String name;
    double price;
    int productId;
    int stockCount;

    public Product(Category category, String productName, int productId) {
        this.category = category;
        this.name = productName;
        this.productId = productId;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getProductId() {
        return productId;
    }
}
