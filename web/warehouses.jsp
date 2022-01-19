<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Смирных Павел
  Date: 28.12.2021
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Warehouses</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body class="container">
<jsp:include page="patterns/navbar.jsp"/>
<h1>List of warehouses</h1>
<table class="table">
    <tr>
        <td><a class="btn btn-success" href="${pageContext.request.contextPath}/add?table=1">Add warehouse</a></td>
        <td align="right"><a class="btn btn-secondary" href="${pageContext.request.contextPath}/items_in_storage.jsp">Items in storage</a></td>
    </tr>
</table>
<table class="table">
    <tr>
        <th>Number</th>
        <th>Address</th>
        <th></th>
    </tr>
    <c:forEach items="${warehouse.getAllFromDB()}" var="i">
        <tr>
            <td>${i.getNumber()}</td>
            <td>${i.getAddress()}</td>
            <td align="right"><a class="btn btn-danger"
                   href="${pageContext.request.contextPath}/delete?table=1&id=${i.getNumber()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
