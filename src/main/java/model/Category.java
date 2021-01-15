package model;

public class Category {
    private int id;
    private String categoryName;
    private String categoryDesc;
    private int status;

    public Category() {
    }

    public Category(int id, String categoryName, String categoryDesc) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryDesc = categoryDesc;
    }

    public Category(int id, String categoryName, String categoryDesc, int status) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryDesc = categoryDesc;
        this.status = status;
    }

    public Category(String categoryName, String categoryDesc) {
        this.categoryName = categoryName;
        this.categoryDesc = categoryDesc;
    }

    public Category(int id, int status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
