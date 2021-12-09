package sample;

public class Category {
    int categoryId;
    String name;
//    String description;
    int stockCount;

    public Category(int categoryId, String name) {
        this.name = name;
        this.categoryId = categoryId;
//        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
}
