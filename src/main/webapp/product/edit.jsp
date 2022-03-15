<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <form method="post" class="card">
        <div class="card-header">
            <h3>Product Edit Form</h3>
        </div>
        <div class="card-body">
            <c:if test="${message}">
                <p>${message}</p>
            </c:if>
            <div>
                <div class="mb-3">
                    <label for="id" class="form-label">Id</label>
                    <input id="id" type="text" placeholder="product name" name="productId" value="${products.productId}">
                </div>
                <div class="mb-3">
                    <label for="name" class="form-label">Name</label>
                    <input id="name" type="text" placeholder="product name" name="name"  value="${products.productName}">
                </div>
                <div class="mb-3">
                    <label for="price" class="form-label">Price</label>
                    <input id="price" type="number" placeholder="product price" name="price"  value="${products.price}">
                </div>
                <div class="mb-3">
                    <label for="amount" class="form-label">Amount</label>
                    <input id="amount" type="text" placeholder="Amount" name="amount"  value="${products.amount}">
                </div>
                <div class="mb-3">
                    <label for="color" class="form-label">Color</label>
                    <input id="color" type="text" placeholder="Color" name="color"  value="${products.color}">
                </div>
                <div class="mb-3">
                    <label for="description" class="form-label">Description</label>
                    <input id="description" type="text" placeholder="Description" name="description" value="${products.description}">
                </div>
                <div class="mb-3">
                    <label for="category" class="form-label">Category</label>
                    <select name="category" id="category">
                        <c:forEach items="${categories}" var="category">
                            <option value="${category.categoryId}" name="category">${category.categoryName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <div class="card-footer">
            <button type="submit" class="btn btn-primary">Edit</button>
        </div>
    </form>
    <a href="/product">Back List Product</a>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>