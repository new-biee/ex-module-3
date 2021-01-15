package DAO.product;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    public void insertProduct(Product product) throws Exception;

    public List<Product> getProductList() throws SQLException;

    public List<Product> selectByProductName(String categoryName) throws SQLException;

    public boolean updateProduct(Product product) throws SQLException;

    public boolean removeProduct(Product product) throws SQLException;

    Product getProductById(int productId) throws SQLException;

}
