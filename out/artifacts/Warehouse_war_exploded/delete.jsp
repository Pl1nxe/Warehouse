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
    <title>Delete</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<jsp:include page="patterns/navbar.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <table class="table">
        <tr>
            <th>Article</th>
            <th>Title</th>
            <th>Manufacturer</th>
            <th>Price</th>
            <th></th>
        </tr>
        <c:forEach items="${items}" var="item">

            <tr>
                <th>${item.getArticle()}</th>
                <td>${item.getTitle()}</td>
                <td>${item.getManufacturer()}</td>
                <td>${item.getPrice()}</td>
                <td><a class="btn btn-danger" href="${pageContext.request.contextPath}/sell?id=${item.id}">Удалить</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
