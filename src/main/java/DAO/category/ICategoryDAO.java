package DAO.category;

import model.Category;

import java.util.List;

public interface ICategoryDAO {
    public void insertCategory(Category category) throws Exception;

    public List<Category> getCategoryList() throws Exception;

    public boolean updateCategory(Category category) throws Exception;

    public boolean removeCategory(Category category) throws Exception;
}
