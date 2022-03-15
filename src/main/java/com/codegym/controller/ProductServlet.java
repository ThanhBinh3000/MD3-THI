package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.service.category.CategoryService;
import com.codegym.service.category.ICategoryService;
import com.codegym.service.product.IProductService;
import com.codegym.service.product.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();
    private ICategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                showProductCreateFrom(request, response);
                break;
            }
            case "edit": {
                showProductEditFrom(request, response);
                break;
            }
            case "delete": {
                showProductDeleteFrom(request, response);
                break;
            }
            default: {
                showProductList(request, response);
                break;
            }
        }
    }

    private void showProductDeleteFrom(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("productId"));
        Product oldProduct = productService.findById(id);
        Category categories = categoryService.findById(oldProduct.getCategoryId());
        RequestDispatcher dispatcher;
        if (oldProduct == null) {
            dispatcher = request.getRequestDispatcher("/loi404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("/product/delete.jsp");
            request.setAttribute("product", oldProduct);
            request.setAttribute("categories", categories);
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showProductEditFrom(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("productId"));
        Product product = productService.findById(id);
        List<Category> categories = categoryService.getAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        request.setAttribute("products", product);
        request.setAttribute("categories", categories);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showProductCreateFrom(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/create.jsp");
            List<Category> categories = categoryService.getAll();
            request.setAttribute("categories", categories);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showProductList(HttpServletRequest request, HttpServletResponse response) {
        String productName = request.getParameter("q");
        List<Product> products;
        if (productName == null || productName.equals("")) {
            products = productService.getAll();
        } else {
            products = productService.findProductByName(productName);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/list.jsp");
        request.setAttribute("products", products);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                addProduct(request, response);
                break;
            }
            case "delete": {
                deleteProduct(request, response);
                break;
            }
            case "edit": {
                editProduct(request, response);
                break;
            }
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int productId = Integer.parseInt(request.getParameter("productId"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int categoryId = Integer.parseInt(request.getParameter("category"));
        Product product = new Product(productId, name, price, amount, color, description,categoryId);
        boolean isEdit = productService.update(productId, product);
        String message = "";
        if (isEdit) {
            message = "Edit success!";
        } else {
            message = "Edit fail!";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/edit.jsp");
        request.setAttribute("message", message);
        List<Category> categories = categoryService.getAll();
        request.setAttribute("categories", categories);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("productId"));
        productService.delete(id);
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int categoryId = Integer.parseInt(request.getParameter("category"));
        Product product = new Product(name, price, amount, color, description);
        product.setCategoryId(categoryId);
        boolean isCreated = productService.save(product);
        String message = "";
        if (isCreated) {
            message = "Create success!";
        } else {
            message = "create fail!";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/create.jsp");
        request.setAttribute("message", message);
        List<Category> categories = categoryService.getAll();
        request.setAttribute("categories", categories);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
