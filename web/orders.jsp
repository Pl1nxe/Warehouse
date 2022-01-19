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
    <title>Orders</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body class="container">
<jsp:include page="patterns/navbar.jsp"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>List of orders</h1>
<table class="table">
    <tr>
        <td><a class="btn btn-success" href="${pageContext.request.contextPath}/add?table=3">Add order</a></td>
        <td align="right"><a class="btn btn-secondary" href="${pageContext.request.contextPath}/ordered_items.jsp">Items in storage</a></td>
    </tr>
</table>
<table class="table">
    <tr>
        <th>Reference Number</th>
        <th>Customer ITN</th>
        <th>Date</th>
        <th></th>
    </tr>
    <c:forEach items="${ordering.getAllFromDB()}" var="i">
        <tr>
            <td>${i.getReferenceNumber()}</td>
            <td>${i.getCustomerITN()}</td>
            <td>${i.getDate()}</td>
            <td align="right"><a class="btn btn-danger"
                                 href="${pageContext.request.contextPath}/delete?table=3&id=${i.getReferenceNumber()}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
