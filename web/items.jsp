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
    <title>Items</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body class="container">
<jsp:include page="patterns/navbar.jsp"/>
<h1>List of orders</h1>
<table class="table">
    <tr>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <tr>
        <td><a class="btn btn-success" href="${pageContext.request.contextPath}/add?table=2">Add item</a></td>
        <td><a class="btn btn-secondary" href="${pageContext.request.contextPath}/items_in_storage.jsp">Items in storage</a></td>
        <td><a class="btn btn-secondary" href="${pageContext.request.contextPath}/ordered_items.jsp">Ordered items</a></td>
        <td><a class="btn btn-primary" href="${pageContext.request.contextPath}/items?type=1">Beam</a></td>
        <td><a class="btn btn-primary" href="${pageContext.request.contextPath}/items?type=2">Fitting</a></td>
        <td><a class="btn btn-primary" href="${pageContext.request.contextPath}/items?type=3">Pipe</a></td>
    </tr>
</table>
<table class="table">
    <c:if test="${type == 0}">
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
        <c:forEach items="${item.getAllFromDB()}" var="i">
            <tr>
                <td>${i.getArticleNum()}</td>
                <td>${i.getTitle()}</td>
                <td>${i.getManufacturer()}</td>
                <td>${i.getPrice()}</td>
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
    </c:if>
    <c:if test="${type == 1}">
        <tr>
            <th>Article</th>
            <th>Title</th>
            <th>Manufacturer</th>
            <th>Price</th>
            <th>Length</th>
            <th>Width</th>
            <th>Height</th>
            <th>Material</th>
            <th></th>
        </tr>
        <c:forEach items="${item.getItemsByType(1)}" var="i">
        <tr>
            <td>${i.getArticleNum()}</td>
            <td>${i.getTitle()}</td>
            <td>${i.getManufacturer()}</td>
            <td>${i.getPrice()}</td>
            <td>${i.getLength()}</td>
            <td>${i.getWidth()}</td>
            <td>${i.getHeight()}</td>
            <td>${i.getMaterial()}</td>
            <td align="right"><a class="btn btn-danger"
                                 href="${pageContext.request.contextPath}/delete?table=2&id=${i.getArticleNum()}">Delete</a>
            </td>
        </tr>
        </c:forEach>
    </c:if>
    <c:if test="${type == 2}">
        <tr>
            <th>Article</th>
            <th>Title</th>
            <th>Manufacturer</th>
            <th>Price</th>
            <th>Length</th>
            <th>Thickness</th>
            <th></th>
        </tr>
        <c:forEach items="${item.getItemsByType(2)}" var="i">
            <tr>
                <td>${i.getArticleNum()}</td>
                <td>${i.getTitle()}</td>
                <td>${i.getManufacturer()}</td>
                <td>${i.getPrice()}</td>
                <td>${i.getLength()}</td>
                <td>${i.getThickness()}</td>
                <td align="right"><a class="btn btn-danger"
                                     href="${pageContext.request.contextPath}/delete?table=2&id=${i.getArticleNum()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    <c:if test="${type == 3}">
        <tr>
            <th>Article</th>
            <th>Title</th>
            <th>Manufacturer</th>
            <th>Price</th>
            <th>Material</th>
            <th>Inner diameter</th>
            <th>Outer diameter</th>
            <th></th>
        </tr>
        <c:forEach items="${item.getItemsByType(3)}" var="i">
            <tr>
                <td>${i.getArticleNum()}</td>
                <td>${i.getTitle()}</td>
                <td>${i.getManufacturer()}</td>
                <td>${i.getPrice()}</td>
                <td>${i.getMaterial()}</td>
                <td>${i.getInnerDiameter()}</td>
                <td>${i.getOuterDiameter()}</td>
                <td align="right"><a class="btn btn-danger"
                                     href="${pageContext.request.contextPath}/delete?table=2&id=${i.getArticleNum()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
