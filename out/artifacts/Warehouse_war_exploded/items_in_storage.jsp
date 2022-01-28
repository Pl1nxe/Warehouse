<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Pavel Smirnykh
  Date: 19.01.2022
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Items in storage</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body class="container">
<jsp:include page="patterns/navbar.jsp"/>
<h1>List of items in storage</h1>
<table class="table">
    <tr>
        <th>Warehouse number</th>
        <th>Item article</th>
        <th>Count</th>
    </tr>
    <c:forEach items="${item_in_storage.getAllFromDB()}" var="i">
        <tr>
            <td>${i.getWarehouseNum()}</td>
            <td>${i.getItemArticle()}</td>
            <td>${i.getCount()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
