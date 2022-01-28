<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Pavel Smirnykh
  Date: 20.01.2022
  Time: 6:22
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
<h1>Warehouse №${number}</h1>
<a class="btn btn-danger"
   href="${pageContext.request.contextPath}/delete?table=1&id=${number}">Delete warehouse</a>
<table class="table">
    <tr>
        <th>Article</th>
        <th>Title</th>
        <th>Manufacturer</th>
        <th>Price</th>
        <th>Length</th>
        <th>Width</th>
        <th>Height</th>
        <th>Material</th>
        <th>Thickness</th>
        <th>Inner diameter</th>
        <th>Outer diameter</th>
        <th></th>
    </tr>
    <c:forEach items="${item.getByWarehouseNum(number)}" var="i">
        <tr>
            <td>${i.getArticleNum()}</td>
            <td>${i.getTitle()}</td>
            <td>${i.getManufacturer()}</td>
            <td>${decimal_converter.toDecimalFormat(i.getPrice())}</td>
            <td>${i.getLength()}</td>
            <td>${i.getWidth()}</td>
            <td>${i.getHeight()}</td>
            <td>${i.getMaterial()}</td>
            <td>${i.getThickness()}</td>
            <td>${i.getInnerDiameter()}</td>
            <td>${i.getOuterDiameter()}</td>
            <td align="right"><a class="btn btn-danger"
                                 href="${pageContext.request.contextPath}/delete?table=2&id=${i.getArticleNum()}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

