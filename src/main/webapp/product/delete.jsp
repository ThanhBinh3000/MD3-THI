<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/product">Show products list</a>
<h1>Delete product form</h1>
<form method="post">
    <div>
        <p>${product.productName}</p>
    </div>

    <div>
        <p>${product.price}</p>
    </div>

    <div>
        <p>${product.amount}</p>
    </div>

    <div>
        <p>${product.color}</p>
    </div>

    <button>Delete</button>
</form>
</body>
</html>