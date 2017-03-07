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

<html>
<head>
    <meta http-equiv="content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Klienci u Cypa</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Klienci</h1>
            <p>Najlepsi Cypowi klienci</p>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <c:forEach items="${customers}" var="customer">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>imie: ${customer.name}</h3>
                        <p>miejscowosc: ${customer.adress}</p>
                        <p>numer klienta: ${customer.customerId}</p>
                    </div>

                </div>
            </div>
        </c:forEach>
    </div>
</section>

</body>
</html>
