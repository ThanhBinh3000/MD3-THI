package com.codegym.dao.product;

import com.codegym.dao.DBConnection;
import com.codegym.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao{

    public static final String SQL_SELECT_ALL_PRODUCT = "select * from product";
    public static final String SQL_INSERT_PRODUCT = "insert into product(productName,price,amount,color,description,categoryId) value (?,?,?,?,?,?)";
    public static final String SQL_UPDATE_PRODUCT = "update product set productName = ?, price = ?, amount = ?, color = ?, description = ?, categoryId = ? where  productId = ?";
    public static final String SQL_DELETE_PRODUCT = "delete from product where productId=?";
    public static final String SQL_SELECT_ONE_PRODUCT = "select * from product where productId = ?";
    public static final String SQL_SELECT_PRODUCT_BY_NAME = "select * from product where productName like ?";
    private Connection connection = DBConnection.getConnection();

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_PRODUCT);
            ResultSet resultSet = statement.executeQuery();
            Product product = null;
            while (resultSet.next()) {
                product = getProduct(product, resultSet);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean save(Product product) {
        boolean isInsert =false;
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_PRODUCT);
            getProduct(product, statement);
            isInsert = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isInsert;
    }

    @Override
    public boolean update(int id, Product product) {
        boolean isEdit = false;
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_PRODUCT);
            getProduct(product, statement);
            statement.setInt(7,product.getProductId());
            isEdit = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isEdit;
    }

    private void getProduct(Product product, PreparedStatement statement) throws SQLException {
        statement.setString(1, product.getProductName());
        statement.setDouble(2, product.getPrice());
        statement.setInt(3, product.getAmount());
        statement.setString(4, product.getColor());
        statement.setString(5, product.getDescription());
        statement.setInt(6, product.getCategoryId());
    }

    @Override
    public boolean delete(int id) {
        boolean isDelete = false;
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_PRODUCT);
            statement.setInt(1, id);
            isDelete = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDelete;
    }

    @Override
    public Product findById(int id) {
        Product product = new Product();
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ONE_PRODUCT);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                product = getProduct(product, resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    private Product getProduct(Product product, ResultSet resultSet) throws SQLException {
        int productId = resultSet.getInt("productId");
        String productName = resultSet.getString("productName");
        double price = resultSet.getDouble("price");
        int amount = resultSet.getInt("amount");
        String color = resultSet.getString("color");
        String description = resultSet.getString("description");
        int categoryId = resultSet.getInt("categoryId");
        product = new Product(productId,productName,price,amount,color,description,categoryId);
        return product;
    }

    @Override
    public List<Product> findProductByName(String productName) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_PRODUCT_BY_NAME);
            statement.setString(1, productName);
            ResultSet resultSet = statement.executeQuery();
            Product product = null;
            while (resultSet.next()) {
                product = getProduct(product, resultSet);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
