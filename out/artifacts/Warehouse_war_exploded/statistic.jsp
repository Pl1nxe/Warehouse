<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Pavel Smirnykh
  Date: 19.01.2022
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Statistic</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body class="container">
<jsp:include page="patterns/navbar.jsp"/>
    <h1>Statistic</h1>
    <table class="table">
        <tr>
            <th>Table</th>
            <th>Count</th>
        </tr>
        <tr>
            <td>warehouse</td>
            <td>${warehouse.getCount()}</td>
        </tr>
        <tr>
            <td>item_in_storage</td>
            <td>${item_in_storage.getCount()}</td>
        </tr>
        <tr>
            <td>item</td>
            <td>${item.getCount()}</td>
        </tr>
        <tr>
            <td>ordered_item</td>
            <td>${ordered_item.getCount()}</td>
        </tr>
        <tr>
            <td>ordering</td>
            <td>${ordering.getCount()}</td>
        </tr>
        <tr>
            <td>customer</td>
            <td>${customer.getCount()}</td>
        </tr>
    </table>
</body>
</html>
