package controller;

import DAO.category.CategoryDAO;
import model.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CategoryServlet", urlPatterns = "/category")
public class CategoryServlet extends HttpServlet {
    private CategoryDAO categoryDAO;

    public void init() {
        categoryDAO = new CategoryDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showFormCreateCategory(request, response);
                    break;
                case "edit":
                    showFormUpdateCategory(request, response);
                    break;
                default:
                    displayListCategory(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertCategory(request, response);
                    break;
                case "edit":
                    updateCategory(request, response);
                    break;
                case "remove":
                    removeCategory(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void removeCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        int status = 0;
        Category block = new Category(id, status);
        categoryDAO.removeCategory(block);
        HttpSession session = request.getSession();
        session.setAttribute("message_remove", "Removed successfully");
        response.sendRedirect("category");
    }

    private void showFormCreateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/create.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        String desc = request.getParameter("desc");
        Category category = new Category(name, desc);
        categoryDAO.insertCategory(category);
        HttpSession session = request.getSession();
        session.setAttribute("message_add", "Add successfully");
        response.sendRedirect("category");
    }

    private void displayListCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String categoryName = request.getParameter("search");
        categoryName = "%" + categoryName + "%";
        List<Category> categoryList = categoryDAO.getCategoryList();
        List<Category> categories = categoryDAO.selectByCategoryName(categoryName);

        if (categoryName.equals("%null%")) {
            request.setAttribute("categoryList", categoryList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("category/home.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("categoryList", categories);
            RequestDispatcher dispatcher = request.getRequestDispatcher("category/home.jsp");
            dispatcher.forward(request, response);
        }
    }


    private void showFormUpdateCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int idCategory = Integer.parseInt(request.getParameter("id"));
        Category existingCategory = categoryDAO.getCategoryById(idCategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/update.jsp");
        request.setAttribute("category", existingCategory);
        dispatcher.forward(request, response);
    }

    private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String desc = request.getParameter("desc");
        Category block = new Category(id, name, desc);
        categoryDAO.updateCategory(block);
        HttpSession session = request.getSession();
        session.setAttribute("message_edit", "Edited successfully");
        response.sendRedirect("category");
    }
}
