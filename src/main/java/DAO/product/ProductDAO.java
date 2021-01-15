package DAO.product;

import DAO.category.CategoryDAO;
import helper.ConnectionHelper;
import helper.Query;
import model.Category;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {

    private Connection connection;
    private PreparedStatement statement;
    private CategoryDAO categoryDAO;

    public ProductDAO() {
        connection = ConnectionHelper.getConnection();
        System.out.println("Ket noi thanh cong");
    }

    @Override
    public void insertProduct(Product product) throws Exception {
        statement = connection.prepareStatement(Query.INSERT_PRODUCT_SQL);
        statement.setInt(1, product.getId());
        statement.setString(2, product.getProductName());
        statement.setDouble(3, product.getProductPrice());
        statement.setInt(4, product.getQuantity());
        statement.setString(5, product.getColor());
        statement.setString(6, product.getProductDesc());
        statement.setInt(7, product.getCategoryId());
        statement.executeUpdate();
    }

    @Override
    public List<Product> getProductList() throws SQLException {
        List<Product> productList = new ArrayList<>();
        categoryDAO = new CategoryDAO();
        Category category;
        statement = connection.prepareStatement(Query.SELECT_ALL_PRODUCT);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String productName = resultSet.getString("product_name");
            double productPrice = resultSet.getDouble("product_price");
            int productQuantity = resultSet.getInt("product_quantity");
            String color = resultSet.getString("product_color");
            int categoryId = resultSet.getInt("category_id");
            category = categoryDAO.getCategoryById(categoryId);
            int status = resultSet.getInt("status");
            productList.add(new Product(id, productName, productPrice, productQuantity, color, category, status));
        }
        return productList;
    }

    @Override
    public List<Product> selectByProductName(String categoryName) throws SQLException {
        List<Product> productList = new ArrayList<>();
        categoryDAO = new CategoryDAO();
        Category category;
        statement = connection.prepareStatement(Query.SELECT_PRODUCT_BY_NAME);
        statement.setString(1, categoryName);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String productName = resultSet.getString("product_name");
            double productPrice = resultSet.getDouble("product_price");
            int productQuantity = resultSet.getInt("product_quantity");
            String productColor = resultSet.getString("product_color");
            String productDesc = resultSet.getString("product_desc");
            int categoryId = resultSet.getInt("category_id");
            category = categoryDAO.getCategoryById(categoryId);
            int status = resultSet.getInt("status");
            productList.add(new Product(id, productName, productPrice, productQuantity, productColor, productDesc, category, status));
        }
        return productList;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        return false;
    }

    @Override
    public boolean removeProduct(Product product) throws SQLException {
        return false;
    }

    @Override
    public Product getProductById(int productId) throws SQLException {
        categoryDAO = new CategoryDAO();
        statement = connection.prepareStatement(Query.SELECT_PRODUCT_BY_ID);
        statement.setInt(1, productId);
        Product product = new Product();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            product.setId(resultSet.getInt("id"));
            product.setProductName(resultSet.getString("product_name"));
            product.setProductPrice(resultSet.getDouble("product_price"));
            product.setQuantity(resultSet.getInt("product_quantity"));
            product.setColor(resultSet.getString("product_color"));
            product.setCategory(categoryDAO.getCategoryById(resultSet.getInt("category_id")));
        }
        return product;
    }
}

