package controller;

import DAO.category.CategoryDAO;
import DAO.product.ProductDAO;
import model.Category;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private ProductDAO productDAO = new ProductDAO();
    private CategoryDAO categoryDAO = new CategoryDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showFormCreateProduct(request, response);
                    break;
                default:
                    displayProductList(request, response);

            }
        } catch (Exception e) {
            throw new ServletException(e);
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
                    insertProduct(request, response);
                    break;
                case "edit":
//                    updateProduct(request, response);
                    break;
                case "remove":
//                    removeProduct(request, response);
                    break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void showFormCreateProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Category> categoryList = categoryDAO.getCategoryList();
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Category> categoryList = categoryDAO.getCategoryList();
        String productName = request.getParameter("name");
        double productPrice = Double.parseDouble(request.getParameter("price"));
        int productQuantity = Integer.parseInt(request.getParameter("quantity"));
        String productColor = request.getParameter("color");
        String productDesc = request.getParameter("desc");
        int categoryId = Integer.parseInt(request.getParameter("category_id"));
        Product newProduct = new Product(productName, productPrice, productQuantity, productColor, productDesc, categoryId);
        productDAO.insertProduct(newProduct);
        request.setAttribute("categoryList", categoryList);
        HttpSession session = request.getSession();
        session.setAttribute("message_add", "New item is successfully added");
        response.sendRedirect("/product");

    }

    private void displayProductList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String productName = request.getParameter("search");
        productName = "%" + productName + "%";
        List<Product> productList = productDAO.getProductList();
        List<Product> products = productDAO.selectByProductName(productName);

        if (productName.equals("%null%")) {
            request.setAttribute("productList", productList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("product/home.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("products", products);
            RequestDispatcher dispatcher = request.getRequestDispatcher("product/home.jsp");
            dispatcher.forward(request, response);
        }
    }

}
