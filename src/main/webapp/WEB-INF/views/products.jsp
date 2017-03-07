<%--
  Created by IntelliJ IDEA.
  User: Cyprian
  Date: 2017-03-03
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <meta http-equiv="content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Produkty od Cypa</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Produkty</h1>
            <p>Produkty oferowane przez Cypa</p>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <c:forEach items="${products}" var="product">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>${product.name}</h3>
                        <p>${product.description}</p>
                        <p>${product.unitPrice}PLN</p>
                        <p>Liczba sztuk: ${product.unitsInStock}</p>
                        <p>
                            <a href="<spring:url value="/products/product?id=${product.productId}"/>"
                               class="btn btn-primary">
                                <span class="glyphicon-info-sign glyphicon"/></span>Szczegoly
                            </a>
                        </p>
                    </div>

                </div>
            </div>
        </c:forEach>
    </div>
</section>

</body>
</html>
