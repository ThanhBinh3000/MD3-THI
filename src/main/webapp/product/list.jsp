<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <link rel="stylesheet" href="//use.fontawesome.com/releases/v5.0.7/css/all.css">
</head>
<body>
<div class="container">
    <div class="card">
        <div class="card-header">
            <div class="row">
                <h2 class="col-6">Product list</h2>
                <form class="d-flex col-6" action="/product" method="get">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="q">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
            <div>
                <button class="btn btn-primary">
                    <a class="text-white" href="/product?action=create">Create</a>
                </button>
            </div>
        </div>
        <div class="card-body">
            <table class="table table-striped">
                <thead>
                <tr>
                    <td>Index</td>
                    <td>Name</td>
                    <td>Price</td>
                    <td>Amount</td>
                    <td>Color</td>
                    <td>Description</td>
                    <td>Category</td>
                    <td colspan="2">Action</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <th scope="row">${product.productId}</th>
                        <td>${product.productName}</td>
                        <td>${product.price}</td>
                        <td>${product.amount}</td>
                        <td>${product.color}</td>
                        <td>${product.description}</td>
                        <td>${(product.category).categoryName}</td>
                        <td><a class="btn btn-info" href="/product?action=edit&productId=${product.productId}"> <i class="fa fa-edit"></i></a></td>
                        <td><a class="btn btn-danger" href="/product?action=delete&productId=${product.productId}"><i class="fa fa-trash"></i></a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>
