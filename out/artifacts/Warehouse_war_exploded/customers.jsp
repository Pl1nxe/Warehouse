<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Смирных Павел
  Date: 28.12.2021
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body class="container">
<jsp:include page="patterns/navbar.jsp"/>
<h1>List of customers</h1>
<a class="btn btn-success" href="${pageContext.request.contextPath}/add?table=4&type=1">Add customer</a>
<table class="table">
    <tr>
        <th>ITN</th>
        <th>Name</th>
        <th>Address</th>
        <th>Birthdate</th>
        <th></th>
    </tr>
    <c:forEach items="${customer.getAllFromDB()}" var="i">
        <tr>
            <td>${i.getITN()}</td>
            <td>${i.getName()}</td>
            <td>${i.getAddress()}</td>
            <td>${i.getBirthDate()}</td>
            <td align="right"><a class="btn btn-danger"
                                 href="${pageContext.request.contextPath}/delete?table=4&id=${i.getITN()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
