<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Pavel Smirnykh
  Date: 19.01.2022
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ordered items</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body class="container">
<jsp:include page="patterns/navbar.jsp"/>
<h1>List of ordered items</h1>
<a class="btn btn-success" href="${pageContext.request.contextPath}/add?table=5">Add item in order</a>
<table class="table">
    <tr>
        <th>Order reference number</th>
        <th>Item article</th>
        <th></th>
    </tr>
    <c:forEach items="${ordered_item.getAllFromDB()}" var="i">
        <tr>
            <td>${i.getOrderRefNum()}</td>
            <td>${i.getItemArticle()}</td>
            <td align="right"><a class="btn btn-danger"
                                 href="${pageContext.request.contextPath}/delete?table=5&id=${i.getItemArticle()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
