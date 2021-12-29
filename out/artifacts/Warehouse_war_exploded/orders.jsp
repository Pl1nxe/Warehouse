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
<body>
<jsp:include page="patterns/navbar.jsp"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <table class="table">
        <tr>
            <th>Reference Number</th>
            <th>Customer ITN</th>
            <th>Date</th>
            <th>Cost</th>
        </tr>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.getReferenceNumber()}</td>
                <td>${order.getCustomerITN()}</td>
                <td>${order.getDate()}</td>
                <td>${order.getCost()}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
